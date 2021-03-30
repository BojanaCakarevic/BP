package prakticnirad01;

public class Knjiga {

	private int inventarnibr;
	private String naslov;

	public Knjiga() {
	}

	public Knjiga(int inventarnibr, String naslov) {
		this();
		this.inventarnibr = inventarnibr;
		this.naslov = naslov;
	}

	public int getInventarnibr() {
		return inventarnibr;
	}

	public void setInventarnibr(int inventarnibr) {
		this.inventarnibr = inventarnibr;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	@Override
	public String toString() {
		return "Knjiga [inventarnibr=" + inventarnibr + ", naslov=" + naslov + "]";
	}

}
