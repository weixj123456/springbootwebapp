package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
 
//import com.sfzc.relation.service.imp.ProPropertiesOperate;
 
public class GetXml {
	private String fileUrl=null;
	public String getFileUrl() {
		return fileUrl;
	}
	public GetXml(String file) {
		this.fileUrl=GetXml.getPath(file);
	}
	/**
	  * 获得项目所在路径
	  * @return String
	  */
	 public static String getPath(String filename) {
	  URL url = GetXml.class.getResource("");
	  File file = new File(url.getFile());
	  String path = file.getParent();
	  while (-1 != path.lastIndexOf("bin") || -1 != path.lastIndexOf(".jar")) {
	   file = new File(path);
	   path = file.getParent();
	  }
	  if (path.startsWith("file")) {
	   path = path.replaceAll("file:", "");
	  }
 
	  path = path + File.separator + "imp\\"+filename; 
	  path="C:\\Program Files\\Apache Software Foundation\\Tomcat 5.5\\webapps\\sfzc\\WEB-INF\\classes\\com\\sfzc\\books\\service\\imp\\"+filename;
	  return path;
	 }
	 public org.jdom.Document load(){
		 org.jdom.Document document=null;
		 String url=this.getFileUrl();
		 try {
			 SAXBuilder reader = new SAXBuilder(); 
			 document=reader.build(new File(url));
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 return document;
	 }
	 public String XmlToString(){
		 org.jdom.Document document=null;
		 document=this.load();
		 
		 Format format =Format.getPrettyFormat();    
		 format.setEncoding("UTF-8");//设置编码格式 
		 
		 StringWriter out=null; //输出对象
		 String sReturn =""; //输出字符串
		 XMLOutputter outputter =new XMLOutputter(); 
		 out=new StringWriter(); 
		 try {
			outputter.output(document,out);
		 } catch (IOException e) {
			e.printStackTrace();
		 } 
		 sReturn=out.toString(); 
		 return sReturn;
	 }
 
	 
  public static String getXmlString(String filename) {
		 String xmlString;
		 byte[] strBuffer = null;
		 int flen = 0;
		 File xmlfile = new File(filename);
		 try {
		 InputStream in = new FileInputStream(xmlfile);
		 flen = (int)xmlfile.length();
		 strBuffer = new byte[flen];
		 in.read(strBuffer, 0, flen);
		 } catch (FileNotFoundException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 } catch (IOException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 xmlString = new String(strBuffer); //构建String时，可用byte[]类型，
		 return xmlString;
		}
	 
	 /*-----------------------------------

	    笨方法：String s = "你要去除的字符串";
	.去除空格：s = s.replace('\\s','');
	.去除回车：s = s.replace('\n','');

	    这样也可以把空格和回车去掉，其他也可以照这样做。

	    注：\n 回车(\u000a) 
	    \t 水平制表符(\u0009) 
	    \s 空格(\u0008) 
	    \r 换行(\u000d)
	    这个方法会去掉标签中值的空格
	    */	 
	 public static String replaceBlank0(String str) {
	        String dest = "";
	        if (str!=null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(str);
	            dest = m.replaceAll("");
	        }
	        return dest;
	    }
	 
	 public static String replaceBlank(String str) {

	        StringBuffer sb=new StringBuffer();
	        for(String s:str.split("\n")) {
	        	sb.append(s.trim());
	        }
	        return sb.toString();
	    }
	 
	 public String removeBlank(String resource,char ch)
	  {
	    StringBuffer buffer=new StringBuffer();
	    int position=0;
	    char currentChar;
	 
	    while(position<resource.length())
	    {
	      currentChar=resource.charAt(position++);
	      if(currentChar!=ch) buffer.append(currentChar); } 
	    return buffer.toString();
	  }

	 
	 
	 /**
	   * 获取指定标签中的内容
	   * @param xml 传入的xml字符串
	   * @param label  指定的标签中的内容
	   */
	 public static String regex(String xml,String label) {
	 String context = "";
	 //正则表达式
	 String rgex = "<"+label+">(.*?)</"+label+">";
     Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
	  Matcher m = pattern.matcher(xml);
  //匹配的有多个
	 		 List<String> list = new ArrayList<String>();
	        while (m.find()) {
	              int i = 1;
              list.add(m.group(i));
              i++;
	 }
	 //只要匹配的第一个
	    if(list.size()>0){
	 context = list.get(0);
	 }
	 return context;
	 }

	 /**
	   * 获取指定标签中的内容  重写regex()方法   此方法可用
	   * @param xml 传入的xml字符串
	   * @param label  指定的标签中的内容
	   *返回匹配成功后的字符串
	   */
	 
	 public static String matcher(String xml,String label) {
		 String context = "";		 
		 //正则表达式
		 String rgex = "<"+label+">(.*?)</"+label+">";
	     Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
		  Matcher m = pattern.matcher(xml);
	     while(m.find()) {	    	 
	    	 context= m.group(1);
	     }
		 return context;
		 }
	 
	 public static String matcherAndReplace(String xml,String label,String replacedStr) {
		 String context = "";		 
		 //正则表达式
		 String rgex = "<"+label+">(.*?)</"+label+">";
	     Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
		  Matcher m = pattern.matcher(xml);
	     while(m.find()) {	    	 
//	    	 System.out.println("1===========匹配并获取字符串成功==================1");
	    	 context= m.group(1);
	     }
	     context=xml.replace(matcher(xml,label), replacedStr);
		 return context;
		}	 
	 
	 
	 
	 public static void main(String[] args) {
//		  GetXml xml=new GetXml("E:\\git1\\WorkSpace-Oxygen\\ssm\\src\\com\\jsx\\utils\\CF004043.xml");
//		  String string=xml.getXmlString("E:\\git1\\WorkSpace-Oxygen\\ssm\\src\\com\\jsx\\utils\\CF004043.xml");
//		  String replacestr=GetXml.replaceBlank(string);   //获取XML文件并转换为字符串后需要去掉空格
//		  System.out.println("========"+replacestr+"===============");
		  String teststr="123564<Test>000000000011111111111</Test>";
//		  System.out.println(string);
//		 String string2=matcher(replacestr,"reqdata");
//		 System.out.println(string2);
		 
		 String context=matcherAndReplace(teststr,"Test","myReplacedtestXml");
		 System.out.println(context);
		 
//		 System.out.println("string2:"+string2);
//	       String strXml=null;
//	       GetXml xml=new GetXml("CF004043.xml");
//	       strXml=xml.XmlToString();
//	       System.out.println(strXml);
	//       return strXml;
		 
//	       String strXml=null;
//	       GetXml xml=new GetXml("CF004043.xml");
//	       strXml=xml.XmlToString();
//	       System.out.println(strXml);
	//       return strXml;

	}
}
