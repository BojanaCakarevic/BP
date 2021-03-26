package pv04;

public class Nastavnik {
	private int idNastavnika;
	private String ime, prezime, zvanje;

	public Nastavnik() {
	}

	public Nastavnik(int idNastavnika, String ime, String prezime, String zvanje) {
		this.idNastavnika = idNastavnika;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}

	public int getIdNastavnika() {
		return idNastavnika;
	}

	public void setIdNastavnika(int idNastavnika) {
		this.idNastavnika = idNastavnika;
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

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	@Override
	public String toString() {
		return "Nastavnik [IdNastavnika=" + idNastavnika + ", ime=" + ime + ", prezime=" + prezime + ", zvanje="
				+ zvanje + "]";
	}

}
