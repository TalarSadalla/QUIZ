package Quiz;

public class QuizSzyfrCezara implements QuizSzyfr {

	@Override
	public String szyfruj(String wiadomosc) {
		char[] znaki = wiadomosc.toCharArray();
		char[] zakodowaneZnaki = new char[znaki.length];
		for (int i = 0; i < znaki.length; i++) {
			zakodowaneZnaki[i] = (char) (znaki[i] + 1);
		}
		return String.valueOf(zakodowaneZnaki);
	}

	@Override
	public String rozszyfruj(String zakodowanaWiadomosc) {
		char[] znaki = zakodowanaWiadomosc.toCharArray();
		char[] zakodowaneZnaki = new char[znaki.length];
		for (int i = 0; i < znaki.length; i++) {
			zakodowaneZnaki[i] = (char) (znaki[i] - 1);
		}
		return String.valueOf(zakodowaneZnaki);
	}

}
