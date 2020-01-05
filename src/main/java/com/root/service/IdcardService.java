package com.root.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
//import org.com.common.dbutils.JdbcUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.root.dao.IdcardMapper;
import com.root.entity.Idcard;

import conf.JdbcUtils;

public class IdcardService {
	private final static ApplicationContext context=new ClassPathXmlApplicationContext("config/spring.xml");

	
	static Logger	log	= Logger.getLogger(IdcardService.class);
    
    private static String loanno;
    private static String contno;
      
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static Idcard getIdcard(int num) throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from idcard where id=?";
        Object params[] = {num};
        Idcard idcard=(Idcard) qr.query(sql, params, new BeanHandler(Idcard.class));
//      System.out.println(idcard.getId());
        log.info("===================从IdcardService类中获取Idcard信息成功========="+idcard);
        return idcard;
    }
    
    
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static Idcard getIdcardById(int id) throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from idcard where id=?";
        Object params[] = {id};
        Idcard idcard=(Idcard) qr.query(sql, params, new BeanHandler(Idcard.class));
        log.info("===================从IdcardService类中获取Idcard信息成功========="+idcard);
        return idcard;
    }
    
 
    
    public static void insert(Object params[]) throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql="insert into idcard(username,idno,bankno,telphone,descption,num,loanno,contno) value(?,?,?,?,?,?,?,?)";
        qr.update(sql, params);
        log.info("======================插入数据成功！！！========================");
    }
    
    public static void insert(String sql,Object params[]) throws SQLException {
        //将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());    
        qr.update(sql, params);
        log.info("======================插入数据成功！！！========================");
    }
 
    public static void insert(String custName,String idNo,String indivMobile,String applAcNo,String channelid, String info) {
		 int id=Integer.parseInt(channelid);    	
    	Object params[]= {custName,idNo,applAcNo,indivMobile,channelid+info,id,"",""};//设置参数
		 try {
			IdcardService.insert(params);
			System.out.println("新增客户数据成功："+"  custName:"+custName+"  idNo:"+idNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    
       //更新字段类型为字符串字段
     //String sql = "update users set account=? where id=?";
    public static void update(String updateSql,Object params[]) throws SQLException {   	
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());        
        qr.update(updateSql, params);  
        log.info("======================Mysql数据更新客户信息成功！！！========================");
    }

    public static void updateLoanInfo(String env,String idNo,int num) throws SQLException, InterruptedException {
		   Idcard idcard=IdcardService.getMaxKey(idNo,num);
		   System.out.println(idcard.toString());
		    String custName=idcard.getUsername();
		    idNo=idcard.getIdno();
			log.info("=====！！！ custName:"+custName+"   idNo"+idNo);				 

		    //保存操作客户信息
			 String updateSql = "update idcard set loanno=?,contno=? where idno=?";
			 Object params[]= {loanno,contno,idNo};
			 IdcardService.update(updateSql, params);				 
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
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static int  queryMaxId() throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from idcard";       
        List<Idcard> list = (List<Idcard>) qr.query(sql, new BeanListHandler(Idcard.class));
        int num=list.size();
//        for(Idcard u : list){
//             System.out.print(u.getId()+"  ");
//             System.out.print(u.getIdno()+"  ");
//             System.out.println(u.getNum()+"  ");            
//        }    
        return num;
    }
    
    @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static Idcard  getMaxKey(String idno,int id) throws SQLException {
    	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    	//SELECT * FROM idcard  WHERE ID IN(SELECT MAX(ID) FROM idcard );
    	String sql=null;
    	
    	if((!idno.equals(""))&&id==0) {     //身份证为空的情况执行
    	 Object params0[] = {idno};
         sql = "select * from idcard where idno=? order by id desc limit 1";
         Idcard idcard=(Idcard) qr.query(sql, params0,new BeanHandler(Idcard.class));
         return idcard;
    	}else if((idno.equals(""))&&id>0){   //当需要依赖主键，循环执行用户语句  赋值idno为空，主键大于0时执行
    		sql="select * from idcard where id=? ";
    		Object params1[] = {id};
    		Idcard idcard=(Idcard) qr.query(sql, params1,new BeanHandler(Idcard.class));
            return idcard;
    	}else if((idno.equals(""))&&id==0){    //一般情况查询最后一条语句进行执行,最大的KEY
         sql = "select * from idcard  order by id desc limit 1";  
         Object params2[] = {};
         Idcard idcard=(Idcard) qr.query(sql, params2,new BeanHandler(Idcard.class));
         return idcard;
    	}else {  //一般情况查询最后一条语句进行执行,最大的KEY
//    		System.out.println("当前未找到相应的IDCARD客户，请确认！！！");   
    		sql = "select * from idcard  order by id desc limit 1";  
            Object params2[] = {};
            Idcard idcard=(Idcard) qr.query(sql, params2,new BeanHandler(Idcard.class));
            return idcard;
			
    	}
    }
    

	public static void main(String[] args) throws Exception {
		String env="uat1";
//		insert into idcard(username,idno,bankno,telphone,descption,num,loanno,contno) value(?,?,?,?,?,?,?,?)
    	//示例1  
//        IdcardService ids=new IdcardService();
    	Idcard idcard=IdcardService.getMaxKey("420117199101010200",0);  
//    	Idcard idcard=IdcardService.getMaxKey("");  
        System.out.println(idcard.toString());
        //示例2
        Object params[] = {"111","222",687};
        String sql="update idcard set loanno=?,contno=? where id=?";
        IdcardService.update(sql, params);
        Idcard idcard2=IdcardService.getMaxKey("421126200911290390",0); 
        IdcardService.updateLoanInfo(env,"421126200911290390", 0);
        System.out.println(idcard2.toString());      
 //       Thread.sleep(50000);

    }


	public static void updateByIdno(Idcard idcard) {
		// TODO Auto-generated method stub
	  IdcardMapper dao=context.getBean(IdcardMapper.class);
  	  dao.updateByPrimaryKeySelective(idcard);
  	  System.out.println("已更新客户信息");
	}
	
	
}
