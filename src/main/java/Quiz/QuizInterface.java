package Quiz;

import java.util.List;
import java.util.Scanner;

public class QuizInterface {

	public Integer WyborTrybu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Tryb gracza");
		System.out.println("2. Tryb administratora");
		System.out.println("3. Koniec");
		Integer opcja = scanner.nextInt();

		return opcja;
	}

	public String Autoryzacja() {
		QuizSzyfr quizSzyfr = new QuizSzyfrCezara();
		System.out.println("Podaj hasło: (Podpowiedź imię autora projektu) ");
		Scanner scanner = new Scanner(System.in);
		String haslo = scanner.nextLine();
		String hasloZakodowane = quizSzyfr.szyfruj(haslo);
		return hasloZakodowane;
	}

	public Integer menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Start");
		System.out.println("2. Wynik");
		System.out.println("3. Koniec");

		Integer opcja = scanner.nextInt();
		return opcja;

	}

	public Integer menuAdmina() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Dodaj pytanie");
		System.out.println("2. Koniec");

		Integer opcja = scanner.nextInt();
		return opcja;

	}

	public void przedStartem() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Zaraz zacznie się gra.");
		scanner.nextLine();
	}

	public boolean wyswietlPytanie(Pytanie pytanie) {

		System.out.println(pytanie.getPytanie());
		System.out.println("_________________");
		List<String> odpowiedzi = pytanie.getListaOdpowiedzi();
		// odpowiedzi.forEach(e -> System.out.println(e));
		char prefix = 'a';
		for (int i = 0; i < odpowiedzi.size(); i++) {
			System.out.println((char) (prefix + i) + ". " + odpowiedzi.get(i));
		}
		System.out.println("_________________");
		System.out.println("Podaj odpowiedz: ");
		Scanner scanner = new Scanner(System.in);
		String odpowiedz = scanner.nextLine();
		if (odpowiedz.equals(pytanie.getPoprawnaOdpowiedz())) {
			return true;

		} else {
			return false;
		}

	}

	public void poprawnaOdpowiedz() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Poprawna odpowiedz");
		scanner.nextLine();
	}

	public void niepoprawnaOdpowiedz() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Niepoprawna odpowiedz");
		scanner.nextLine();
	}

	public Wynik wyswietlWynikPoGrze(int poprawnychOdpowiedzi, int wszystkichPytan) {
		System.out.println("Twoj wynik to: " + poprawnychOdpowiedzi + "/" + wszystkichPytan);
		System.out.println("Podaj swoje imię: ");
		Scanner scanner = new Scanner(System.in);
		Wynik wynik = new Wynik();
		String imie = scanner.nextLine();
		wynik.setImie(imie);
		wynik.setPoprawnychOdpowiedzi(poprawnychOdpowiedzi);
		wynik.setWszystkichOdpowiedzi(wszystkichPytan);
		return wynik;
	}

	public void wyswietlWyniki(List<Wynik> listaWynikow) {
		System.out.println("Imię:\tWynik:\tIlość pytań:");
		System.out.println("________________________________________");
		for (Wynik wynik : listaWynikow) {
			System.out.println(
					wynik.getImie() + "\t" + wynik.getPoprawnychOdpowiedzi() + "\t" + wynik.getWszystkichOdpowiedzi());

		}
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}
