package vezbanje;

public class RadnoMesto {

	private int ozrm;
	private String naziv;
	
	public RadnoMesto() {}
	
	public RadnoMesto(int ozrm, String naziv) {
		super();
		this.ozrm = ozrm;
		this.naziv = naziv;
	}

	public int getOzrm() {
		return ozrm;
	}

	public void setOzrm(int ozrm) {
		this.ozrm = ozrm;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Radnik [ozrm=" + ozrm + ", naziv=" + naziv + "]";
	}
	
}
