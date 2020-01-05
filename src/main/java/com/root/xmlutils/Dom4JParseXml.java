package com.root.xmlutils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
 
/**
 * Created by 一枝叶 on 2019/2/22.
 */
public class Dom4JParseXml {
    static Document document;
    final static String savePath="收藏.xml";
    public static void main(String[] args) {
 
 
        try {
            //解析器
            SAXReader saxReader=new SAXReader();
 
            //得到指定xml文件的dom对象
            document=saxReader.read(new File("收藏.xml"));
 
 
            delete();//删除节点
            update();//修改节点
            addInfo();  //增加节点
            showInfo(); //显示节点
 
        } catch (DocumentException e) {
            e.printStackTrace();
        }
 
 
 
 
    }
 
    //显示节点信息
    public static  void showInfo(){
 
        //获取XML的根节点
        Element root=document.getRootElement();
 
        //使用迭代器遍历所有根节点的子节点
        Iterator itBrand=root.elementIterator();
 
        while (itBrand.hasNext()){
 
            Element brand= (Element) itBrand.next();
 
            //输出标签的name属性
            System.out.println("品牌:"+brand.attributeValue("name"));
 
            //遍历Type标签
 
 
            //使用迭代器遍历
            for(Iterator itType=brand.elementIterator(); itType.hasNext();){
 
                Element type= (Element) itType.next();
 
                //输出标签的name属性
                System.out.println("\t型号:"+type.attributeValue("name"));
 
 
            }
 
 
        }
 
    }
 
    //添加节点信息
    public static  void addInfo(){
 
        Element root=document.getRootElement();//得到根节点
        Element el=root.addElement("Brand"); //创建Brand标签
        el.addAttribute("name","华为"); //给Brand标签设置属性
        Element typeEl=el.addElement("Type");//创建Type标签
        typeEl.addAttribute("name","荣耀METE20PRO");//给Type标签添加属性
        saveXML(savePath);
    }
 
 
 
    //修改
    public static void update(){
 
        //得到根节点
        Element root=document.getRootElement();
        int id=0;
 
        //遍历根节点的子节点(所有品牌)
        for(Iterator itBrand=root.elementIterator();itBrand.hasNext();){
 
            Element brand= (Element) itBrand.next();
            id++;
            brand.addAttribute("id",id+"");
            saveXML(savePath);
 
        }
    }
 
    //删除
    public static void delete(){
 
        //获取根节点
        Element root=document.getRootElement();
        int id=0;
        for(Iterator itBrand=root.elementIterator();itBrand.hasNext();){
            Element brand= (Element) itBrand.next();
            if(brand.attributeValue("name").equals("华为")){
                brand.getParent().remove(brand);
            }
        }
        saveXML(savePath);
    }
    //保存XML文件
    public static void saveXML(String path){
 
 
        try {
            OutputFormat format=OutputFormat.createCompactFormat(); //创建美化格式
            format.setEncoding("utf-8"); //指定XML编码
            XMLWriter writer;
            writer=new XMLWriter(new FileWriter(path),format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
