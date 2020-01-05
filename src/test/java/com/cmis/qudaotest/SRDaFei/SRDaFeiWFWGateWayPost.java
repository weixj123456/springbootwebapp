package com.cmis.qudaotest.SRDaFei;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.log4j.Logger;
import com.root.entity.Channel;
import com.root.entity.Idcard;
import com.root.myutils.GetParam;
import com.root.service.ChannelService;
import com.root.service.IdcardService;
import com.root.utils.StringUtils;
import com.root.xmlutils.Dom4j4Utils;
import com.root.xmlutils.GetXml;
import com.root.xmlutils.JiaMi;
import com.root.xmlutils.MyParseXMLDoc;
import com.root.xmlutils.Post;
import com.root.xmlutils.WriteXmlFile;


public class SRDaFeiWFWGateWayPost {
    
	private final static Logger	log	= Logger.getLogger(SRDaFeiWFWGateWayPost.class);

	
	public static String custName;
	public static String idNo;
	public static String reqTime;
//	public static String applAcNo;
	public static String phoneNo;
	public static String flowNo;
	public static String thirdSeq;
	public static String apptAge;
	      // 生成随机数
			public static int tails(final int min, final int max) {
				Random r1 = new Random();
				int tmp = Math.abs(r1.nextInt());
				return tmp % (max - min + 1) + min;
			}
	
	static int[] phoneHead = { 186, 131, 185, 177, 138, 139, 156, 185, 152,150, 151 };
	static String indivMobile = phoneHead[(int) (Math.random() * 9)] +""+ tails(10000000, 99999999);

