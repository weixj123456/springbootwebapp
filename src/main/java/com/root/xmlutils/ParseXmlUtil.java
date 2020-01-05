package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;  
import org.apache.log4j.Logger;  
import org.dom4j.Document;  
import org.dom4j.DocumentException;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.Namespace;  
import org.dom4j.QName;  
/** 
 * 解析xml的工具类 
 * 1、将多层级xml解析为Map 
 * 2、将多层级xml解析为Json 
 * 
 * @author lmb 
 * 
 */  
public class ParseXmlUtil {  
        
      public static Logger logger = Logger.getLogger(ParseXmlUtil.class);  
      public static void main(String[] args) {   
              // 获取一个xml文件   
              String textFromFile = MyXmlUtil.XmlToString();  
              //将xml解析为Map  
              @SuppressWarnings({ "rawtypes", "unused" })
			Map resultMap = xml2map(textFromFile);  
              //将xml解析为Json  
//              String resultJson = xml2Json(textFromFile);  
      }   
        
        
      /** 
       * 将xml格式响应报文解析为Json格式 
       * @param responseXmlTemp 
       * @return 
       */  
      public static String xml2Json(String responseXmlTemp) {  
            Document doc = null;  
            try {  
                  doc = DocumentHelper.parseText(responseXmlTemp);  
            } catch (DocumentException e) {  
                  logger.error("parse text error : " + e);  
            }  
            Element rootElement = doc.getRootElement();  
            Map<String,Object> mapXml = new HashMap<String,Object>();  
            element2Map(mapXml,rootElement);  
            String jsonXml = JSONObject.fromObject(mapXml).toString();  
            System.out.println("Json >>> " + jsonXml);  
            return jsonXml;  
      }  
      /** 
       * 将xml格式响应报文解析为Map格式 
       * @param responseXmlTemp 
       * @param thirdXmlServiceBean 
       * @return 
       * @throws DocumentException 
       */  
      public static Map<String, Object> xml2map(String responseXmlTemp) {  
            Document doc = null;  
            try {  
                  doc = DocumentHelper.parseText(responseXmlTemp);  
            } catch (DocumentException e) {  
                  logger.error("parse text error : " + e);  
            }  
            Element rootElement = doc.getRootElement();  
            Map<String,Object> mapXml = new HashMap<String,Object>();  
            element2Map(mapXml,rootElement);  
            System.out.println("Map >>> " + mapXml);  
            return mapXml;  
      }  
      /** 
       * 使用递归调用将多层级xml转为map 
       * @param map 
       * @param rootElement 
       */  
      @SuppressWarnings("rawtypes")
	public static void element2Map(Map<String, Object> map, Element rootElement) {  
              
            //获得当前节点的子节点  
            @SuppressWarnings("unchecked")
			List<Element> elements = rootElement.elements();  
            if (elements.size() == 0) {  
                  //没有子节点说明当前节点是叶子节点，直接取值  
                  map.put(rootElement.getName(),rootElement.getText());  
            }else if (elements.size() == 1) {  
                  //只有一个子节点说明不用考虑list的情况，继续递归  
                  Map<String,Object> tempMap = new HashMap<String,Object>();  
                  element2Map(tempMap,elements.get(0));  
                  map.put(rootElement.getName(),tempMap);  
            }else {  
                  //多个子节点的话就要考虑list的情况了，特别是当多个子节点有名称相同的字段时  
                  Map<String,Object> tempMap = new HashMap<String,Object>();  
                  for (Element element : elements) {  
                        tempMap.put(element.getName(),null);  
                  }  
                  Set<String> keySet = tempMap.keySet();  
                  for (String string : keySet) {  
                        Namespace namespace = elements.get(0).getNamespace();  
                        @SuppressWarnings("unchecked")
						List<Element> sameElements = rootElement.elements(new QName(string,namespace));  
                        //如果同名的数目大于1则表示要构建list  
                        if (sameElements.size() > 1) {  
                              List<Map> list = new ArrayList<Map>();  
                              for(Element element : sameElements){  
                                    Map<String,Object> sameTempMap = new HashMap<String,Object>();  
                                    element2Map(sameTempMap,element);  
                                    list.add(sameTempMap);  
                              }  
                              map.put(string,list);  
                        }else {  
                              //同名的数量不大于1直接递归  
                              Map<String,Object> sameTempMap = new HashMap<String,Object>();  
                              element2Map(sameTempMap,sameElements.get(0));  
                              map.put(string,sameTempMap);  
                        }  
                  }  
            }  
      }  
      
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
//	    	 System.out.println(m.group(1));
	    	 System.out.println("1===========匹配并获取字符串成功==================1");
	    	 context= m.group(1);
	     }
		 return context;
		 }
      
      
}  

