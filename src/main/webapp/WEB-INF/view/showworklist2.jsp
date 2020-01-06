<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet"  type="text/css"  href="<%=basePath%>css/td.css"/>
    <title>工作量统计清单</title>
 <!-- 分页功能显示 -->  
 <!-- ============================== --> 
 <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript">      

</script>
</head>
  <body>
<h3><center>工作量统计表2</center></h3>
 <a href="<%=request.getContextPath() %>/worklist/addindex.do"><input type="button" value="添加"></a>
 
	<form action="<%=request.getContextPath()%>/worklist/query.do" method="post">
		数据查询：<br>
		需求编号：
		<!--  
		<input type="text" name="requireid" placeholder="需求编号"/> 
		-->
		<input type="text" name="requireid"  placeholder="需求编号" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
		&nbsp;&nbsp;&nbsp;
		需求名称：<input type="text" name="requirename" placeholder="需求名称"/>
		&nbsp;&nbsp;&nbsp;
		起始时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control0"  name="sitstarttime" id="sitstarttime" pattern="yyyy-MM-dd">
		&nbsp;&nbsp;&nbsp;
		截止时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control0"  name="sitendtime" id="sitendtime" pattern="yyyy-MM-dd"><br><br>
		<!--  UAT结束时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control1"  name="sitendtime"> -->
		<input type="submit" class="mybutton" value="查询"/>
		<input type="reset" class="mybutton111" value="重置"/> 
    </form>


数据列表：   <div class="total" style="text-align: right;display: true;">当前需求总工时: ${totalnum}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
   <form>
      <table style="width:100%;border:1px white solid">
    	<tr  bgcolor="#4F81BD" style="color: #fff;">
    		<td  style="text-align: center;display: none;">编号</td>
    		<td size='20'>需求编号</td>
    		<td size='3'>需求名称</td>
    		<!--  
    		<td>SIT开始时间</td>
    		<td>SIT结束时间</td>
    		<td>分配SIT测试人员</td>
    		<td>UAT开始时间</td>
    		-->
    		<td>渠道工作量</td>
    		<td>核心工作量</td>
    		<td>数仓工作量</td>
    		<td>外围组工作量</td>
    		<td>分配测试人员</td>
    		<td>工作量确认时间</td>
    		<td>SIT描述涉及系统</td>
    		<td>UAT备注</td>
    		<td style="text-align: center">工作量是否确认</td>
    		<td style="text-align: center">工作量总计</td>
    		<!--
    		<td>&nbsp;&nbsp;&nbsp;操作</td>
    		-->
    	</tr>
    	<c:forEach var="list"  items="${worklist}">
    	<tr bgcolor="${status.index%2==0?'#D0D8E8':'#E9EDF4'}">
    		<td style="text-align: center;display: none">${list.id}</td>
    		<td>${list.requireid}</td>
    		<td>${list.requirename}</td> 		 
    		<!-- 
    		<td><fmt:formatDate value="${list.sitendtime}" pattern="yyyy-MM-dd"/></td>   		 		
    		<td><fmt:formatDate value="${list.uatstarttime}" pattern="yyyy-MM-dd"/></td>   		
    		<td><fmt:formatDate value="${list.uatendtime}" pattern="yyyy-MM-dd"/></td>
    		<td>${list.uattoperson}</td>
    		-->
    		<td>${list.qudaowork}</td>
    		<td>${list.hexinwork}</td>
    		<td>${list.shucangwork}</td>
    		<td>${list.waiweiwork}</td>
    		<td>${list.sittoperson}</td>
    		<td><fmt:formatDate value="${list.sitstarttime}" pattern="yyyy-MM-dd"/></td>
    		<td>${list.sitdescription}</td>
    		<td>${list.uatdescription}</td>
    		<td>${list.beizhu=="0"? "已确认":"未确认"}</td>
    		<td>${list.totalwork}</td>
    	</tr>
    	</c:forEach> 
     </table>
   </form>
<br>
${message}
<br><br>
<h2 class="myFrame" style="text-align: center;"><a href="<%=request.getContextPath() %>/userlogon.jsp">返回登录界面</a></h2>
<script type="text/javascript">
//脚本方式
hidetd.style.display = 'none';
</script>  
</body>
</html>