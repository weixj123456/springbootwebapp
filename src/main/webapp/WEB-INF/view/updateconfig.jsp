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
    <form action="<%=request.getContextPath()%>/configinfo/update.do" method="post"> 
		<input type="text" name="id" value="${list.id}" style="display:none;"> <br><br>
    	渠道编号:<input type="text" name="channelid" value="${list.channelid}"> <br><br>
    	渠道名称:<input type="text" name="descinfo"  value="${list.descinfo}"> <br><br>
        UAT请求url:<br>
    	<input type="text" style="width:500;" name="wfwuaturl" id="wfwuaturl" value="${list.wfwuaturl}"><br>
    	CMIS请求url:<br>
    	<input type="text" style="width:500;" name="wfwcmisurl" id="wfwcmisurl" value="${list.wfwcmisurl}"><br>
    	SIT请求url:<br>
    	<input type="text" style="width:500;" name="wfwsiturl" id="wfwsiturl" value="${list.wfwsiturl}"><br>
                        报文存放路径:<br>
    	<input type="text" style="width:500;" name="filepath" id="filepath" value="${list.filepath}"><br>
                       测试公钥:<br>
        <input type="text" style="width:1800;" name="publickey" id="publickey" value="${list.publickey}"><br>       
                       测试私钥:<br>
        <input type="text" style="width:1800;" name="privatekey" id="privatekey" value="${list.privatekey}"><br>       
                        老渠道url:<br>
        <input type="text" style="width:500;" name="oldurl" id="oldurl" value="${list.oldurl}"><br>       
        UAT产品编码:<br>
        <input type="text" name="uatloantyp" id="uatloantyp" value="${list.uatloantyp}"><br>      
        CMIS产品编码:<br>
        <input type="text" name="cmisloantyp" id="cmisloantyp" value="${list.cmisloantyp}"><br>       
        SIT产品编码:<br>
        <input type="text" name="sitloantyp" id="sitloantyp" value="${list.sitloantyp}"><br>       
        UAT商户编码:<br>
        <input type="text" name="uatsupercode" id="uatsupercode" value="${list.uatsupercode}"><br>       
        UAT门店编码:<br>
        <input type="text" name="uatcoopercode" id="uatcoopercode" value="${list.uatcoopercode}"><br>       
        CMIS商户编码:<br>
        <input type="text" name="cmissupercode" id="cmissupercode" value="${list.cmissupercode}"><br>       
        CMIS门店编码:<br>
        <input type="text" name="cmiscoopercode" id="cmiscoopercode" value="${list.cmiscoopercode}"><br>       
        SIT商户编码:<br>
        <input type="text" name="sitsupercode" id="sitsupercode" value="${list.sitsupercode}"><br>                    
        SIT门店编码:<br>
        <input type="text" name="sitcoopercode" id="sitcoopercode" value="${list.sitcoopercode}"><br><br>
   	    <input type="submit" value="提交数据">
      </form>
  </body>
</html>