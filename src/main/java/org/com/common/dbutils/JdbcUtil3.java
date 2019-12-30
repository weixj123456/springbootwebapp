package org.com.common.dbutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * Jdbc工具类
 * 1:properties配置文件 封装获取连接 释放资源 提高代码复用性√
 * 2:类加载时加载驱动√
 * 3:ThreadLocal控制事务√
 * 4:连接池,提高资源利用率√
 * 5:rowmapper封装 减少代码冗余×
 * 6:template封装 减少dao层代码冗余×
 * 
 * 提供的方法:
 * 1.获取连接---getConnection()
 * 2.释放资源--- release()
 * 
 * 
 * @author 郭乾亮1998
 *
 */
public class JdbcUtil3 {
	//声明连接池
	static DataSource pool = null;
	
	//创建properties
	static Properties pro = new Properties();
	//创建ThreadLocal<Connection>,可以为同一个线程保存同一个连接,为不同线程保存不同的连接
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//加载驱动
	static{
		InputStream is = null;
		try {
			is = JdbcUtil3.class.getResourceAsStream("/conf/dbcp.properties");
			//加载文件
			pro.load(is);
			//Class.forName(pro.getProperty("driverClassName"));
			//properties配置文件创建连接池
			pool = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//获取连接
	public static Connection getConnection() throws Exception{
		Connection conn = tl.get();//获得当前线程中的连接
		if(conn == null){//如果当前线程中没有连接
			String url = pro.getProperty("url");
			String user = pro.getProperty("username");
			String password = pro.getProperty("password");
			//创建连接
			//conn = DriverManager.getConnection(url,user,password);
			//通过连接池对象获得connection
			conn = pool.getConnection();
			//将连接保存到当前线程
			tl.set(conn);
		}
		return conn;
	}
	//释放资源
	public static void release(ResultSet rs,PreparedStatement pstm,Connection conn) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(pstm!=null){
			pstm.close();
		}
		if(conn!=null){
			conn.close();
			tl.remove();//将连接从当前线程中移除
		}
	}
}

