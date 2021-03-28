package vezbanje;

public class Radnik {

	private int mbr;
	private String ime, prezime, datr;
	private int ozrm;
	
	public Radnik() {}

	public Radnik(int mbr, String ime, String prezime, String datr, int ozrm) {
		this();
		this.mbr = mbr;
		this.ime = ime;
		this.prezime = prezime;
		this.datr = datr;
		this.ozrm = ozrm;
	}

	public int getMbr() {
		return mbr;
	}

	public void setMbr(int mbr) {
		this.mbr = mbr;
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

	public String getDatr() {
		return datr;
	}

	public void setDatr(String datr) {
		this.datr = datr;
	}

	public int getOzrm() {
		return ozrm;
	}

	public void setOzrm(int ozrm) {
		this.ozrm = ozrm;
	}

	@Override
	public String toString() {
		return "Radnik [mbr=" + mbr + ", ime=" + ime + ", prezime=" + prezime + ", datr=" + datr + ", ozrm=" + ozrm
				+ "]";
	}
	
}
