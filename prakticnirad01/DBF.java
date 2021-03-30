package prakticnirad01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {

	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rset;

	public static boolean unosClana(Clan c) {
		boolean rez = false;

		try {
			pstmt = DBConnection.getConn()
					.prepareStatement("insert into Clan(clanski_broj, ime, prezime, adresa) values (?, ?, ?, ?)");
			pstmt.setInt(1, c.getClanskibr());
			pstmt.setString(2, c.getIme());
			pstmt.setString(3, c.getPrezime());
			pstmt.setString(4, c.getAdresa());
			int brRedova = pstmt.executeUpdate();

			rez = brRedova > 0;
		} catch (Exception e) {
			rez = false;
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return rez;
	}

	public static boolean promenaAdrese(int id, String novaAdresa) {
		boolean rez = false;

		try {
			DBConnection.getConn().setAutoCommit(true);

			pstmt = DBConnection.getConn().prepareStatement("update Clan set adresa = ? where clanski_broj = ?");
			pstmt.setInt(2, id);
			pstmt.setString(1, novaAdresa);
			int brRedova = pstmt.executeUpdate();

			rez = brRedova > 0;
		} catch (Exception e) {
			rez = false;
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return rez;
	}

	public static boolean obrisiClana(int id) {
		boolean rez = false;

		try {
			DBConnection.getConn().setAutoCommit(false);

			pstmt = DBConnection.getConn().prepareStatement("delete from Iznajmljuje where clanski_br = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt = DBConnection.getConn().prepareStatement("delete from Clan where clanski_br = ?");
			pstmt.setInt(1, id);
			int brRedova = pstmt.executeUpdate();

			DBConnection.getConn().commit();
			rez = brRedova > 0;
		} catch (Exception e) {
			try {
				DBConnection.getConn().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rez = false;
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return rez;
	}

	public static void prikazNaslova(int id) {

		try {

			stmt = DBConnection.getConn().createStatement();
			rset = stmt.executeQuery(
					"select k.naslov from Knjiga k, Iznajmljuje i, Clan c where k.inventarni_broj = i.inventarni_broj and "
							+ " i.clanski_broj = c.clanski_broj and i.clanski_broj = " + id);
			while (rset.next()) {
				System.out.println(rset.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (rset != null)
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
