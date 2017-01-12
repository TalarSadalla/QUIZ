package Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class QuizOperacjeZPlikuTest {

	private QuizOperacjeZPliku quizOperacjeZPliku;
	private File file;

	@Before
	public void setUp() {
		quizOperacjeZPliku = new QuizOperacjeZPliku();
		file = new File(Quiz.SCIEZKA_DO_PLIKU_Z_PYTANIAMI);
	}

	@Test
	public void pytaniaZPlikuJakoListaTest() throws FileNotFoundException {
		List<Pytanie> pytania = quizOperacjeZPliku.pytaniaZPlikuJakoLista(file);
		int iloscLinii = pobierzIloscLiniZPliku(file);
		int expectedValue = iloscLinii / 6;
		int actualValue = pytania.size();
		Assert.assertEquals("Niezgodna ilość linii w pliku do ilości pytań", expectedValue, actualValue);
	}

	@Test(expected = FileNotFoundException.class)
	public void czyPlikZPytaniamiIstnieje() throws FileNotFoundException {
		boolean exceptionThrown = false;
		try {
			quizOperacjeZPliku.pytaniaZPlikuJakoLista(file);
		} catch (FileNotFoundException e) {
			exceptionThrown = true;
		}
		if (!exceptionThrown) {
			throw new FileNotFoundException();
		}
	}

	private int pobierzIloscLiniZPliku(File file) throws FileNotFoundException {
		int licznik = 0;
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			licznik++;
			scanner.nextLine();
		}
		return licznik;

	}
}
