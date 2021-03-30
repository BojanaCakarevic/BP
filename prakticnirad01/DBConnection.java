package prakticnirad01;

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
			conn = DriverManager.getConnection("jdbc:mysql://localhost/prakticnirad", "root", "root");
		} catch (Exception e) {
			System.err.println("Doslo je do greske prilikom konekcije");
			e.printStackTrace();
		}

	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
