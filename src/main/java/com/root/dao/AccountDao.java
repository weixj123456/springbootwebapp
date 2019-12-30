package com.root.dao;

import com.root.entity.Account;

/**
 * Dao数据访问层
 * 
 * 提供的方法:
 * 5.数据插入数据库---insertAccount()
 * 3.查询数据库---queryAccountByCardid()
 * 
 * @author QianliangGuo
 */
public interface AccountDao {
	//5.注册功能(数据插入数据库)
	public void insertAccount(Account account);

	//3.查询余额(查询数据库)
	//根据卡号查看账号信息
	public Account queryAccountByCardid(int cardid);

	//4.转账(更新数据库balance)
	public void updateAccount(Account account);

	//7.修改密码(更新数据库password)
	public void changepassword(Account account);

	//6.注销账户(删除数据库记录)
	public void logout(Account account);
}

