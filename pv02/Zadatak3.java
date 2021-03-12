package pv02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Dodavanje nastavnika
public class Zadatak3 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			stmt = conn.createStatement();
			int brRedova = stmt.executeUpdate("insert into Nastavnik (nastavnik_id, ime, prezime, zvanje) values (88, 'Bojana', 'Cakarevic', 'profesor')");
			System.out.println("Dodat je " + brRedova + " nastavnik");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