	private static String applAcNo = "6214320102" + tails(100000, 999999);
    
	
public static void main(String[] args) throws Exception {
           
	
    String env="PRESS"; 

	String qudaoenv="";
	    String hesuanenv="";
	String response=null;
	String httpsUrl = null;
	String channelid="7127";   	
	String superCoopr="";
	String cooprCde="";
	String loanTyp="";
	
	if(env.equals("UAT1")||env.equals("uat1")) {
    	 qudaoenv="YXUAT";
		 hesuanenv="GLLOUAT1";
		 httpsUrl = "http://10.10.0.66:7001/hbcfcmsa/gateway-inbound";
			superCoopr="szxs005001";
			cooprCde="szxs005001001";
			loanTyp="PDF003";
   }
	
	if(env.equals("CMIS")||env.equals("cmis")) {
    	 qudaoenv="YXCFC";
		 hesuanenv="GLLOANS";
		 httpsUrl="http://10.10.0.110:7001/hbcfcmsa/gateway-inbound";  //准生产
			superCoopr="szxs004001";
			cooprCde="szxs004001001";
			loanTyp="PDF003";
	}
	
	if(env.equals("press")||env.equals("PRESS")) {
		httpsUrl="http://10.200.9.25:7001/hbcfcmsa/gateway-inbound";
		qudaoenv="PRESSYXCFC";
		hesuanenv="PRESSGLLOANS";
		superCoopr="szxs004001";
		cooprCde="szxs004001001";
		loanTyp="PDF003";
	}
	
	
//		String httpsUrl = "http://10.10.0.66:7001/hbcfcmsa/gateway-inbound";
//    	String httpsUrl = "http://10.10.0.65:8081/hbcfcmsa/gateway-inbound";
//		String httpsUrl = "http://10.10.0.98:8082/hbcfcmsa/gateway-inbound"; //UAT
//		String httpsUrl="http://10.10.0.110:7001/hbcfcmsa/gateway-inbound";  //准生产
      for(int j=0;j<1;j++) {
    	String xmlStr0="";
    	String xmlStr="";
    	

		String[] idnogroup= {"19900808","19910808","19920808","19930808","19940808","19950808","19960808","19970808"};
		int idnoindex=(int)(Math.random()*idnogroup.length);
		String idnoyear=idnogroup[idnoindex];
    	int    num=          0          ;   //用于执行插入数据库记录数据   0为插入，其它值为不插入执行,并可从数据库获取值
    	SimpleDateFormat df =new SimpleDateFormat("yyyyMMddHHmmss");
    	SimpleDateFormat df1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String reqTime=df.format(new Date());
    	String sysdate=GetParam.getSysTime(env);
    	String lastChgDt=df1.format(new Date());
		
		Channel channel=ChannelService.getChannelByChannelid(channelid);
		String filepath=channel.getFilepath();
//		String cooprCde=channel.getHexinnemdianid();
		
    	String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjPa05Paazk+qxLND/Xncf0at1t7Wdg+sZhM+o1eRtm/Yy3U6tIdYqiTljACVm5PF90l9jGNQPE9Scr1OboYWTeumgB+jWDW2nOT5moWE87ZyZwV1NGwqnf6rdTcP1HoBMno6RO3DA3Jy1fbkaR7jGiMu1dTYPDOCktz5AXAdglQIDAQAB";
    		
		
		//查询三个系统时间是否一致
		if(GetParam.isEqualTime(env,qudaoenv,hesuanenv)==0) {
			
//      idNo=IdCardGenerator.createIdno();	
    	idNo=StringUtils.getIdNo(idnoyear, true);
		custName="SRDF"+StringUtils.getCustName();
	    apptAge=GetParam.getAgeStr(idNo);

		
//		custName="贷拒绝";
//	    idNo="310225201409100210";
	    System.out.println("custName:"+custName+"   idNo:"+idNo);
	    
        apptAge=GetParam.getAgeStr(idNo);			  
		  //解析身份证提取出生年月日
		String apptStartDate=GetParam.getBirthdate(idNo);
        
 		 phoneNo=indivMobile;   	 
    	 flowNo=idNo;
    	 thirdSeq=idNo;
 /*   	 
    	  String ZXTest="false";   	  //为false不调用征信
		  if("true".equals(ZXTest)) {
		  //第一代征信测试处理  先检查数据库REPORT_ID是否存在，若无需要先在征信表中插入以下表记录后做变更  NNNNNNNNNNNNNNNNNNNNNNNN
		  //String REPORT_ID,String CLASS5STATE,String CURROVERDUECYC,String CURROVERDUEAMOUNT,String LATEST24STATE
		  String REPORT_ID="2019031100000613096091";		  
		  GetParam.updateZXMaintalbe(REPORT_ID,custName, idNo);
		  GetParam.updateZXDKtalbe(REPORT_ID, "正常","0","0","NNNNNNNNNNNNNNNNNNNNNNNN");
		  GetParam.updateZXDBtalbe(REPORT_ID, "正常");
		  GetParam.updateZXDcardtalbe(REPORT_ID,"1", "0", "0", "NNNNNNNNNNNNNNNNNNNNNNNN");
		  }
    	 */
    	String common="xmlString=";
    	String common4064="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root><head><channel>7127</channel><currentBusinessCode>CF004064</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><sign></sign><signFlag></signFlag></head><reqdata>";
    	String common1018="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root><head><channel>7127</channel><currentBusinessCode>CF001018</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><sign></sign><signFlag></signFlag></head><reqdata>";
    	String common4063="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root><head><channel>7127</channel><currentBusinessCode>CF004063</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><sign></sign><signFlag></signFlag></head><reqdata>";
    	String common4043="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root><head><channel>7127</channel><currentBusinessCode>CF004043</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><sign></sign><signFlag></signFlag></head><reqdata>";
    	String end="</reqdata></root>";

 //   	/*
    	
    	// 用于变更影像批量上传原始报文数据
    	String[] filename= {"CF004064","CF001018","CF004063","CF004043"};  
    	MyParseXMLDoc.updateXMLhead(filepath,filename[1], "reqTime", reqTime);
    	MyParseXMLDoc.updateXMLhead(filepath,filename[1], "flowNo", flowNo);
		MyParseXMLDoc.updateXMLdata(filepath,filename[1], "custName", custName);
		MyParseXMLDoc.updateXMLdata(filepath, filename[1], "idNo", idNo);
		MyParseXMLDoc.updateXMLdata(filepath, filename[1], "thirdSeq", thirdSeq);
		MyParseXMLDoc.updateXMLdata(filepath, filename[1], "phoneNo", phoneNo); 
        //{"CF004064","CF001018","CF004063","CF004043"}; 
		MyParseXMLDoc.updateXMLhead(filepath,filename[2], "reqTime", reqTime);
		MyParseXMLDoc.updateXMLhead(filepath,filename[2], "flowNo", flowNo);		
		MyParseXMLDoc.updateXMLdata(filepath,filename[2], "custName", custName);
		MyParseXMLDoc.updateXMLdata(filepath, filename[2], "idNo", idNo);
		MyParseXMLDoc.updateXMLdata(filepath, filename[2], "thirdSeq", thirdSeq);
		MyParseXMLDoc.updateXMLdata(filepath, filename[2], "indivMobile", indivMobile); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[2], "applAcBank", "CMB"); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[2], "bankNo", applAcNo); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[2], "bankAcPhone", indivMobile); 
         //{"CF004064","CF001018","CF004063","CF004043"}; 
//		Dom4j4Utils  domutils=new Dom4j4Utils();		
		Dom4j4Utils.setDataValue(filepath, "CF004043", "indivMobile", indivMobile);
		Dom4j4Utils.setDataValue(filepath, "CF004043", "crtDt", sysdate);
		Dom4j4Utils.setDataValue(filepath, "CF004043", "lastChgDt", lastChgDt);
		MyParseXMLDoc.updateXml3Value(filepath, "CF004043", "iApplAccInfoList", "rows", "applAcKind", "02", "applAcNam", custName);
		MyParseXMLDoc.updateXml3Value(filepath, "CF004043", "iApplAccInfoList", "rows", "applAcKind", "02", "applAcNo", applAcNo);
		MyParseXMLDoc.updateXMLhead(filepath,filename[3], "flowNo", flowNo);
		MyParseXMLDoc.updateXMLhead(filepath,filename[3], "reqTime", reqTime);
		MyParseXMLDoc.updateXMLdata(filepath,filename[3], "custName", custName);
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "idNo", idNo);
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "thirdSeq", thirdSeq); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[3],  "indivMobile", indivMobile);
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "apptAge", apptAge); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "apptStartDate", apptStartDate); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "superCoopr", superCoopr); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "cooprCde", cooprCde); 
		MyParseXMLDoc.updateXMLdata(filepath, filename[3], "loanTyp", loanTyp); 

		
		log.info("=====================获取报文体数据开始。。。。。==============================");
  //  	*/
		//定义用于截取主求报文数据体
    	String[] filereqdata= {"CF001018.xml","CF004063.xml","CF004043.xml"};	   	
    	String reqdata4064="<cooprCde>"+cooprCde+"</cooprCde>";
    	log.info("reqdata4064:\n"+reqdata4064);
    	//获取影像批量上传数据体
    	String reqdata1018=GetXml.matcher(GetXml.replaceBlank(GetXml.getXmlString(filepath+filereqdata[0])), "reqdata"); 
    	log.info("reqdata1018:\n"+reqdata1018);
    	//获取风控数据体
    	String reqdata4063=GetXml.matcher(GetXml.replaceBlank(GetXml.getXmlString(filepath+filereqdata[1])), "reqdata");    	    	
    	log.info("reqdata4063:\n"+reqdata4063);
    	//获取进件申请数据体
    	String reqdata4043=GetXml.matcher(GetXml.replaceBlank(GetXml.getXmlString(filepath+filereqdata[2])), "reqdata");   	
    	log.info("reqdata4043:\n"+reqdata4043);
    	System.out.println("=====================数据体已全部获取。。。=============");
