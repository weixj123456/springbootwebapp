<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>SSM测试项目</title>
  </head>
  <body>
  			<h1>${loginUser}</h1>
  			<h2 class="myHeader" id="myHeader" onclick="getValue()" style="text-align: center;">本周投产清单</h2>	          	
	        <a href="add.jsp">新增数据</a>  <br />  <br />
<!--  		<a href="require/modify.do">变更投产需求</a>  <br />  <br />
	        <a href="require.jsp">本周投产清单</a>  <br />  <br /> -->
	                      查询本周投产清单ROOT2
	        <form action="<%=request.getContextPath() %>/require/getRequire.do" method="post">
    	            查询条件-投产日期: <input type="text" name="productdate1" value="20180303"><br>
    	            查询条件-投产日期: <input type="text" name="productdate2" value="20180304"><br>
    	            查询条件-投产日期: <input type="text" name="productdate3" value="20180305"><br>            		
   			 <input type="submit" value="查询投产清单">
            </form>	       	        
	<!--         	                      
	 <a href="require/getRequire.do">查询本周投产清单ROOT2</a>  <br />  <br />  
	-->
	<h2 class="myHeader" style="text-align: center;"><a href="require/addrequire.jsp">新增投产需求</a></h2>
	<h2 class="myHeader" style="text-align: center;"><a href="channel.jsp">项目管理-第三方平台测试</a></h2>
	<!--
    <h2 class="myHeader" style="text-align: center;"><a href="channel.jsp">项目管理-第三方平台测试</a></h2>
    -->
    <h2 class="myFrame" style="text-align: center;"><a href="frame.jsp">项目管理-征信报文上传界面</a></h2>
     <!--   
            <a href="channel.jsp">项目管理-第三方测试</a>  <br /> <br />
     -->
	        <a href="test.jsp">测试页面</a>   <br />  <br />   
	        
  </body>
</html>