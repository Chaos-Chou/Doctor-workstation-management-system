package Dao.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BaseDao;
import Dao.MedicineDao;
import entity.Medicine;

public class MedicineDaoImp extends BaseDao implements MedicineDao {

	@Override
	public boolean addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "insert into medicine(m_id, m_name, producedate, validdate, stock, price)"
					+ " values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, medicine.getM_id());
			pstmt.setString(2, medicine.getM_name());
			pstmt.setDate(3, medicine.getProducedate());
			pstmt.setDate(4, medicine.getValiddate());
			pstmt.setInt(5, medicine.getStock());
			pstmt.setInt(6, medicine.getPrice());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean delMedicine(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "delete from medicine where m_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean modifyPrice(int number, int price) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update medicine set price=? where m_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, number);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean modifyStock(int number, int stock) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update medicine set stock=? where m_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setInt(2, number);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public Medicine findMedicine(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Medicine medicine = null;
		try {
			conn = this.connection();
			String sql = "select * from medicine where m_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				medicine = new Medicine();
				medicine.setM_id(rs.getInt("m_id"));
				medicine.setM_name(rs.getString("m_name"));
				medicine.setProducedate(rs.getDate("producedate"));
				medicine.setValiddate(rs.getDate("validdate"));
				medicine.setStock(rs.getInt("stock"));
				medicine.setPrice(rs.getInt("price"));

			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return medicine;
	}

}
