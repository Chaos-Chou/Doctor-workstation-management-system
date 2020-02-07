package Dao;

import entity.Patient;

/**
 * 
 * 患者实体类的增删改查
 *
 */
public interface PatientDao {
	boolean addPatient(Patient patient);

	/**
	 * 增加病人
	 */
	boolean delPatient(int number);

	/**
	 * 删除指定编号的病人
	 */
	boolean updatePatient(int number, Patient patient);

	/**
	 * 更改指定编号的病人信息
	 */
	Patient findPatient(int number);
	/**
	 * 查找病人信息
	 */
}
