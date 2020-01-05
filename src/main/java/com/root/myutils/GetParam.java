package com.root.myutils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;

import com.root.dbutils.DB2Tool;
import com.root.entity.Idcard;
import com.root.service.IdcardService;
import com.root.utils.MyDate;


public class GetParam {
         
	private final static Logger	log	= Logger.getLogger(GetParam.class);
	
	
	private static java.text.DecimalFormat df=new java.text.DecimalFormat("######0.00");
	
	// 生成随机数
			public static int tails(final int min, final int max) {
				Random r1 = new Random();
				int tmp = Math.abs(r1.nextInt());
				return tmp % (max - min + 1) + min;
			}
	
	
  public static int isEqualTime(String hexinenv,String qudaoenv,String hesuanenv) {
	  String sql="select CUR_PRCS_DT from s_ctrl";
	  String hexindate=DB2Tool.excuteQuery(hexinenv,sql,"CUR_PRCS_DT");
	  String qudaotime="select CST_NOWTIME from CENTER_SYS_TIME";
	  String qudaodate=DB2Tool.excuteQuery(qudaoenv,qudaotime,"CST_NOWTIME");
	  String hesuanttime="select s.cur_prcs_dt from s_ctrl s";
	  String gllouattime=DB2Tool.excuteQuery(hesuanenv,hesuanttime,"cur_prcs_dt");
	  log.info("核心时间："+hexindate+"      渠道时间："+qudaodate+"   "+hexinenv+"核算时间"+gllouattime);
	  if(!hexindate.equals(qudaodate)||!hexindate.equals(gllouattime)) {
		  log.info("当前渠道系统时间与核心系统时间不一致，或核心与核算时间不一致请核查！！！");
		  return -1;
	  }else {
		  log.info("进件时间正常，可以进件！！！");
		  return 0;
	  }
	  
  }	
	  
  public static void updateQudaotime(String hexinenv,String qudaoenv) {
	  String sql="select CUR_PRCS_DT from s_ctrl";
	  String hexindate=DB2Tool.excuteQuery(hexinenv,sql,"CUR_PRCS_DT");
	  String updatequdaosql="update CENTER_SYS_TIME set CST_NOWTIME='"+hexindate+"' where CST_ID='10001'";
//	  String qudaotime=DB2Tool.excuteQuery(qudaoenv,updatequdaosql,"CUR_PRCS_DT");
	  DB2Tool.update(qudaoenv, updatequdaosql);
	  log.info("渠道时间已更新，可以进件！！！");
  }
  
  public static String getSysTime(String env) {
//		  SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
//		  System.out.println("========"+df.format(new Date())+"==========================");
		  String sql="select CUR_PRCS_DT from s_ctrl";
		  String date=DB2Tool.excuteQuery(env,sql,"CUR_PRCS_DT");
		  System.out.println("=================systime："+date+"======================");	
		  return date;		  
	  }
	  
  
  public static String getSysDate(String env) {
	  String sql="select CUR_PRCS_DT from s_ctrl";
	  String date=DB2Tool.excuteQuery(env,sql,"CUR_PRCS_DT");
	  return date;		  
  }
	
  /**
   * 根据证件号码匹配最新一条记录，获取合同号
   * @param env   查询环境
   * @param idNo  
   * @return  返回合同号
   */
  public static String getContNo(String env,String idNo) {
	  String sql="select CONT_NO from lc_appl where id_no='"+idNo+"' order by APPL_CDE desc fetch first 1 rows only";
	  String CONT_NO=DB2Tool.excuteQuery(env,sql,"CONT_NO");
	  return CONT_NO;  
  }
  
	  public static String getBiaoZhunTime(String env) {
//		  SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
//		  System.out.println("=============================获取当前营业时间================================================");		  
//		  System.out.println("========"+df.format(new Date())+"==========================");
		  String sql="select CUR_PRCS_DT from s_ctrl";
		  String date=DB2Tool.excuteQuery(env,sql,"CUR_PRCS_DT");
		  String biaozhuntime=date+" 10:10:10";
				 System.out.println("=================reqTime："+biaozhuntime+"======================");	
		return biaozhuntime;		  
	  }
	 
			
	  public static String getReqTime(String env) {
		  String reqTime=GetParam.getSysTime(env).replace("-", "")+"101010";
		   return reqTime; 
	  }
	  
	  public static String getTradeTime(String env) {
		  String tradeTime=GetParam.getSysTime(env)+" 10:10:10";
		return tradeTime;		  
	  }
	  
	  

	  private static int getSubStrToInt(String id,int currentYear) {
		  String yearmmdd = null;
		  if(!(id.length()==18)) {
			  System.out.println("当前号码输入长度不为18位！！！");
		  }
		  yearmmdd=id.substring(6, 10);	
		  System.out.println("yearmmdd:"+yearmmdd);
		  int i=Integer.parseInt(yearmmdd);
		  int age=currentYear-i;
		  System.out.println("age:"+age);
		  return age;
	  }
	  
	  public static String getAgeStr(String idNo) {
			//设置客户年龄
//	          log.info("=============设置客户年龄==============");
//	          String systime=GetParam.getSysTime(env);
		      SimpleDateFormat df =new SimpleDateFormat("yyyy");
	    	  int currenyear=Integer.parseInt(df.format(new Date()));
			  int age=GetParam.getSubStrToInt(idNo, currenyear);
			  String apptAge=age+"";
			  return apptAge; 
		  }
	  	
	  
	  public static String getAgeStr(String env,String idNo) {
			//设置客户年龄
//	          log.info("=============设置客户年龄==============");
	          String systime=GetParam.getSysTime(env);
	          int year=Integer.parseInt(systime.substring(0, 4));
			  int age=GetParam.getSubStrToInt(idNo, year);
			  String apptAge=age+"";
			  return apptAge; 
		  }
	  
