package com.root.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

	public class MySQLTool {
		
		public static Connection createConn(String env)
	    {    
			String url=null;
	        Connection conn=null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();      	            
//	            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
	            Properties props = new Properties();
	            props.setProperty("user", "hbxj");
	            props.setProperty("password", "hbxj123");
	            if(env.equals("DX")||env.equals("dx")) {
		               url="jdbc:mysql://10.10.0.28:3306/obj_service";
		          }else{
		        	   url="jdbc:mysql://10.10.0.28:3306/obj_service";
		            }
	                 
	        conn=DriverManager.getConnection(url,props);           	            
	        }catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
		
	    public static PreparedStatement prepare(Connection conn,String sql)
	    {
	        PreparedStatement stat=null;
	        try {
	            stat=conn.prepareStatement(sql);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return stat;
	    }
	    
	    public static void close(Connection conn)
	    {
	        if(conn==null) return;
	        
	        try {
	            conn.close();
	            conn=null;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void close(Statement stat)
	    {
	        if(stat==null) return;
	        
	        try {
	            stat.close();
	            stat=null;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void close(ResultSet rs)
	    {
	        if(rs==null) return;
	        try {
	            rs.close();
	            rs=null;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public  static String excuteQuery(String env,String table,String condition,String conditionValue,String column) {
	           Connection conn = createConn(env);
//	           String sql="select * from "+Database+"."+table +" where "+condition+"='"+conditionValue+"'";
	           String sql="select * from "+table +" where "+condition+"='"+conditionValue+"'";
	           System.out.println(sql);
		        String value = null;
		        PreparedStatement ps;
		        try {
		            ps = conn.prepareStatement(sql);
	            try {
	                ResultSet rs=ps.executeQuery();
	                
	                while(rs.next())
	                {    
	                	value=rs.getString(column);
	    //            	System.out.println(num+","+rs.getString("APPL_CDE")+","+rs.getString("APPL_SEQ"));
	    //              System.out.println(num+","+rs.getString("APPL_CDE")+","+rs.getString("APPL_SEQ"));
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            conn.close();
	            ps.close();
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        return value;
	    }
		
	    public  static String excuteQuery(String env,String sql,String column) {
	           Connection conn = createConn(env);
		        String value = null;
		        PreparedStatement ps;
		        try {
		            ps = conn.prepareStatement(sql);
	            try {
	                ResultSet rs=ps.executeQuery();
	                
	                while(rs.next())
	                {    
	                	value=rs.getString(column);
                    }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            conn.close();
	            ps.close();
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        return value;
	    }
		
	    public  static void update0(String env,String sql) {
	           Connection conn = createConn(env);
		        PreparedStatement ps = null;
		            try {
						ps = conn.prepareStatement(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                try {
						int rs=ps.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}     
	            try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	    
	    
	    public  static void update(String env,String sql) {
	           Connection conn = createConn(env);
		        PreparedStatement ps = null;
		            try {
						ps = conn.prepareStatement(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                try {
						int rs=ps.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}     
	            try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
		

	 public static void main(String[] args) {
		String env="DX";
		String value= MySQLTool.excuteQuery(env,"tbl_pboc_result_info", "ID", "10888800557", "REPORT_SN");
		System.out.println("=========================="+value+"===============================");
		/* 
	  try {
	   Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
//	   String url = "jdbc:db2://10.10.0.30:50001/HBCFC";
	   String url="jdbc:db2://10.10.0.30:50001/hbcfc:currentSchema=YXUAT;";
	   String user = "db2inst1";
	   String password = "db2inst130";
	   System.out.println("try");
	   Connection conn = DriverManager.getConnection(url, user, password);
	   System.out.print("Done!OK!!! ");
	   
	   Statement stmt = conn.createStatement();
	   ResultSet rs = stmt.executeQuery("select * from CF_APPL");
	   while (rs.next()) {
	    String id = rs.getString("APPL_CDE");
	    String APPLCDE = rs.getString("APPLCDE");
	    System.out.println(id + " , " + APPLCDE);
	   }
	   stmt.close();
	   conn.close();
	  } catch (Exception e1) {
	   e1.printStackTrace();
	  }  
	  */
	 }
	}
