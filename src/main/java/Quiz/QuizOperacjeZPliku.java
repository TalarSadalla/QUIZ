package Quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizOperacjeZPliku implements QuizOperacje {

	private QuizSzyfr quizSzyfr = new QuizSzyfrCezara();

	public List<Pytanie> pytaniaZPlikuJakoLista(File file) throws FileNotFoundException {

		ArrayList<Pytanie> listaPytan = new ArrayList<>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Pytanie pytanie = new Pytanie();
			pytanie.setPytanie(scanner.nextLine());
			List<String> odpowiedzi = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				String odpowiedz = scanner.nextLine();
				odpowiedzi.add(odpowiedz);
			}
			pytanie.setListaOdpowiedzi(odpowiedzi);
			pytanie.setPoprawnaOdpowiedz(scanner.nextLine());
			listaPytan.add(pytanie);
		}
		return listaPytan;

	}

	public void zapiszWynikDoPliku(File plikZWynikami, Wynik wynik) throws IOException {
		try (FileWriter fw = new FileWriter(plikZWynikami, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			String wynikJakoString = wynik.toString();
			out.println(quizSzyfr.szyfruj(wynikJakoString));
		}

	}

	public List<Wynik> wynikiZPlikuJakoLista(File plikZWynikami) throws FileNotFoundException {
		ArrayList<Wynik> listaWynikow = new ArrayList<>();
		Scanner scanner = new Scanner(plikZWynikami);
		while (scanner.hasNext()) {
			Wynik wynik = new Wynik();
			String line = scanner.nextLine();
			String odkodowany = quizSzyfr.rozszyfruj(line);
			String[] podzielonyWynik = odkodowany.split(" ");
			wynik.setImie(podzielonyWynik[0]);
			wynik.setPoprawnychOdpowiedzi(new Integer(podzielonyWynik[1]));
			wynik.setWszystkichOdpowiedzi(new Integer(podzielonyWynik[2]));
			listaWynikow.add(wynik);

		}
		return listaWynikow;

	}

	public Pytanie pobieraniePytania() {
		Scanner scanner = new Scanner(System.in);
		Pytanie pytanie = new Pytanie();
		List<String> listaOdpowiedzi = new ArrayList<>();
		System.out.println("Podaj treść pytania: ");
		pytanie.setPytanie("\n" + scanner.nextLine());

		int licznik = 0;
		char prefix = 'a';
		while (licznik < 4) {
			System.out.println("Podaj odpowiedź " + (char) (prefix + licznik));
			listaOdpowiedzi.add(licznik, scanner.nextLine());
			licznik++;
		}
		pytanie.setListaOdpowiedzi(listaOdpowiedzi);
		System.out.println("Podaj poprawną odpowiedź: (a,b,c,d): ");
		pytanie.setPoprawnaOdpowiedz(scanner.nextLine());
		return pytanie;
	}

	public void zapiszPytanieDoPliku(File plikZWynikami, Pytanie pytanie) throws IOException {
		try (FileWriter fw = new FileWriter(plikZWynikami, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			String wynikJakoString = pytanie.toString() + "\r\n";
			out.print(wynikJakoString);
		}

	}

}
