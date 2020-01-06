<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<h1 class="myFrame0" style="text-align: center;">欢迎页面</h1>

	<h2 id="userlogon" class="myFrame1111" style="text-align: center;"><a href="userlogon.jsp">用户登录查询清单</a></h2>
	<h2 id="env" class="myFrame0" style="text-align: center;"><a href="env.jsp">测试环境地址</a></h2>
    <h2 id="frame" class="myFrame" style="text-align: center;"><a href="frame.jsp">项目管理-征信报文上传界面</a></h2>
    <h2 id="createindex" class="myFrame2" style="text-align: center;"><a href="createindex.jsp">银行卡身份证生成器</a></h2>
    <h2 id="configindex" class="myFrame3" style="text-align: center;"><a href="configindex.jsp">渠道信息配置中心</a></h2>
    <!--  
	<h2 id="examplePost3" class="myFrame12" style="text-align: center;"><a href="<%=request.getContextPath()%>/examplePost3.jsp">提交接收测试</a></h2>
	-->
	    <br>  ${message}1
</body>
</html>