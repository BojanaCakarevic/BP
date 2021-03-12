package pv01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Oracle baza
//Ispis imena, prezimena i zvanja profesora
public class Zadatak1 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet resS = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			stmt = conn.createStatement();
			resS = stmt.executeQuery(" SELECT * FROM nastavnik");
			System.out.printf("%10s %15s %20s \n", "IME", "PREZIME", "ZVANJE");

			while (resS.next())
				System.out.printf("%10s %-5s %20s \n",resS.getString(2), resS.getString(3), resS.getString(4));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				resS.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
