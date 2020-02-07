package Dao.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BaseDao;
import Dao.BuymedicineDao;
import entity.Buymedicine;

public class BuymedicineDaoImp extends BaseDao implements BuymedicineDao {

	@Override
	public boolean addBuymedicine(Buymedicine order) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "insert into buymedicine values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOrder_id());
			pstmt.setInt(2, order.getP_id());
			pstmt.setInt(3, order.getM_id());
			pstmt.setTimestamp(4, order.getBuy_time());
			pstmt.setInt(5, order.getBuy_number());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean delBuymedicine(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "delete from buymedicine where order_id=?";
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
	public Buymedicine findBuymedicine(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Buymedicine order = null;
		try {
			conn = this.connection();
			String sql = "select * from buymedicine where order_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				order = new Buymedicine();
				order.setOrder_id(rs.getInt("order_id"));
				order.setP_id(rs.getInt("p_id"));
				order.setM_id(rs.getInt("m_id"));
				order.setBuy_time(rs.getTimestamp("buy_time"));
				order.setBuy_number(rs.getInt("buy_number"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return order;
	}

}
