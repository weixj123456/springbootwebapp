<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<h1 class="myFrame0" style="text-align: center;">欢迎页面</h1>
	<form action="user/login1" method="post">
		<label>账号：</label>
		<input type="text" id="txtUsername" name="username" placeholder="请输入账号" value="weixj" /><br/>
		<label>密码：</label>
		<input type="password" id="txtPassword" name="password" placeholder="请输入密码" value="123456" /><br/>
		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
	</form>
<h1 class="myFrame1" style="text-align: center;">查询测试用户页面</h1>
<form action="testuser/getonetestuser.do" method="post">
		<label>ID：</label>
		<input type="text" id="txtUsername" name="id" placeholder="请输入账号" value="1" /><br/>
		<label>密码：</label>
		<input type="password" id="txtPassword" name="password" placeholder="请输入密码" value="123456" /><br/>
		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
	</form>
	
	<h1 class="myFrame2" style="text-align: center;">查询所有用户界面</h1>
    <form action="testuser/getall.do" method="post">
		<label>ID：</label>
		<input type="text" id="txtUsername" name="id" placeholder="请输入账号" value="1" /><br/>
		<label>密码：</label>
		<input type="password" id="txtPassword" name="password" placeholder="请输入密码" value="123456" /><br/>
		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
	</form>
	<h2 class="myFrame3" style="text-align: center;"><a href="welcome.jsp">项目管理-需求列表查询</a></h2>
	<h2 class="myFrame4" style="text-align: center;"><a href="fileupload.jsp">项目管理-文件上传工具</a></h2>
	<h2 class="myFrame5" style="text-align: center;"><a href="welcome.jsp">需求计划列表</a></h2>
	<h2 class="myFrame5" style="text-align: center;"><a href="query.jsp">查询页面测试</a></h2>
	<h2 class="myFrame5" style="text-align: center;"><a href="datedemo.jsp">时间控件测试</a></h2>
	<h2 class="myFrame5" style="text-align: center;"><a href="datedemo2.jsp">时间控件测试2</a></h2>
	<h2 class="myFrame5" style="text-align: center;"><a href="datedemo3.jsp">时间控件测试3</a></h2>
	<h2 class="myFrame5" style="text-align: center;"><a href="datedemo4.jsp">时间控件测试4</a></h2>
</body>
</html>