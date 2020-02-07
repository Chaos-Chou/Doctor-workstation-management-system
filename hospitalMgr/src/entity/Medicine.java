package entity;

import java.sql.Date;

public class Medicine {
	private int m_id;// 药品编号
	private String m_name;// 药品名
	private Date producedate;// 生产日期
	private Date validdate;// 有效期
	private int stock;// 库存
	private int price;// 单价

	public void showInfo() {
		System.out.println("药品编号：" + m_id);
		System.out.println("药品名：" + m_name);
		System.out.println("生产日期：" + producedate.toString());
		System.out.println("有效期：" + validdate.toString());
		System.out.println("库存：" + stock);
		System.out.println("单价：" + price);
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Date getProducedate() {
		return producedate;
	}

	public void setProducedate(Date producedate) {
		this.producedate = producedate;
	}

	public Date getValiddate() {
		return validdate;
	}

	public void setValiddate(Date validdate) {
		this.validdate = validdate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