	  public static String getBirthdate(String idNo) {
		  //解析身份证提取出生年月日
		  String apptStartDate=idNo.substring(6, 10)+"-"+idNo.substring(10, 12)+"-"+idNo.substring(12, 14);
		  return apptStartDate;
	  }
	  
	  public static String getApplAcNo(String idNo,int num) throws SQLException {
//		    String applAcNo15 = "6214320102" + tails(10000, 99999);
		    Idcard idcard= IdcardService.getMaxKey("", 0);
			 String cardnoStr=idcard.getBankno();  //获取数据库中最大值下的账号
			 String cardstr0=cardnoStr.substring(14,15);  //获取账号第15位，再转换数字加1
//			 System.out.println("======cardstr0========"+cardstr0);
			 int cardnum15=Integer.parseInt(cardstr0)+1;
			 String cardstr=cardnoStr.substring(0,14)+cardnum15;//拼接成新银行账号
		     System.out.println("=============="+cardstr);                
		    
				//生成设置客户银行卡号
			 log.info("============生成设置客户银行卡号=========");
			 Card16 card=new Card16(cardstr);			 
			//银行卡号初始化，填写前15位然后生成
//		      Card16 card=new Card16("621485121383521");   			 			   
			 String applAcNo=card.getCard();	
			return applAcNo;
	  }
	  
	  
	  public static String getBillDate(String env,String str) {
		  String fristBillDate=null;
		  String dueDt=null;
		  String systime=GetParam.getSysTime(env);
		  String subri=systime.substring(8, systime.length());
		  String subnian=systime.substring(0, 4);
		  String subyue=systime.substring(5, 7);
		  int intyue=Integer.parseInt(subyue);
		  int intnian=Integer.parseInt(subnian);
		  intyue++;
		  if(intyue<=12) {			  
			  if(intyue<10) {
				  subyue="0"+(""+intyue);
			  }else {
				  subyue=(""+intyue);
			  }
			 }  
			  fristBillDate=subnian+"-"+subyue+"-"+subri;
			  intyue=intyue+10;
			  if(intyue<=12) {
				    subyue=""+intyue;
			  }else if(intyue>12) {
				  intyue=intyue-12;
				  subyue=""+(intyue-1);
				  intnian=intnian+1;
				  dueDt=subnian+"-"+subyue+"-"+subri;
			  }
			  dueDt=intnian+"-"+subyue+"-"+subri;		      
			  if(str.equals(fristBillDate)) {
				    return fristBillDate;
				 }else {
					 return dueDt;
				 }		
	  } 
	  
	  public static void insertZXBatlle(String env,String REPORT_ID,String idNo) {
		  String sql="insert into SERVICE_BAFFLE (PK_VAL, CURRENT_BUSINESS_CODE, RSP_MESSAGE, REQ_MESSAGE, ON_OFF, SERVICE_REMARK, UPDATE_DATE) values ('"+idNo+"', 'credit', '<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
		  		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + 
		  		"<soapenv:Body><ResponseBody><BatNo>000108B91439EDF7B119B381484C23F9</BatNo>" + 
		  		"<FileName/><Flag/><ReqSeqNo/><SvrDate/><SvrSeqNo/><SvrTime/><TxnCd/></ResponseBody>" + 
		  		"<Fault><FaultCode>FFFFFFF</FaultCode><FaultString>系统错误，联系运维！</FaultString><Detail><TxStatus>FAIL</TxStatus></Detail></Fault></soapenv:Body></soapenv:Envelope>', null, 'on', '系统错误，联系运维！', null)";
			 DB2Tool.update(env,sql);
			 log.info("=====已插入挡板---征信查询异常设置！！！ ===========REPORT_ID："+REPORT_ID+"   name:"+"  idNo"+idNo);

	  }
	  
	  /**
	   * flag为0，不需要查人行征信，1需要查征信
	   * @param env
	   * @param id
	   * @param flag
	   * @param REPORT_ID
	   * @param name
	   * @param idNo
	   */
	  public static void insertCreditRepInfo(String env,String id,int flag,String REPORT_ID,String name,String idNo) {
		  SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
	      String occuredate=df.format(new Date());
	      if(flag==0) {
	    	  occuredate=df.format(new Date());
		}else {
			occuredate="2019-06-11";
		}
	      
		  String sql="insert into CREDIT_REP_INFO (USERNAME, CERTYPE, CERCODE, QUERYREASON, VERTYPE, IDAUTHFLAG, OCCURDATE, USERID, PASSWORD, FLAG, INPUT_ID, INPUT_BR_ID, STATUS, PK, INPUT_DATE, REMARK, CHECK_ID, LOCAL_KEEP_DAYS, QUERY_WAY, OPERATE_METHOD, QUERY_ID, FILE_PATH, APPL_SEQ, LOCAL_NAME, LOCAL_IP, LOCAL_MAC, OPERATE_DATE, RETURN_TIME, SUM_COUNT, IS_VER, IS_WAY, SERIAL_NUMBER, IS_REUSE, BATCH_NO, IS_MODE) values ('"+name+"', '0', '"+idNo+"', '02', '30', '0', '"+occuredate+"', null, null, '1', '0038', '900000000', null, '"+idNo+"', null, null, null, null, null, null, 'SQ201903080000082581', 'L2hvbWUvd2FzYWRtaW4vY21pc2ZpbGUvenhyZXBvcnQvMjAxOTAzMDgvU1EyMDE5MDMwODAwMDAwODI1ODEueG1sOy9ob21lL3dhc2FkbWluL2NtaXNmaWxlL3p4cmVwb3J0LzIwMTkwMzA4L1NRMjAxOTAzMDgwMDAwMDgyNTgxcmVwb3J0Lmh0bWw=', '"+idNo+"', '渠道33', '181.21.0.250', '00-50-56-C0-00-10', '2019-03-07 17:03:01 ', '2019-03-08 01:01:55', 1, null, null, null, null, null, null)";
	      log.info("征信客户信息记录表\n"+sql);
		  DB2Tool.update(env,sql);
		  log.info("=====已插入征信客户信息记录表！！！ ===========REPORT_ID："+REPORT_ID+"   name:"+name+"  idNo"+idNo);

	  }
	  
