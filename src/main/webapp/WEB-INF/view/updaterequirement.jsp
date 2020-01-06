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
    <form action="<%=request.getContextPath()%>/requirement/update.do" method="post"> 
		<input type="text" name="id" value="${add.id}" style="display:none;"> <br><br>
    	需求编号:<input type="text" name="requireid" value="${add.requireid}"> <br><br>
    	需求提出部门: <input type="text" name="department" value="${add.department}"> <br><br>
    	需求协助部门:<input type="text" name="relatedepartment" value="${add.relatedepartment}"> <br><br>
    	需求名称:<input type="text" name="requirename" value="${add.requirename}"> <br><br>
    	需求当前进度:<input type="text" name="process" value="${add.process}"><br><br>
    	关联需求:<input type="text" name="relaterequire" value="${add.relaterequire}"><br><br>
    	变更记录:<input type="text" name="updaterecord" value="${add.updaterecord}"><br><br>
    	主牵系统:<input type="text" name="system" value="${add.system}"><br><br>
    	关联系统:<input type="text" name="relatesystem" value="${add.relatesystem}"><br><br>
    	业务需求人员:<input type="text" name="yewuman" value="${add.yewuman}"><br><br>
    	需求科技对接人:<input type="text" name="requiretechman" value="${add.requiretechman}"><br><br>
    	测试负责人:<input type="text" name="techtester" value="${add.techtester}"><br><br>
    	开发人员:<input type="text" name="developer" value="${add.developer}"><br><br>
    	UAT开始时间:<br>
    	<!-- <input type="date" name="uatdate" value="${add.uatdate}"><br><br>
    	 -->
        <input type="date" class="form-control"  name="uatdate" value="<fmt:formatDate value="${add.uatdate}" pattern="yyyy-MM-dd" />" >       
        <br><br>
 <!--   UAT结束时间: &nbsp <input type="DATE" name="uatendtime" value="${add.uatendtime}"><br><br>   
                       只读属性设置如下readonly
        UAT结束时间:<input type="date"  class="form-control" readonly name="uatendtime" value="<fmt:formatDate value="${add.uatendtime}" pattern="yyyy-MM-dd" />" >
        -->UAT结束时间:<br><input type="text"  class="form-control"  name="uatendtime" value="<fmt:formatDate value="${add.uatendtime}" pattern="yyyy-MM-dd" />" >  	
    <!--
        UAT结束时间:<br> 
    	<input type="date" name="uatendtime" value="${add.uatendtime}"><br><br>
    	-->
    	<br><br>
    	预计投产时间:
    	<!--  
    	<input type="date" name="productdate" value="${add.productdate}"><br><br>
    	-->
    	<input type="text" name="productdate" value="<fmt:formatDate value="${add.productdate}" pattern="yyyy-MM-dd" />"><br><br>
    	是否督办:<input type="text" name="issuperintendent" value="${add.issuperintendent}"><br><br>
    	优先级:&nbsp;&nbsp;<input type="text" name="property" value="${add.property}"><br><br>
    	备注:&nbsp;&nbsp;<input type="text" name="description" value="${add.description}"><br><br>
    	需求提出时间:
    	<!--
    	<input type="date" name="requirestartdate" value="${add.requirestartdate}"><br><br>  -->
    	<input type="text" class="form-control"  name="requirestartdate" value="<fmt:formatDate value="${add.requirestartdate}" pattern="yyyy-MM-dd" />" ><br><br>
    	需求确认时间:
    	<!--
    	<input type="date" name="requireconfirmdate" value="${add.requireconfirmdate}"><br><br>
    	-->
    	<input type="text" class="form-control"  name="requireconfirmdate" value="<fmt:formatDate value="${add.requireconfirmdate}" pattern="yyyy-MM-dd" />" ><br><br>
<!--  				<input type="hidden" name="id" value="${add.id }">  -->
   				 <input type="submit" value="提交数据">
      </form>
  </body>
</html>