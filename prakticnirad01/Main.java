package prakticnirad01;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Clan c = new Clan(6, "Milan", "Milosevic", "Sime Milosevica 5");
		
		System.out.println("1. UNOS NOVOG CLANA");
		if (DBF.unosClana(c))
			System.out.println("Clan uspesno unet.");
		else
			System.out.println("Nije uspesno unet clan.");
		System.out.println("-------------------------------------");
		
		System.out.println("2. PROMENA ADRESE POSTOJECEG CLANA");
		if (DBF.promenaAdrese(3, "Proleterska br. 15"))
			System.out.println("Adresa uspesno promenjena");
		else
			System.out.println("Adresa nije promenjena.");
		System.out.println("-------------------------------------");
		
		
		System.out.println("3. BRISANJE CLANA");
		if (DBF.obrisiClana(2))
			System.out.println("Clan je obrisan.");
		else
			System.out.println("Clan nije obrisan.");
		System.out.println("-------------------------------------");
		
		System.out.println("4. PRIKAZ NASLOVA KOJE JE IZNAJMIO CLAN SA OVIM CLANSKIM BROJEM");
		DBF.prikazNaslova(4);
		System.out.println("-------------------------------------");
		
		try {
			DBConnection.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
