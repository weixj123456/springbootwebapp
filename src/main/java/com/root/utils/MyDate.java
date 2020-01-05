package com.root.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.time.DateFormatUtils;


public class MyDate {
     	
	private  DateTimeFormatter formatter;
    private  Map<String, DateTimeFormatter> map;
    private static final int CAPACITY = 8;
    
      
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
 //   public static DateTimeFormatter FMT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.s");
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    // 2017-08-09 上午/下午
    public static final String YYYY_MM_DD_A = "yyyy-MM-dd a";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static SimpleDateFormat YYYY_MM = new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat YYYY = new SimpleDateFormat("yyyy");

// --------------------------------------------------------------------------------------------

	

    /**
     * 
     * @param month   月份   负数代表几个月前
     * @param day     日       负数代表几个月前的某一天
     * 备注示例如下
     * @return 
     */
	public static String getBeforeDate(int month,int day) {
		Date dNow = new Date(); //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		if(!(day==0)) {
		  //calendar.add(calendar.MONTH, -3); //设置为前3月
			calendar.add(calendar.MONTH, month); //设置为前3月
		}
		if(!(day==0)) {
			//calendar.add(calendar.DAY_OF_MONTH,-1);//前几个月的第几天
			calendar.add(calendar.DAY_OF_MONTH,-1);
		}		
		dBefore = calendar.getTime(); //得到前3月的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
		String defaultStartDate = sdf.format(dBefore); //格式化前3月的时间
		String defaultEndDate = sdf.format(dNow); //格式化当前时间
//		System.out.println("前3个月的时间是：" + defaultStartDate);
//		System.out.println("生成的时间是：" + defaultEndDate);
		return defaultStartDate;
	}

	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	private static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	public static String getNowDate1(){   
	    String temp_str="";   
	    Date dt = new Date();   
	    //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");   
	    temp_str=sdf.format(dt);   
	    return temp_str;   
	}
	
	public static String DateToStr(Date date) {
		  
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String str = format.format(date);
		   return str;
		} 
	
	public static Date strToDateTurn(String time) throws ParseException {
		  //字符串转换成时间
		    //time="2010-11-20 11:10:10";  	  
		    Date date=null;  
		    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    date=formatter.parse(time);
		    //System.out.println(date);
		    return date;
	  }
	
	public static String getCurrentDate(){
		  //取得当前系统时间，返回yyyy-MM-dd HH:mm:ss字符串
		    Date date=new Date();
		    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String time=formatter.format(date);
		    //System.out.println(time);
		    return time;
	  }
	
	public String getCurrentTime(){
		  //取得当前系统时间，返回 HH:mm:ss字符串
		    Date date=new Date();
		    SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
		    String time=formatter.format(date);
		    //System.out.println(time);
		    return time;
	  }
	
	public static String stringToDatestr(String time) throws ParseException{
		    //将20101125102503转换成2010-11-25 10:25:03输出
		   //  time="20101125102503";
		    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    SimpleDateFormat formatter2=new SimpleDateFormat("yyyyMMddHHmmss");
		    String time1=formatter1.format(formatter2.parse(time));
		    //System.out.println(time);
		    return time1;
	  }

	public static String getToday() {
		// TODO Auto-generated method stub
		Date date=new Date();
	    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=formatter.format(date);
	    //System.out.println(time);
	    return time;
	}
	
	// 获取当前时间戳1
	public static String getTimeStr() {
		long currentTime=new Date().getTime();
		String str=currentTime+"";
		return str;
	}
	
	// 获取当前时间戳2
	public static String getCurrentTimeMillis() {
		long l=System.currentTimeMillis();
		String str=l+"";
		return str;		
	}
	
	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTimer() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到当前日期和时间字符串 格式（yyyyMMddHHmmss）
	 */
	public static String getDateTimestr() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}
	
