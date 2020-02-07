package Dao.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BaseDao;
import Dao.RoomDao;
import entity.Room;

public class RoomDaoImp extends BaseDao implements RoomDao {

	@Override
	public boolean addRoom(Room room) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "insert into room(r_id, r_name, r_address)" + " values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room.getR_id());
			pstmt.setString(2, room.getR_name());
			pstmt.setString(3, room.getR_address());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean delRoom(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "delete from room where r_id=?";
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
	public boolean updateRoom(int number, Room room) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update room set r_id=?, r_name=?, r_address=? where r_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room.getR_id());
			pstmt.setString(2, room.getR_name());
			pstmt.setString(3, room.getR_address());
			pstmt.setInt(4, number);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public Room findRoom(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Room room = null;
		try {
			conn = this.connection();
			String sql = "select * from room where r_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				room = new Room();
				room.setR_id(rs.getInt("r_id"));
				room.setR_name(rs.getString("r_name"));
				room.setR_address(rs.getString("r_address"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return room;
	}

}
