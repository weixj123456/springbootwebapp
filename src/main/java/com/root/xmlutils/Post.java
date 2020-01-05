package com.root.xmlutils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Post {

    /** 
     * 微服务使用请求方法
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
//			urlCon.setRequestProperty("content-type","application/x-www-form-urlencoded;charset=UTF-8");
			urlCon.setRequestProperty("content-type","text/xml;charset=UTF-8");
			urlCon.setUseCaches(false);
			// 设置为gbk可以解决服务器接收时读取的数据中文乱码问题
			urlCon.getOutputStream().write(xmlStr.getBytes("UTF-8"));
			urlCon.getOutputStream().flush();
			urlCon.getOutputStream().close();
			InputStream in = urlCon.getInputStream();
			byte[] ret = new byte[in.available()];
			in.read(ret);
			System.out.println("服务器端发送的报文为：\n" +xmlStr);
			System.out.println("服务器端返回的报文为：\n" + new String(ret, "UTF-8"));
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
	
	

    /** 
     * 微服务使用请求方法
	 * <ol>HTTPS请求发送</ol>
	 */
	public static String post(String httpsUrl, String postid,String xmlStr) {
       String response=null;
		HttpURLConnection urlCon = null;
		try {
			urlCon = (HttpURLConnection) (new URL(httpsUrl)).openConnection();
			urlCon.setDoInput(true);
			urlCon.setDoOutput(true);
			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("Content-Length",String.valueOf(xmlStr.getBytes("UTF-8").length));
//			urlCon.setRequestProperty("content-type","application/x-www-form-urlencoded;charset=UTF-8");
			urlCon.setRequestProperty("content-type","text/xml;charset=UTF-8");
			urlCon.setUseCaches(false);
			// 设置为gbk可以解决服务器接收时读取的数据中文乱码问题
			urlCon.getOutputStream().write(xmlStr.getBytes("UTF-8"));
			urlCon.getOutputStream().flush();
			urlCon.getOutputStream().close();
			InputStream in = urlCon.getInputStream();
			byte[] ret = new byte[in.available()];
			in.read(ret);
			System.out.println("客户端发送"+postid+"的报文为：" +xmlStr);
			System.out.println("服务器端返回"+postid+"的报文为：" + new String(ret, "UTF-8"));
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
