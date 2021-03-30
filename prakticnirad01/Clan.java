package prakticnirad01;

public class Clan {

	private int clanskibr;
	private String ime, prezime, adresa;

	public Clan() {
	}

	public Clan(int clanskibr, String ime, String prezime, String adresa) {
		this.clanskibr = clanskibr;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}

	public int getClanskibr() {
		return clanskibr;
	}

	public void setClanskibr(int clanskibr) {
		this.clanskibr = clanskibr;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public String toString() {
		return "Clan [clanskibr=" + clanskibr + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + "]";
	}

}
