package Dao;

import java.util.ArrayList;

import entity.Doctor;

/**
 * 
 * 医生实体类的增删改查
 *
 */
public interface DoctorDao {
	boolean addDoctor(Doctor doc);

	/**
	 * 添加医生
	 */
	boolean delDoctor(int number);

	/**
	 * 删除医生
	 */
	boolean updateDoctor(int num, Doctor doc);

	/**
	 * 更改信息
	 */

	boolean updateWorktime(int docId, int worktime);

	/**
	 * 更改工作时间段
	 */

	Doctor findDoctor(int number);

	/**
	 * 查找指定职工号的医生信息
	 */
	ArrayList<Doctor> findDoctorsGrade(int grade);

	/**
	 * 查找对应等级的所有医生
	 */
	ArrayList<Doctor> findDoctorsTime(int worktime);
	/**
	 * 查找对应工作时间的所有医生
	 */
}