//=========================================
	
	/**
	  * 获取现在时间
	  *
	  * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	  */
	 public static Date getNowDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	 }
	 
	 /**
	  * 获取现在时间
	  *
	  * @return返回短时间格式 yyyy-MM-dd
	  */
	 public static Date getNowDateShort() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	 }
	 

	 /**
	  * 获取现在时间
	  *
	  * @return 返回短时间字符串格式yyyy-MM-dd
	  */
	 public static String getStringDateShort() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 获取时间 小时:分;秒 HH:mm:ss
	  *
	  * @return
	  */
	 public static String getTimeShort() {
	  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	  Date currentTime = new Date();
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	  *
	  * @param strDate
	  * @return
	  */
	 public static Date strToDateLong(String strDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	 }
	 
	 /**
	  * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	  *
	  * @param dateDate
	  * @return
	  */
	 public static String dateToStrLong(java.util.Date dateDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(dateDate);
	  return dateString;
	 }
	 
	 /**
	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
	  *
	  * @param dateDate
	  * @param k
	  * @return
	  */
	 public static String dateToStr(java.util.Date dateDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(dateDate);
	  return dateString;
	 }
	 
	 /**
	  * 将短时间格式字符串转换为时间 yyyy-MM-dd
	  *
	  * @param strDate
	  * @return
	  */
	 public static Date strToDate(String strDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	 }
	 
	 /**
	  * 得到现在时间
	  *
	  * @return
	  */
	 public static Date getNow() {
	  Date currentTime = new Date();
	  return currentTime;
	 }
	 
	 /**
	  * 提取一个月中的最后一天
	  *
	  * @param day
	  * @return
	  */
	 public static Date getLastDate(long day) {
	  Date date = new Date();
	  long date_3_hm = date.getTime() - 3600000 * 34 * day;
	  Date date_3_hm_date = new Date(date_3_hm);
	  return date_3_hm_date;
	 }
	 
	 /**
	  * 得到现在时间
	  *
	  * @return 字符串 yyyyMMdd HHmmss
	  */
	 public static String getStringToday() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 得到现在小时
	  */
	 public static String getHour() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  String hour;
	  hour = dateString.substring(11, 13);
	  return hour;
	 }

	 
	 /**
	  * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	  *
	  * @param sformat
	  *            yyyyMMddhhmmss
	  * @return
	  */
	 public static String getUserDate(String sformat) {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat(sformat);
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	  */
	 public static String getTwoHour(String st1, String st2) {
	  String[] kk = null;
	  String[] jj = null;
	  kk = st1.split(":");
	  jj = st2.split(":");
	  if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
	   return "0";
	  else {
	   double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
	   double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
	   if ((y - u) > 0)
	    return y - u + "";
	   else
	    return "0";
	  }
	 }
	 
	 /**
	  * 得到二个日期间的间隔天数
	  */
	 public static String getTwoDay(String sj1, String sj2) {
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  long day = 0;
	  try {
	   java.util.Date date = myFormatter.parse(sj1);
	   java.util.Date mydate = myFormatter.parse(sj2);
	   day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	  } catch (Exception e) {
	   return "";
	  }
	  return day + "";
	 }
	 
	 /**
	  * 时间前推或后推分钟,其中JJ表示分钟.
	  */
	 public static String getPreTime(String sj1, String jj) {
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String mydate1 = "";
	  try {
	   Date date1 = format.parse(sj1);
	   long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
	   date1.setTime(Time * 1000);
	   mydate1 = format.format(date1);
	  } catch (Exception e) {
	  }
	  return mydate1;
	 }
	 
	 /**
	  * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	  */
	 public static String getNextDay(String nowdate, String delay) {
	  try{
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  String mdate = "";
	  Date d = strToDate(nowdate);
	  long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
	  d.setTime(myTime * 1000);
	  mdate = format.format(d);
	  return mdate;
	  }catch(Exception e){
	   return "";
	  }
	 }
	 
	 /**
	  * 判断是否润年
	  *
	  * @param ddate
	  * @return
	  */
	 public static boolean isLeapYear(String ddate) {
	 
	  /**
	   * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
	   * 3.能被4整除同时能被100整除则不是闰年
	   */
	  Date d = strToDate(ddate);
	  GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
	  gc.setTime(d);
	  int year = gc.get(Calendar.YEAR);
	  if ((year % 400) == 0)
	   return true;
	  else if ((year % 4) == 0) {
	   if ((year % 100) == 0)
	    return false;
	   else
	    return true;
	  } else
	   return false;
	 }
	 
	 /**
	  * 返回美国时间格式 26 Apr 2006
	  *
	  * @param str
	  * @return
	  */
	 public static String getEDate(String str) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(str, pos);
	  String j = strtodate.toString();
	  String[] k = j.split(" ");
	  return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	 }
	 
	 /**
	  * 获取一个月的最后一天
	  *
	  * @param dat
	  * @return
	  */
	 public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
	  String str = dat.substring(0, 8);
	  String month = dat.substring(5, 7);
	  int mon = Integer.parseInt(month);
	  if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
	   str += "31";
	  } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
	   str += "30";
	  } else {
	   if (isLeapYear(dat)) {
	    str += "29";
	   } else {
	    str += "28";
	   }
	  }
	  return str;
	 }
	 
	 /**
	  * 判断二个时间是否在同一个周
	  *
	  * @param date1
	  * @param date2
	  * @return
	  */
	 public static boolean isSameWeekDates2(Date date1, Date date2) {
	  Calendar cal1 = Calendar.getInstance();
	  Calendar cal2 = Calendar.getInstance();
	  cal1.setTime(date1);
	  cal2.setTime(date2);
	  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
	  if (0 == subYear) {
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
	   // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  }
	  return false;
	 }
	 
	 /**
	  * 产生周序列,即得到当前时间所在的年度是第几周
	  *
	  * @return
	  */
	 public static String getSeqWeek() {
	  Calendar c = Calendar.getInstance(Locale.CHINA);
	  String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
	  if (week.length() == 1)
	   week = "0" + week;
	  String year = Integer.toString(c.get(Calendar.YEAR));
	  return year + week;
	 }


	 /**
	  * 两个时间之间的天数
	  *
	  * @param date1
	  * @param date2
	  * @return
	  */
	 public static long getDays2(String date1, String date2) {
	  if (date1 == null || date1.equals(""))
	   return 0;
	  if (date2 == null || date2.equals(""))
	   return 0;
	  // 转换为标准时间
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  java.util.Date date = null;
	  java.util.Date mydate = null;
	  try {
	   date = myFormatter.parse(date1);
	   mydate = myFormatter.parse(date2);
	  } catch (Exception e) {
	  }
	  long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	  return day;
	 }

	 
	 /**
	  * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	  *
	  * @param k
	  *            表示是取几位随机数，可以自己定
	  */
	 
	 public static String getNo(int k) {
	 
	  return getUserDate("yyyyMMddhhmmss") + getRandom(k);
	 }
	 

	 
	 public static String getRandom(int i) {
		  Random jjj = new Random();
		  // int suiJiShu = jjj.nextInt(9);
		  if (i == 0)
		   return "";
		  String jj = "";
		  for (int k = 0; k < i; k++) {
		   jj = jj + jjj.nextInt(9);
		  }
		  return jj;
		 }

	/**
	  *
	  * @param args
	  */
	 public static boolean RightDate(String date) {
	 
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	  ;
	  if (date == null)
	   return false;
	  if (date.length() > 10) {
	   sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	  } else {
	   sdf = new SimpleDateFormat("yyyy-MM-dd");
	  }
	  try {
	   sdf.parse(date);
	  } catch (ParseException pe) {
	   return false;
	  }
	  return true;
	 }
//=========================================
	 /** 
	     * 得到几天前的时间 
	     *  
	     * @param d 
	     * @param day 
	     * @return 
	     */  
	    public static Date getDateBefore(Date d, int day) {  
	        Calendar now = Calendar.getInstance();  
	        now.setTime(d);  
	        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
	        return now.getTime();  
	    }    
	    /** 
	     * 得到几天后的时间 
	     *  
	     * @param d 
	     * @param day 
	     * @return 
	     */  
	    public static Date getDateAfter(Date d, int day) {  
	        Calendar now = Calendar.getInstance();  
	        now.setTime(d);  
	        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
	        return now.getTime();  
	    }
//=========================================================
	   
	    public static String getWeekOfDate1(Date dt) {
	        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(dt);

	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0)
	            w = 0;

	        return weekDays[w];
	    } 
	    
	    
	    
	    
	    
	    /** 
	     * 根据日期获得星期 
	     * @param date 
	     * @return 
	     */ 
	public static String getWeekOfDate(Date date) { 
	  String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }; 
	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
	  Calendar calendar = Calendar.getInstance(); 
	  calendar.setTime(date); 
	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
	  return weekDaysCode[intWeek]; 
	} 

	/** 
	  * 判断两个日期是否在同一周 
	  * 
	  * @param date1 
	  * @param date2 
	  * @return 
	  */ 
	public static boolean isSameWeekDates(Date date1, Date date2) { 
	  Calendar cal1 = Calendar.getInstance(); 
	  Calendar cal2 = Calendar.getInstance(); 
	  cal1.setTime(date1); 
	  cal2.setTime(date2); 
	  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR); 
	  if (0 == subYear) { 
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2 
	     .get(Calendar.WEEK_OF_YEAR)) 
	    return true; 
	  } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) { 
	   // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周 
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2 
	     .get(Calendar.WEEK_OF_YEAR)) 
	    return true; 
	  } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) { 
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2 
	     .get(Calendar.WEEK_OF_YEAR)) 
	    return true; 
	  } 
	  return false; 
	}	    
	  
	 /**
	  * 根据一个日期，返回是星期几的字符串
	  *
	  * @param sdate
	  * @return
	 */ 	
	public static String getWeekStr(Date date) {
		  // 再转换为时间
		 // hour中存的就是星期几了，其范围 1~7
	  	  // 1=星期日 7=星期六，其他类推
	        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
	        dateFm.format(date);
	        System.out.println("TimeBean.getWeekStr(Date date)得到星期："+dateFm.format(date));
		    Calendar c = Calendar.getInstance();
		    c.setTime(date);
		  // int hour=c.get(Calendar.DAY_OF_WEEK);
		  // hour中存的就是星期几了，其范围 1~7
		  // 1=星期日 7=星期六，其他类推
//		  return new SimpleDateFormat("EEEE").format(c.getTime());
		    return dateFm.format(date);
		  
		 }

	//字符串转换为日期类型    String s = "20170525";
	@SuppressWarnings("unused")
	private static Date getDatefromStr(String str) {
//       String s = "2017-05-25";
     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
     Date date = null;
     try {
        // date = format.parse(s);
     	date = format.parse(str);
     } catch (ParseException e) {
         System.out.println(e.getMessage());
     }
     System.out.println("TimeBean.getDatefromStr(String str)方法转换后返回时间"+date);
     return date;
 }

	
	
