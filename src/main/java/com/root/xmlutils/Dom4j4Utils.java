package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

public class Dom4j4Utils { 
	
	
	
	
	public static void getDom4j4XmlNameValue(String channelid,String filepath,String filename) {			
			   
		       List<String> list = new ArrayList<String>();
				try{
			    InputSource is = new InputSource(filepath+filename+".xml");	
				SAXReader reader = new SAXReader(); 
				reader.setEncoding("utf-8"); 
				/*File f = new File("D:\\androidspace\\javanote\\src\\wzq\\j2se\\xml\\data4.xml"); 
				Document doc = reader.read(f); */ 
				Document doc = reader.read(is); 
				@SuppressWarnings("unused")
				Dom4j4Utils j1 = new Dom4j4Utils(); 
				Element rootElt = doc.getRootElement(); // 获取根节点 
				System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称 
				@SuppressWarnings("rawtypes")
				Iterator Resp = rootElt.elementIterator("Resp");
				// 遍历bbbb节点 
				while (Resp.hasNext()) { 
				Element recordEless = (Element) Resp.next(); 
				@SuppressWarnings("rawtypes")
				Iterator iBankSupChannelList = recordEless.elementIterator("iBankSupChannelList"); // 获取子节点bbbb下的子节点cccc 
				while (iBankSupChannelList.hasNext()) { 
				Element itemEle = (Element) iBankSupChannelList.next(); 
				@SuppressWarnings("rawtypes")
				Iterator row = itemEle.elementIterator("row");		 
				while(row.hasNext()){ 
				Element tableItem = (Element) row.next(); 
				String channelCode = tableItem.elementTextTrim("channelCode"); // 拿到dddd下的字节点username的值 
				list.add(channelCode);
				System.out.println("channelCode:" + channelCode);
				} 
				// 遍历方式1:使用iterator 
			    Iterator<String> it = list.iterator(); 
			    while (it.hasNext()) { 
			      @SuppressWarnings("unused")
				String value = it.next(); 
//			      System.out.println("List输出结果："+value); 
			       }
			    for (int i = 0, size = list.size(); i < size; i++) { 
					   String value = list.get(i); 
					   System.out.println("List输出结果===："+value); 
					 } 
				  } 
				 } 
				}catch(Exception e){ 
				e.printStackTrace(); 
		       } 
		    }
		
		//遍历list集合 
		@SuppressWarnings("unused")
		private static void listTest() { 
			 List<String> list = new ArrayList<String>(); 
			 list.add("111"); 
			 list.add("222"); 
			 list.add("333"); 
			 list.add("444"); 
			 list.add("555"); 
			  System.out.println("输出LIST列表数据。。。。。。。。。。。。。");
			 // 遍历方式1:使用iterator 
			 Iterator<String> it = list.iterator(); 
					 while (it.hasNext()) { 
					   String value = it.next(); 
					   System.out.println(value); 
					 } 
			
			 // 遍历方法2:使用传统for循环进行遍历。 
			 for (int i = 0, size = list.size(); i < size; i++) { 
			   String value = list.get(i); 
			   System.out.println(value); 
			 } 
			
			 // 遍历方法3:使用增强for循环进行遍历。 
			 for (String value : list) { 
			   System.out.println(value); 
			 } 
			} 
		
