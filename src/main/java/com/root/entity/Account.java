package com.root.entity;

/**
 * 标配封装数据
 * 1.属性全部私有√
 * 2.提供get和set√
 * 3.提供无参构造√
 * 4.实现Serializable接口×
 * 高配: toString() 有参构造√
 */
public class Account {
	private Integer cardid;//卡号
	private String name;//姓名
	private String password;//密码
	private Double balance;//余额
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(Integer cardid, String name, String password, Double balance) {
		super();
		this.cardid = cardid;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	public Integer getCardid() {
		return cardid;
	}
	public void setCardid(Integer cardid) {
		this.cardid = cardid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [cardid=" + cardid + ", name=" + name + ", password="
				+ password + ", balance=" + balance + "]";
	}
}