	  /**
	   * flag为0，不需要查人行征信，1需要查征信
	   * @param env
	   * @param id
	   * @param flag
	   * @param REPORT_ID
	   * @param name
	   * @param idNo
	   */
	  public static void insertZXMaintable(String env,String id,int flag,String REPORT_ID,String name,String idNo) {
		  SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      String queryTime=df.format(new Date());
	      if(flag==0) {
	    	  queryTime=df.format(new Date());
		}else {
		   queryTime="2019-02-11 20:11:17";
		}
	      String sql="insert into TBL_PBOC_RESULT_INFO (ID, BAR_CODE, REPORT_SN, QUERY_TIME, REPORT_CREATE_TIME, NAME, CERT_TYPE, CERT_NO, QUERY_REASON, QYERY_FORMAT, QUERY_ORG, USER_CODE, QUERY_RESULT_CUE) values ('"+id+"', 'SQ201901100000081909', '"+REPORT_ID+"', '"+queryTime+"', '"+queryTime+"', '"+name+"', '身份证', '"+idNo+"', '贷款审批', null, '湖北消费金融股份有限公司', 'hb*fj*cx3', null)";
		 DB2Tool.update(env,sql);
		 log.info("=====已插入征信主表！！！ ===========REPORT_ID："+REPORT_ID+"   name:"+name+"  idNo"+idNo);
	  }
	  
	  /**
	   * 征信规则测试挡板
	   * @param env
	   * @param id
	   * @param flag  flag标识是否3个月内有贷款，0是无，1代表3个月内有贷款
	   * @param REPORT_ID
	   */
	  public static void insertDKtable(String env,String id,int flag,String REPORT_ID) {
		 //flag标识是否3个月内有贷款，0是无，1代表3个月内有贷款
		  String opentime=null;
		  SimpleDateFormat opendateformat =new SimpleDateFormat("yyyy-MM-dd");
		  if(flag==1) {
		   opentime=opendateformat.format(new Date());
		  }else {
			  opentime=MyDate.getBeforeDate(-3, -1).substring(0,10);
		  }
			 String sql="insert into TBL_PBOC_LOAN_INFO (ID, REPORT_ID, FINANCEORG, ACCOUNT, TYPE, CURRENCY, OPENDATE, ENDDATE, CREDITLIMITAMOUNT, GUARANTEETYPE, PAYMENTRATING, PAYMENTCYC, STATE, STATEENDDATE, STATEENDMONTH, CLASS5STATE, BALANCE, REMAINPAYMENTCYC, SCHEDULEDPAYMENTAMOUNT, SCHEDULEDPAYMENTDATE, ACTUALPAYMENTAMOUNT, RECENTPAYDATE, CURROVERDUECYC, CURROVERDUEAMOUNT, OVERDUE31TO60AMOUNT, OVERDUE61TO90AMOUNT, OVERDUE91TO180AMOUNT, OVERDUEOVER180AMOUNT, LAST24MONTHBEGINMONTH, LAST24MONTHENDMONTH, LATEST24STATE, LASTFIVEYEARBEGINMONTH, LASTFIVEYEARENDMONTH, LOAN_ID, CUE) values ('"+id+"', '"+REPORT_ID+"', '商业银行“IA”', null, '个人消费贷款', '人民币', '"+opentime+"', '2090-01-11', '100000', '信用/免担保', '28期', '按月归还', '正常', null, null, '正常', '80000', '23', '2000', '2017.02.04', '346', '2017.01.08', '1', '1', '0', '0', '0', '0', '2015.03.', '2017.02.', 'NNNNNNNNNNNNNNNNNNNNNNNN', null, null, '19409249236304776', '2.2016年09月10日商业银行“IA”发放的7,587元（人民币）个人消费贷款，业务号X，信用/免担保，28期，按月归还，2019年01月11日到期。截至2017年02月04日，')";
			 DB2Tool.update(env,sql);
			 log.info("=====已插入贷款信息表！！！ ===========REPORT_ID："+REPORT_ID);
		  }
	  
