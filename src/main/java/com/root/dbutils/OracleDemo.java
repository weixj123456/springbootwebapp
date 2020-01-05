package com.root.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
/**
 * @Author: LiGe
 * @Date: 2018/10/21 13:21
 * @description:
 */
public class OracleDemo {
	static String env="uat";
    //连接对象
    Connection connection=null;
    //创建预编译对象
    PreparedStatement ps=null;
    //创建结果集
    ResultSet rs = null;
 
    /*插入*/
    public int insert() throws SQLException{
        int result = 0;
        connection = OracleDBUtil.getCon(env);
        String sql = "insert into student values(?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,2);
            ps.setString(2,"老王");
            ps.setString(3,"女");
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	OracleDBUtil.closeCon(connection);
        }
        return result;
    }
    /*查询*/
    public void select(String env) throws SQLException{
        connection = OracleDBUtil.getCon(env);
        String sql = "select id,name,gender from student";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                System.out.println("ID:"+id + " NAME:"+name+" GENDER:"+gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	OracleDBUtil.closeCon(connection);
        }
    }
    /*修改*/
    public int update(String env) throws SQLException{
        connection = OracleDBUtil.getCon(env);
        String sql = "update student set name = ?,gender = ? where id = ?";
        int result = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,"老张");
            ps.setString(2,"男");
            ps.setInt(3,2);
           result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
           }finally {
        	   OracleDBUtil.closeCon(connection);
        }
 
        return result;
 
    }
 
    /*删除 */
    public int delete(String env) throws SQLException{
        int result = 0;
        connection = OracleDBUtil.getCon(env);
        String sql = "delete from student where id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,1);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	OracleDBUtil.closeCon(connection);
        }
        return result;
    }
 
    public static void main(String[] args) throws SQLException{
        OracleDemo od = new OracleDemo();
        /*int add = od.add();
        System.out.println(add);*/
        od.select("uat");
//        System.out.println(od.delete());
    }
}

