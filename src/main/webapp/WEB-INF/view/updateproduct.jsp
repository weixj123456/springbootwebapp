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
    <title>修改数据</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/product/update.do" method="post"> 
		<input type="text" name="id" value="${add.id}" style="display:none;"> <br><br>
    	需求编号:<input type="text" name="requireno" value="${add.requireno}"> <br><br>
    	需求类型: <input type="text" name="type" value="${add.type}"> <br><br>
    	需求名称:<input type="text" name="requirename" value="${add.requirename}"> <br><br>
    	是否测试完成:<input type="text" name="istest" value="${add.istest}"> <br><br>
    	业务部门:<input type="text" name="yewudep" value="${add.yewudep}"><br><br>
    	是否主牵部门:<input type="text" name="ismaster" value="${add.ismaster}"><br><br>
    	关联系统:<input type="text" name="relatesys" value="${add.relatesys}"><br><br>
    	业务及测试人员:<input type="text" name="yewuer" value="${add.yewuer}"><br><br>
    	需求分析人员:<input type="text" name="analyser" value="${add.analyser}"><br><br>
    	测试对接人:<input type="text" name="tester" value="${add.tester}"><br><br>
    	开发人员:<input type="text" name="developer" value="${add.developer}"><br><br>
    	是否完成投产签报:<input type="text" name="isproduct" value="${add.isproduct}"><br><br>
    	UAT开始时间:<br>
        <input type="date" class="form-control"  name="uatstarttime" value="<fmt:formatDate value="${add.uatstarttime}" pattern="yyyy-MM-dd" />" >       
        <br><br>
         UAT结束时间:<br><input type="date"  class="form-control"  name="uatendtime" value="<fmt:formatDate value="${add.uatendtime}" pattern="yyyy-MM-dd" />" >
    	<br><br>
    	预计投产时间:
    	<input type="date" name="producttime" value="<fmt:formatDate value="${add.producttime}" pattern="yyyy-MM-dd" />"><br><br>
    	是否变更投产时间:<input type="text" name="isupdate" value="${add.isupdate}"><br><br>
    	备注:&nbsp;&nbsp;<input type="text" name="description" value="${add.description}"><br><br>
 <br><br>
<!--  				<input type="hidden" name="id" value="${add.id }">  -->
   				 <input type="submit" value="提交数据">
      </form>
  </body>
</html>