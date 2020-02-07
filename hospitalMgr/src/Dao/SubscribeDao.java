package Dao;

import java.sql.Date;

import entity.Subscribe;

/**
 * 
 * 患者预约医生信息的增删改查
 *
 */
public interface SubscribeDao {
	boolean addSubscribe(Subscribe subcribe);

	/**
	 * 添加新的预约信息
	 */
	boolean delSubscribe(Date date, int number);

	/**
	 * 删除预约信息
	 */
	Subscribe findNextSubscribe(int doctorId);

	/**
	 * 查询医生对应的下一个患者
	 */

	Subscribe findSubscribe(Date date, int number);

	/**
	 * 查询预约信息
	 */
	boolean updateSubscribe(Date date, int number, int state);
	/**
	 * 修改预约的状态
	 */
}
