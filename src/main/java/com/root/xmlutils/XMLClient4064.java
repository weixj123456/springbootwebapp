package com.root.xmlutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.FileUtils;

import com.root.entity.Channel;
import com.root.service.ChannelService;




public class XMLClient4064 {
	public static String channelid;
	
	public static String filepath;    //获取服务器文件路径 ，可在这个路径下创建你上传的文件，与工程XML文件名中保持一致/home/upload/thirdChannel/
	public static String ipaddr;
	 
	public XMLClient4064(String channelid) {
		XMLClient4064.channelid=channelid;
	}
	
	public  String getReqString(String virtualHostFileName) throws Exception{
		File file = new File(virtualHostFileName);
		return FileUtils.readFileToString(file);	
	}	

	public  String getReqString4(String code) throws Exception{
		String virtualHostFileName = "D:\\code\\XMLClient\\xml\\"+code+".xml";
		File file = new File(virtualHostFileName);
		return FileUtils.readFileToString(file);	
	}	
	
	
	public  String getReqString2(String code) throws Exception{
//		String rootPath = this.getClass().getResource("/").getPath().toString();
//		rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
		//String virtualHostFileName = rootPath + "WEB-INF/request/" + currentBusinessCode + ".xml";	
		//准入查询接口  CF004064
		String virtualHostFileName = "D:\\code\\XMLClient\\xml\\"+code+".xml";
			
		File file = new File(virtualHostFileName);
		return FileUtils.readFileToString(file);	
	}	
	
		public String getReqString1(String tranCode) throws Exception{
//			String rootPath = this.getClass().getResource("/").getPath().toString();
//			rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
			//String virtualHostFileName = rootPath + "WEB-INF/request/" + tranCode + ".xml";	
			String virtualHostFileName = "D:\\code\\XMLClient\\xml\\CF004064.xml";
			
			File file = new File(virtualHostFileName);
			return FileUtils.readFileToString(file);	
		}
		
		
		public static String postXML4064(String channelid,String filepathandname) throws IllegalArgumentException, Exception {
			 String result =null;
			Channel channel1=ChannelService.getChannelByChannelid(channelid);
		     filepath =channel1.getFilepath();     //获取服务器文件路径 ，可在这个路径下创建你上传的文件，与工程XML文件名中保持一致/home/upload/thirdChannel/
			 ipaddr=channel1.getIpaddress();
						
//			final String ChARSET="UTF-8";
		     HttpClient httpClient = new HttpClient();
		     PostMethod postMethod = null;
		     if(channelid.equals("7115")) {
		    	 System.out.println("==================== 当前为分期乐渠道准入调用！！！========================");
			    postMethod = new PostMethod("http://10.10.0.98:8082/hbcfcmsa/gateway-inbound");
			    postMethod.setRequestHeader("Connection", "close");
			    postMethod.addRequestHeader("Content-Type","text/xml;charset=UTF-8");
		     }else {
		       postMethod = new PostMethod(ipaddr+"/iLoan/servlet/XMLReqServlet"); 
		       postMethod.setRequestHeader("Connection", "close");
			   postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
		     }		   
				XMLClient4064 client = new XMLClient4064(channelid);

		        String upData = client.getReqString(filepathandname);
		        postMethod.addParameter("xmlString", upData);
		        httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		        System.out.println("上送数据："+upData);
		        try {
		            httpClient.executeMethod(postMethod);
		            result = postMethod.getResponseBodyAsString();
//		            System.out.println("返回数据："+new String(result.getBytes("ISO8859-1"),"UTF-8"));
		            result=new String(result.getBytes("ISO8859-1"),"UTF-8");
		            System.out.println("返回数据："+result);
		            postMethod.releaseConnection();
		            
		        } catch (HttpException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            postMethod.releaseConnection();
		           
		        }
		        return result;
		    }
		
}
