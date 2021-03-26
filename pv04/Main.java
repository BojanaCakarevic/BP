package pv04;

public class Main {

	public static void main(String[] args) {
		try {

			Nastavnik nastavnik = new Nastavnik(10, "Milan", "Radovic", "profesor");

			// 1
			System.out.println("UNOS NOVOG NASTAVNIKA: ");
			if (DBF.dodajNastavnika(nastavnik))
				System.out.println("Unet novi nastavnik");
			else
				System.out.println("Nije unet novi nastavnik");
			System.out.println("-----------------------------");

			// 2
			System.out.println("BRISANJE NASTAVNIKA:");
			if (DBF.obrisiNastavnika(3))
				System.out.println("Nastavnik uspesno obrisan");
			else
				System.out.println("Nastavnik nije obrisan");
			System.out.println("-----------------------------");
			
			// 3
			System.out.println("PRIKAZ PREDMETA ODABRANOG NASTAVNIKA:");
			DBF.prikazPredmeta(1);
			System.out.println("-----------------------------");

			// 4
			System.out.println("PROMENA PREZIMENA NASTAVNIKA:");
			if (DBF.promeniPrezime(2, "Lazarevic"))
				System.out.println("Prezime nastavnika je promenjeno");
			else
				System.out.println("Prezime nastavnika nije promenjeno");
			System.out.println("-----------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}

}
