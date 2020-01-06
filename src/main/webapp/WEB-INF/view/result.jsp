<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>结果页</title>
  </head>
  <body>
  
        <div style="margin-top:82px;text-align: center;">=====</div>
        
        <div style="margin-top:82px;text-align: center;">
  		<h1  >	  ${InfoMessage}  </h1>
  		</div> <br> 		
  		<div style="margin-top:82px;text-align: center;"> 		
    	<h1><a href="<%=basePath%>">返回首页</a></h1>
    	</div>
    	<br> ===============${flag}=====================
  </body>
</html>