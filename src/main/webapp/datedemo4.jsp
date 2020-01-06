<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>日期控件My97DatePicker</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/body.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mark.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/console.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/console.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/weChatQRCode.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
body {
color: #030303;
}
</style>
</head>
<body>
	<center>
		<h1>使用My97DatePicker日期控件</h1>
		<a target="_blank" href="http://www.my97.net/demo/index.htm" style="background-color: #0000AA; border-color: #0000AA;">
		My97DatePicker日期控件官方演示和api文档
		</a>
		<br><br>
		<a target="_blank" href="http://www.my97.net/index.asp" style="background-color: #8E388E; border-color: #8E388E;">
		My97DatePicker日期控件官方网站
		</a>    
		<a target="_blank" href="http://www.my97.net/down.asp" style="background-color: #CD0000; border-color: #CD0000;">
		My97DatePicker日期控件官方下载
		</a>
		<br><br>
		<a target="_blank" href="https://blog.csdn.net/emoven/article/details/41869029" style="background-color: black; border-color: black;">
		使用My97DatePicker日期控件的参考网页1
		</a>    
		<a target="_blank" href="https://www.cnblogs.com/hanwenhua/articles/3307451.html" style="background-color: green; border-color: green;">
		使用My97DatePicker日期控件的参考网页2
		</a><br><br>
		<h3>以下是使用My97DatePicker日期控件的案例demo</h3>
		请假时间:<input class="Wdate" type="text" style="width: 188px; color: #0000AA;" onfocus="WdatePicker()">
		    
		缴费时间:<input class="Wdate" type="text" style="width: 240px; color: #4B0082;" onfocus="WdatePicker({lang:'zh-cn', dateFmt:'yyyy-MM-dd HH:mm:ss'})">
		<br><br>
		离职时间:<input class="Wdate" type="text" style="width: 350px; color: #CD0000;" onfocus="WdatePicker({lang:'zh-cn', dateFmt:'yyyy年MM月dd日 HH时:mm分:ss秒'})">
		    
		入职时间:<input class="Wdate" type="text" style="width: 350px; color: black;" onfocus="WdatePicker({readOnly:true, lang:'zh-cn', dateFmt:'yyyy年MM月dd日 HH时:mm分:ss秒'})">
		<br><br>
	</center>
</body>
</html>
