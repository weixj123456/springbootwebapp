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
    		<td size='20'>需求编号</td>
    		<td size='3'>类型</td>
    		<td>需求称名</td>
    		<td>是否完成验证</td>
    		<td>提出及测试部门</td>
    		<td>涉及系统</td>
    		<td>业务验证人员</td>
    		<td>测试对接人</td>
    		<td>是否完成签报</td>
    		<td style="text-align: center">开发人员</td>
    		<td>是否变更投产时间</td>
    		<td>描述</td>
    		<td>&nbsp &nbsp &nbsp操作</td>
    	</tr>
    	<c:forEach var="list"  items="${addLists}">
    	<tr bgcolor="${status.index%2==0?'#D0D8E8':'#E9EDF4'}">
    		<td style="text-align: center;display: none">${list.id}</td>
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
    		<td >${list.descp}</td>
    		<td ><a href="require/modifyrequire.do?id=${list.id}">更新</a>    <a href="require/del.do?id=${list.id}">删除</a></td>
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