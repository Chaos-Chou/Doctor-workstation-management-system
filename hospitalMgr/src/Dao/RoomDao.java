package Dao;

import entity.Room;

public interface RoomDao {
	boolean addRoom(Room room);

	/**
	 * 增添诊室信息
	 */
	boolean delRoom(int number);

	/**
	 * 删除诊室信息
	 */
	boolean updateRoom(int number, Room room);

	/**
	 * 更改诊室信息
	 */
	Room findRoom(int number);
	/**
	 * 查询诊室信息
	 */
}
