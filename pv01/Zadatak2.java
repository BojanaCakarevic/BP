package pv01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//MySQL baza
//Ispis predmeta koje predaje Petar Peric
public class Zadatak2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt  = null;
		ResultSet resS = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			stmt = conn.createStatement();
			resS = stmt.executeQuery("SELECT p.predmet_id, p.naziv FROM nastavnik n, predmet p, predaje pr " 
					+ "WHERE pr.nastavnik_id = n.nastavnik_id AND pr.predmet_id = p.predmet_id " 
					+ "and n.ime = 'Petar' and n.prezime = 'Peric'");
			System.out.printf("%-15s %-15s \n", "ID PREDMETA", "NAZIV");
			while(resS.next())
				System.out.printf("%-15s %-15s \n", resS.getInt(1), resS.getString(2));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				if(resS != null)
					resS.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
