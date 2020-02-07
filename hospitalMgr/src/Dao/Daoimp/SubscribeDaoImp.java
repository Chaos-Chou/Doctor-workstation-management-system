package Dao.Daoimp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BaseDao;
import Dao.SubscribeDao;
import entity.Subscribe;

public class SubscribeDaoImp extends BaseDao implements SubscribeDao {

	@Override
	public boolean addSubscribe(Subscribe subscribe) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "insert into subscribe(s_id, s_date, p_id, d_id, state)" + " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subscribe.getS_id());
			pstmt.setDate(2, subscribe.getS_date());
			pstmt.setInt(3, subscribe.getP_id());
			pstmt.setInt(4, subscribe.getD_id());
			pstmt.setInt(5, subscribe.getState());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean delSubscribe(Date date, int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "delete from subscribe where to_days(s_date) = to_days(?) AND s_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
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
	public Subscribe findSubscribe(Date date, int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Subscribe subscribe = null;
		try {
			conn = this.connection();
			String sql = "select * from subscribe where s_date=? AND s_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
			pstmt.setInt(2, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subscribe = new Subscribe();
				subscribe.setS_id(rs.getInt("s_id"));
				subscribe.setS_date(rs.getDate("s_date"));
				subscribe.setP_id(rs.getInt("p_id"));
				subscribe.setD_id(rs.getInt("d_id"));
				subscribe.setState(rs.getInt("state"));

			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return subscribe;
	}

	@Override
	public Subscribe findNextSubscribe(int doctorId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Subscribe subscribe = null;
		try {
			conn = this.connection();
			String sql = "select * from subscribe where subscribe.s_id = (select MIN(s_id) from subscribe s where s.state = 1 and s.s_date = (select MIN(s_date) from subscribe where subscribe.d_id = ? and subscribe.state = 1)) and subscribe.state = 1 and subscribe.s_date =(select MIN(s_date) from subscribe where subscribe.d_id = ? and subscribe.state = 1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doctorId);
			pstmt.setInt(2, doctorId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				subscribe = new Subscribe();
				subscribe.setS_id(rs.getInt("s_id"));
				subscribe.setS_date(rs.getDate("s_date"));
				subscribe.setP_id(rs.getInt("p_id"));
				subscribe.setD_id(rs.getInt("d_id"));
				subscribe.setState(rs.getInt("state"));

			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return subscribe;
	}

	@Override
	public boolean updateSubscribe(Date date, int number, int state) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update subscribe set state=? where s_id=? AND s_date=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, state);
			pstmt.setInt(2, number);
			pstmt.setDate(3, date);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

}
