package Quiz;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Quiz {
	public static final String SCIEZKA_DO_PLIKU_Z_PYTANIAMI = "C:/Users/RENT/workspace1/OperacjeNaPlikach/quiz.txt";
	public static final String SCIEZKA_DO_PLIKU_Z_ODPOWIEDZIAMI = "C:/Users/RENT/workspace1/OperacjeNaPlikach/wyniki.txt";

	public static void main(String[] args) throws IOException {

		File file = new File(SCIEZKA_DO_PLIKU_Z_PYTANIAMI);
		File plikZWynikami = new File(SCIEZKA_DO_PLIKU_Z_ODPOWIEDZIAMI);
		Wynik wynik = new Wynik();
		QuizInterface quizInterfejs = new QuizInterface();
		QuizOperacje quizOperacjeZPliku = new QuizOperacjeZPliku();

		boolean flagaGłówna = true;
		while (flagaGłówna) {
			Integer WyborTrybu = quizInterfejs.WyborTrybu();
			switch (WyborTrybu) {
			case 1:
				boolean flaga = true;
				while (flaga) {
					Integer opcja = quizInterfejs.menu();

					switch (opcja) {
					case 1:
						List<Pytanie> pytania = quizOperacjeZPliku.pytaniaZPlikuJakoLista(file);
						int poprawnychOdpowiedzi = 0;
						quizInterfejs.przedStartem();
						for (int i = 0; i < pytania.size(); i++) {
							boolean odpowiedz = quizInterfejs.wyswietlPytanie(pytania.get(i));

							if (odpowiedz) {
								quizInterfejs.poprawnaOdpowiedz();
								poprawnychOdpowiedzi++;
							} else {
								quizInterfejs.niepoprawnaOdpowiedz();
							}

						}

						wynik = quizInterfejs.wyswietlWynikPoGrze(poprawnychOdpowiedzi, pytania.size());
						quizOperacjeZPliku.zapiszWynikDoPliku(plikZWynikami, wynik);

						break;
					case 2:

						List<Wynik> wynikiZPlikuJakoLista = quizOperacjeZPliku.wynikiZPlikuJakoLista(plikZWynikami);
						quizInterfejs.wyswietlWyniki(wynikiZPlikuJakoLista);

						break;

					case 3:
						flaga = false;
						break;

					default:

						break;

					}
				}
				break;

			case 2:
				String haslo = quizInterfejs.Autoryzacja();
				boolean flagaAdmina = true;
				if (haslo.equals("Ubmbs"))// Szyfr Cezara
				{
					while (flagaAdmina) {
						Integer opcja = quizInterfejs.menuAdmina();

						switch (opcja) {
						case 1:
							Pytanie nowePytanie = quizOperacjeZPliku.pobieraniePytania();
							System.out.println(nowePytanie);
							quizOperacjeZPliku.zapiszPytanieDoPliku(file, nowePytanie);
							break;
						case 2:
							flagaAdmina = false;
							break;

						default:

							break;

						}
					}
				} else {
					System.out.println("Podałeś błędne hasło, zostaniesz przekierowany do poprzedniego Menu");
					flagaAdmina = false;
				}

				break;

			case 3:
				flagaGłówna = false;
				break;
			}
		}
	}

}
