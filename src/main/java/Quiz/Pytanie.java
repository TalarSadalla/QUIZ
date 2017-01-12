package Quiz;

import java.util.List;

public class Pytanie {
	private String pytanie;
	private List<String> odpowiedzi;
	private String poprawnaOdpowiedz;

	public String getPytanie() {
		return pytanie;
	}

	public void setPytanie(String pytanie) {
		this.pytanie = pytanie;
	}

	public List<String> getListaOdpowiedzi() {
		return odpowiedzi;
	}

	public void setListaOdpowiedzi(List<String> listaOdpowiedzi) {
		this.odpowiedzi = listaOdpowiedzi;
	}

	public String getPoprawnaOdpowiedz() {
		return poprawnaOdpowiedz;
	}

	public void setPoprawnaOdpowiedz(String poprawnaOdpowiedz) {
		this.poprawnaOdpowiedz = poprawnaOdpowiedz;
	}

	public String odpowiedziToString() {
		StringBuilder odpowiedzJakoString = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			odpowiedzJakoString.append(odpowiedzi.get(i) + "\r\n");
		}
		return odpowiedzJakoString.toString();

	}

	@Override
	public String toString() {
		return pytanie + "\r\n" + odpowiedziToString() + poprawnaOdpowiedz;
	}

}