	  /**
	   * 评分测试挡板
	   * @param env
	   * @param id
	   * @param flag  flag标识是否3个月内有贷款，0是无，1代表3个月内有贷款
	   * 来源：TBL_PBOC_LOAN_INFO
                           计算：loan_type_zf_amount=IF TYPE in(‘个人商用房（包括商住两用’，‘个人商用房（包括商住两用）贷款’，‘个人住房公积金贷款’，‘个人住房贷款’) THEN SUM（CREDITLIMITAMOUNT）
	   (-Inf,0]->75  (0,300000]->77  (300000, Inf]->84 
	   * @param REPORT_ID   //////////////////////*N  计算N的次数
	   * (-Inf,0]||Missing/异常（非数值） (0,0.035] (0.035,0.45] (0.45, Inf]
	   */
	  public static void insertDKtableGrade(String env,String id,int flag,String REPORT_ID,double CREDITLIMITAMOUNT,double BALANCE,double rate) {
		  SimpleDateFormat reportidformat =new SimpleDateFormat("ddHHmmss");
		  String id1=reportidformat.format(new Date())+"002";
	  
		  String CREDITLIMITAMOUNT0=CREDITLIMITAMOUNT+"";
		  String BALANCE0=BALANCE+"";
		  double tatal=BALANCE/rate;
		  String a= df.format(tatal);		  
		  double aa=Double.parseDouble(a);
		  String another=(aa-BALANCE)+"";
		  System.out.println("aa:"+aa+"   another:"+another);
		 //flag标识是否3个月内有贷款，0是无，1代表3个月内有贷款
		  String opentime=null; 
		  SimpleDateFormat opendateformat =new SimpleDateFormat("yyyy-MM-dd");
		  if(flag==1) {
		   opentime=opendateformat.format(new Date());
		  }else {
			  opentime="2019-04-25";
		  }
			 String sql="insert into TBL_PBOC_LOAN_INFO (ID, REPORT_ID, FINANCEORG, ACCOUNT, TYPE, CURRENCY, OPENDATE, ENDDATE, CREDITLIMITAMOUNT, GUARANTEETYPE, PAYMENTRATING, PAYMENTCYC, STATE, STATEENDDATE, STATEENDMONTH, CLASS5STATE, BALANCE, REMAINPAYMENTCYC, SCHEDULEDPAYMENTAMOUNT, SCHEDULEDPAYMENTDATE, ACTUALPAYMENTAMOUNT, RECENTPAYDATE, CURROVERDUECYC, CURROVERDUEAMOUNT, OVERDUE31TO60AMOUNT, OVERDUE61TO90AMOUNT, OVERDUE91TO180AMOUNT, OVERDUEOVER180AMOUNT, LAST24MONTHBEGINMONTH, LAST24MONTHENDMONTH, LATEST24STATE, LASTFIVEYEARBEGINMONTH, LASTFIVEYEARENDMONTH, LOAN_ID, CUE) values ('"+id+"', '"+REPORT_ID+"', '商业银行“IA”', null, '农户贷款', '人民币', '"+opentime+"', '2090-01-11', '"+CREDITLIMITAMOUNT0+"', '信用/免担保', '28期', '按月归还', '正常', null, null, '正常', '"+BALANCE0+"', '23', '2000', '2017.02.04', '346', '2017.01.08', '1', '1', '0', '0', '0', '0', '2015.03.', '2017.02.', 'NNNNNNNNNNNNNNNNNNNNNNNN', null, null, '19409249236304776', '2.2016年09月10日商业银行“IA”发放的7,587元（人民币）个人消费贷款，业务号X，信用/免担保，28期，按月归还，2019年01月11日到期。截至2017年02月04日，')";
			 DB2Tool.update(env,sql);
			 if(rate>0) {
			 String sql1="insert into TBL_PBOC_LOAN_INFO (ID, REPORT_ID, FINANCEORG, ACCOUNT, TYPE, CURRENCY, OPENDATE, ENDDATE, CREDITLIMITAMOUNT, GUARANTEETYPE, PAYMENTRATING, PAYMENTCYC, STATE, STATEENDDATE, STATEENDMONTH, CLASS5STATE, BALANCE, REMAINPAYMENTCYC, SCHEDULEDPAYMENTAMOUNT, SCHEDULEDPAYMENTDATE, ACTUALPAYMENTAMOUNT, RECENTPAYDATE, CURROVERDUECYC, CURROVERDUEAMOUNT, OVERDUE31TO60AMOUNT, OVERDUE61TO90AMOUNT, OVERDUE91TO180AMOUNT, OVERDUEOVER180AMOUNT, LAST24MONTHBEGINMONTH, LAST24MONTHENDMONTH, LATEST24STATE, LASTFIVEYEARBEGINMONTH, LASTFIVEYEARENDMONTH, LOAN_ID, CUE) values ('"+id1+"', '"+REPORT_ID+"', '商业银行“IA”', null, '个人住房贷款', '人民币', '"+opentime+"', '2090-01-11', '"+CREDITLIMITAMOUNT0+"', '信用/免担保', '28期', '按月归还', '正常', null, null, '正常', '"+another+"', '23', '2000', '2017.02.04', '346', '2017.01.08', '1', '1', '0', '0', '0', '0', '2015.03.', '2017.02.', 'NNNNNNNNNNNNNNNNNNNNNNNN', null, null, '19409249236304776', '2.2016年09月10日商业银行“IA”发放的7,587元（人民币）个人消费贷款，业务号X，信用/免担保，28期，按月归还，2019年01月11日到期。截至2017年02月04日，')";
			 DB2Tool.update(env,sql1);
			 }
			 log.info("=====已插入贷款信息表！！！ ===========REPORT_ID："+REPORT_ID+"   another:"+another);
		  }
	  
	  
	  public static void insertDBtable(String env,String id,String REPORT_ID) {
			 String sql="insert into TBL_PBOC_GUARANTEE (ID, REPORT_ID, ORGANNAME, CONTRACTMONEY, BEGINDATE, ENDDATE, GUANANTEEMONEY, GUARANTEEBALANCE, CLASS5STATE, BILLINGDATE) values ('"+id+"', '"+REPORT_ID+"', 'VC', '100000', '2018.08.30', '2019.06.20', '100000', '100000', '正常', '2016.08.21')";
			 DB2Tool.update(env,sql);
			 log.info("=====已插入担保信息表！！！ ===========REPORT_ID："+REPORT_ID);
	   }
	  
