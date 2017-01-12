package Quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface QuizOperacje {
	List<Pytanie> pytaniaZPlikuJakoLista(File file) throws FileNotFoundException;

	void zapiszWynikDoPliku(File plikZWynikami, Wynik wynik) throws IOException;

	List<Wynik> wynikiZPlikuJakoLista(File plikZWynikami) throws FileNotFoundException;

	Pytanie pobieraniePytania();

	void zapiszPytanieDoPliku(File plikZWynikami, Pytanie pytanie) throws IOException;
}
