package tollplaza.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tollplaza.pojos.Vehical;
import tollplaza.utilities.*;

public class VehicalDao {

	public static int create(Vehical vehical) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into vehical ( tb_id, reg_no, arrival_time, vt_id, tax_collected) "
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, vehical.getTbId());
			ps.setString(2, vehical.getRegNo());
			java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
			ps.setTime(3, sqlDate);
			ps.setInt(4, vehical.getVtId());
			ps.setFloat(5, vehical.getTaxCollected());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}

	public static boolean edit(Vehical vehical) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update vehical "
					+ "set tb_id = ?, reg_no = ?, arrival_time = ?, vt_id = ?, tax_collected = ? where v_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vehical.getTbId());
			ps.setString(2, vehical.getRegNo());
			java.sql.Time sqlDate = new java.sql.Time(new java.util.Date().getTime());
			ps.setTime(3, sqlDate);
			ps.setInt(4, vehical.getVtId());
			ps.setFloat(5, vehical.getTaxCollected());
			ps.setInt(6, vehical.getvId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int vId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from vehical where v_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static Vehical find(int vId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Vehical vehical = new Vehical();
		try {
			String sql = "select * from vehical where v_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vehical.setvId(vId);
				vehical.setTbId(rs.getInt("tb_id"));
				vehical.setRegNo(rs.getString("reg_no"));
				java.sql.Timestamp dt = rs.getTimestamp("arrival_time");
				vehical.setArrivalTime(new java.util.Date(dt.getTime()));
				vehical.setVtId(rs.getInt("tb_no"));
				vehical.setTaxCollected(rs.getFloat("tax_collected"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return vehical;
	}

	public static float findGrandTotalTax() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select sum(tax_collected) as tax from vehical ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getFloat("tax");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return 0.0f;
	}

	public static float findTotalBoothTax(int tbId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select sum(tax_collected) as tax from vehical where tb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tbId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getFloat("tax");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return 0.0f;
	}
	
	public static ArrayList<Vehical> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Vehical> listVehical = new ArrayList<Vehical>();
		try {
			String sql = "select * from vehical";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vehical vehical = new Vehical();
				vehical.setvId(rs.getInt("v_id"));
				vehical.setTbId(rs.getInt("tb_id"));
				vehical.setRegNo(rs.getString("reg_no"));
				java.sql.Timestamp dt = rs.getTimestamp("arrival_time");
				vehical.setArrivalTime(new java.util.Date(dt.getTime()));
				vehical.setVtId(rs.getInt("tb_no"));
				vehical.setTaxCollected(rs.getFloat("tax_collected"));
				listVehical.add(vehical);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listVehical;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// Vehical vehical = new Vehical(88, "ADWADA", dt, 123456, 146.5f);
		// System.out.println(VehicalDao.create(vehical));

		// Vehical vehical = new Vehical(1, 88,
		// "ADWADA", "ASDASD", "JYUUYUqwerty");
		// System.out.println(VehicalDao.edit(vehical));

		// VehicalDao.remove(1);
//		System.out.println(VehicalDao.findGrandTotalTax());
//		 System.out.println(VehicalDao.findTotalBoothTax(88));
		// System.out.println(VehicalDao.findAll());
	}

}