	  public static void insertDcardtable(String env,String id,String REPORT_ID) {
			 String sql="insert into TBL_PBOC_LOAN_CARD_INFO (ID, REPORT_ID, CARD_TYPE, CUE, FINANCEORG, ACCOUNT, CURRENCY, OPENDATE, CREDITLIMITAMOUNT, GUARANTEETYPE, STATE, STATEENDDATE, STATEENDMONTH, SHARECREDITLIMITAMOUNT, USEDCREDITLIMITAMOUNT, LATEST6MONTHUSEDAVGAMOUNT, USEDHIGHESTAMOUNT, SCHEDULEDPAYMENTDATE, SCHEDULEDPAYMENTAMOUNT, ACTUALPAYMENTAMOUNT, GUANANTEEMONEY, RECENTPAYDATE, CURROVERDUECYC, CURROVERDUEAMOUNT, OVERDUE31TO60AMOUNT, OVERDUE61TO90AMOUNT, OVERDUE91TO180AMOUNT, OVERDUEOVER180AMOUNT, BEGINMONTH_24MONTH, ENDMONTH_24MONTH, LAST_24STATE, BEGINMONTH_FI, ENDMONTH_FIVEYEAR, LOAN_ID) values ('"+id+"', '"+REPORT_ID+"', '1', '1.2016年12月21日商业银行“LK”发放的贷记卡（人民币账户），业务号X，授信额度18,000元，共享授信额度18,000元，信用/免担保。截至2017年03月20日，', '商业银行“LK”', '人民币账户', '人民币', '2016-12-21', '20000', null, '正常', null, null, '18000', '18000', '12977', '100000', '2018.05.20', '1430', '5000', '0', '2018.05.08', '0', '0', null, null, null, null, '2015.04', '2018.05', 'NNNNNNNNNNNNNNNNNNNNNNNN', null, null, '19409249279119521')";
			 DB2Tool.update(env,sql);
			 log.info("=====已插入贷记卡、准贷记卡信息表！！！ ===========REPORT_ID："+REPORT_ID);
	   }
	  
	  
	  /**
	   * 近1个月本人查询次数 (1, Inf]||Missing/异常（小于0或非数值）->14  (0,1]->46 (-Inf,0]->82  依次递增
	   * @param env
	   * @param dknum
	   * @param xyknum
	   * @param REPORT_ID
	   * @throws InterruptedException
	   */
	  
	  public static void insertQueryTatal(String env,int dknum,int xyknum,String REPORT_ID) throws InterruptedException {
		     String id=null;
		     String sql=null;
		     String querytime=null;
		     SimpleDateFormat reportidformat =new SimpleDateFormat("ddHHmmss");
		     SimpleDateFormat querytimeformat =new SimpleDateFormat("yyyy.MM");
		     String querytime0=querytimeformat.format(new Date());
		    if(dknum>0) {
		    	log.info("插入贷款审批查询数据"+dknum+"条");
			    for(int i=0;i<dknum;i++) {
			    	  Thread.sleep(1000);
				     id=reportidformat.format(new Date())+"00"+(i+1);
				     querytime=querytime0+".0"+(i+1);
					 sql="insert into TBL_PBOC_RECORDDETAIL_HIS (ID, QUERY_DATE, QUERIER, QUERY_REASON, REPORT_ID) values ('"+id+"', '"+querytime+"', '湖北消费金融"+i+"', '贷款审批', '"+REPORT_ID+"')";
					 DB2Tool.update(env,sql);
					 if(i==6) {
						 Thread.sleep(1000);
						 id=reportidformat.format(new Date())+"01"+(i+1);
						 String sql1="insert into TBL_PBOC_RECORDDETAIL_HIS (ID, QUERY_DATE, QUERIER, QUERY_REASON, REPORT_ID) values ('"+id+"', '"+querytime+"', '湖北消费金融"+i+"', '贷款审批', '"+REPORT_ID+"')";
						 DB2Tool.update(env,sql1);
			         }
				}
			  log.info("=====已插入贷款查询统计信息表-贷款审批！！！ ===========REPORT_ID："+REPORT_ID);   
		     }
		    
		    if(xyknum>0) {
		    	log.info("插入信用卡审批查询数据"+xyknum+"条");
		    	for(int j=0;j<xyknum;j++) {
		    	   Thread.sleep(1000);
		    	   id=reportidformat.format(new Date())+"00"+(j+1);
		    	   querytime=querytime0+".0"+(j+1);
		    	    sql="insert into TBL_PBOC_RECORDDETAIL_HIS (ID, QUERY_DATE, QUERIER, QUERY_REASON, REPORT_ID) values ('"+id+"', '"+querytime+"', '湖北消费金融"+j+"', '信用卡审批', '"+REPORT_ID+"')";
		    	    DB2Tool.update(env,sql);
		    	}
				log.info("=====已插入贷款查询统计信息表-信用卡审批！！！ ===========REPORT_ID："+REPORT_ID);						
		    }
	  }
	  
	  /**TBL_PBOC_PERSIONAL_INFO
	   * 初中/中专及以下  高中 Missing 大专 本科及以上  依次递增
	   * @param env
	   * @param reportid
	   * @param idNo
	   * @param edulevel
	   */
	  public static void insertPersonalInfo(String env,String reportid,String idNo,String edulevel) {
		     String id=null;
		     String sql=null;
		     String BIRTHDAY=getBirthdate(idNo).replace("-", ".");
		     SimpleDateFormat reportidformat =new SimpleDateFormat("ddHHmmss");
//		     SimpleDateFormat querytimeformat =new SimpleDateFormat("yyyy.MM");
		     id=reportidformat.format(new Date())+"001";
		     sql="insert into TBL_PBOC_PERSIONAL_INFO (ID, REPORT_ID, GENDER, BIRTHDAY, MARITAL_STSTE, MOBILE, OFFICE_TELEPHONE_NO, HOME_TELEPHONE_NO, EDU_LEVEL, EDU_DEGREE, POST_ADDRESS, REGISTERED_ADDRESS, SPOUSE_NAME, SPOUSE_CERT_TYPE, SPOUSE_CERT_NO, SPOUSE_EMPLOYER, SPOUSE_TELEPHOME_NO) values ('"+id+"', '"+reportid+"', '男性', '"+BIRTHDAY+"', '已婚', '13962557880', '13913700093', '--', '"+edulevel+"', '其他', '吴江市平望镇西村6东木港4号', '--', '--', '--', '--', '--', '--')";
		     DB2Tool.update(env,sql);
		     log.info("插入TBL_PBOC_PERSIONAL_INFO表执行成功:"+sql);
	  }
	  
