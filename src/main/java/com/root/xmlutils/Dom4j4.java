package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document; 
import org.dom4j.Element; 
import org.dom4j.io.SAXReader; 
import org.xml.sax.InputSource; 


public class Dom4j4 { 
	
	
	public String getXmlString(String filename) {
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
   */
 
 public static String matcher(String xml,String label) {
	 String context = "";		 
	 //正则表达式
	 String rgex = "<"+label+">(.*?)</"+label+">";
     Pattern pattern = Pattern.compile(rgex);// 匹配的模式    
	  Matcher m = pattern.matcher(xml);
	  System.out.println("0=============================0");
     while(m.find()) {	    	 
//    	 System.out.println(m.group(1));
    	 System.out.println("1===========匹配并获取字符串成功==================1");
    	 context= m.group(1);
     }
	 return context;
	 }
	
	
	
public static void main(String[] args) { 
	
//	     Dom4j4.listTest();
	
	     List<String> list = new ArrayList<String>();
		try{ 
		InputSource is = new InputSource("D:\\code\\XMLClient\\files\\data4.xml"); 
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
		/*File f = new File("D:\\androidspace\\javanote\\src\\wzq\\j2se\\xml\\data4.xml"); 
		Document doc = reader.read(f); */ 
		Document doc = reader.read(is); 
		@SuppressWarnings("unused")
		Dom4j4 j1 = new Dom4j4(); 
		Element rootElt = doc.getRootElement(); // 获取根节点 
		System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称 
		@SuppressWarnings("rawtypes")
		Iterator bbbb = rootElt.elementIterator("bbbb"); ///获取根节点下的子节点bbbb 
		// 遍历bbbb节点 
		while (bbbb.hasNext()) { 
		Element recordEless = (Element) bbbb.next(); 
		@SuppressWarnings("rawtypes")
		Iterator cccc = recordEless.elementIterator("cccc"); // 获取子节点bbbb下的子节点cccc 
		while (cccc.hasNext()) { 
		Element itemEle = (Element) cccc.next(); 
		@SuppressWarnings("rawtypes")
		Iterator dddd = itemEle.elementIterator("dddd");		 
		while(dddd.hasNext()){ 
		Element tableItem = (Element) dddd.next(); 
		String username = tableItem.elementTextTrim("username"); // 拿到dddd下的字节点username的值 
		list.add(username);
		System.out.println("username:" + username);
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
  } 

