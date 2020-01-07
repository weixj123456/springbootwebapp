package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WriteXmlFile {
	
	
	//重写xml写入方法，添加写入路径
	/**
	 * 
	 * @param filepath   将要写入路径
	 * @param filename   将要写入文件名称
	 * @param xmlstr     写入字符串
	 */
	public static void writeXmlFile(String filepath,String filename,String xmlstr) {    	
		//此文件写在项目路径下的files目录下
//    	File f=new File("files/writerfile.xml");//新建一个文件对象，如果不存在则创建一个该文件
		File f=new File(filepath+filename+".xml");
		FileWriter fw;	
        try {
             fw=new FileWriter(f);
             fw.write(xmlstr);//将字符串写入到指定的路径下的文件中
             fw.flush();
             fw.close();
             System.out.println(filepath+filename+".xml文件已写入完成!!!");
            } catch (IOException e) { e.printStackTrace();  }	    	
	}
	
	public static void writeTxtFile(String filepath,String filename,String context) {    	
		//此文件写在项目路径下的files目录下
//    	File f=new File("files/writerfile.xml");//新建一个文件对象，如果不存在则创建一个该文件
		File f=new File(filepath+filename+".txt");
		FileWriter fw;	
        try {
             fw=new FileWriter(f);
             fw.write(context+System.getProperty("line.separator"));//将字符串写入到指定的路径下的文件中
             fw.flush();
             fw.close();
             System.out.println(filepath+filename+".xml文件已写入完成!!!");
            } catch (IOException e) { e.printStackTrace();  }	    	
	}	
	
	//重写xml写入方法，添加写入路径
	public static void writeXmlFile2(String filepath,String filename,String xmlstr) {
    	
		//此文件写在项目路径下的files目录下
//    	File f=new File("files/writerfile.xml");//新建一个文件对象，如果不存在则创建一个该文件
		File file=new File(filepath+filename+".xml");
		FileWriter fw;			
//		File file =new File("C:\\Users\\QPING\\Desktop\\JavaScript");    
			//如果文件夹不存在则创建    
			if  (!file .exists()  && !file .isDirectory())      
			{       
			    System.out.println("//不存在");  
			    file .mkdir();    
			} else   
			{  
			    System.out.println("//目录存在");  
			}  
			
        try {
             fw=new FileWriter(file);
             fw.write(xmlstr);//将字符串写入到指定的路径下的文件中
             fw.flush();
             fw.close();
             } catch (IOException e) { e.printStackTrace();  }	    	
	}
	
	@SuppressWarnings("resource")
	public static String readXmlStr(String filename) {
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
	
	
	public static void writeTxtFile2(String filepath,String filename,String context) {    	
		//此文件写在项目路径下的files目录下
//    	File f=new File("files/writerfile.xml");//新建一个文件对象，如果不存在则创建一个该文件
		File f=new File(filepath+filename+".txt");
		FileWriter fw;	
        try {
             fw=new FileWriter(f);
             fw.write(context+System.getProperty("line.separator"));//将字符串写入到指定的路径下的文件中
             fw.flush();
             fw.close();
             System.out.println(filepath+filename+".txt文件已写入完成!!!");
            } catch (IOException e) { e.printStackTrace();  }	    	
	}	
	
	
	public static void writeTxtFileAppend(String filepath,String filename,String context) {    	
		//此文件写在项目路径下的files目录下
//    	File f=new File("files/writerfile.xml");//新建一个文件对象，如果不存在则创建一个该文件
//		context+="\r\n";
		File f=new File(filepath+filename+".txt");
		FileWriter fw;	
        try {
             fw=new FileWriter(f,true);
             fw.write(context+System.getProperty("line.separator"));//将字符串写入到指定的路径下的文件中
             fw.flush();
             fw.close();
             System.out.println(filepath+filename+".txt文件已写入完成!!!");
            } catch (IOException e) { e.printStackTrace();  }	    	
	}	
	

	public static void writeXmlFileAppend(String filepath,String filename,String context) {    	
		//此文件写在项目路径下的files目录下
//    	File f=new File("files/writerfile.xml");//新建一个文件对象，如果不存在则创建一个该文件
//		context+="\r\n";
		File f=new File(filepath+filename+".xml");
		FileWriter fw;	
        try {
             fw=new FileWriter(f,true);
             fw.write(context+System.getProperty("line.separator"));//将字符串写入到指定的路径下的文件中
             fw.flush();
             fw.close();
             System.out.println(filepath+filename+".xml文件已写入完成!!!");
            } catch (IOException e) { e.printStackTrace();  }	    	
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

	  GetXml xml=new GetXml("E:\\git1\\WorkSpace-Oxygen\\ssm\\src\\com\\jsx\\utils\\CF004043.xml");
	  String string=xml.getXmlString("E:\\git1\\WorkSpace-Oxygen\\ssm\\src\\com\\jsx\\utils\\CF004043.xml");
	  String replacestr=GetXml.replaceBlank(string);   //获取XML文件并转换为字符串后需要去掉空格
	  System.out.println("========"+replacestr+"===============");
	  String teststr="123564<Test>000000000011111111111</Test>";
//	  System.out.println(string);
	 String string2=matcher(replacestr,"reqdata");
	 System.out.println(string2);
//	 System.out.println("string2:"+string2);
//      String strXml=null;
//      GetXml xml=new GetXml("CF004043.xml");
//      strXml=xml.XmlToString();
//      System.out.println(strXml);
//       return strXml;
	 
//      String strXml=null;
//      GetXml xml=new GetXml("CF004043.xml");
//      strXml=xml.XmlToString();
//      System.out.println(strXml);
//       return strXml;

}
 
}
