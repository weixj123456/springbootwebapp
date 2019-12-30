package com.root.service.impl;

import org.com.common.dbutils.JdbcTemplate;

import com.root.dao.AccountDao;
import com.root.entity.Account;
import com.root.interfaces.AccountRowMapper;

/**
 * AccountDaoImpl类(实现了AccountDao接口)
 * 作用:访问数据库
 * 提供方法:
 * 1.注册账户---insertAccount()
 * 2.查询余额---queryAccountByCardid()
 * 
 * @author QianliangGuo
 */
public class AccountDaoImpl implements AccountDao {
	//Dao层访问JdbcTemplate()类,创建JdbcTemplat()对象.
	JdbcTemplate template = new JdbcTemplate();
	
	//5.注册账户
	@Override
	public void insertAccount(Account account) {
		template.update("insert into account(name,password,balance) values(?,?,?)", account.getName(),account.getPassword(),account.getBalance());
		
	}
	//3.查询余额
	@Override
	public Account queryAccountByCardid(int cardid) {
		Account account = (Account)template.queryForObject("select * from account where cardid=?",new AccountRowMapper(),cardid);
		return account;
	}
	
	//4.转账(更新数据库)
	@Override
	public void updateAccount(Account account) {
		template.update("update account set balance = ? where cardid = ?", account.getBalance(),account.getCardid());
	}
	
	//7.修改密码(修改数据)
	@Override
	public void changepassword(Account account) {
		template.update("update account set PASSWORD = ? where cardid = ?",account.getPassword(),account.getCardid());
	}
	
	//6.注销账户
	@Override
	public void logout(Account account) {
		template.update("DELETE FROM `mybase`.`account` WHERE  `cardid`=?",account.getCardid());
	}
}