		public static void setHeadValue(String filepath,String filename,String element,String value) {			
			   
		    @SuppressWarnings("unused")
			List<String> list = new ArrayList<String>();
			     String file=filepath+filename+".xml";
			    InputSource is = new InputSource(file);	
				SAXReader reader = new SAXReader(); 
				reader.setEncoding("utf-8"); 
				Document doc = null;
				try {
					doc = reader.read(is);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				Element rootElt = doc.getRootElement(); // 获取根节点 
				System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称 
				rootElt.element("head").element(element).setText(value);
				try {
					XMLWriter writer=new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
					try {
						writer.write(doc);
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
  public String getXmlString0(String filename) {
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
		
		
public static void setDataValue(String filepath,String filename,String element,String value) {			   
		       
//			    List<String> list = new ArrayList<String>();
			    String file=filepath+filename+".xml";
			    InputSource is = new InputSource(file);	
				SAXReader reader = new SAXReader(); 
				reader.setEncoding("utf-8"); 
				Document doc = null;
				try {
					doc = reader.read(is);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				Element root = doc.getRootElement(); // 获取根节点 
//				System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
				root.element("reqdata").element(element).setText(value);
				try {
					XMLWriter writer=new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
					try {
						writer.write(doc);
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		


   public static void setXmlDataHeXin(String filepath,String filename,String element,String value,String fatherelementlist) {			   
       
//	    List<String> list = new ArrayList<String>();
	    String file=filepath+filename+".xml";
	    InputSource is = new InputSource(file);	
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
		Document doc = null;
		try {
			doc = reader.read(is);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Element root = doc.getRootElement(); // 获取根节点 
//		System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
		if(!(root.element("body").element(element)==null)){
		root.element("body").element(element).setText(value);
		}else {
			root.element("body").element(fatherelementlist).element(element).setText(value);
		}
		try {
			XMLWriter writer=new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
			try {
				writer.write(doc);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

public static void setValue(String filepath,String filename) {			
			   
		    @SuppressWarnings("unused")
			List<String> list = new ArrayList<String>();
			String file=filepath+filename+".xml";
			InputSource is = new InputSource(file);	
		    SAXReader reader = new SAXReader(); 
		    reader.setEncoding("utf-8"); 
			Document doc = null;
				try {
					doc = reader.read(is);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				Element root = doc.getRootElement(); // 获取根节点 
//				System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
				root.element("reqdata").element("custName").setText("123456");
				try {
					XMLWriter writer=new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
					try {
						writer.write(doc);
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}


       public static String setXML3Vaule(String xmlstr) {
    	   
    	   
    	   
		return xmlstr;
    	   
    	   
       }


				
		//遍历当前节点下的所有节点
		public static void listNodes(Element node){
//		    System.out.println("当前节点的名称：" + node.getName());
		    //首先获取当前节点的所有属性节点
		    @SuppressWarnings("unchecked")
			List<Attribute> list = node.attributes();
		    //遍历属性节点
		    for(Attribute attribute : list){
		        System.out.println("属性"+attribute.getName() +":" + attribute.getValue());
		    }
		    //如果当前节点内容不为空，则输出
		    if(!(node.getTextTrim().equals(""))){
//		        System.out.println( node.getName() + "：" + node.getText());
		    }
		    //同时迭代当前节点下面的所有子节点
		    //使用递归
		    @SuppressWarnings("unchecked")
			Iterator<Element> iterator = node.elementIterator();
		    while(iterator.hasNext()){
		        Element e = iterator.next();
		        listNodes(e);
		    }
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
		    
		    */	 
  public static String replaceBlank(String str) {
		        String dest = "";
		        if (str!=null) {
		            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		            Matcher m = p.matcher(str);
		            dest = m.replaceAll("");
		        }
		        return dest;
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
			  System.out.println("0=============进入匹配字符串方法====================0");
		     while(m.find()) {	    	 
//		    	 System.out.println(m.group(1));
		    	 System.out.println("1===========匹配并获取字符串成功==================1");
		    	 context= m.group(1);
		     }
			 return context;
			 }
		 
		
		
		
public static void main(String[] args) {
			
//			Dom4j4Utils  domutils=new Dom4j4Utils();
//			String filepath="D:\\code\\XMLClient\\files\\";
//			String filename="CF004043";
//			String element="flowNo";
//			String value="12345688888";
//			Dom4j4Utils.setValue(filepath, filename);
//			Dom4j4Utils.setHeadValue(filepath, filename, element, value);
//			Dom4j4Utils.setDataValue(filepath, filename, "custName", value);、
//			Dom4j4Utils.listNodes();
		}
		
		
		
		
			
/*

public static void main(String[] args) { 
	
	  List<String> list = new ArrayList<String>();
		try{  //CC000033Resp.xml
			InputSource is = new InputSource("D:\\code\\XMLClient\\files\\CC000033Resp.xml");	
				SAXReader reader = new SAXReader(); 
				reader.setEncoding("utf-8"); 
				Document doc = reader.read(is); 
				@SuppressWarnings("unused")
				Dom4j4Utils j1 = new Dom4j4Utils(); 
				Element rootElt = doc.getRootElement(); // 获取根节点 
				System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称 
				@SuppressWarnings("rawtypes")
				Iterator Resp = rootElt.elementIterator("Resp");
		//		Iterator bbbb = rootElt.elementIterator("bbbb"); ///获取根节点下的子节点bbbb 
				// 遍历bbbb节点 
				while (Resp.hasNext()) { 
				Element recordEless = (Element) Resp.next(); 
				@SuppressWarnings("rawtypes")
				Iterator iBankSupChannelList = recordEless.elementIterator("iBankSupChannelList"); // 获取子节点bbbb下的子节点cccc 
				while (iBankSupChannelList.hasNext()) { 
				Element itemEle = (Element) iBankSupChannelList.next(); 
				@SuppressWarnings("rawtypes")
				Iterator row = itemEle.elementIterator("row");		 
				while(row.hasNext()){ 
				Element tableItem = (Element) row.next(); 
				String channelCode = tableItem.elementTextTrim("channelCode"); // 拿到dddd下的字节点username的值 
				String channelName= tableItem.elementTextTrim("channelName");
				list.add(channelCode);
				list.add(channelName);
				System.out.println("channelCode:" + channelCode);
				System.out.println("channelName:" + channelName);
				
		      } 
		// 遍历方式1:使用iterator 
	    Iterator<String> it = list.iterator(); 
	    while (it.hasNext()) { 
	      @SuppressWarnings("unused")
		String value = it.next(); 
//	      System.out.println("List输出结果："+value); 
	       }
	    for (int i = 0, size = list.size(); i < size; i++) { 
			   String value = list.get(i);
			   if(value.equals("招商银行")) {
			   System.out.println("List输出结果===：此处签约渠道是招商银行"+value+"================"); 
			   }else {
				   System.out.println("List输出结果===：此签约银行非招商银行！！！！"); 
			   }
			 } 
		  } 
		 } 
		}catch(Exception e){ 
		e.printStackTrace(); 
    } 
 }
 
 	*/
		
		
	
	
  } 

