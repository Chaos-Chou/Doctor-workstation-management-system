package Dao.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.BaseDao;
import Dao.DoctorDao;
import entity.Doctor;

public class DoctorDaoImp extends BaseDao implements DoctorDao {

	@Override
	public boolean addDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "insert into doctor(d_id, d_name, d_gender, d_phone, room_id, grade, worktime)"
					+ " values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doc.getD_id());
			pstmt.setString(2, doc.getD_name());
			pstmt.setString(3, doc.getD_gender());
			pstmt.setString(4, doc.getD_phone());
			pstmt.setInt(5, doc.getRoom_id());
			pstmt.setInt(6, doc.getGrade());
			pstmt.setInt(7, doc.getWorktime());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean delDoctor(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "delete from doctor where d_id=?";
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
	public boolean updateDoctor(int num, Doctor doc) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update doctor set d_id=?, d_name=?, d_gender=?, d_phone=?, room_id=?, grade=?, worktime=? where d_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, doc.getD_id());
			pstmt.setString(2, doc.getD_name());
			pstmt.setString(3, doc.getD_gender());
			pstmt.setString(4, doc.getD_phone());
			pstmt.setInt(5, doc.getRoom_id());
			pstmt.setInt(6, doc.getGrade());
			pstmt.setInt(7, doc.getWorktime());
			pstmt.setInt(8, num);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean updateWorktime(int docId, int worktime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update doctor set worktime=? where d_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, worktime);
			pstmt.setInt(2, docId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public Doctor findDoctor(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Doctor doctor = null;
		try {
			conn = this.connection();
			String sql = "select * from doctor join room on r_id=doctor.room_id where d_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				doctor = new Doctor();
				doctor.setD_id(rs.getInt("d_id"));
				doctor.setD_name(rs.getString("d_name"));
				doctor.setD_gender(rs.getString("d_gender"));
				doctor.setD_phone(rs.getString("d_phone"));
				doctor.setRoom_id(rs.getInt("room_id"));
				doctor.setGrade(rs.getInt("grade"));
				doctor.setWorktime(rs.getInt("worktime"));
				doctor.room.setR_id(rs.getInt("r_id"));
				doctor.room.setR_name(rs.getString("r_name"));
				doctor.room.setR_address(rs.getString("r_address"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return doctor;
	}

	@Override
	public ArrayList<Doctor> findDoctorsGrade(int grade) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		try {
			conn = this.connection();
			String sql = "select * from doctor join room on r_id=doctor.room_id where grade=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grade);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setD_id(rs.getInt("d_id"));
				doctor.setD_name(rs.getString("d_name"));
				doctor.setD_gender(rs.getString("d_gender"));
				doctor.setD_phone(rs.getString("d_phone"));
				doctor.setRoom_id(rs.getInt("room_id"));
				doctor.setGrade(rs.getInt("grade"));
				doctor.setWorktime(rs.getInt("worktime"));
				doctor.room.setR_id(rs.getInt("r_id"));
				doctor.room.setR_name(rs.getString("r_name"));
				doctor.room.setR_address(rs.getString("r_address"));
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return doctors;
	}

	@Override
	public ArrayList<Doctor> findDoctorsTime(int worktime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		try {
			conn = this.connection();
			String sql = "select * from doctor join room on r_id=doctor.room_id where worktime=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, worktime);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setD_id(rs.getInt("d_id"));
				doctor.setD_name(rs.getString("d_name"));
				doctor.setD_gender(rs.getString("d_gender"));
				doctor.setD_phone(rs.getString("d_phone"));
				doctor.setRoom_id(rs.getInt("room_id"));
				doctor.setGrade(rs.getInt("grade"));
				doctor.setWorktime(rs.getInt("worktime"));
				doctor.room.setR_id(rs.getInt("r_id"));
				doctor.room.setR_name(rs.getString("r_name"));
				doctor.room.setR_address(rs.getString("r_address"));
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return doctors;
	}

}
