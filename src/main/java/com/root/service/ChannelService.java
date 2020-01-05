package com.root.service;

import java.sql.SQLException;
import java.util.List;
import com.root.entity.Channel;
import com.root.entity.Idcard;

///*
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.T;
//import org.com.common.dbutils.JdbcUtils;
import conf.JdbcUtils;
//*/
public class ChannelService {
	
	static Logger	log	= Logger.getLogger(ChannelService.class);

    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static Channel getChannel(int num) throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where id=?";
        Object params[] = {num};
        Channel channel=(Channel) qr.query(sql, params, new BeanHandler(Channel.class));
        System.out.println(channel.getId());
//        log.info("===================从ChannelService类中获取channel信息成功========="+channelid);
        return channel;
    }
    
    
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static Channel getChannelById(int id) throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where id=?";
        Object params[] = {id};
        Channel channel=(Channel) qr.query(sql, params, new BeanHandler(Channel.class));
 //       log.info("===================从ChannelService类中获取channel信息成功========="+channelid);
        return channel;
    }
    
    
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static Channel getChannelByChannelid(String channelid) throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where channelid=?";
        Object params[] = {channelid};
        Channel channel=(Channel) qr.query(sql, params, new BeanHandler(Channel.class));
//        log.info("===================从ChannelService类中获取channel信息成功========="+channelid);
        return channel;
    }
 
	public void add(String table,String columns,String columnsValues,Object params[]) throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql="insert into "+table+"("+columns+") values ("+columnsValues+")";
        qr.update(sql, params);
      }
	
    public void addBeanOne(String table,String columns,String columnsValues,Object params[]) throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql="insert into "+table+"("+columns+") values ("+columnsValues+")";
 //     Object params[] = {"4","hello world",2323}; 
        qr.update(sql, params);
      }
    
    public void addBeanOne(String sql,Object params[]) throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        qr.update(sql, params);
    }
    
    
    public static void insertBean(String sql,Object params[]) throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        qr.update(sql, params);
        log.info("======================插入数据成功！！！========================");
    }
    
       //更新字段类型为字符串字段
     //String sql = "update users set account=? where id=?";
    public static void update(String tableSql,Object params[]) throws SQLException {   	
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        qr.update(tableSql, params);    
    }
    
    
       //更新字段类型为整型字段
       //String sql = "update users set account=? where id=?";
      public static void updateBeanOne(String table,String column,int keyid,int columnValue) throws SQLException {   	
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        //更新模板      
	        String sql = "update "+table+" set "+column+"=? where id=?";
	        Object params[] = {columnValue, keyid};
	        qr.update(sql, params);    
       }
    
    public static void updateTableColumn(String table,int setcolumn,int keyid,String tablecolumn) throws SQLException {    	
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        //更新模板
        String sql = "update "+table+" set "+tablecolumn+"=? where id=?";
        Object params[] = {setcolumn, keyid};
        qr.update(sql, params); 
        log.info("======================更新成功！！！========================");
    }
    
    
    
    public static void deleteBeanOne(String table,int keyid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "delete from "+table+" where id=?";
        qr.update(sql, keyid);
        log.info("======================删除成功！！！===============================");
    }
       
	  @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	 public static T selectBeanById(String sql,Class<T> T,int keyid) throws SQLException {
	   	  QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());	    
	      Object params[] = {keyid};
	      T obj=(T) qr.query(sql, params, new BeanHandler(T.class));
	      return obj;
       }
	  
	  @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	  public static T selectBeanById(String sql,Class<T> T,String keyid) throws SQLException {
	  	  QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());	    
	      Object params[] = {keyid};
	      T obj=(T) qr.query(sql, params, new BeanHandler(T.class));
	      return obj;
         }
	  
	  
	  @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	  public static T queryBeanById(String sql,Class<T> T,String keyid) throws SQLException {
	  	  QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());	    
	      Object params[] = {keyid};
	      T obj=(T) qr.query(sql, params, new BeanHandler(T.class));
	      return obj;
         }
	  
       //String sql = "select * from Channel where id=?";
	  @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	  public T selectBean(String tableSql,Class<T> T,int keyid) throws SQLException {
	  	  QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	      Object params[] = {keyid};
	      T obj=(T) qr.query(tableSql, params, new BeanHandler(T.class));
	      return obj;
        }
    
	    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
		public static T selectTableColumn(String table,Class<T> T,int keyid) throws SQLException {
	    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	        String sql = "select * from "+table+" where id=?";
	        Object params[] = {keyid};
	        T obj=(T) qr.query(sql, params, new BeanHandler(T.class));
	        return obj;
	    }
    
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static String findIdno(int num) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from idcard where id=?";
        Object params[] = {num};
        Idcard idcard=(Idcard) qr.query(sql, params, new BeanHandler(Idcard.class));
        System.out.println(idcard.getIdno());
        String idno=idcard.getIdno();
        return idno;
        //qr.update(sql, params);
    }
    
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static String queryIdno(int num) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from idcard where id=?";
        Object params[] = {num};
        Idcard idcard=(Idcard) qr.query(sql, params, new BeanHandler(Idcard.class));
        System.out.println(idcard.getIdno());
        String idcardno=idcard.getIdno();
        //qr.update(sql, params);
        return idcardno;
    }
       
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public Channel selectChannelByid(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where id=?";
        Object params[] = {id};
        Channel channel = (Channel) qr.query(sql, params, new BeanHandler(Channel.class));
        log.info("==============查询渠道数据成功！！！=====================");
        return channel;
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public Channel queryChannelByid(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where id=?";
        Object params[] = {id};
        Channel channel = (Channel) qr.query(sql, params, new BeanHandler(Channel.class));
        System.out.println(channel.getId());
        System.out.println(channel.getChannelid());
        log.info("==============查询渠道数据成功！！！=====================");
        return channel;
    }
    
    
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public Channel queryChannelByChannelId(String channelid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where channelid=?";
        Object params[] = {channelid};
        Channel channel = (Channel) qr.query(sql, params, new BeanHandler(Channel.class));
        System.out.println(channel.getId());
        System.out.println(channel.getChannelid());
        log.info("==============查询渠道数据成功！！！=====================");
        return channel;
    }
     
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> getAllBeans(String table,Class<T> T) throws SQLException {
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		    String sql = "select * from "+table;       
		    List<T> list = (List<T>) qr.query(sql, new BeanListHandler(T.class));
             return list;    
		}
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void getAllBeans() throws SQLException {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    String sql = "select * from idcard";       
    List<Idcard> list = (List<Idcard>) qr.query(sql, new BeanListHandler(Idcard.class));
    for(Idcard u : list){
         System.out.print(u.getId()+"  ");
         System.out.print(u.getIdno()+"  ");
         System.out.println(u.getNum()+"  ");            
		    }       
		}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void getAll2(String tablename,Object Idcard) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from"+" " +tablename;
        List<Idcard> list = (List<Idcard>) qr.query(sql, new BeanListHandler(Idcard.class));
        for(Idcard u : list){
             System.out.println(u.getIdno());
        }
       
    }      
    
   @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public Channel selectChannelByChannelId(String channelid) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from channel where channelid=?";
        Object params[] = {channelid};
        Channel channel = (Channel) qr.query(sql, params, new BeanHandler(Channel.class));
        log.info("==============查询渠道数据成功！！！=====================");
        return channel;
    }
   
   
   
    @SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
          
        ChannelService cs=new ChannelService();
        Channel channel=cs.getChannel(10);
        String cid=channel.getChannelid();
        System.out.println(cid);
        log.info("查询成功！！！");  
        
//        String docname=cs.getDocname();
//        System.out.println(docname);
    }
}
