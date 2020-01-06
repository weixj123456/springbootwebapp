<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>征信上传功能界面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />
</head>
<body>
 <!--  
	 <form action="test.do" method="post">
	        用户名：<input type="text" name="username"/><br/>
	        密码：<input type="password" name="password"/><br/>
	        确认密码：<input type="password" name="password"/><br/>
	        <input type="submit" value="注册"/>
	 </form>
 -->
   <h2 class="myFrame" style="text-align: center;">项目管理-征信报文上传界面</h2> 
   <h2 class="myFrame" style="text-align: center;">项目管理-征信报文上传界面</h2>
<div class="fileUpload" align="center">  
    <form action="gotoAction.do" enctype="multipart/form-data" method="post">
                   设置上传路径：<input type="text" name="savefilepath" placeholder="/home/app/upload" style="width: 500px" maxlength='200' />
        <table>
            <tr>
                <td>请选择文件：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td>开始上传</td>
                <td><input type="submit" value="上传"></td>
            </tr>
        </table>
    </form>
</div> 
   
<div class="MultifileUpload" align="center">
    <h1>上传多个附件</h1>
	<form method="post" action="doMultiUpload.do" enctype="multipart/form-data">
			<input type="file" name="file1"/>
			<br/>  <br/>
			<input type="file" name="file2"/> <br/>
			<button type="submit" >提交</button>
	</form>   
</div>
<div class="fileUpload0" align="center"> 
		<h1>上传附件</h1>
		<form method="post" action="doUploadfile.do" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<button type="submit" >提交</button>
		</form>
</div>
   
    <h1 class="myFrame" style="text-align: center;"><a href="login.jsp">返回主页</a></h1>
     
</body>
</html>