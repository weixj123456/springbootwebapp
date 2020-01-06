<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<h2 class="myFrame" style="text-align: center;">获取BugFree用户</h2>
<form action="testuser/getuser" method="post">
id:<input type="text" id="txtUsername" name="id" placeholder="请输入id" value="10" /><br/>
<label>账号：</label>
<input type="text" id="txtUsername" name="username" placeholder="请输入账号" value="weixj" /><br/>
<label>密码：</label>
<input type="password" id="txtPassword" name="password" placeholder="请输入密码" value="123456" /><br/>
<input type="submit" value="提交" />
<input type="reset" value="重置" />
</form>

<form action="testuser/getRequire.do" method="post">
id:<input type="text" id="txtUsername" name="id" placeholder="请输入id" value="10" /><br/>
<label>账号：</label>
<input type="text" id="txtUsername" name="username" placeholder="请输入账号" value="weixj" /><br/>
<label>密码：</label>
<input type="password" id="txtPassword" name="password" placeholder="请输入密码" value="123456" /><br/>
<input type="submit" value="提交" />
<input type="reset" value="重置" />
</form>


   <h2 class="myFrame" style="text-align: center;"><a href="frame.jsp">项目管理-征信报文上传界面</a></h2>
</body>
</html>