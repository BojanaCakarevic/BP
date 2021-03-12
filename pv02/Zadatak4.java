package pv02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Zadatak4 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			pstmt = conn.prepareStatement("insert into Nastavnik (nastavnik_id, ime, prezime, zvanje) values (?, ?, ?, ?)");
			pstmt.setInt(1, 881);
			pstmt.setString(2, "Bojana");
			pstmt.setString(3, "Cakarevic");
			pstmt.setString(4, "profesor");
			pstmt.executeUpdate();
			// Ako dodamo jos jedan id vrednosti 881 prvi profesor ce se dodati, a drugi ne
			// To je svakako greska, te treba primeniti transakcije - sve ili nista
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
}