//=========================================================	
	/**
	 * 将yyyy-MM-dd hh:mm:ss格式字符串转为util的Date
	 * @param strDate 要转换的字符串格式的日期
	 * @return date 转换好了的util的日期
	 */
	@SuppressWarnings("unused")
	private static Date fmtStrToDate(String strDate) {
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

	    try {
	        return sdf.parse(strDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return null;

	}

	/**
	 * 将数据库中的timestamp类型转为String
	 * @param date javax.sql.timestamp
	 * @return java.lang.string
	 */
	public static String fmtTimestampToStr(Timestamp date){
	    Date dateTime=new Date(date.getTime());
	    return fmtDatetoStr(dateTime);
	}
	
	
	
	    /**s
	     * 将Util.Date 转为yyyy-MM-dd:HH:mm:ss的格式字符串 如果HH改为hh则是为十二小时制。
	     * @param dateTime 要进行转化的Date对象
	     * @return string 转化好的字符串格式的日期。
	     */
	private static String fmtDatetoStr(Date dateTime) {
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
	    return sdf.format(dateTime);
	}
	
	
	
	/**
	 * 将字符串时间转化为mysql中datetime能够接收的格式
	 *
	 * @param str
	 * @return
	 */
	

	/**
	 * String(yyyy-mm-dd hh:mm:ss) 转化为 Datetime yyyy-mm-dd hh:mm:ss
	 *
	 * @param str
	 * @return
	 */
	public static Date convertStrToTime(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		if (StringUtils.isNotEmpty(str)) {
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}


//=========================================	
	
	/**
     * Formats a date-time object using this formatter. 
     * 
     * @param date       the temporal object to format, not null
     * @return  the formatted string, not null
     * @throws DateTimeException if an error occurs during formatting
     */
    public String format(TemporalAccessor temporal) {
        return formatter.format(temporal);
    }
    
    /**
     * Formats a date-time object using this formatter. 
     * 
     * @param date       the temporal object to format, not null
     * @return  the formatted string, not null
     * @throws DateTimeException if an error occurs during formatting
     */
    public String formatDate(Date date) {
        return formatter.format(date.toInstant());
    }
    
    /**
     * Formats a date-time object using this formatter. 
     * 
     * @param epochMilli         the temporal object to format, not null
     * @return  the formatted string, not null
     * @throws DateTimeException if an error occurs during formatting
     */
    public String formatTimestamp(long epochMilli) {
        return formatter.format(Instant.ofEpochMilli(epochMilli));
    }
    
    /**
     * Formats a date-time object using this formatter. 
     * 
     * @return  the formatted string, not null
     * @throws DateTimeException if an error occurs during formatting
     */
    public String formatNow() {
        return formatter.format(Instant.now());
    }
    

    // --------------------------------------------------------------------------------------------

    
    /**
     * Fully parses the text producing an object of the specified type.
     * 
     * @param date       the text to parse, not null
     * @param query      the query defining the type to parse to, not null
     * @return  the parsed date-time, not null
     * @throws DateTimeParseException if unable to parse the requested result
     */
    public <R> R parse(String date, TemporalQuery<R> query) {
        return formatter.parse(date, query);
    }
    
    /**
     * Fully parses the text producing an object of the specified type.
     * 
     * @param date       the text to parse, not null
     * @param query      the query defining the type to parse to, not null
     * @return  the parsed date-time, not null
     * @throws DateTimeException if unable to parse the requested result
     */
    public <R> Instant parseInstant(String date, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return ((LocalDateTime) temporal).atZone(ZoneId.systemDefault()).toInstant();
        }
        if (temporal instanceof LocalDate) {
            return ((LocalDate) temporal).atStartOfDay(ZoneId.systemDefault()).toInstant();
        }
        if (temporal instanceof LocalTime) {
            LocalDate epoch = LocalDate.of(1970, 1, 1); // or LocalDate.now() ???
            LocalDateTime datetime = LocalDateTime.of(epoch, (LocalTime) temporal);
            return datetime.atZone(ZoneId.systemDefault()).toInstant();
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate or LocalTime ");
    }
    
    /**
     * Fully parses the text producing an object of the specified type.
     * 
     * @param date       the text to parse, not null
     * @param query      the query defining the type to parse to, not null
     * @return  the parsed date-time, not null
     * @throws DateTimeException if unable to parse the requested result
     */
    public <R> Date parseDate(String date, TemporalQuery<R> query) {
        return Date.from(parseInstant(date, query));
    }
    
    /**
     * Fully parses the text producing an object of the specified type.
     * 
     * @param date       the text to parse, not null
     * @param query      the query defining the type to parse to, not null
     * @return  the parsed time-stamp
     * @throws DateTimeException if unable to parse the requested result
     */
    public <R> long parseTimestamp(String date, TemporalQuery<R> query) {
        return parseInstant(date, query).toEpochMilli();
    }
    

    // --------------------------------------------------------------------------------------------

    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of years added.
     * 
     * @param date      date of the String type
     * @param years     the years to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusYears(String date, long years, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusYears(years));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).plusYears(years));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of months added.
     * 
     * @param date      date of the String type
     * @param months    the months to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusMonths(String date, long months, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusMonths(months));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).plusMonths(months));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of weeks added.
     * 
     * @param date      date of the String type
     * @param weeks     the weeks to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusWeeks(String date, long weeks, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusWeeks(weeks));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).plusWeeks(weeks));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of days added.
     * 
     * @param date      date of the String type
     * @param days      the days to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusDays(String date, long days, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusDays(days));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).plusDays(days));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of hours added.
     * 
     * @param date      date of the String type
     * @param hours     the hours to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusHours(String date, long hours, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusHours(hours));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).plusHours(hours));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of minutes added.
     * 
     * @param date      date of the String type
     * @param minutes   the minutes to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusMinutes(String date, long minutes, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusMinutes(minutes));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).plusMinutes(minutes));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of seconds added.
     * 
     * @param date      date of the String type
     * @param seconds   the seconds to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusSeconds(String date, long seconds, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusSeconds(seconds));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).plusSeconds(seconds));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of milliseconds added.
     * 
     * @param date          date of the String type
     * @param milliseconds  the milliseconds to add, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String plusMilliseconds(String date, long milliseconds, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).plusNanos(milliseconds * 1000000L));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).plusNanos(milliseconds * 1000000L));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    

    // --------------------------------------------------------------------------------------------

    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of years subtracted.
     * 
     * @param date      date of the String type
     * @param years     the years to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusYears(String date, long years, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusYears(years));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).minusYears(years));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of months subtracted.
     * 
     * @param date      date of the String type
     * @param months    the months to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusMonths(String date, long months, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusMonths(months));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).minusMonths(months));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of weeks subtracted.
     * 
     * @param date      date of the String type
     * @param weeks     the weeks to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusWeeks(String date, long weeks, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusWeeks(weeks));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).minusWeeks(weeks));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of days subtracted.
     * 
     * @param date      date of the String type
     * @param days      the days to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusDays(String date, long days, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusDays(days));
        }
        if (temporal instanceof LocalDate) {
            return formatter.format(((LocalDate) temporal).minusDays(days));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalDate ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of hours subtracted.
     * 
     * @param date      date of the String type
     * @param hours     the hours to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusHours(String date, long hours, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusHours(hours));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).minusHours(hours));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of minutes subtracted.
     * 
     * @param date      date of the String type
     * @param minutes   the minutes to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusMinutes(String date, long minutes, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusMinutes(minutes));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).minusMinutes(minutes));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of seconds subtracted.
     * 
     * @param date      date of the String type
     * @param seconds   the seconds to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusSeconds(String date, long seconds, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusSeconds(seconds));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).minusSeconds(seconds));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    
    /**
     * Returns a copy of this <tt>date</tt> with the specified number of milliseconds subtracted.
     * 
     * @param date          date of the String type
     * @param milliseconds  the milliseconds to subtract, may be negative
     * @param query     the query defining the type to parse to, not null
     * @return  based on this date-time with the years subtracted, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public <R> String minusMilliseconds(String date, long milliseconds, TemporalQuery<R> query) {
        R temporal = parse(date, query);
        if (temporal instanceof LocalDateTime) {
            return formatter.format(((LocalDateTime) temporal).minusNanos(milliseconds * 1000000L));
        }
        if (temporal instanceof LocalTime) {
            return formatter.format(((LocalTime) temporal).minusNanos(milliseconds * 1000000L));
        }
        throw new DateTimeException(" Type parameter must be LocalDateTime or LocalTime ");
    }
    

    // --------------------------------------------------------------------------------------------

    
    /**
     * Change the format of the date display
     * 
     * @param date      date of the String type
     * @param pattern   the format of the date display
     * @param query     the query defining the type to parse to, not null
     * @return
     * @throws DateTimeException if unable to parse the requested result
     */
    public String transform(String date, String pattern, TemporalQuery<?> query) {
        synchronized (map) {
            if (map.containsKey(pattern)) {
                return map.get(pattern).format((TemporalAccessor) formatter.parse(date, query));
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.systemDefault());
            String result = dtf.format((TemporalAccessor) formatter.parse(date, query));
            if (pattern.length() == result.length()) {
                if (map.size() >= CAPACITY) {
                    map.keySet().stream().findFirst().ifPresent(map::remove);
                }
                map.putIfAbsent(pattern, dtf);
            }
            return result;
        }
    }
	
