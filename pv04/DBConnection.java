package pv04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn;

	public static Connection getConn() {
		return conn;
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/pv04", "root", "root");
		} catch (Exception e) {
			System.err.println("Greska prilikom konektovanja na bazu!");
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				System.err.println("Greska prilikom zatvaranja konekcije!");
				ex.printStackTrace();
			}
		}
	}

}
