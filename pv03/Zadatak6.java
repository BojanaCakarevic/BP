package pv03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Zadatak6 {

	public static void main(String[] args) {
		Connection conn = null;
		CallableStatement cstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");

			cstmt = conn.prepareCall("{ ? = call povezi(?, ?, ?)}");
			cstmt.setString(2, "Bojana");
			cstmt.setString(3, "Cakarevic");
			cstmt.setString(4, "Analiza 1");
			cstmt.registerOutParameter(1, Types.INTEGER);

			cstmt.executeUpdate();
			System.out.println("Rezultat izvrsavanja: " + cstmt.getInt(1));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (cstmt != null)
					cstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
