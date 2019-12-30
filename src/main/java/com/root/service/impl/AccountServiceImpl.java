package com.root.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.com.common.dbutils.JdbcUtil3;

import com.root.dao.AccountDao;
import com.root.entity.Account;
import com.root.service.AccountService;

/**
 * AccountServiceImpl类(实现了Service接口层)
 * 作用:对View层的数据进行处理
 * 提供方法:
 * 1.查询余额---queryBalance()
 * 2.注册---regist()
 * 3.转账---transfer()
 * 4.存钱---
 * 
 * @author QianliangGuo
 */
public class AccountServiceImpl implements AccountService {
	//Service层--->Dao层
	AccountDao accountDao = new AccountDaoImpl();
	Connection conn = null;

	// 5.注册
	@Override
	public void regist(Account account, String repassword) {
		
		/**
		 * 异常情况:
		 * 1.输入空姓名
		 * 2.两次密码不一致
		 */
		String name = account.getName();
		if (name == null) {
			throw new RuntimeException("用户名不能为空");
		}
		
		String password = account.getPassword();
		if (!password.equals(repassword)) {
			throw new RuntimeException("两次密码不一致");
		}
		
		/**
		 * 正常情况:
		 * 
		 * 创建连接,设置手动提交,控制事务
		 */
		try {
			//创建连接
			conn = JdbcUtil3.getConnection();
			//使用事务,设置连接手动提交
			conn.setAutoCommit(false);
			//数据插入数据库
			accountDao.insertAccount(account);
			conn.commit();
		} catch (Exception e) {
			try {
				//如果有异常,进行回滚
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException("事务回滚异常");
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("关闭连接异常");
			}
		}
	}

	// 3.查询余额
	@Override
	public Double queryBalance(int cardid, String password) {
		Double balance = 0.0;
		
		/**
		 * 异常情况:
		 * 1.账号不存在
		 * 2.密码输入不正确
		 * 
		 */
		//查看账号是否存在
		Account account = accountDao.queryAccountByCardid(cardid);
		if (account == null) {
			throw new RuntimeException("账号不存在");
		}
		
		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("密码输入错误");
		}
		
		/**
		 * 正常情况:
		 * 
		 * 创建连接,获得balance,关闭连接
		 */
		try {
			conn = JdbcUtil3.getConnection();
			balance = account.getBalance();
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil3.release(null, null, conn);
			} catch (Exception e) {
				throw new RuntimeException("关闭连接异常");
			}
		}
		return balance;
	}

	//4.转账
	@Override
	public void transfer(int from_cardid, String password, int to_cardid,double money) {
		//通过账号获取两个账户对象 Service--->Dao.queryAccountByCardid();
		Account from_account = accountDao.queryAccountByCardid(from_cardid);
		Account to_account = accountDao.queryAccountByCardid(to_cardid);
		
		/**
		 * 异常情况:
		 * 1.我方账号不存在
		 * 2.对方账号不存在
		 * 3.我方密码不正确
		 * 4.我方余额小于转账余额
		 */
		if(from_account == null){
			throw new RuntimeException("您的账号不存在!");
		}
		if(to_account == null){
			throw new RuntimeException("对方账号不存在!");
		}
		if(!from_account.getPassword().equals(password)){
			throw new RuntimeException("密码输入错误!");
		}
		if(from_account.getBalance() < money){
			throw new RuntimeException();
		}
		
		/**
		 * 正常情况(可以转账):
		 * { 1.我方余额-money;
		 *   2.对方余额-money; }
		 * 创建连接,设置手动提交,控制事务
		 * 
		 */
		from_account.setBalance(from_account.getBalance()-money);
		to_account.setBalance(to_account.getBalance()+money);
		
		try{
			conn = JdbcUtil3.getConnection();
			conn.setAutoCommit(false);
			accountDao.updateAccount(from_account);
			accountDao.updateAccount(to_account);		
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (Exception e1) {
				System.out.println("事务回滚失败!");
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				System.out.println("数据库关闭失败");
			}
		}
	}

	//1.存钱
	@Override
	public void save(int cardid, String password, double money) {
		/**
		 * 异常情况:
		 * 1.账号不存在
		 * 2.密码输入不正确
		 * 
		 */
		//查看账号是否存在
		Account account = accountDao.queryAccountByCardid(cardid);
		if (account == null) {
			throw new RuntimeException("账号不存在");
		}
		
		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("密码输入错误");
		}
		
		/**
		 * 正常情况(可以存钱):
		 * 创建连接,加钱,关闭连接
		 * 
		 */
		//对应账号加钱
		account.setBalance(account.getBalance()+money);

		try {
			conn = JdbcUtil3.getConnection();
			accountDao.updateAccount(account);
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil3.release(null, null, conn);
			} catch (Exception e) {
				throw new RuntimeException("关闭连接异常");
			}
		}
	}

	//2.取钱
	@Override
	public void draw(int cardid, String password, double money) {
		/**
		 * 异常情况:
		 * 1.账号不存在
		 * 2.密码输入不正确
		 * 
		 */
		//查看账号是否存在
		Account account = accountDao.queryAccountByCardid(cardid);
		if (account == null) {
			throw new RuntimeException("账号不存在");
		}
		
		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("密码输入错误");
		}
		
		/**
		 * 正常情况(可以存钱):
		 * 创建连接,减钱,关闭连接
		 * 
		 */
		//对应账号减钱
		account.setBalance(account.getBalance()-money);

		try {
			conn = JdbcUtil3.getConnection();
			accountDao.updateAccount(account);
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil3.release(null, null, conn);
			} catch (Exception e) {
				throw new RuntimeException("关闭连接异常");
			}
		}
	}

	//7.修改密码
	@Override
	public void changepassword(int cardid, String password,String chpassword) {
		/**
		 * 异常情况:
		 * 1.账号不存在
		 * 2.密码输入不正确
		 * 
		 */
		//查看账号是否存在
		Account account = accountDao.queryAccountByCardid(cardid);
		if (account == null) {
			throw new RuntimeException("账号不存在");
		}
		
		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("密码输入错误");
		}
		
		/**
		 * 正常情况(可以修改):
		 * 创建连接,修改密码,关闭连接
		 * 
		 */
		account.setPassword(chpassword);
		
		try {
			conn = JdbcUtil3.getConnection();
			accountDao.changepassword(account);
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil3.release(null, null, conn);
			} catch (Exception e) {
				throw new RuntimeException("关闭连接异常");
			}
		}
	}

	//6.注销账户
	@Override
	public void logout(int cardid, String password) {
		/**
		 * 异常情况:
		 * 1.账号不存在
		 * 2.密码输入不正确
		 * 
		 */
		//查看账号是否存在
		Account account = accountDao.queryAccountByCardid(cardid);
		if (account == null) {
			throw new RuntimeException("账号不存在");
		}
		
		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("密码输入错误");
		}
		/**
		 * 正常情况(可以注销):
		 * 创建连接,注销账户,关闭连接
		 * 
		 */
		try {
			conn = JdbcUtil3.getConnection();
			accountDao.logout(account);
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil3.release(null, null, conn);
			} catch (Exception e) {
				throw new RuntimeException("关闭连接异常");
			}
		}	
	}
}

