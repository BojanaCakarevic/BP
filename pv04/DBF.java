package pv04;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rSet;

	public static boolean dodajNastavnika(Nastavnik n) {
		boolean rez = false;
		try {
			pstmt = DBConnection.getConn()
					.prepareStatement("insert into (nastavnik_id, ime, prezime, zvanje) values (?, ?, ?, ?)");
			pstmt.setInt(1, n.getIdNastavnika());
			pstmt.setString(2, n.getIme());
			pstmt.setString(3, n.getPrezime());
			pstmt.setString(4, n.getZvanje());
			int brRedova = pstmt.executeUpdate();
			rez = brRedova > 0;
		} catch (SQLException e) {
			rez = false;
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rez;
	}

	public static boolean obrisiNastavnika(int id) {
		boolean rez = false;
		try {
			DBConnection.getConn().setAutoCommit(false);

			pstmt = DBConnection.getConn().prepareStatement("delete from predaje where nastavnik_id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt = DBConnection.getConn().prepareStatement("delete from nastavnik where nastavnik_id = ?");
			pstmt.setInt(1, id);
			int brRedova = pstmt.executeUpdate();

			DBConnection.getConn().commit();
			rez = brRedova > 0;
		} catch (Exception e) {
			rez = false;
			try {
				DBConnection.getConn().rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rez;
	}

	public static void prikazPredmeta(int id) {

		try {
			stmt = DBConnection.getConn().createStatement();
			rSet = stmt.executeQuery(
					"select naziv from predmet p, predaje pr where p.predmet_id = pr.predmet_id and pr.nastavnik_id = "
							+ id);
			while (rSet.next()) {
				System.out.println(rSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rSet != null) {
				try {
					rSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean promeniPrezime(int id, String novoPrz) {
		boolean rez = false;

		try {
			DBConnection.getConn().setAutoCommit(true);

			pstmt = DBConnection.getConn().prepareStatement("update Nastavnik set prezime = ? where nastavnik_id = ?");
			pstmt.setString(1, novoPrz);
			pstmt.setInt(2, id);
			int brRedova = pstmt.executeUpdate();

			rez = brRedova > 0;
		} catch (Exception e) {
			rez = false;
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rez;
	}

}
