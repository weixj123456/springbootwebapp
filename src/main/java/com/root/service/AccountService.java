package com.root.service;

import com.root.entity.Account;

/**
 * Service业务层接口
 * 
 * 作用:对View层的数据进行处理
 * 
 * @author QianliangGuo
 */
public interface AccountService {
	//5.注册
	public void regist(Account account,String repassword);
	//3.查询余额
	public Double queryBalance(int cardid,String password);
	//4.转账
	public void transfer(int from_cardid, String password, int to_cardid,double money);
	//1.存钱
	public void save(int cardid, String password, double money);
	//2.取钱
	public void draw(int cardid, String password, double money);
	//7.修改密码
	public void changepassword(int cardid, String password,String chpassword);
	//6.注销账户
	public void logout(int cardid, String password);
}


