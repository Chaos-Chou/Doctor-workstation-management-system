package Dao;

import entity.Buymedicine;

/**
 * 
 * 患者买药信息的增删改查
 *
 */
public interface BuymedicineDao {
	boolean addBuymedicine(Buymedicine order);

	/**
	 * 增加药品订单信息
	 */
	boolean delBuymedicine(int number);

	/**
	 * 删除药品订单信息
	 */
	Buymedicine findBuymedicine(int number);
	/**
	 * 查找药品订单信息
	 */
}
