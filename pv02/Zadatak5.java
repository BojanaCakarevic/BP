package pv02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Zadatak5 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			// Konekcija nije u AutoCommit rezimu rada
			// Sve do sledeceg commit-a je jedna transakcija
			// Izvrsice se obe ili nijedna
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement("insert into Nastavnik (nastavnik_id, ime, prezime, zvanje) "
					+ "values (?, ?, ?, ?)");
			pstmt.setInt(1, 8819);
			pstmt.setString(2, "Mika");
			pstmt.setString(3, "Milosevic");
			pstmt.setString(4, "profesor");
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into Nastavnik (nastavnik_id, ime, prezime, zvanje)"
					+ " values (?, ?, ?, ?)");
			pstmt.setInt(1, 8819);
			pstmt.setString(2, "Pera");
			pstmt.setString(3, "Lazic");
			pstmt.setString(4, "profesor");
			pstmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				// Ako dodje do greske pomocu rollback-a se opoziva transakcija
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
