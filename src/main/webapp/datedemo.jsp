<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传Excel文件到数据库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  <body>
   <form method="post" action="importExcel" enctype="multipart/form-data">
                   选择文件：<input type="file" name="excelfilename"/></br>
                  请选择年份：<input type="text" name="qwe" id="qwe" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></br>
       <input type="submit" value="数据入库">
   
   </form>
  </body>
</html>