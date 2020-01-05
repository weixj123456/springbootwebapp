package com.root.xmlutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

public class MyParseXMLDoc {
	public final static Logger	log	= Logger.getLogger(MyParseXMLDoc.class);

	static String xmlfile="";
	//static String xmlfile1="";
//	/**
	//循环解析节点
	@SuppressWarnings("unused")
	private void getAllNodes(String xml) {
        try {
            Document authtmp = DocumentHelper.parseText(xml);
            @SuppressWarnings("unchecked")
			List<Element> list = authtmp.selectNodes("//sms/node");
            for (int j = 0; j < list.size(); j++) {
                Element node = (Element) list.get(j);
                nodeByNodes(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
	private void nodeByNodes(Element node) {
        if (node.element("node") != null) {
            String id = node.attributeValue("id");
            String name = node.attributeValue("name");
            System.out.print(id + "-------");
            System.out.println(name);
            for (Iterator i = node.elementIterator("node"); i.hasNext();) {
                Element newNode = (Element) i.next();
                nodeByNodes(newNode);
            }
        } else {
            String id = node.attributeValue("id");
            String name = node.attributeValue("name");
            System.out.print(id + "-------");
            System.out.println(name);
        }
    }
//	**/
    
	public static String  readEle(Element e) {
		String value=null;
		if(e.hasMixedContent()) {
			//输出该节点的名字，对他的子节点继续进行判断
			System.out.println("节点名： "+e.getName());
			@SuppressWarnings("rawtypes")
			Iterator it=e.elementIterator();
			while(it.hasNext()) {
				Element arrName=(Element) it.next();
				readEle(arrName);
			}
		}else {
			//如果没有复合内容，就可以输出
			value=e.getTextTrim();
			System.out.println("节点名： "+e.getName()+",节点值： "+e.getTextTrim());
			
		}
		return value;
	}
	
    //渠道
	public static void updateXml3Value(String filepath,String filename,String nodeThreeName,String nodeFourName,String ifnodename,String equalsValue,String setNode,String setNodeValue) {
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
//		System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
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
		Iterator rows = itemEle.elementIterator(nodeFourName);		 
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
	
	     //渠道    
		public static void updateXmlfile3Value(String filepath,String filename,String nodeThreeName,String nodeFourName,String ifnodename,String equalsValue,String setNode,String setNodeValue) {
			String file=filepath+filename;
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
//			System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
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
			Iterator rows = itemEle.elementIterator(nodeFourName);		 
			while(rows.hasNext()){ 
			Element tableItem = (Element) rows.next(); 
			String username = tableItem.elementTextTrim(ifnodename); // 拿到dddd下的字节点username的值 
		    if(username.equals(equalsValue)) {
		    	tableItem.element(setNode).setText(setNodeValue);	    	
		    }
//			System.out.println("还款卡号已变更 :" + setNodeValue);
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
	
	    //核心使用
		public static void updateXml3HeXin(String filepath,String filename,String nodeThreeName,String nodeFourName,String ifnodename,String equalsValue,String setNode,String setNodeValue) {
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
//			System.out.println("根节点：" + root.getName()); // 拿到根节点的名称 
			@SuppressWarnings("rawtypes")
			Iterator reqdata = root.elementIterator("body"); ///获取根节点下的子节点bbbb 
			// 遍历bbbb节点 
			while (reqdata.hasNext()) { 
			Element recordEless = (Element) reqdata.next(); 
			@SuppressWarnings("rawtypes")
			Iterator nodeThreelist = recordEless.elementIterator(nodeThreeName); // 获取子节点bbbb下的子节点cccc 
			while (nodeThreelist.hasNext()) { 
			Element itemEle = (Element) nodeThreelist.next(); 
			@SuppressWarnings("rawtypes")
			Iterator rows = itemEle.elementIterator(nodeFourName);		 
			while(rows.hasNext()){ 
			Element tableItem = (Element) rows.next(); 
			String username = tableItem.elementTextTrim(ifnodename); // 拿到dddd下的字节点username的值 
		    if(username.equals(equalsValue)) {
		    	tableItem.element(setNode).setText(setNodeValue);	    	
		    }
//			System.out.println("还款卡号已变更 :" + setNodeValue);
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
		
	
	
     //最新方法，变更影像编号代码
	@SuppressWarnings({ "rawtypes", "unused" })
	public static int updateXMLimgdocCde(String Channelid,String filepath,String filename,String docCdes,int num) {
    	int flag=-1;
		String doccode=null;
		int number=DoDocNum.getCount(docCdes, ',');
		doccode=DoDocNum.getOnedocCde(docCdes, num);
    	try {
        XMLWriter writer = null;// 声明写XML的对象
        SAXReader reader = new SAXReader();       
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");// 设置XML文件的编码格式
        format.setNewLineAfterDeclaration(false);
        //拼装文件，涉及影像1016接口 
        xmlfile = filepath+filename+".xml";           
        File file = new File(xmlfile);        
            if (file.exists()) {
                Document document = reader.read(file);// 读取XML文件
                Element root = document.getRootElement();// 得到根节点
                boolean bl = false;
                for (Iterator i = root.elementIterator("reqdata"); i.hasNext();) {
                    Element reqdata = (Element) i.next();
                    reqdata.selectSingleNode("docCde").setText(doccode);
              writer = new XMLWriter(new FileWriter(xmlfile), format);
              writer.write(document);
              writer.close();
              bl = true;
              break;
            }
            if (bl) {
            }
        } else {       
        	xmlfile = "D:\\files\\student.xml";
        	File file1 = new File(xmlfile);
        	if (!file1.exists()) {
        		
        	}else {

        	}
        }
//        System.out.println("1操作结束! ");
    } catch (Exception e) {
        e.printStackTrace();
    }
    	
    	return 0;
}
	
	
    //变更影像编号   传入渠道编号   渠道上传影像件编号
 
	@SuppressWarnings({ "rawtypes", "unused" })
	public static int parseXMLimg(String Channelid,String filepath,String filename,String docCde,int num) {
    	int flag=-1;
    	String doccde=docCde;
		String doccode=null;
//		DoDocname ddc=new DoDocname();
		int number=DoDocNum.getCount(docCde, ',');
		if(number!=num) {
	    System.out.println("请重新输入数字，才能调用影像通知接口,输入数字不在上传影像个数范围内！！！");
     	log.info("=============MyParseXMLDoc.parseXMLimg=请重新输入数字，才能调用影像通知接口,输入数字不在上传影像个数范围内！！！==========");  
     	   return flag;
		}
		doccode=DoDocNum.getOnedocCde(docCde, num);
    	try {
        XMLWriter writer = null;// 声明写XML的对象
        SAXReader reader = new SAXReader();       
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");// 设置XML文件的编码格式
        //拼装文件，涉及影像1016接口 
        xmlfile = filepath+filename+".xml";           
        File file = new File(xmlfile);        
            if (file.exists()) {
                Document document = reader.read(file);// 读取XML文件
                Element root = document.getRootElement();// 得到根节点
                boolean bl = false;
                for (Iterator i = root.elementIterator("reqdata"); i.hasNext();) {
                    Element reqdata = (Element) i.next();
                    reqdata.selectSingleNode("docCde").setText(doccode);
              writer = new XMLWriter(new FileWriter(xmlfile), format);
              writer.write(document);
              writer.close();
              bl = true;
              break;
            }
            if (bl) {
            }
        } else {
            // 新建student.xml文件并新增内容
        	xmlfile = "D:\\files\\student.xml";
        	File file1 = new File(xmlfile);
        	if (!file1.exists()) {
        		
        	}else {

        	}
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    	
    	return 0;
}
	
    //操作头部数据
	@SuppressWarnings("rawtypes")
	public static void parseXMLhead(String filepath,String filename,String headname,String headdataValue) {

		try {
        XMLWriter writer = null;// 声明写XML的对象
        SAXReader reader = new SAXReader();       
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");// 设置XML文件的编码格式
        //拼装文件，涉及影像1016接口、风控字段存储调用4063接口、4043进件申请接口       
        xmlfile = filepath+filename+".xml";
        File file = new File(xmlfile);        
            if (file.exists()) {
                Document document = reader.read(file);// 读取XML文件
                Element root = document.getRootElement();// 得到根节点
                boolean bl = false;
                for (Iterator i = root.elementIterator("head"); i.hasNext();) {
                    Element head = (Element) i.next();
                    head.selectSingleNode(headname).setText(headdataValue);
              writer = new XMLWriter(new FileWriter(xmlfile), format);
              writer.write(document);
              writer.close();
              bl = true;
              break;
            }
            if (bl) {

            }
        } else {    
        	xmlfile = "D:\\files\\student.xml";
        	File file1 = new File(xmlfile);
        	if (!file1.exists()) {
        	}else {

        	}
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  	 	
	
	   //操作头部数据     最新方法
		@SuppressWarnings("rawtypes")
		public static void updateXMLhead(String filepath,String filename,String headDataName,String headDataValue) {

			try {
	        XMLWriter writer = null;// 声明写XML的对象
	        SAXReader reader = new SAXReader();       
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        format.setEncoding("UTF-8");// 设置XML文件的编码格式
	        format.setNewLineAfterDeclaration(false);
//	        format.setNewlines(false);
	        //拼装文件，涉及影像1016接口、风控字段存储调用4063接口、4043进件申请接口       
	        xmlfile = filepath+filename+".xml";
	        
	        File file = new File(xmlfile);
	            if (file.exists()) {
	                Document document = reader.read(file);// 读取XML文件
	                Element root = document.getRootElement();// 得到根节点
	                boolean bl = false;
	                for (Iterator i = root.elementIterator("head"); i.hasNext();) {
	                    Element head = (Element) i.next();
	                    head.selectSingleNode(headDataName).setText(headDataValue);
	              writer = new XMLWriter(new FileWriter(xmlfile), format);
	              writer.write(document);
	              writer.close();
	              Thread.sleep(200);

	              bl = true;
	              break;
	            }
	            if (bl) {

	            }
	        } else {    
	        	xmlfile = "D:\\files\\student.xml";
	        	File file1 = new File(xmlfile);
	        	if (!file1.exists()) {
	        	}else {

	        	}
	        }
//	        System.out.println("1操作结束! ");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	    //操作数据部分流水号变更、姓名变更、身份证变更、电话变更     最新方法
		@SuppressWarnings("rawtypes")
		public static void updateXMLdata(String filepath,String filename,String dataName,String requestdataValue) {
			try {
		        XMLWriter writer = null;// 声明写XML的对象
		        SAXReader reader = new SAXReader();       
		        OutputFormat format = OutputFormat.createPrettyPrint();
		        format.setEncoding("UTF-8");// 设置XML文件的编码格式
		        format.setNewLineAfterDeclaration(false);
//		        format.setNewlines(false);
		        //拼装文件，涉及影像1016接口、风控字段存储调用4063接口、4043进件申请接口	        
		        xmlfile = filepath+filename+".xml";	           
		        File file = new File(xmlfile);
		            if (file.exists()) {
		                Document document = reader.read(file);// 读取XML文件
		                Element root = document.getRootElement();// 得到根节点
		                boolean bl = false;
		                for (Iterator i = root.elementIterator("reqdata"); i.hasNext();) {
		                    Element reqdata = (Element) i.next();
		                    reqdata.selectSingleNode(dataName).setText(requestdataValue);
		              writer = new XMLWriter(new FileWriter(xmlfile), format);
		              writer.write(document);
		              writer.close();
		              Thread.sleep(200);
		              bl = true;
		              break;
		            }
		            if (bl) {
		            }		       
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	               
	//核心数据变更body
    //操作数据部分流水号变更、姓名变更、身份证变更、电话变更     最新方法
	@SuppressWarnings("rawtypes")
	public static void updateXMLBody(String filepath,String filename,String dataName,String requestdataValue) {
					try {
				        XMLWriter writer = null;// 声明写XML的对象
				        SAXReader reader = new SAXReader();       
				        OutputFormat format = OutputFormat.createPrettyPrint();
				        format.setEncoding("UTF-8");// 设置XML文件的编码格式
				        format.setNewLineAfterDeclaration(false);
//				        format.setNewlines(false);
				        //拼装文件，涉及影像1016接口、风控字段存储调用4063接口、4043进件申请接口	        
				        xmlfile = filepath+filename+".xml";	           
				        File file = new File(xmlfile);
				            if (file.exists()) {
				                Document document = reader.read(file);// 读取XML文件
				                Element root = document.getRootElement();// 得到根节点
				                boolean bl = false;
				                for (Iterator i = root.elementIterator("body"); i.hasNext();) {
				                    Element reqdata = (Element) i.next();
				                    reqdata.selectSingleNode(dataName).setText(requestdataValue);
				              writer = new XMLWriter(new FileWriter(xmlfile), format);
				              writer.write(document);
				              writer.close();
				              Thread.sleep(200);
				              bl = true;
				              break;
				            }
				            if (bl) {
				            }		       
				        }
				    } catch (Exception e) {
				        e.printStackTrace();
				    }
			}
		
		
	//操作数据部分流水号变更、姓名变更、身份证变更、电话变更
	@SuppressWarnings("rawtypes")
	public static void parseXMLdata(String filepath,String filename,String dataName,String requestdata) {
		try {
	        XMLWriter writer = null;// 声明写XML的对象
	        SAXReader reader = new SAXReader();       
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        format.setEncoding("UTF-8");// 设置XML文件的编码格式
	        //拼装文件，涉及影像1016接口、风控字段存储调用4063接口、4043进件申请接口	        
	        xmlfile = filepath+filename+".xml";	           
	        File file = new File(xmlfile);
	            if (file.exists()) {
	                Document document = reader.read(file);// 读取XML文件
	                Element root = document.getRootElement();// 得到根节点
	                boolean bl = false;
	                for (Iterator i = root.elementIterator("reqdata"); i.hasNext();) {
	                    Element reqdata = (Element) i.next();
	                    reqdata.selectSingleNode(dataName).setText(requestdata);
	              writer = new XMLWriter(new FileWriter(xmlfile), format);
	              writer.write(document);
	              writer.close();
	              bl = true;
	              break;
	            }
	            if (bl) {
	                // 添加一个学生信息
	               System.out.println("file.exists()已做判断");
	            }
	        } else {
	            // 新建student.xml文件并新增内容
	        	xmlfile = "D:\\files\\student.xml";
	        	File file1 = new File(xmlfile);
	        	if (!file1.exists()) {
	        	}else {

	        	}
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
     }
	
	
	//操作数据部分流水号变更、姓名变更、身份证变更、电话变更     最新方法
			@SuppressWarnings("rawtypes")
			public static void updateXMLListdata(String filepath,String filename,String dataName,String requestdataValue) {
				try {
			        XMLWriter writer = null;// 声明写XML的对象
			        SAXReader reader = new SAXReader();       
			        OutputFormat format = OutputFormat.createPrettyPrint();
			        format.setEncoding("UTF-8");// 设置XML文件的编码格式
			        //拼装文件，涉及影像1016接口、风控字段存储调用4063接口、4043进件申请接口	        
			        xmlfile = filepath+filename+".xml";	           
			        File file = new File(xmlfile);
			            if (file.exists()) {
			                Document document = reader.read(file);// 读取XML文件
			                Element root = document.getRootElement();// 得到根节点
			                Element node=root.element("reqdata").element("iApplAccInfoList");
			                Element node1=root.element("reqdata").element("signFlag");
			                System.out.println("======="+node1.getName()+"=================="+node1.getTextTrim());
			                Iterator nodelist=node.elementIterator();
			                System.out.println("获取文件成功！！！");
			                boolean bl = false;
			                for (Iterator i =nodelist ; i.hasNext();) {
			                	if("02".equals(root.element("reqdata").element("iApplAccInfoList").element("applAcKind").getTextTrim())) {		                         
			                	System.out.println("获取节点成功！！！");
			                	}
	//	                    reqdata.selectSingleNode(dataName).setText(requestdataValue);
			              writer = new XMLWriter(new FileWriter(xmlfile), format);
			              writer.write(document);
			              writer.close();
			              bl = true;
			              break;
			            }
			            if (bl) {
			            }		       
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
		}
	
	
	/*
	public static List<String> getDom4j4XmlNameValue(String channelid,String filename) {			
		   
		Channel channel1 = null;
		try {
			channel1 = ChannelService.getChannelByChannelid(channelid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 String filepath =channel1.getFilepath();

       List<String> list = new ArrayList<String>();
		try{
	    InputSource is = new InputSource(filepath+filename+".xml");	
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
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
		
		return list;
		
    }
	*/
    public static String getRespXMLValue(String file,String elementname) {
    	String value=null;
//    	String filepath="D:\\code\\XMLClient\\7121\\";
//		String filename="CF004043";
//		InputSource is = new InputSource(filepath+filename+".xml");	
    	InputSource is = new InputSource(file);
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(file);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//以下为读取文件方式
//		try {          
//			doc = reader.read(is);
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		Element root = doc.getRootElement(); // 获取根节点  thirdSeq
//		Element head=root.element("head").element(elementname);
		Element e=root.element(elementname);
		value=MyParseXMLDoc.readEle(e);		
		return value;
    }
    
    public static String getRespXMLHeXin(String file,String elementname) {
    	String value=null;
//    	String filepath="D:\\code\\XMLClient\\7121\\";
//		String filename="CF004043";
//		InputSource is = new InputSource(filepath+filename+".xml");	
    	InputSource is = new InputSource(file);
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(file);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			//以下为读取文件方式
			//		try {          
			//			doc = reader.read(is);
			//		} catch (DocumentException e) {
			//			// TODO Auto-generated catch block
			//			e.printStackTrace();
			//		} 
		Element root = doc.getRootElement(); // 获取根节点  thirdSeq
		Element head=root.element("head").element(elementname);
		value=MyParseXMLDoc.readEle(head);		
		return value;
    }
	
 
	public static String getRespXMLNode3Value(String str,String node) {
		//主动还款试算（CF202006）返回字符串处理
		String value=null;
		try {
			Document doc=DocumentHelper.parseText(str);
			Element root = doc.getRootElement(); // 获取根节点  thirdSeq
			Element Resp=root.element("Resp");
		    value=Resp.element(node).getTextTrim();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(value);
		return value;
		
	}
	
	
	public static String getHeXinXMLRespBody3(String str,String node) {
		//接收核心拍拍贷APP返回字符串处理
		String value=null;
		try {
			Document doc=DocumentHelper.parseText(str);
			Element root = doc.getRootElement(); // 获取根节点  thirdSeq
			Element body=root.element("body");
		    value=body.element(node).getTextTrim();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println(value);
		return value;
		
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
//    	 System.out.println(m.group(1));
    	 System.out.println("1===========匹配并获取字符串成功==================1");
    	 context= m.group(1);
     }
	 return context;
	 }
	
	
	public static void main(String[] args) {
		String value=null;
		String filepath="D:\\code\\XMLClient\\7121\\";
		String filename="CF004043";
		InputSource is = new InputSource(filepath+filename+".xml");	
		InputSource is1=new InputSource("D:\\code\\XMLClient\\doc\\1.xml");
		SAXReader reader = new SAXReader(); 
		reader.setEncoding("utf-8"); 
		Document doc = null;
		try {
//			doc = reader.read(is);
			doc = reader.read(is1);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		@SuppressWarnings("unused")
		Dom4j4Utils j1 = new Dom4j4Utils(); 
		Element root = doc.getRootElement(); // 获取根节点  thirdSeq
//		Element e=root.element("reqdata").element("iApplAccInfoList");
///		Element e=root.element("reqdata").element("thirdSeq");
		
		
		Element respE=root.element("ec");
		value=MyParseXMLDoc.readEle(respE);
		
		System.out.println(value);
//		MyParseXMLDoc.updateXMLListdata(filepath, filename, "applAcNo", "111");
		
	}
	
}
