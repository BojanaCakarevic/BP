package vezbanje;

public class Main {

	public static void main(String[] args) {
		
		Radnik r = new Radnik(38, "Milan", "Mitrovic", "21-02-1995", 1);
		
		System.out.println("UNOS NOVOG RADNIKA");
		if (DBF.dodajRadnika(r))
			System.out.println("Novi radnik uspesno dodat");
		else
			System.out.println("Nije dodat novi radnik");
		System.out.println("--------------------------------");
		
		System.out.println("BRISANJE RADNOG MESTA");
		if (DBF.obrisiRadnoMesto(2))
			System.out.println("Radno mesto uspesno obrisano");
		else
			System.out.println("Radno mesto nije obrisano");
		System.out.println("--------------------------------");
		
		System.out.println("PROMENI IME RADNIKU");
		if (DBF.pomeniIme(1, "Jovana"))
			System.out.println("Odabranom radniku promenjeno ime");
		else
			System.out.println("Ime radnika nije promenjeno");
		System.out.println("--------------------------------");
		
		System.out.println("PRIKAZI RADNIKE NA OVOM RADNOM MESTU");
		DBF.prikaziRadnike(1);
		System.out.println("--------------------------------");
		
	}

}
