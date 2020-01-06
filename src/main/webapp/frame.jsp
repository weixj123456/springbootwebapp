<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<form action="user/login.do" method="post">
	<label>账号：</label>
	<input type="text" id="txtUsername" name="username" placeholder="请输入账号" value="weixj" /><br/>
	<label>密码：</label>
	<input type="password" id="txtPassword" name="password" placeholder="请输入密码" value="123456" /><br/>
	<input type="submit" value="提交" />
	<input type="reset" value="重置" />
</form>
<frameset rows="30%,*">
    <frame src="<c:url value='/top.jsp'/>" name="top"/>
    <frame src="<c:url value='/welcome.jsp'/>" name="main"/>
</frameset>
<h2 class="myFrame" style="text-align: center;"><a href="welcome.jsp">项目管理-征信报文上传界面</a></h2>
</body>
</html>