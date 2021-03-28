package vezbanje;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {
	
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rset;
	
	public static boolean dodajRadnika(Radnik r) {
		boolean rez = false;
		
		try {
			
			pstmt = DBConnection.getConn().prepareStatement("insert into Radnik(mbr, ime, prz, datr, ozrm) values (?, ?, ?, ?, ?)");
			pstmt.setInt(1, r.getMbr());
			pstmt.setString(2, r.getIme());
			pstmt.setString(3, r.getPrezime());
			pstmt.setString(4, r.getDatr());
			pstmt.setInt(5, r.getOzrm());
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
	
	public static boolean obrisiRadnoMesto(int id) {
		boolean rez = false;
		
		try {
			DBConnection.getConn().setAutoCommit(false);
			
			pstmt = DBConnection.getConn().prepareStatement("delete from Radnik where ozrm = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			pstmt = DBConnection.getConn().prepareStatement("delete from RadnoMesto where ozrm = ?");
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
	
	public static boolean pomeniIme (int mbr, String novoIme) {
		boolean rez = false;
		
		try {
			DBConnection.getConn().setAutoCommit(true);
			
			pstmt = DBConnection.getConn().prepareStatement("update Radnik set ime = ? where mbr = ?");
			pstmt.setInt(2, mbr);
			pstmt.setString(1, novoIme);
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
	
	public static void prikaziRadnike (int id) {
		
		try {
			
			stmt = DBConnection.getConn().createStatement();
			rset = stmt.executeQuery("select ime, prz from Radnik r, RadnoMesto rm where r.ozrm = rm.ozrm and rm.ozrm = " + id);
			while (rset.next()) {
				System.out.println(rset.getString(1) + " " + rset.getString(2));
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
