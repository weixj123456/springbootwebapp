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
    <title>周四上线需求</title>
 <!-- 分页功能显示 -->  
 <!-- ============================== --> 
 <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
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

    
     function select(){	   
    	alert("111111");                                                                     
    	form.action="/product/query.do";                                                                         
    	form.submit();  
    	}
    
    $(function(){
        $("#button1").click(function(){
         	$("#div1") .text("1111")    
        })
        $("#button2").click(function(){
         	$("#div1") .text("2222")    
        })
        $("#button3").click(function(){
        	form.action="/product/query.do";                                                                         
        	form.submit();   
        })
    })
</script>
</head>
  <body>
    <%
    response.setIntHeader("Refresh", 614800);   //30S自动刷新屏幕
    %> 
<h3><center>本周上线需求如下</center></h3>
 <!--     <table width="300px" border="1" cellpadding="0" cellspacing="0" align="center"> -->
 <a href="<%=request.getContextPath() %>/product/addindex.do"><input type="button" value="添加"></a>
 
<form action="<%=request.getContextPath()%>/product/query.do" method="post">
数据查询：
需求编号：<input type="text" name="requireno" placeholder="编号"/>&nbsp;&nbsp;
需求名称：<input type="text" name="requirename" placeholder="需求名称"/>&nbsp;&nbsp;
UAT开始时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control"  name="uatstarttime">&nbsp;&nbsp;
UAT结束时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control"  name="uatendtime">&nbsp;&nbsp;
<input type="submit" class="mybutton" value="查询"/> 
</form>
数据列表： <a href="<%=request.getContextPath() %>/product/addindex.do"><input type="button" value="添加"></a>
<br>
<form>
<table style="width:100%;border:1px white solid">
    	<tr  bgcolor="#4F81BD" style="color: #fff;">
    		<td  style="text-align: center;display: none;">编号</td>
    		<td size='20'>需求编号</td>
    		<td size='3'>需求类型</td>
    		<td>需求名称</td>
    		<td>是否完成测试</td>
    		<td>业务部门</td>
    		<td>是否主牵部门</td>
    		<td>关联系统</td>
    		<td>业务及测试人员</td>
    		<td>需求分析人员</td>
    		<td>测试对接人</td>
    		<td style="text-align: center">开发人员</td>
    		<td>是否完成投产签报</td>
    		<td>UAT开始时间</td>
    		<td>UAT结束时间</td>
    		<td>预计投产时间</td>
    		<td>是否变更投产时间</td>
    		<td>备注</td>
    		<!--
    		<td>&nbsp;&nbsp;&nbsp;操作</td>
    		-->
    	</tr>
    	<c:forEach var="list"  items="${listrm}">
    	<tr bgcolor="${status.index%2==0?'#D0D8E8':'#E9EDF4'}">
    		<td style="text-align: center;display: none">${list.id}</td>
    		<td>${list.requireno}</td>
    		<td>${list.type=="1"?"业务需求":"外部缺陷"}</td>
    		<td>${list.requirename}</td>
    		<td>${list.istest=="1"?"否":"是"}</td>
    		<td>${list.yewudep}</td>
    		<td>${list.ismaster=="1"?"是":"否"}</td>
    		<td>${list.relatesys}</td>
    		<td>${list.yewuer}</td>
    		<td>${list.analyser}</td>
    		<td>${list.tester}</td>
    		<td>${list.developer}</td>
    		<td>${list.isproduct=="1"?"否":"是"}</td>
    		<td><fmt:formatDate value="${list.uatstarttime}" pattern="yyyy-MM-dd"/></td>   		
    		<td><fmt:formatDate value="${list.uatendtime}" pattern="yyyy-MM-dd"/></td>
    		<td><fmt:formatDate value="${list.producttime}" pattern="yyyy-MM-dd"/></td>
    		<td>${list.isupdate}</td>
    		<td>${list.description}</td>
    		<!--  
  		     <td><a href="<%=request.getContextPath() %>/product/modifyrequirement.do?id=${list.id}">更新</a>    <a href="<%=request.getContextPath() %>/product/del.do?id=${list.id}">删除</a></td>
    	     -->
    	</tr>
    	</c:forEach> 
</table>
</form>
 
 
 <h2 class="myFrame" style="text-align: center;"><a href="<%=request.getContextPath() %>/userlogon.jsp">返回登录界面</a></h2>
 
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
		
	 <div  class="row">
      	 	<div class="col-md-6 col-sm-3">
      	 	   <!-- 功能列表 -->
      	 	   <button id="button1" type="button" class="btn btn-primary">功能一</button>     
      	 	   <button id="button2" type="button" class="btn btn-primary">功能二</button>  	 	  
      	 	   <button id="button3" type="button" class="btn btn-primary">功能三</button>  	 	       	 	
      	 	</div>
      	 	<div class="col-md-6 col-sm-3" id="div1">
      	     	
      	 	</div>
      	 </div>
	
		    
</body>
</html>