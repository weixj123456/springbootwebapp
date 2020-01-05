package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.root.entity.Channel;
import com.root.service.ChannelService;


public class WriteXmlFile {
	
	String channelid;
    String reqTime;
    String cooprCde;
    String flowNo;
    String filepath;
    
    
	public static String  filenameCC000033="CC000033";
	public static String  filenameCC000034="CC000034";
	public static String  filenameCC000035="CC000035";

	String  userName;
//	String  reqTime;
	String  applAcNo;
//	String  flowNo;
	String  cstno;
	String  idCode;   //证件号码
	String  mobilePhone;  //银行预留手机号码
	String  channelCode;   //渠道编号    从0033接口返回里面取出后签约
    String  bankAccountNo;  //银行卡号
	String  bankCode;   //银行编码  //CMB  招商银行
	String channelType;
	public static String  header="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    
	
	public WriteXmlFile() {
		super();
	}
	/**
	 * 调用准入及申请贷后时初始化参数值使用
	 * @param channelid
	 * @param filepath
	 * @param reqTime
	 * @param cooprCde
	 * @param flowNo
	 */
	//调用准入查询接口使用
    public WriteXmlFile(String channelid,String filepath, String reqTime, String cooprCde, String flowNo) {
		super();
		this.channelid = channelid;
		this.reqTime = reqTime;
		this.cooprCde = cooprCde;
		this.flowNo = flowNo;
		this.filepath=filepath;
	}
    
    
    //签约接口使用 CC000033
    public WriteXmlFile(String userName,String reqTime,String applAcNo,String flowNo,String cstno,String idCode,String mobilePhone, String channelCode,String bankAccountNo,String bankCode,String channelType) {
		super();
		this.userName = userName;
		this.reqTime = reqTime;
		this.applAcNo = applAcNo;
		this.flowNo = flowNo;
		this.cstno = cstno;
		this.idCode = idCode;
		this.mobilePhone = mobilePhone;
		this.channelCode = channelCode;
		this.bankAccountNo = bankAccountNo;
		this.bankCode=bankCode;
		this.channelType=channelType;
	}
    
    

