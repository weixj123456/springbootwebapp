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
    <form action="<%=request.getContextPath()%>/worklist/update.do" method="post"> 
		<input type="text" name="id" value="${worklist.id}" style="display:none;"> <br><br>
    	需求编号:<input type="text" name="requireid" value="${worklist.requireid}"> <br><br>
    	需求名称:<input type="text" name="requirename" value="${worklist.requirename}"> <br><br>
    	渠道组工作量:
    	<input type="text" name="qudaowork" value="${worklist.qudaowork}"><br><br>
    	核心组工作量:
    	<input type="text" name="hexinwork" value="${worklist.hexinwork}"><br><br>
    	数据组工作量:
    	<input type="text" name="shucangwork" value="${worklist.shucangwork}"><br><br>
    	外围组工作量:
    	<input type="text" name="waiweiwork" value="${worklist.waiweiwork}"><br><br>
    	工作量登记时间:
    	<br>
        <input type="date" class="form-control"  name="sitstarttime" value="<fmt:formatDate value="${worklist.sitstarttime}" pattern="yyyy-MM-dd" />" >        
        <br><br>
    	分配测试人员:
    	<input type="text" name="sittoperson" value="${worklist.sittoperson}"><br><br>
    	<!--  UAT分配人员: 
    	<input type="text" style="display:none;" name="uattoperson">
    	-->
    	SIT描述涉及系统:
    	<input type="text" name="sitdescription" value="${worklist.sitdescription}"><br><br>
    	UAT描述:
    	<input type="text" name="uatdescription" value="${worklist.uatdescription}"><br><br>
    	工作量是否确认:&nbsp;&nbsp;<!-- <input type="text" name="beizhu" value="${worklist.beizhu}"> -->
    	<select name="beizhu" id="beizhu" >
   	      <!--  <option value="">--请选择--</option>-->
   	      <option value="${worklist.beizhu}">${worklist.beizhu=="0"?"已确认":"未确认"}</option>
   	      <option value="0">已确认</option>
   	      <option value="1">未确认</option>
   	    </select>
   	    <br><br><br><br>
    	<!-- 
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
         -->
        <!--  				
        <input type="hidden" name="id" value="${add.id }">  
        -->
   	    <input type="submit" value="提交数据">
      </form>
  </body>
</html>