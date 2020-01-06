<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>新增投产清单</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/product/add.do" method="post"> 
		<input type="text" name="id" style="display:none;"> <br><br>
    	需求编号:<input type="text" name="requireno"> <br><br>
    	需求类型: <input type="text" name="type"> <br><br>
    	需求名称:<input type="text" name="requirename"> <br><br>
    	是否测试完成:<input type="text" name="istest"> <br><br>
    	业务部门:<input type="text" name="yewudep"><br><br>
    	是否主牵部门:<input type="text" name="ismaster"><br><br>
    	关联系统:<input type="text" name="relatesys"><br><br>
    	业务及测试人员:<input type="text" name="yewuer"><br><br>
    	需求分析人员:<input type="text" name="analyser"><br><br>
    	测试对接人:<input type="text" name="tester"><br><br>
    	开发人员:<input type="text" name="developer"><br><br>
    	是否完成投产签报:<input type="text" name="isproduct"><br><br>
    	UAT开始时间:<br>
        <input type="date" class="form-control"  name="uatstarttime">       
        <br><br>
         UAT结束时间:<br><input type="date"  class="form-control"  name="uatendtime">
    	<br><br>
    	预计投产时间:
    	<input type="date" name="producttime"><br><br>
    	是否变更投产时间:<input type="text" name="isupdate" value="${add.isupdate}"><br><br>
    	备注:&nbsp;&nbsp;<input type="text" name="description" value="${add.description}"><br><br><br><br>
   	   <input type="submit" value="提交数据">
      </form>
  </body>
</html>