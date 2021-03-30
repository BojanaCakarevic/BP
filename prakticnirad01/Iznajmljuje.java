package prakticnirad01;

public class Iznajmljuje {

	private int clanskibr, inventarnibr;
	private String datum;

	public Iznajmljuje() {
	}

	public Iznajmljuje(int clanskibr, int inventarnibr, String datum) {
		this();
		this.clanskibr = clanskibr;
		this.inventarnibr = inventarnibr;
		this.datum = datum;
	}

	public int getClanskibr() {
		return clanskibr;
	}

	public void setClanskibr(int clanskibr) {
		this.clanskibr = clanskibr;
	}

	public int getInventarnibr() {
		return inventarnibr;
	}

	public void setInventarnibr(int inventarnibr) {
		this.inventarnibr = inventarnibr;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Iznajmljuje [clanskibr=" + clanskibr + ", inventarnibr=" + inventarnibr + ", datum=" + datum + "]";
	}

}
