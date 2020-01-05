package com.root.xmlutils;

public class DoDocNum {
	
	public static int getCount(String docCdes,char c) {
       // 出现次数
        int num = 0;
       //循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
        for (int i=0;i<docCdes.length();i++)
        {
            //获取每个字符，判断是否是字符a
            if (docCdes.charAt(i)==c) {
            //累加统计次数
                num++; 
            }
        }
        return num;
    }
	
	
	//getDocCdeS
	public static String getOnedocCde(String docnames,int num) {
		  String str="======请重新输入docCde=====";
		  String docArray[] = docnames.split(",");  
//			for(String str :docArray) {
//				System.out.println(str);
//			}	
		  if(num<0) {
			  return str;
		  }

			String docCde=docArray[num];
			return docCde;	
	  }
	
	    //getDocCdeS
		public static String[] getStrs(String docnames,String c) {
			  String str="======请重新输入docCde=====";
			  String docArray[] = docnames.split(c);  
//				for(String str :docArray) {
//					System.out.println(str);
//				}	
			 
				return docArray;	
		  }
	
	
	  public static String getOnedocCde1(String docnames,int num) {
		  String str="====请重新输入docCde====";
		  String docArray[] = docnames.split(",");
//			for(String str :docArray) {
//				System.out.println(str);
//			}
		  if(num<0) {
			  return str;
		  }
			String docCde=docArray[num];
			return docCde;	
	  }
	
	  
	  public static int getSubStrToInt(String id,int currentYear) {
		  String yearmmdd = null;
		  if(!(id.length()==18)) {
			  System.out.println("当前号码输入长度不为18位！！！");
		  }
		  yearmmdd=id.substring(6, 10);	
		  System.out.println("yearmmdd:"+yearmmdd);
		  int i=Integer.parseInt(yearmmdd);
		  int age=currentYear-i;
		  System.out.println("age:"+age);
		  return age;
	  }
	
	public static void main(String[] args) {
		String docname="DTY0004,DZY052,DZY053,DTY0011,DZY0054,";
		int num=DoDocNum.getCount(docname, ',');
		System.out.println(num);
		String docone=DoDocNum.getOnedocCde(docname,num-1);	
		System.out.println(docone);
//		String docArray[] = docname.split(",");
//		for(String str :docArray) {
//			System.out.println(str);
		
		
		String id="500227198908285217";
		DoDocNum.getSubStrToInt(id, 2019);
//		}
	}	
}
