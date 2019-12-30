package org.com.common.dbutils;

import java.sql.ResultSet;
/**
 * RowMapper接口
 * 作用: 将ResultSet结果集封装成对象
 * 
 * @author QianliangGuo
 */
public interface RowMapper<T> {
	// 将ResultSet结果集封装成对象
	public T mappreRow(ResultSet rs);
}

