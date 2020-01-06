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
    <link rel="stylesheet"  type="text/css"  href="<%=basePath%>css/td.css"/>
    <title>周四上线需求</title>
    
    <script type="text/javascript">

    //脚本方式
    //hidetd.style.display = 'none';
     
     var num = 0;
    function show(){
    	
     var myTable= document.getElementById("myTable"); 
     num=num+1;
//     alert(num);
     if(num%2==0){    
     myTable.style.display="block";
     }else{
    	 myTable.style.display="none";
     }
     }

    function hidden(){
     var myTable1= document.getElementById("myTable"); 
     num=num+1;
     alert(num);
     
    
    }

    </script>
    
    
  </head>
  <body>
    <%
    response.setIntHeader("Refresh", 614800);   //30S自动刷新屏幕
    %> 
  	<h3><center>本周上线需求如下</center></h3>
 <!--     <table width="300px" border="1" cellpadding="0" cellspacing="0" align="center"> -->
   <table style="width:100%;border:1px white solid">
    	<tr  bgcolor="#4F81BD" style="color: #fff;">
    		<td  style="text-align: center;display: none;">编号</td>
    		<td size='20'>需求编号</td>
    		<td size='3'>需求提出部门</td>
    		<td>需求协助部门</td>
    		<td>需求名称</td>
    		<td>需求当前进度</td>
    		<td>关联需求</td>
    		<td>变更记录</td>
    		<td>主牵系统</td>
    		<td>关联系统</td>
    		<td style="text-align: center">业务需求人员</td>
    		<td>需求科技对接人</td>
    		<td>测试负责人</td>
    		<td>开发人员</td>
    		<td>UAT开始时间</td>
    		<td>UAT结束时间</td>
    		<td>预计投产时间</td>
    		<td>是否督办</td>
    		<td>优先级</td>
    		<td>备注</td>
    		<td>需求提出时间</td>
    		<td>需求确认时间</td>
    		<td>&nbsp;&nbsp;&nbsp;操作</td>
    	</tr>
    	<c:forEach var="list"  items="${listrm}">
    	<tr bgcolor="${status.index%2==0?'#D0D8E8':'#E9EDF4'}">
    		<td style="text-align: center;display: none">${list.id}</td>
    		<td>${list.requireid}</td>
    		<td>${list.department}</td>
    		<td>${list.relatedepartment}</td>
    		<td>${list.requirename}</td>
    		<td>${list.process}</td>
    		<td>${list.relaterequire}</td>
    		<td>${list.updaterecord}</td>
    		<td>${list.system}</td>
    		<td>${list.relatesystem}</td>
    		<td>${list.yewuman}</td>
    		<td>${list.requiretechman}</td>
    		<td>${list.techtester}</td>
    		<td>${list.developer}</td>
    		<td><fmt:formatDate value="${list.uatdate}" pattern="yyyy-MM-dd"/></td>   		
    		<td><fmt:formatDate value="${list.uatendtime}" pattern="yyyy-MM-dd"/></td>
    		<td><fmt:formatDate value="${list.productdate}" pattern="yyyy-MM-dd"/></td>
    		<td>${list.issuperintendent}</td>
    		<td>${list.property}</td>
    		<td>${list.description}</td>
    		<td><fmt:formatDate value="${list.requirestartdate}" pattern="yyyy-MM-dd"/></td>  		
    		<td><fmt:formatDate value="${list.requireconfirmdate}" pattern="yyyy-MM-dd"/></td>
    		<td><a href="<%=request.getContextPath()%>/requirement/modifyrequire.do?id=${list.id}">更新</a>    <a href="<%=request.getContextPath() %>/requirement/del.do?id=${list.id}">删除</a></td>
    	</tr>
    	</c:forEach> 
    </table>
    
<br><br>
  <table border=0 title="测试">
    <caption>表格格式测试</caption>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <tr>
        <td>张三</td>
        <td>22</td>
    </tr>
    <tr>
        <td><input type=text /></td>
        <td><input type=text /></td>
    </tr>
</table>   
    
    <%!
		private int current = 1;
		private synchronized int getCurrentCount()
		{
		return current++;
	}
  %>
    
  
   <input  type="button" name="button0" value="显示隐藏替换显示" onclick="show();">
<!--     
   <input  type="button" name="button1" value="隐藏" onclick="hidden();">
 -->  
  <table id="myTable" width="200" border="0" align="center" cellpadding="1" cellspacing="0">  
 <tr>
 <td height="60" align="center" class="hong12">显示table信息</td>
 </tr>
 </table>  
    
<table>
<tr>
   <td  id="hidetd">已经隐藏了哦</td>
   <!-- 
   <td style="display:none;" id="hidetd">已经隐藏了哦</td> 
   -->
</tr>
</table>
<br>
${message}
<br><br>
		<script type="text/javascript">
		  //脚本方式
		  hidetd.style.display = 'none';
		</script>      
</body>
</html>