//    	Thread.sleep(50000);  //DZY052
    	log.info("==================获取报文体数据结束。。。。。=================================");
    	System.out.println("客户名称:"+custName+"      身份证号: "+idNo+"      手机号:"+indivMobile+"  银行卡号："+applAcNo);
	    System.out.println("      流水号:"+flowNo+"        请求时间:"+reqTime+"      第三方流水号:"+thirdSeq);

		log.info("=================准入校验提交开始。。。======================");	

		//处理准入查询  包括加密码、组装报文、发送请求

		String reqRsadata4064= JiaMi.rsaString(publicKey, reqdata4064);
		System.out.println("准入查询strreqdata4064:");
		System.out.println(common+common4064+reqRsadata4064+end);
		xmlStr0=common4064+reqRsadata4064+end;
		xmlStr=common+common4064+reqRsadata4064+end;
		WriteXmlFile.writeXmlFile(filepath, "strreqdata4064", xmlStr0);
		System.out.println("准入查询提交处理中。。。"+httpsUrl);
//		response=Post.post(httpsUrl, xmlStr);
		response="0";
		System.out.println("等待中。。。"+httpsUrl);
//		Thread.sleep(50000);
		System.out.println("======已完成提交准入=================================");
		
//		if("0".equals(MyParseXMLDoc.getRespXMLValue(response, "ec"))) {	
			
		if(true) {		
			
		log.info("=================进件申请分别调用批量影像上传、风控上传、进件申请提交开始。。。======================");	
		//处理影像批量上传  包括加密码、组装报文、发送请求
		String reqRsadata1018= JiaMi.rsaString(publicKey, reqdata1018);
		System.out.println("批量影像strreqdata1018:\n");
		System.out.println(common+common1018+reqRsadata1018+end);
		xmlStr0=common1018+reqRsadata1018+end;
		xmlStr=common+common1018+reqRsadata1018+end;
		WriteXmlFile.writeXmlFile(filepath, "reqRsadata1018", xmlStr0);
		response=Post.post(httpsUrl, xmlStr);
		System.out.println("等待中。。。");
//		Thread.sleep(50000);
		System.out.println("================影像提交=======================");
		System.out.println("================影像提交=======================");
		System.out.println("================影像提交=======================");
		
		if("0".equals(MyParseXMLDoc.getRespXMLValue(response, "ec"))) {
		//处理风控字段上传  包括加密码、组装报文、发送请求
		String reqRsadata4063=JiaMi.rsaString(publicKey, reqdata4063);
		System.out.println("风控reqdata4063:");
		System.out.println(common+common4063+reqRsadata4063+end);
		xmlStr0=common4063+reqRsadata4063+end;
		xmlStr=common+common4063+reqRsadata4063+end;
		WriteXmlFile.writeXmlFile(filepath, "strreqdata4063", xmlStr0);
		response=Post.post(httpsUrl, xmlStr);
		System.out.println("===============风控提交========================");
		System.out.println("===============风控提交========================");
		System.out.println("===============风控提交========================");
	     
		if("0".equals(MyParseXMLDoc.getRespXMLValue(response, "ec"))) {
			//处理贷款申请提交  包括加密码、组装报文、发送请求

			String reqRsadata4043=JiaMi.rsaString(publicKey, reqdata4043);
			System.out.println("贷款申请提交reqdata4043:");
			System.out.println(common+common4043+reqRsadata4043+end);
			xmlStr0=common4043+reqRsadata4043+end;
			xmlStr=common+common4043+reqRsadata4043+end;
			WriteXmlFile.writeXmlFile(filepath, "strreqdata4043", xmlStr0);
			String response1=Post.post(httpsUrl, xmlStr);
			if("0".equals(MyParseXMLDoc.getRespXMLValue(response1, "ec"))) {
			   if(num==0) {
			      //保存操作客户信息
				  IdcardService.insert(custName, idNo, indivMobile, applAcNo, channelid, "达飞测试"+sysdate+"||"+"进件成功"+j);
				 }
				System.out.println("==============进件提交=========================");
				System.out.println("==============进件提交=========================");
				System.out.println("==============进件提交=========================");
			  }
			}	
		  }  
      }else {
		  log.info("调用准入存在问题，请排查。。。。");
      }
	}		
   }
}    
    
    
    
     /**
 	 * <ol>HTTPS请求发送</ol>
 	 */
 	public static String post(String httpsUrl, String xmlStr) {
        String response=null;
 		HttpURLConnection urlCon = null;
 		try {
 			urlCon = (HttpURLConnection) (new URL(httpsUrl)).openConnection();

 			urlCon.setDoInput(true);
 			urlCon.setDoOutput(true);
 			urlCon.setRequestMethod("POST");
 			urlCon.setRequestProperty("Content-Length",String.valueOf(xmlStr.getBytes("UTF-8").length));
// 			urlCon.setRequestProperty("content-type","application/x-www-form-urlencoded;charset=UTF-8");
 			urlCon.setRequestProperty("content-type","text/xml;charset=UTF-8");
 			urlCon.setUseCaches(false);
 			// 设置为gbk可以解决服务器接收时读取的数据中文乱码问题
 			urlCon.getOutputStream().write(xmlStr.getBytes("UTF-8"));
 			urlCon.getOutputStream().flush();
 			urlCon.getOutputStream().close();
 			InputStream in = urlCon.getInputStream();
 			byte[] ret = new byte[in.available()];
 			in.read(ret);
 			System.out.println("服务器端返回的报文为：" + new String(ret, "UTF-8"));
 			response=new String(ret, "UTF-8");
 		} catch (MalformedURLException e) {
 			e.printStackTrace();
 			return "调用异常，请排查";
 		} catch (IOException e) {
 			e.printStackTrace();
 			return "调用异常，请排查";
 		} catch (Exception e) {
 			e.printStackTrace();
 			return "调用异常，请排查";
 		}
		return response;
 	}
 	
 
}
