package com.root.xmlutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.root.entity.Channel;
import com.root.service.ChannelService;


public class PostOld {
		
	  private  String ipaddress;
	  private  String filepath;
	  private  String filecode;
	  
	 private final static Logger	log	= Logger.getLogger(PostOld.class);
     
	 public PostOld(String ipaddress,String filepath,String filecode) {
    	  this.ipaddress=ipaddress;
    	  this.filepath=filepath;
    	  this.filecode=filecode;
     }
	  
	 
	private  String getReqString(String channelid,String filecode) throws Exception{
		Channel channel=ChannelService.getChannelByChannelid(channelid);
	    String filepath=channel.getFilepath();
		String filename = filepath+filecode+".xml";
		log.info("已打印filename："+filename);
		File file = new File(filename);	
		return FileUtils.readFileToString(file);	
	}

	/**
	 * @param args
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 */
	public String postXML(String channelid) throws IllegalArgumentException, Exception {
		String result1 = null;
		HttpClient httpClient = new HttpClient();
		String Url=ipaddress+"/iLoan/servlet/XMLReqServlet";
		System.out.println("Url:"+Url);
		PostMethod postMethod = new PostMethod(Url);
        postMethod.setRequestHeader("Connection", "close");
	    postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
	    PostOld client = new PostOld(ipaddress, filepath, filecode);
	    String upData = client.getReqString(channelid,filecode);
	    postMethod.addParameter("xmlString", upData);
	    httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
	    log.info("上送数据:\n"+upData);
	    try {
	         httpClient.executeMethod(postMethod);
//	         postMethod.setResponse("Content-Type","text/html;charset=UTF-8");
	         String result = postMethod.getResponseBodyAsString();
//	         log.info("返回数据："+new String(result.getBytes("ISO8859-1"),"UTF-8"));
	         result1=new String(result.getBytes("ISO8859-1"),"UTF-8");
	         log.info("返回数据:\n"+result1);	            				
	         postMethod.releaseConnection();
	        } catch (HttpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            postMethod.releaseConnection();
	        }	        
			return result1;
	    }
         
	
	/**
	 * 
	 * @param ipaddress   服务器IP  http://10.10.0.31:8080/iLoan/servlet/XMLReqServlet
	 * @param channelid   渠道ID
	 * @return  result1        返回结果
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public String post(String Url,String channelid) throws IllegalArgumentException, Exception {
		String result1 = null;
		HttpClient httpClient = new HttpClient();
//		String Url=ip+"/iLoan/servlet/XMLReqServlet";
		System.out.println("Url:"+Url);
		PostMethod postMethod = new PostMethod(Url);
        postMethod.setRequestHeader("Connection", "close");
	    postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
	    PostOld client = new PostOld(ipaddress, filepath, filecode);
	    String upData = client.getReqString(channelid,filecode);
	    postMethod.addParameter("xmlString", upData);
	    httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
	    log.info("上送数据:\n"+upData);
	    try {
	         httpClient.executeMethod(postMethod);
	         String result = postMethod.getResponseBodyAsString();
//	         log.info("返回数据："+new String(result.getBytes("ISO8859-1"),"UTF-8"));
	         result1=new String(result.getBytes("ISO8859-1"),"UTF-8");
	         log.info("返回数据:\n"+result1);	            				
	         postMethod.releaseConnection();
	        } catch (HttpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            postMethod.releaseConnection();
	        }	        
			return result1;
	    }
	
	

	/**
	 * 
	 * @param ipaddress   服务器IP  http://10.10.0.31:8080/iLoan/servlet/XMLReqServlet
	 * @param channelid   渠道ID
	 * @return  result1        返回结果
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public String postString(String Url,String upData) throws IllegalArgumentException, Exception {
		String result = null;
		HttpClient httpClient = new HttpClient();
		System.out.println("Url:"+Url);
		PostMethod postMethod = new PostMethod(Url);
        postMethod.setRequestHeader("Connection", "close");
	    postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
	    postMethod.addParameter("xmlString", upData);
	    httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
	    log.info("上送数据:\n"+upData);
	    try {
	         httpClient.executeMethod(postMethod);
	         result = postMethod.getResponseBodyAsString();
	         System.out.println("===============================返回数据:==========================\n"+result);
	         System.out.println("\n");
	         System.out.println("=============================\n");
//	         log.info("返回数据：\n"+new String(result.getBytes("ISO8859-1"),"UTF-8"));
//	         result1=new String(result.getBytes("ISO8859-1"),"UTF-8");
//	         log.info("返回数据:\n"+result1);	            				
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
	
	public static void postXML4064(String channelid,String filepathandname) throws IllegalArgumentException, Exception {
        
		Channel channel=ChannelService.getChannelByChannelid(channelid);
	    String filepath =channel.getFilepath();     //获取服务器文件路径 ，可在这个路径下创建你上传的文件，与工程XML文件名中保持一致/home/upload/thirdChannel/
		String ipaddr=channel.getIpaddress();
					
//		final String ChARSET="UTF-8";
	     HttpClient httpClient = new HttpClient();
	     PostMethod postMethod = null;
	     if(channelid.equals("7115")) {
	    	 log.info("==================== 当前为分期乐渠道准入调用！！！========================");
		    postMethod = new PostMethod("http://10.10.0.98:8082/hbcfcmsa/gateway-inbound");
	     }else {
	       postMethod = new PostMethod(ipaddr+"/iLoan/servlet/XMLReqServlet"); 
	     }
	     postMethod.setRequestHeader("Connection", "close");
	     postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");

			XMLClient4064 client = new XMLClient4064(channelid);

	        String upData = client.getReqString(filepathandname);
	        postMethod.addParameter("xmlString", upData);
	        httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
	        log.info("上送数据：\n"+upData);
	        try {
	            httpClient.executeMethod(postMethod);
	            String result = postMethod.getResponseBodyAsString();
	            log.info("返回数据：\n"+new String(result.getBytes("ISO8859-1"),"UTF-8"));
	            postMethod.releaseConnection();
	        } catch (HttpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            postMethod.releaseConnection();
	        }		        
	    }
	
	
	
	
	/**
	 * @param args
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 */
	public String parseXMLAndPost(String channelid) throws IllegalArgumentException, Exception {
		String result1 = null;
		HttpClient httpClient = new HttpClient();
		String Url=ipaddress+"/iLoan/servlet/XMLReqServlet";
		System.out.println("Url:"+Url);
		 PostMethod postMethod = new PostMethod(Url);	 
	        postMethod.setRequestHeader("Connection", "close");
	        postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
	        PostOld client = new PostOld(ipaddress, filepath, filecode);
	        String upData = client.getReqString(channelid,filecode);
	        postMethod.addParameter("xmlString", upData);
	        httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
//	        log.info("===上送数据："+upData+"===");
	        try {
	            httpClient.executeMethod(postMethod);
	            String result = postMethod.getResponseBodyAsString();
	            result1=new String(result.getBytes("ISO8859-1"),"UTF-8");
	            log.info("返回数据：\n"+result1);	            				
	            postMethod.releaseConnection();
	        } catch (HttpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            postMethod.releaseConnection();
	        }	        
			return result1;
	    }

	public String post(String channelid) throws IllegalArgumentException, Exception {
		    String result1 = null;
		    HttpClient httpClient = new HttpClient();
		    PostMethod postMethod = new PostMethod(ipaddress+"/iLoan/servlet/XMLReqServlet");
	        postMethod.setRequestHeader("Connection", "close");
	        postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
	        PostOld client = new PostOld(ipaddress, filepath, filecode);
	        String upData = client.getReqString(channelid,filecode);
	        postMethod.addParameter("xmlString", upData);
	        httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
//	        log.info("===上送数据："+upData+"===");
	        try {
	            httpClient.executeMethod(postMethod);
	            String result = postMethod.getResponseBodyAsString();
	            result1=new String(result.getBytes("ISO8859-1"),"UTF-8");
	            log.info("返回数据:\n"+result1);	            				
	             postMethod.releaseConnection();
	        } catch (HttpException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            postMethod.releaseConnection();
	        }	        
			return result1;
	    }
	
	
}
