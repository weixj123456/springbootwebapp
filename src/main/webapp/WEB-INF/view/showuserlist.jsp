<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    		<td size='20'>英文名称</td>
    		<td size='3'>密码</td>
    		<td>真实姓名</td>
    		<td>邮箱</td>
    		<td>旺旺</td>
    		<td>邮件标识</td>
    		<td>旺旺标识</td>
    		<td>创建时间</td>
    		<td>创建人</td>
    		<td>更新时间</td>
    		<td>更新人</td>
    		<td>是否删除</td>
    		<td>作者模式</td>
    		<td>创建版本</td>
    		<td>全拼</td>
    		<td style="text-align: center">简拼</td>
    		<td>&nbsp &nbsp &nbsp操作</td>
    	</tr>
    	<c:forEach var="list"  items="${testuserlist}">
    	<tr bgcolor="${status.index%2==0?'#D0D8E8':'#E9EDF4'}">
    		<td style="text-align: center;display: none">${list.id}</td>
    		<td>${list.username}</td>
    		<td>${list.password}</td>
    		<td>${list.realname}</td>
    		<td>${list.email}</td>
    		<td>${list.wangwang}</td>
    		<td>${list.emailFlag}</td>
    		<td>${list.wangwangFlag}</td>
    		<td>${list.createdAt}</td>
    		<td>${list.createdBy}</td>
    		<td>${list.updatedAt}</td>
    		<td>${list.updatedBy}</td>
    		<td>${list.isDropped}</td>
    		<td>${list.authmode}</td>
    		<td>${list.lockVersion}</td>
    		<td>${list.fullPinyin}</td>
    		<td>${list.firstPinyin}</td>  		
    		<td><a href="<%=request.getContextPath()%>/testuser/modify.do?id=${list.id}">更新</a>    <a href="<%=request.getContextPath()%>/testuser/del.do?id=${list.id}">删除</a></td>
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
<br><br>
		<script type="text/javascript">
		  //脚本方式
		  hidetd.style.display = 'none';
		</script>      
</body>
</html>