	public void writeXml4064(String filepath,String filename) {
    	   String xmlstr4064="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF004064</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>"+channelid+"</channel></head><reqdata><cooprCde>"+cooprCde+"</cooprCde></reqdata></root>";
    	   ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr4064);
    	   
       } 
	
	public void writeXml4064(String filepath,String filename,String channelcode) {
// 	   String xmlstr4064="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF004064</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>"+channelid+"</channel></head><reqdata><cooprCde>"+cooprCde+"</cooprCde></reqdata></root>";
 	   String xmlstr4064="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root><head><channel>"+channelid+"</channel><currentBusinessCode>CF004064</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><sign></sign><signFlag>Y</signFlag></head><reqdata><cooprCde>"+cooprCde+"</cooprCde></reqdata></root>";
 	   ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr4064);
 	   
    } 

    public void writeXml2026(String filepath,String filename) {
    	String xmlstr2026="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF002026</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>"+channelid+"</channel></head><reqdata><thirdSeq>"+flowNo+"</thirdSeq></reqdata></root>";
    	 ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr2026);
    }
    
    public void writeXml2016(String filepath,String filename) {
    	String xmlstr2026="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF002016</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>"+channelid+"</channel></head><reqdata><thirdSeq>"+flowNo+"</thirdSeq></reqdata></root>";
    	 ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr2026);
    }
	
    public void writeXml7281(String filepath,String filename,String batchNo,String thirdSeq) {
    	String xmlstr7281="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF007281</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>"+channelid+"</channel></head><reqdata><batchNo>"+batchNo+"</batchNo><batchPayNoticeList><rows><thirdSeq>"+thirdSeq+"</thirdSeq></rows></batchPayNoticeList></reqdata></root>";
    	 ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr7281);
    }
    
    public void writeXmlCF600001(String filepath,String filename,String batchNo,String loanNo) {
    	String xmlstr600001="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF600001</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>"+channelid+"</channel></head><reqdata><batchNo>"+batchNo+"</batchNo><batchDeductionList><rows><loanNo>"+loanNo+"</loanNo><DeductionStatus>0</DeductionStatus></rows></batchDeductionList></reqdata></root>";
    	 ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr600001);
    }
	
    
    //
    public void writeXml7282(String filepath,String filename,String batchNo) {  
    	String xmlstr7282="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><currentBusinessCode>CF002026</currentBusinessCode><flowNo>420117199101010200</flowNo><reqTime>20290615101010</reqTime><channel>7123</channel></head><reqdata><batchNo>"+batchNo+"</batchNo></reqdata></root>";
    	ParseResponseWithDom4j.writeXmlFile(filepath, filename, xmlstr7282);
    }
    
    
	public  void writeCC000033xml(String channelid) {
		String CC000033xmlStr=header+"<root><head><channel>7121</channel><currentBusinessCode>CC000033</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime></head><reqdata><count>3</count><applAcNo>"+applAcNo+"</applAcNo><bankCode>CMB</bankCode><channelType>2001</channelType><cstno>"+cstno+"</cstno><idCode>"+idCode+"</idCode></reqdata></root>";    
 
		Channel channel1 = null;
		try {
			channel1 = ChannelService.getChannelByChannelid(channelid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("调用数据库SQL异常");
			e.printStackTrace();
		}	 
		 String filepath =channel1.getFilepath();     //获取服务器文件路径 ，可在这个路径下创建你上传的文件，与工程XML文件名中保持一致/home/upload/thirdChannel/
		 ParseResponseWithDom4j.writeXmlFile(filepath, filenameCC000033, CC000033xmlStr);		
	}
	
	public  void writeCC000034xml(String channelid) {
	  String CC000034xmlStr=header +"<root><head><currentBusinessCode>CC000034</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>7121</channel></head><reqdata><userName>"+userName+"</userName><idCode>"+idCode+"</idCode><mobilePhone>"+mobilePhone+"</mobilePhone><channelCode>"+channelCode+"</channelCode><bankAccountNo>"+bankAccountNo+"</bankAccountNo><portReqType>2</portReqType><channelType>2001</channelType><bankCode>"+bankCode+"</bankCode></reqdata></root>";
       
//		String filepath="";
//		String filename="";	
		Channel channel1 = null;
		try {
			channel1 = ChannelService.getChannelByChannelid(channelid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("调用数据库SQL异常");
			e.printStackTrace();
		}	 
		String filepath =channel1.getFilepath(); 
		ParseResponseWithDom4j.writeXmlFile(filepath, filenameCC000034, CC000034xmlStr);		
	}
	
     
	public  void writeCC000035xml(String channelid) {
		  String CC000035xmlStr=header +"<root><head><currentBusinessCode>CF004043</currentBusinessCode><flowNo>"+flowNo+"</flowNo><reqTime>"+reqTime+"</reqTime><channel>7121</channel></head><reqdata><userName>"+userName+"</userName><idCode></idCode><mobilePhone>"+mobilePhone+"</mobilePhone><channelCode>"+channelCode+"</channelCode><bankCode>"+bankCode+"</bankCode><bankName></bankName><bankAccountNo></bankAccountNo><channelType>2001</channelType><portReqType>2</portReqType><veriCode>123456</veriCode><signTyp>0</signTyp><cstno>"+cstno+"</cstno></reqdata></root>";
	        
//			String filepath="";
//			String filename="";	
			Channel channel1 = null;
			try {
				channel1 = ChannelService.getChannelByChannelid(channelid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("调用数据库SQL异常");
				e.printStackTrace();
			}	 
			String filepath =channel1.getFilepath(); 
			ParseResponseWithDom4j.writeXmlFile(filepath, filenameCC000035, CC000035xmlStr);		
		}
	
	
	@Override
	public String toString() {
		return "WritXmlFile [channelid=" + channelid + ", reqTime=" + reqTime + ", cooprCde=" + cooprCde
				+ ", flowNo=" + flowNo + ", filepath=" + filepath + "]";
	}		
	
	
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
