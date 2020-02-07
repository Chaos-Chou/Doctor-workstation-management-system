package entity;

import javafx.scene.control.Label;

public class Doctor {
	private int d_id;// 医生id
	private String d_name;// 医生姓名
	private String d_gender;// 医生性别
	private String d_phone;// 医生电话
	private int room_id;// 诊室号
	private int grade;// 医生等级 0、普通 1、专家
	private int worktime;// 工作时间 1、上午 2、中午 3、下午
	public Room room;// 医生所在诊室信息

	public Doctor() {
		room = new Room();
	}

	public Label showInfo() {
		String d_grade;
		String d_worktime;
		if (grade == 0) {
			d_grade = "普通";
		} else {
			d_grade = "专家";
		}

		if (worktime == 1) {
			d_worktime = "上午";
		} else if (worktime == 2) {
			d_worktime = "中午";
		} else {
			d_worktime = "下午";
		}
		Label label = new Label(d_id + "\t" + String.format("%-10s", d_name) + d_gender + "\t\t"
				+ String.format("%-15s", d_phone + "\t\t") + d_grade + "\t\t" + d_worktime + "\t\t\t" + room_id + "\t\t"
				+ room.showInfo());
		return label;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_gender() {
		return d_gender;
	}

	public void setD_gender(String d_gender) {
		this.d_gender = d_gender;
	}

	public String getD_phone() {
		return d_phone;
	}

	public void setD_phone(String d_phone) {
		this.d_phone = d_phone;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getWorktime() {
		return worktime;
	}

	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}

}
