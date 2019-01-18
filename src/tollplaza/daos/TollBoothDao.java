package tollplaza.daos;

import tollplaza.utilities.*;
import tollplaza.pojos.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TollBoothDao {
	public static int create(TollBooth tollBooth) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		int id = 0;
		try {
			String sql = "insert into toll_booth ( tb_no, tb_location, tb_handler, tb_highway) "
					+ "values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, tollBooth.getTbNo());
			ps.setString(2, tollBooth.getTbLocation());
			ps.setString(3, tollBooth.getTbHandler());
			ps.setString(4, tollBooth.getHighway());
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

	public static boolean edit(TollBooth tollBooth) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		boolean b = true;
		Connection conn = pool.getConnection();
		try {
			String sql = "update toll_booth "
					+ "set tb_no = ?, tb_location = ?, tb_handler = ?, tb_highway = ? where tb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, tollBooth.getTbNo());
			ps.setString(2, tollBooth.getTbLocation());
			ps.setString(3, tollBooth.getTbHandler());
			ps.setString(4, tollBooth.getHighway());
			ps.setInt(5, tollBooth.getTbId());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static boolean remove(int tbId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		boolean b = true;
		try {
			String sql = "delete from toll_booth where tb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tbId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete row." + sq);
			b = false;
		} finally {
			pool.putConnection(conn);
		}
		return b;
	}

	public static TollBooth find(int tbId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		TollBooth tollBooth = new TollBooth();
		try {
			String sql = "select * from toll_booth where tb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tbId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tollBooth.setTbId(tbId);
				tollBooth.setHighway(rs.getString("tb_highway"));
				tollBooth.setTbHandler(rs.getString("tb_handler"));
				tollBooth.setTbLocation(rs.getString("tb_location"));
				tollBooth.setTbNo(rs.getInt("tb_no"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return tollBooth;
	}

	public static ArrayList<TollBooth> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<TollBooth> listTollBooth = new ArrayList<TollBooth>();
		try {
			String sql = "select * from toll_booth";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TollBooth tollBooth = new TollBooth();
				tollBooth.setTbId(rs.getInt("tb_id"));
				tollBooth.setHighway(rs.getString("tb_highway"));
				tollBooth.setTbHandler(rs.getString("tb_handler"));
				tollBooth.setTbLocation(rs.getString("tb_location"));
				tollBooth.setTbNo(rs.getInt("tb_no"));
				listTollBooth.add(tollBooth);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listTollBooth;
	}

	public static void main(String args[]) {
		// java.util.Date dt = DateUtils.convertDate("22-04-2018");
		// java.util.Date dt1 = DateUtils.convertDate("12-02-1018");
//		 TollBooth tollBooth = new TollBooth(88, "ADWADA", "ASDASD", "JYUUYU");
//		 System.out.println(TollBoothDao.create(tollBooth));

//		 TollBooth tollBooth = new TollBooth(1, 88,
//		 "ADWADA", "ASDASD", "JYUUYUqwerty");
//		 System.out.println(TollBoothDao.edit(tollBooth));

//		 TollBoothDao.remove(1);

//		 System.out.println(TollBoothDao.find(3));
//		 System.out.println(TollBoothDao.findAll());
	}

	
	
}
