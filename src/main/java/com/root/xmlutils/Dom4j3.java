package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

public class Dom4j3 {

	
	
	public static void parseXml3(String filepath,String filename,String nodeThreeName,String lastNodelistName,String ifnodename,String equalsValue,String setNode,String setNodeValue) {
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
		Element root= doc.getRootElement(); // 获取根节点 
		System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
		@SuppressWarnings("rawtypes")
		Iterator reqdata = root.elementIterator("reqdata"); ///获取根节点下的子节点bbbb 
		// 遍历bbbb节点 
		while (reqdata.hasNext()) { 
		Element recordEless = (Element) reqdata.next(); 
		@SuppressWarnings("rawtypes")
		Iterator nodeThreelist = recordEless.elementIterator(nodeThreeName); // 获取子节点bbbb下的子节点cccc 
		while (nodeThreelist.hasNext()) { 
		Element itemEle = (Element) nodeThreelist.next(); 
		@SuppressWarnings("rawtypes")
		Iterator rows = itemEle.elementIterator(lastNodelistName);		 
		while(rows.hasNext()){ 
		Element tableItem = (Element) rows.next(); 
		String username = tableItem.elementTextTrim(ifnodename); // 拿到dddd下的字节点username的值 
	    if(username.equals(equalsValue)) {
	    	tableItem.element(setNode).setText(setNodeValue);	    	
	    }
//		System.out.println("还款卡号已变更 :" + setNodeValue);
		} 
	}
   }
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public static void parseXml31(String filepath,String filename,String nodeThreeName,String lastNodelistName,String ifnodename,String equalsValue,String setNode,String setNodeValue) {
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
		Element root= doc.getRootElement(); // 获取根节点 
		System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
		@SuppressWarnings("rawtypes")
		Iterator reqdata = root.elementIterator("reqdata"); ///获取根节点下的子节点bbbb 
		// 遍历bbbb节点 
		while (reqdata.hasNext()) { 
		Element recordEless = (Element) reqdata.next(); 
		@SuppressWarnings("rawtypes")
		Iterator nodeThreelist = recordEless.elementIterator(nodeThreeName); // 获取子节点bbbb下的子节点cccc 
		while (nodeThreelist.hasNext()) { 
		Element itemEle = (Element) nodeThreelist.next(); 
		@SuppressWarnings("rawtypes")
		Iterator rows = itemEle.elementIterator(lastNodelistName);		 
		while(rows.hasNext()){ 
		Element tableItem = (Element) rows.next(); 
		String username = tableItem.elementTextTrim(ifnodename); // 拿到dddd下的字节点username的值 
	    if(username.equals(equalsValue)) {
	    	tableItem.element(setNode).setText(setNodeValue);	    	
	    }
//		System.out.println("还款卡号已变更 :" + setNodeValue);
		} 
	}
   }
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
	
	public static void main(String[] args) {
		String file="G:\\cmis\\WorkSpace-Oxygen\\ssm\\files\\CF004043.xml";
	//	InputSource is = new InputSource("G:\\cmis\\WorkSpace-Oxygen\\ssm\\files\\CF004043.xml");
		InputSource is = new InputSource(file);
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
		/*File f = new File("D:\\androidspace\\javanote\\src\\wzq\\j2se\\xml\\data4.xml"); 
		Document doc = reader.read(f); */ 
		Document doc = null;
		try {
			doc = reader.read(is);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Element rootElt = doc.getRootElement(); // 获取根节点 
		System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称 
		@SuppressWarnings("rawtypes")
		Iterator reqdata = rootElt.elementIterator("reqdata"); ///获取根节点下的子节点bbbb 
		// 遍历bbbb节点 
		while (reqdata.hasNext()) { 
		Element recordEless = (Element) reqdata.next(); 
		@SuppressWarnings("rawtypes")
		Iterator klist = recordEless.elementIterator("klist"); // 获取子节点bbbb下的子节点cccc 
		while (klist.hasNext()) { 
		Element itemEle = (Element) klist.next(); 
		@SuppressWarnings("rawtypes")
		Iterator rows = itemEle.elementIterator("rows");		 
		while(rows.hasNext()){ 
		Element tableItem = (Element) rows.next(); 
		String username = tableItem.elementTextTrim("key1"); // 拿到dddd下的字节点username的值 
	    if(username.equals("test2")) {
	    	tableItem.element("value").setText("已修改成功");
	    	
	    }
		System.out.println("username:" + username);
		} 
	}
   }
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(file),OutputFormat.createPrettyPrint());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.write(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
