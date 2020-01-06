<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>征信上传功能界面</title>
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
    <form action="gotoAction.do" enctype="multipart/form-data" method="post">
                   设置上传路径：<input type="text" name="savefilepath" style="width: 500px" maxlength='200' />
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
    <h2 class="myFrame" style="text-align: center;"><a href="login.jsp">返回主页</a></h2>
    <h2 class="myFrame5" style="text-align: center;"><a href="requirePlan.jsp">需求计划列表</a></h2>
    <h2 class="myFrame" style="text-align: center;"><a href="require.jsp">跳转至需求列表</a></h2>
    <h2 class="myFrame" style="text-align: center;"><a href="gettestuser.jsp">跳转至BugFree页面</a></h2>
    
  <!--    
  
  -->     
</body>
</html>