//========================================	
    
    /**
     * 得到转换后的日期格式
     */
    public static String getFormatTime0(Date time) {
        if (time == null) {
            return "";
        }
        return sdf.format(time);
    }

    //得到转换后的日期格式
    public static String getFormatPlanTime(Date time) {
        if (time == null) {
            return " ";
        }
        return sdf1.format(time);
    }

    //获取当天的起始时间
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    //获取昨天天的起始时间
    public static Date getLastDayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.DATE, -1);
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getLastDayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.DATE, -1);
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static boolean greaterEqualEvlent(String time) {
        try {
            Calendar todayStart = Calendar.getInstance();
            todayStart.set(Calendar.HOUR_OF_DAY, 11);
            todayStart.set(Calendar.MINUTE, 40);
            todayStart.set(Calendar.SECOND, 0);
            todayStart.set(Calendar.MILLISECOND, 0);
            Date time1 = sdf.parse(time);
            if (time1.getTime() < todayStart.getTime().getTime()) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * 转换不同类型的日期格式
     *
     * @param to
     * @param from
     * @param target
     * @return
     */
    public static String transferFormat(String target, String from, String to) {
        try {
            SimpleDateFormat fromFormat = new SimpleDateFormat(from);
            Date targetDate = fromFormat.parse(target);
            return new SimpleDateFormat(to).format(targetDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

  
    /**
     * 获取当前时间戳（秒）
     */
    public static long getCurrentTimeStampSecond() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取指定年份日历
     * @param year
     * @return
     */
    private static Calendar getCalendarFormYear(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }
    /**
     * 获取指定年指定周的开始日期
     * @param year
     * @param weekNo
     * @return
     */
    public static String getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String monthStr = null;
        String dayStr = null;
        StringBuilder monthBuilder = new StringBuilder();
        StringBuilder dayBuilder = new StringBuilder();
        if(month < 10){
            monthStr = monthBuilder.append("0").append(month).toString();
        } else {
            monthStr = monthBuilder.append(month).toString();
        }
        if(day < 10) {
            dayStr = dayBuilder.append("0").append(day).toString();
        } else {
            dayStr = dayBuilder.append(day).toString();
        }
        return cal.get(Calendar.YEAR) + "-" + monthStr + "-" + dayStr;

    }

    /**
     * 获取指定年指定周的结束日期
     * @param year
     * @param weekNo
     * @return
     */
    public static String getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String monthStr = null;
        String dayStr = null;
        StringBuilder monthBuilder = new StringBuilder();
        StringBuilder dayBuilder = new StringBuilder();
        if(month < 10){
            monthStr = monthBuilder.append("0").append(month).toString();
        } else {
            monthStr = monthBuilder.append(month).toString();
        }
        if(day < 10) {
            dayStr = dayBuilder.append("0").append(day).toString();
        } else {
            dayStr = dayBuilder.append(day).toString();
        }
        return cal.get(Calendar.YEAR) + "-" + monthStr + "-" +  dayStr;
    }


    //获取 某日是某年的第几周
    public static int getWeekByDay(String day) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(format.parse(day));
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

 
    public static long getNextDay(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return calendar.getTimeInMillis();
    }

    /**
     * 得到某一天是这一年的第几周
     * @param date
     * @return
     */
    public static int getWeek(String date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        return week;
    }

    
    public static Timestamp getTimestamp(Date date) {
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
//        System.out.println(timestamp); // 2017-09-24 23:33:20.655
        return timestamp;
    }

    public static Date getSqlDatetime1(String date) throws ParseException{
//    	Date date=new Date();                             
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String date1=temp.format(date);  
        Date date2=temp.parse(date1); 
		return date2;
    	
    }
    
    
//	String date = "2016-12-11 17:17:10";         // 时间字符串
    public static Timestamp getSqlDatetime(String datestr) throws ParseException{
                            
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
    	Date date = null;
    	try{
    	date = format.parse(datestr);
    	}catch(Exception e){
    	e.printStackTrace();
    	}
    	Timestamp timeStamp = new Timestamp(date.getTime());
    	return timeStamp;
    	
    }
    
    public String getFormatTime(Date inTime) {
        String value = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        value =dateFormat.format(inTime);
        return value;
    }
    
    
//========================================
	
	public static void main(String[] args) throws ParseException {
////		   System.out.println(getCurrentDate());
////		  System.out.println(MyDate.stringToDatestr(" "));
//		  System.out.println(MyDate.getNowDate());
//		  System.currentTimeMillis();     //1532868979731  获取当前时间戳
//		  System.out.println(System.currentTimeMillis());
//		  System.out.println(MyDate.getDateTimestr());
//      二、Date转换为Datetime
		Date date = new Date();  
        long longTime = date.getTime();
        Timestamp timestamp = new Timestamp(longTime);
        System.out.println(timestamp); // 2017-09-24 23:33:20.655
        
        java.util.Date date1 = new java.util.Date();          // 获取一个Date对象
        Timestamp timeStamp = new Timestamp(date1.getTime()); 
        System.out.println(timeStamp+"===========1"); // 2017-09-24 23:33:20.655
//
	}

}
