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
    <title>渠道配置</title>
 <!-- 分页功能显示 -->  
 <!-- ============================== --> 
 <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript">      

</script>
</head>
  <body>
<h3><center>渠道配置</center></h3>
 <a href="<%=request.getContextPath() %>/configinfo/addindex.do"><input type="button" value="添加"></a>
 
	<form action="<%=request.getContextPath()%>/configinfo/selectone.do" method="post">
		数据查询：<br>
		渠道编号：
		<input type="text" name="channelid"  placeholder="渠道编号" maxlength="11" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
		&nbsp;&nbsp;&nbsp;
		渠道名称：<input type="text" name="descinfo" placeholder="渠道名称"/>&nbsp;&nbsp;&nbsp;
		起始时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control0"  name="sitstarttime" id="sitstarttime" pattern="yyyy-MM-dd">&nbsp;&nbsp;&nbsp;
		截止时间:&nbsp;&nbsp;&nbsp;<input type="date" class="form-control0"  name="sitendtime" id="sitendtime" pattern="yyyy-MM-dd"><br><br>
		<input type="submit" class="mybutton" value="查询"/>
		<input type="reset" class="mybutton111" value="重置"/> 
	</form>
数据列表：   <div class="total" style="text-align: right;display: none;"> 0 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
   <form>
   	 <table style="width:100%;border:1px white solid">
    	<tr  bgcolor="#4F81BD" style="color: #fff;">
    		<td  style="text-align: center;display: none;">编号</td>
    		<td size='20'>渠道编号</td>
    		<td size='3'>渠道名称</td>  
    		<td>UAT请求url</td>
    		<td>CMIS请求url</td>
    		<td>SIT请求url</td>
    		<td>报文存放路径</td>
    		<td>测试公钥</td>
    		<td>测试私钥</td>
    		<td>老渠道url</td>
    		<td style="text-align: center">UAT产品编码</td>
    		<td style="text-align: center">CMIS产品编码</td>
    		<td style="text-align: center">SIT产品编码</td>
    		<td style="text-align: center">UAT商户编码</td>
    		<td style="text-align: center">UAT门店编码</td>
    		<td style="text-align: center">CMIS商户编码</td>
    		<td style="text-align: center">CMIS门店编码</td>
    		<td style="text-align: center">SIT商户编码</td>
    		<td style="text-align: center">SIT门店编码</td>
    		<td style="text-align: center">操作</td>&nbsp;&nbsp;&nbsp;
    	</tr>
    	<c:forEach var="list"  items="${list}">
    	<tr bgcolor="${status.index%2==0?'#D0D8E8':'#E9EDF4'}">
    		<td style="text-align: center;display: none">${list.id}</td>
    		<td>${list.channelid}</td>
    		<td>${list.descinfo}</td> 		 
    		<td>${list.wfwuaturl}</td>
    		<td>${list.wfwcmisurl}</td>
    		<td>${list.wfwsiturl}</td>
    		<td>${list.filepath}</td>
    		<td>${list.publickey}</td>
    		<td>${list.privatekey}</td>
    		<td>${list.oldurl}</td>
    		<td>${list.uatloantyp}</td>
    		<td>${list.cmisloantyp}</td>
    		<td>${list.sitloantyp}</td>
    		<td>${list.uatsupercode}</td>
    		<td>${list.uatcoopercode}</td>
    		<td>${list.cmissupercode}</td>
    		<td>${list.cmiscoopercode}</td>
    		<td>${list.sitsupercode}</td>
    		<td>${list.sitcoopercode}</td>
  		<td><a href="<%=request.getContextPath() %>/configinfo/modify.do?id=${list.id}">更新</a>    <a href="<%=request.getContextPath() %>/configinfo/delete.do?id=${list.id}">删除</a></td>
    	</tr>
    	</c:forEach> 
     </table>
   </form>
<br>
    ${message}
<br><br>
<h2 class="myFrame" style="text-align: center;"><a href="<%=request.getContextPath() %>/userlogon.jsp">返回登录界面</a></h2>	    
</body>
</html>