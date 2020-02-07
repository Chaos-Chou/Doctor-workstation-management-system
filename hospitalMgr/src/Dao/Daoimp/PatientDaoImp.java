package Dao.Daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BaseDao;
import Dao.PatientDao;
import entity.Patient;

public class PatientDaoImp extends BaseDao implements PatientDao {

	@Override
	public boolean addPatient(Patient patient) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "insert into patient(p_id, p_name, p_gender, id_num, p_phone, p_address, hometown)"
					+ " values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, patient.getP_id());
			pstmt.setString(2, patient.getP_name());
			pstmt.setString(3, patient.getP_gender());
			pstmt.setString(4, patient.getId_num());
			pstmt.setString(5, patient.getP_phone());
			pstmt.setString(6, patient.getP_address());
			pstmt.setString(7, patient.getHometown());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public boolean delPatient(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "delete from patient where p_id=?";
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
	public boolean updatePatient(int number, Patient patient) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = this.connection();
			String sql = "update patient set p_id=?, p_name=?, p_gender=?, id_num=?, p_phone=?, p_address=?, hometown=? where p_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, patient.getP_id());
			pstmt.setString(2, patient.getP_name());
			pstmt.setString(3, patient.getP_gender());
			pstmt.setString(4, patient.getId_num());
			pstmt.setString(5, patient.getP_phone());
			pstmt.setString(6, patient.getP_address());
			pstmt.setString(7, patient.getHometown());
			pstmt.setInt(8, number);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return result != 0;
	}

	@Override
	public Patient findPatient(int number) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Patient patient = null;
		try {
			conn = this.connection();
			String sql = "select * from patient where p_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				patient = new Patient();
				patient.setP_id(rs.getInt("p_id"));
				patient.setP_name(rs.getString("p_name"));
				patient.setP_gender(rs.getString("p_gender"));
				patient.setId_num(rs.getString("id_num"));
				patient.setP_phone(rs.getString("p_phone"));
				patient.setP_address(rs.getString("p_address"));
				patient.setHometown(rs.getString("hometown"));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return patient;
	}

}
