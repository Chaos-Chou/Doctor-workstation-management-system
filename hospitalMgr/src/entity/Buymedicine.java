package entity;

import java.sql.Timestamp;

public class Buymedicine {
	private int order_id;// 订单号
	private int p_id;// 患者id
	private int m_id;// 药品id
	private Timestamp buy_time;// 买药时间
	private int buy_number;// 购买数量

	public void showInfo() {
		System.out.println("订单号：" + order_id);
		System.out.println("患者id：" + p_id);
		System.out.println("药品id：" + m_id);
		System.out.println("购买时间：" + buy_time);
		System.out.println("购买数量：" + buy_number);
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public Timestamp getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(Timestamp buy_time) {
		this.buy_time = buy_time;
	}

	public int getBuy_number() {
		return buy_number;
	}

	public void setBuy_number(int buy_number) {
		this.buy_number = buy_number;
	}

}
