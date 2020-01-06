<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet"  type="text/css"  href="<%=basePath%>css/td.css"/>
    <title>周四上线需求</title>
  </head>
  <body>
  	<h3><center>上线需求如下</center></h3>
    <table width="300px" border="1" cellpadding="0" cellspacing="0" align="center">
    	<tr>
    		<td>编号</td>
    		<td>需求编号</td>
    		<td>类型</td>
    		<td>需求称名</td>
    		<td>是否完成验证</td>
    		<td>提出及测试部门</td>
    		<td>涉及系统</td>
    		<td>业务验证人员</td>
    		<td>测试对接人</td>
    		<td>是否完成签报</td>
    		<td>开发人员</td>
    		<td>是否变更投产时间</td>
    		<td>描述</td>
    	</tr>
    	<c:forEach var="list"  items="${addLists}">
    	<tr>
    		<td>${list.id}</td>
    		<td>${list.reqid}</td>
    		<td>${list.type}</td>
    		<td>${list.reqname}</td>
    		<td>${list.istest}</td>
    		<td>${list.reqpartment}</td>
    		<td>${list.relatesys}</td>
    		<td>${list.yewuer}</td>
    		<td>${list.tester}</td>
    		<td>${list.isproduct}</td>
    		<td>${list.developer}</td>
    		<td>${list.isupdate}</td>
    		<td>${list.descp}</td>
            <td><a href="modify.do?id=${list.id}">更新</a>    <a href="del.do?id=${list.id}">删除</a></td>
    	</tr>
    	</c:forEach> 
    </table>
  </body>
</html>