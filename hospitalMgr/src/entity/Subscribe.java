package entity;

import java.sql.Date;

public class Subscribe {
	private int s_id;// 预约号
	private Date s_date;// 预约日期
	private int p_id;// 患者id
	private int d_id;// 医生id
	private int state;// 预约状态 1、已预约 2、已就诊 3、已过期(扩展)

	public void showInfo() {
		System.out.println("预约号：" + this.s_id);
		System.out.println("预约日期：" + this.s_date);
		System.out.println("患者id：" + this.p_id);
		System.out.println("医生id：" + this.d_id);
		System.out.print("预约状态：");
		if (this.state == 1) {
			System.out.println("已预约");
		} else {
			System.out.println("已就诊");
		}
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
