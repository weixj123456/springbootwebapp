package org.com.common.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbucTemplate类
 * 作用:封装了增删改查操作
 * 
 * @author QianliangGuo
 */
public class JdbcTemplate<T> {
	/*
	 * 1.单条结果查询select_one
	 * 2.多条结果查询select_more
	 * 3.增删改 updata
	 *
	 */
	static Connection conn = null;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	// 1.select_one
	public T queryForObject(String sql, RowMapper<T> rm, Object... args) {
		T t = null;
		try {
			conn = JdbcUtil3.getConnection();
			pstm = conn.prepareStatement(sql);
			if (args.length != 0) {
				for (int i = 0; i < args.length; i++) {
					pstm.setObject(i + 1, args[i]);
				}
			}
			rs = pstm.executeQuery();
			if (rs.next()) {
				t = rm.mappreRow(rs);
			}
		} catch (Exception e) {
			System.out.println("数据库连接异常");
		} finally {
			try {
				//conn留在Service层关闭
				JdbcUtil3.release(rs, pstm, null);
			} catch (Exception e) {
				System.out.println("释放资源出现问题");
			}
		}
		return t;
	}

	//2.select_more
	public List<T> queryForList(String sql,RowMapper<T> rm,Object...args){
		List<T> list = null;
		try {
			conn = JdbcUtil3.getConnection();
			pstm = conn.prepareStatement(sql);
			if (args.length != 0) {
				for (int i = 0; i < args.length; i++) {
					pstm.setObject(i + 1, args[i]);
				}
			}
			rs = pstm.executeQuery();
			list = new ArrayList();
			while(rs.next()) {
				T t = rm.mappreRow(rs);
				list.add(t);
			}
		} catch (Exception e) {
			System.out.println("数据库连接异常");
		} finally {
			try {
				JdbcUtil3.release(rs, pstm,null);
			} catch (Exception e) {
				System.out.println("释放资源出现问题");
			}
		}
		return list;
	}
	
	//3.updata操作
	public void update(String sql, Object... args) {

		try {
			//开启一个连接
			conn = JdbcUtil3.getConnection();
			pstm = conn.prepareStatement(sql);
			// args的长度如果不是0,就说明有参数,那它就是个半成品
			if (args.length != 0) {
				for (int i = 0; i < args.length; i++) {
					pstm.setObject(i + 1, args[i]);
				}
			}
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("数据库异常!");
		} finally {
			try {
				JdbcUtil3.release(null, pstm, null);
			} catch (Exception e) {
				System.out.println("关闭连接异常!");
			}
		}
	}
}

