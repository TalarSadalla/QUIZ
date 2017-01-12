package Quiz;

public class Wynik {
	private String imie;
	private int poprawnychOdpowiedzi;
	private int wszystkichOdpowiedzi;

	@Override
	public String toString() {
		return imie + " " + poprawnychOdpowiedzi + " " + wszystkichOdpowiedzi;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public int getPoprawnychOdpowiedzi() {
		return poprawnychOdpowiedzi;
	}

	public void setPoprawnychOdpowiedzi(int poprawnychOdpowiedzi) {
		this.poprawnychOdpowiedzi = poprawnychOdpowiedzi;
	}

	public int getWszystkichOdpowiedzi() {
		return wszystkichOdpowiedzi;
	}

	public void setWszystkichOdpowiedzi(int wszystkichOdpowiedzi) {
		this.wszystkichOdpowiedzi = wszystkichOdpowiedzi;
	}

}
