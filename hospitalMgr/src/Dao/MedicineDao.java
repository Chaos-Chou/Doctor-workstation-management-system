package Dao;

import entity.Medicine;

/**
 * 
 * 药品实体类的增删改查
 *
 */
public interface MedicineDao {
	boolean addMedicine(Medicine medicine);

	/**
	 * 增加药品信息
	 */
	boolean delMedicine(int number);

	/**
	 * 删除指定药品
	 */
	boolean modifyPrice(int number, int price);

	/**
	 * 修改药品价格
	 */
	boolean modifyStock(int number, int stock);

	/**
	 * 修改药品库存
	 */
	Medicine findMedicine(String name);
	/**
	 * 查找指定药名的药品信息
	 */
}
