package com.root.dbutils;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	//接口，为实现多条查询做准备
	public class OracleJdbcTemple {
		//数据库的链接
		public Connection getConn() {
			Connection conn=null;
			try {
				//加载驱动
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "123456");
			} catch (ClassNotFoundException e) {
				System.out.println("驱动加载失败！");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("链接数据库失败！");
				e.printStackTrace();
			}
			return conn;
		}
		//update()可以实现增删改,注意数组中的元素要与sql中一致；
		public void update (String sql,Object[] values) {
			Connection conn=getConn();
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				for(int i=0;i<values.length;i++) {
					ps.setObject(i+1, values[i]);
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("update方法创建Prepare失败");
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		//单条查询
		public Object load(String sql,Object[] values,Rowmapper rm) {
			Object ojb=null;
			Connection conn=getConn();
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				for(int i=0;i<values.length;i++) {
					ps.setObject(i+1, values[i]);
				}
				ResultSet rs=ps.executeQuery();
				//接收查询出的结果
				ojb=rm.rowMapper(rs);
			} catch (SQLException e) {
				System.out.println("单条查询中创建PrepareStatement失败");
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return ojb;
		}
		//多条查询
		public List<Object> queryAll(String sql,Object[] values,RowmapperAll ra) {
			Connection conn=getConn();
			PreparedStatement ps=null;
			List<Object> list=new ArrayList<Object>();
			try {
				ps=conn.prepareStatement(sql);
				for(int i=0;i<values.length;i++) {
					ps.setObject(i+1, values[i]);
				}
				ResultSet rs=ps.executeQuery();
				//接收查询出的结果
				list=ra.rowMapperAll(rs);
			} catch (SQLException e) {
				System.out.println("多条查询中创建PrepareStatement失败");
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}
	}

