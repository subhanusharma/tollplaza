package tollplaza.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tollplaza.pojos.VehicalType;
import tollplaza.utilities.ConnectionPool;

public class VehicalTypeDao {

	public static int create(VehicalType vehicalType) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into vehical_type ( vt_name, vt_tax) " + "values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, vehicalType.getVtName());
			ps.setFloat(2, vehicalType.getVtTax());
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

	public static boolean edit(VehicalType vehicalType) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update vehical_type "
					+ "set vt_name = ?, vt_tax = ? where vt_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vehicalType.getVtName());
			ps.setFloat(2, vehicalType.getVtTax());
			ps.setInt(3, vehicalType.getVtId());

			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int vtId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from vehical_type where vt_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vtId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static VehicalType find(int vtId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		VehicalType vehicalType = new VehicalType();
		try {
			String sql = "select * from vehical_type where vt_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vtId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vehicalType.setVtId(vtId);
				vehicalType.setVtName(rs.getString("vt_name"));
				vehicalType.setVtTax(rs.getFloat("vt_tax"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return vehicalType;
	}

	public static ArrayList<VehicalType> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<VehicalType> listVehicalType = new ArrayList<VehicalType>();
		try {
			String sql = "select * from vehical_type";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				VehicalType vehicalType = new VehicalType();
				vehicalType.setVtId(rs.getInt("vt_id"));
				vehicalType.setVtName(rs.getString("vt_name"));
				vehicalType.setVtTax(rs.getFloat("vt_tax"));
				listVehicalType.add(vehicalType);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listVehicalType;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
		// VehicalType vehicalType = new VehicalType(88, "ADWADA", "ASDASD", "JYUUYU");
		// System.out.println(VehicalTypeDao.create(vehicalType));

		// VehicalType vehicalType = new VehicalType(1, 88,
		// "ADWADA", "ASDASD", "JYUUYUqwerty");
		// System.out.println(VehicalTypeDao.edit(vehicalType));

		// VehicalTypeDao.remove(1);

		// System.out.println(VehicalTypeDao.find(3));
		// System.out.println(VehicalTypeDao.findAll());
	}

}
