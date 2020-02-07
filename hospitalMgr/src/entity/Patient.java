package entity;

public class Patient {
	private int p_id;// 患者id
	private String p_name;// 患者姓名
	private String p_gender;// 患者性别
	private String id_num;// 患者身份证号
	private String p_phone;// 患者电话
	private String p_address;// 患者住址
	private String hometown;// 患者籍贯

	public void showInfo() {
		System.out.println("患者id：" + this.p_id);
		System.out.println("患者姓名：" + this.p_name);
		System.out.println("患者性别：" + this.p_gender);
		System.out.println("患者身份证号：" + this.id_num);
		System.out.println("患者电话：" + this.p_phone);
		System.out.println("患者住址：" + this.p_address);
		System.out.println("患者籍贯：" + this.hometown);

	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_gender() {
		return p_gender;
	}

	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
	}

	public String getP_phone() {
		return p_phone;
	}

	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

}
