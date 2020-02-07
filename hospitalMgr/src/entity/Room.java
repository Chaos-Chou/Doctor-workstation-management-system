package entity;

/**
 * 诊室号和名称位置对照类
 * 
 * @author elernity
 *
 */
public class Room {
	private int r_id;// 诊室id
	private String r_name;// 诊室名
	private String r_address;// 诊室位置

	public String showInfo() {
		return String.format("%-15s", r_name) + r_address;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_address() {
		return r_address;
	}

	public void setR_address(String r_address) {
		this.r_address = r_address;
	}
}
