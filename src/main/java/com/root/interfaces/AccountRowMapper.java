package com.root.interfaces;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.com.common.dbutils.RowMapper;

import com.root.entity.Account;
/**
 * AccountRowMapper类
 * 实现:RowMapper接口
 * 作用:将Account结果集封装成Account对象
 * 
 * @author QianliangGuo
 */
public class AccountRowMapper implements RowMapper {

	@Override
	public Account mappreRow(ResultSet rs) {
		Account account = new Account();
		try {
			//处理结果集
			account.setCardid(rs.getInt(1));
			account.setName(rs.getString("name"));
			account.setPassword(rs.getString(3));
			account.setBalance(rs.getDouble(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
}