	  /**
	   * TBL_PBOC_PROFESSIONAL
	   * INDUSTRY:房地产业，公共管理和社会组织，建筑业，教育
	   * @param env
	   * @param reportid
	   * @param INDUSTRY
	   */
	  
	  public static void insertTblPbocProfessional(String env,String reportid,String INDUSTRY) {
		     String sql=null;
		     SimpleDateFormat reportidformat =new SimpleDateFormat("ddHHmmss");
//		     SimpleDateFormat querytimeformat =new SimpleDateFormat("yyyy.MM");
		     String id=reportidformat.format(new Date())+"001";
		     sql="insert into TBL_PBOC_PROFESSIONAL (ID, REPORT_ID, EMPLOYER, EMPLOYER_ADDRESS, OCCUPATION, INDUSTRY, DUTY, TITLE, START_YEAR, GET_TIME) values ('"+id+"', '"+reportid+"', '宇信', '创立方', 'IT', '"+INDUSTRY+"', '员工', 'java', '2019', '2019-07-25')";  
		     DB2Tool.update(env,sql);
		     log.info("插入TBL_PBOC_PROFESSIONAL表执行成功:"+sql);
	  }
	  
	  /**
	   * 来源：TBL_CRE_PB_RF_INFO
	   *PRI24MONTHRETST： 销户  封存  缴交   Missing/异常（非以上三种状态）依次递增
                           计算：最近一次更新时间对应的PRI_24_MONTH_RETST  最近一次公积金缴费状态  销户封存 缴交 Missing/异常（非以上三种状态）
	   * @param env 
	   * @param reportid
	   * @param PRI24MONTHRETST
	   */
	  public static void insertTblCrePbReInfo(String env,String id,String reportid,String PRI24MONTHRETST) {
		     String sql=null;
//		     SimpleDateFormat reportidformat =new SimpleDateFormat("ddHHmmss");
//		     SimpleDateFormat querytimeformat =new SimpleDateFormat("yyyy.MM");
//		     String id=reportidformat.format(new Date())+"001";
		     sql="insert into TBL_CRE_PB_RF_INFO (PRI_BARCODE, PRI_NUM, PRI_ACCOUNT, PRI_EMP, PRI_OA_DATE, PRI_FIRST_HOT_DATE, PRI_LAST_HOT_DATE, PRI_RECENT_HOT_DATE, PRI_PAY_DEPOSIT_COM, PRI_PAY_DEPOSIT_PER, PRI_MONTH_PAY_DEPOSIT, PRI_INFO_DATE, PRI_24_MONTH_RETST, PRI_NEW_ID, PRI_NEW_DATE, PRI_UPDATE_ID, PRI_UPDATE_DATE, ID) values ('"+id+"', '"+reportid+"', '参缴地', '缴费单位', '2016.01.01', '2016.02', '2019.03.10', '2019.03.10', '0.04', '0.06', '0', '2019.06.25', '"+PRI24MONTHRETST+"', null, null, null, null, '"+id+"')";
		     DB2Tool.update(env,sql);
		     log.info("插入TBL_CRE_PB_RF_INFO表执行成功:"+sql);		  
	  }
	  
	  
	  /**
	   * TBL_PBOC_RECORDSUMMARY
	   * @param env
	   * @param id
	   * @param reportid
	   * @param querynum  查询次数(1, Inf]||Missing/异常（小于0或非数值）-》14  (0,1]-》46  (-Inf,0]-》82           
	   */
	  public static void insertTblPbocRecordsummary(String env,String id,String reportid,String querynum) {
		  String sql="insert into TBL_PBOC_RECORDSUMMARY (ID, REPORT_ID, LOAN_COUNT, CREDIT_COUNT, PSP_COUNT, GUAR_COUNT, SPECIALCUS_COUNT, QUERY_CYCLE, OWN_COUNT) values ('"+id+"', '"+reportid+"', '1', '0', null, null, null, '最近1个月内的查询次数', '"+querynum+"')";
		  DB2Tool.update(env,sql);
		  log.info("插入TBL_PBOC_RECORDSUMMARY表执行成功:"+sql);	
		  
	  }
	    
	  
	  public static void updateZXMaintalbe(String REPORT_ID,String name,String idNo) {
		  String sql="UPDATE  TBL_PBOC_RESULT_INFO  SET NAME='"+name+"',CERT_NO='"+idNo+"' WHERE REPORT_SN='"+REPORT_ID+"'";
		  DB2Tool.update(sql);
		  log.info("=====已更新征信主表！！！ ===========");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public static void updateZXMaintalbe(String env,String REPORT_ID,String name,String idNo) {
		  String sql="UPDATE  TBL_PBOC_RESULT_INFO  SET NAME='"+name+"',CERT_NO='"+idNo+"' WHERE REPORT_SN='"+REPORT_ID+"'";
		  DB2Tool.update(env,sql);
		  log.info("=====已更新征信主表！！！ ===========");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  
	  public static void updateZXDKtalbe(String REPORT_ID,String CLASS5STATE,String CURROVERDUECYC,String CURROVERDUEAMOUNT,String LATEST24STATE) {
		  String sql="UPDATE  TBL_PBOC_LOAN_INFO  SET CLASS5STATE='"+CLASS5STATE+"',LATEST24STATE='"+LATEST24STATE+"',CURROVERDUECYC='"+CURROVERDUECYC+"',CURROVERDUEAMOUNT='"+CURROVERDUEAMOUNT+"' where REPORT_ID='"+REPORT_ID+"'";
		  DB2Tool.update(sql);
		  log.info("=====贷款五级分类已更新！！！ ===========");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  /**
	   * 来源：TBL_PBOC_LOAN_INFO
                          计算：MAX(还款状态LAST_24STATE中出现‘N’的次数)
	   * @param env
	   * @param REPORT_ID
	   * @param CLASS5STATE
	   * @param CURROVERDUECYC
	   * @param CURROVERDUEAMOUNT
	   * @param LATEST24STATE
	   */

	  public static void updateZXDKtalbe(String env,String REPORT_ID,String CLASS5STATE,String CURROVERDUECYC,String CURROVERDUEAMOUNT,String LATEST24STATE) {
		  String sql="UPDATE  TBL_PBOC_LOAN_INFO  SET CLASS5STATE='"+CLASS5STATE+"',LATEST24STATE='"+LATEST24STATE+"',CURROVERDUECYC='"+CURROVERDUECYC+"',CURROVERDUEAMOUNT='"+CURROVERDUEAMOUNT+"' where REPORT_ID='"+REPORT_ID+"'";
		  DB2Tool.update(env,sql);
		  log.info("=====贷款五级分类已更新！！！ ===========");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public static void updateZXDBtalbe(String REPORT_ID,String CLASS5STATE) {
		  
		  String sql="UPDATE  TBL_PBOC_GUARANTEE  SET CLASS5STATE='"+CLASS5STATE+"' where REPORT_ID='"+REPORT_ID+"'";
		  DB2Tool.update(sql);
		  log.info("=====担保五级分类已更新！！！ ===========");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }//TBL_PBOC_LOAN_CARD_INFO
	  
	  

	  public static void updateZXDBtalbe(String env,String REPORT_ID,String CLASS5STATE) {
		  
		  String sql="UPDATE  TBL_PBOC_GUARANTEE  SET CLASS5STATE='"+CLASS5STATE+"' where REPORT_ID='"+REPORT_ID+"'";
		  DB2Tool.update(env,sql);
		  log.info("=====担保五级分类已更新！！！ ===========");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }//TBL_PBOC_LOAN_CARD_INFO
	  
public static void updateZXDcardtalbe(String REPORT_ID,String type,String CURROVERDUECYC,String CURROVERDUEAMOUNT,String LATEST24STATE) {
	//--1、贷记卡；2、准贷记卡	  
	String sql="UPDATE  TBL_PBOC_LOAN_CARD_INFO  SET CARD_TYPE='"+type+"',CURROVERDUECYC='"+CURROVERDUECYC+"',CURROVERDUEAMOUNT='"+CURROVERDUEAMOUNT+"',LAST_24STATE='"+LATEST24STATE+"' where REPORT_ID='"+REPORT_ID+"'";
	log.info(""+sql);
	 DB2Tool.update(sql);
	  log.info("=====贷记卡信息已更新！！！ ===========");
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}//TBL_PBOC_LOAN_CARD_INFO
	



	public static void updateZXDcardtalbe(String env,String REPORT_ID,String type,String CURROVERDUECYC,String CURROVERDUEAMOUNT,String LATEST24STATE) {
	//--1、贷记卡；2、准贷记卡	  
	String sql="UPDATE  TBL_PBOC_LOAN_CARD_INFO  SET CARD_TYPE='"+type+"',CURROVERDUECYC='"+CURROVERDUECYC+"',CURROVERDUEAMOUNT='"+CURROVERDUEAMOUNT+"',LAST_24STATE='"+LATEST24STATE+"' where REPORT_ID='"+REPORT_ID+"'";
	log.info(""+sql);
	DB2Tool.update(env,sql);
	log.info("=====贷记卡信息已更新！！！ ===========");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}//TBL_PBOC_LOAN_CARD_INFO

	public static List<String> getContLoanNo(String env,String thirdSeq) {
		//	List list=new ArrayList();
		List<String> list = new ArrayList<String>();
		//查询出第三方流水号
	    String applseqsql="SELECT APPL_SEQ FROM LC_APPL WHERE THIRD_SEQ='"+thirdSeq+"'";
	    String applSeq=DB2Tool.excuteQuery(env,applseqsql,"APPL_SEQ");
	    log.info("=====！！！ APPL_SEQ:==========="+applSeq);
	   //获取数据库借据、合同信息				 
		 //根据放款支付表查出合同编号 、借据编号
		 String contnosql="SELECT CONT_NO FROM lpb_appl_dn WHERE   APPL_SEQ IN(SELECT APPL_SEQ FROM LC_APPL WHERE THIRD_SEQ='"+thirdSeq+"')"; 
		 String contno=DB2Tool.excuteQuery(env,contnosql,"CONT_NO");
		 log.info("=====！！！ CONT_NO:==========="+contno);
		 
		 String loannosql="SELECT LOAN_NO FROM lpb_appl_dn WHERE   APPL_SEQ IN(SELECT APPL_SEQ FROM LC_APPL WHERE THIRD_SEQ='"+thirdSeq+"')"; 
		 String loanno=DB2Tool.excuteQuery(env,loannosql,"LOAN_NO");
		 log.info("=====！！！ LOAN_NO:==========="+loanno);
	//	  list.add(thirdSeq);
		  list.add(contno);
		  list.add(loanno);	
		  System.out.println("contno=list.get(0):"+list.get(0)+"  loanno=list.get(1):"+list.get(1));
		  return list;	
	}
	
/**
 * 
 * @param env
 * @param flag  日终状态标识 true为Y，false为N
 */
public static void updateNightFlag(String env,Boolean flag) {
	String updatesql=null;
	if(flag.equals(true)) {
		 updatesql="update s_ctrl set NIGHT = 'Y'";
		 DB2Tool.update(env,updatesql);
		 System.out.println("已更新为日终状态");
	}else {
		updatesql="update s_ctrl set NIGHT = 'N'";
		DB2Tool.update(env,updatesql);
		System.out.println("已关闭日终状态");
	}	
}

/**
 * flag为true时更新为支付失败，为false时为支付成功
 * @param env
 * @param flag
 */
public static void updatePayFail(String env,Boolean flag) {
	String updatesql=null;
	if(flag.equals(true)) {
		 updatesql="update  s_config  set CFG_VALUE='100' where CFG_NAME='pay_Round'";
		 DB2Tool.update(env,updatesql);
		 System.out.println("已更新为支付失败状态");
	}else {
		updatesql="update s_config set CFG_VALUE='0' where CFG_NAME='pay_Round'";
		DB2Tool.update(env,updatesql);
		System.out.println("已更新为支付成功状态");
	}	
}


public static String queryApplSeq(String env,String idNo) {
	String sql="SELECT APPL_SEQ FROM LC_APPL WHERE ID_NO='"+idNo+"'";
	String ApplSeq=DB2Tool.excuteQuery(env,sql,"APPL_SEQ");
	String sql1="SELECT APPL_CDE FROM LC_APPL WHERE ID_NO='"+idNo+"'";
	String ApplCde=DB2Tool.excuteQuery(env,sql1,"APPL_CDE");
	System.out.println("ApplCde:"+ApplCde+"   ApplSeq:"+ApplSeq);
	return ApplSeq;
}

public static String getApplSeq(String env,String idNo) {
//	String sql="SELECT APPL_SEQ FROM LC_APPL WHERE ID_NO='"+idNo+"'";
	String sql="select APPL_SEQ from lc_appl where id_no='"+idNo+"' order by APPL_CDE desc fetch first 1 rows only";
	String ApplSeq=DB2Tool.excuteQuery(env,sql,"APPL_SEQ");
//	String sql1="SELECT APPL_CDE FROM LC_APPL WHERE ID_NO='"+idNo+"'";
	String sql1="select APPL_CDE from lc_appl where id_no='"+idNo+"' order by APPL_CDE desc fetch first 1 rows only";
	String ApplCde=DB2Tool.excuteQuery(env,sql1,"APPL_CDE");
	System.out.println("ApplCde:"+ApplCde+"   ApplSeq:"+ApplSeq);
	return ApplSeq;
}
      
public static String getThirdSeq(String env,String idNo) {
	String sql="SELECT THIRD_SEQ FROM LC_APPL WHERE ID_NO='"+idNo+"'";
	String thirdseq=DB2Tool.excuteQuery(env,sql,"THIRD_SEQ");
	String sql1="SELECT APPL_CDE FROM LC_APPL WHERE ID_NO='"+idNo+"'";
	String ApplCde=DB2Tool.excuteQuery(env,sql1,"APPL_CDE");
	System.out.println("ApplCde:"+ApplCde+"   THIRD_SEQ:"+thirdseq);
	return thirdseq;
}


public static String getNextDueDate(String env,String idNo) {
	String nextduedatesql="SELECT NEXT_DUE_DT FROM LM_LOAN WHERE CUST_ID  IN(SELECT CUST_ID FROM LC_APPL WHERE ID_NO='"+idNo+"')";
	String NFDate=DB2Tool.excuteQuery(env, nextduedatesql, "NEXT_DUE_DT");
	return NFDate;
	   
}

public static void main(String[] args) throws InterruptedException {
		  String env="UAT1";
//		  GetParam.isEqualTime("uat1","yxuat","gllouat1");
//		  String idNo="511901198905200035";
//		 List<String> list= GetParam.getContLoanNo("UAT1", idNo);
//		 System.out.println(list.get(1));
//		System.out.println(GetParam.getBillDate("uat1","dueDt"));
//		  String name="魏小军";
//		  String idNo=StringUtils.getIdNo("19900102", true);
//		  GetParam.getAgeStr(env, idNo);
//		  Thread.sleep(50000);
		  //第一代征信测试处理  111  
//		  String REPORT_ID="2019031100000613096092";	
//		 GetParam.updateZXDBtalbe(REPORT_ID, "正常");
//		 GetParam.updateZXDcardtalbe(REPORT_ID,"1", "0", "0", "NNNNNNNNNNNNNNNNNNNNNNNN");
//		  GetParam.updateNightFlag(env,false);
//		  GetParam.updatePayFail(env, false);  //28114029986  2019031100000613096091
//		                                         1409471301  201909120921505880000 
//	     /*
		  int m=1;
		  SimpleDateFormat reportidformat =new SimpleDateFormat("ddHHmmssSS");
	      SimpleDateFormat mainreportformat =new SimpleDateFormat("yyyyMMddHHmmssSS");
	      
	      String id=reportidformat.format(new Date());
	      String REPORT_ID=mainreportformat.format(new Date())+"0000"+m;
//	      REPORT_ID="2019092910501985200001";
//	      System.out.println("ID:"+id);
	      System.out.println("REPORT_ID:"+REPORT_ID);
//	      GetParam.insertZXMaintable(env,id, REPORT_ID, name, idNo);
//	      GetParam.insertDKtable(env, id,0, REPORT_ID);
//	      GetParam.insertDKtableGrade(env, id,0, REPORT_ID,0,5000,0.6);
//	      REPORT_ID.insertTblPbocProfessional( env, REPORT_ID, "");
//		  */
	    //  GetParam.insertQueryTatal(env, 8, 0, REPORT_ID);
//	        System.out.println("birthtime:"+birthtime);
//	        GetParam.insertPersonalInfo(env,REPORT_ID, idNo);
//	        GetParam.insertTblPbocProfessional(env, REPORT_ID, "建筑业");
	        GetParam.insertTblCrePbReInfo(env, id,REPORT_ID, "销户");
		  
	}
}
