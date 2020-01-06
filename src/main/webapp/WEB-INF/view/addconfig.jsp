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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>新增投产清单</title>
    <script type="text/javascript">
    
    function inputNull(form){
    			if(document.getElementById("channelid").value=='')
    			{
    				alert("渠道编号不能为空");
    				return false;    				
    			}
    			if(document.getElementById("descinfo").value=='')
    			{
    				alert("渠道名称不能为空");
    				return false;    				
    			}
    			if(document.getElementById("filepath").value=='')
    			{
    				alert("报文路径不能为空");
    				return false;    				
    			}
    			if(document.getElementById("qudaowork").value=='')
    			{
    				alert("渠道工作量不能为空，无工作量默认填0");
    				return false;    				
    			}
    			if(document.getElementById("hexinwork").value=='')
    			{
    				alert("核心工作量不能为空，无工作量默认填0");
    				return false;    				
    			}
    			if(document.getElementById("waiweiwork").value=='')
    			{
    				alert("外围组工作量不能为空，无工作量默认填0");
    				return false;    				
    			}
    			if(document.getElementById("shucangwork").value=='')
    			{
    				alert("数据组工作量不能为空，无工作量默认填0");
    				return false;    				
    			}
    			if(document.getElementById("beizhu").value=='')
    			{
    				alert("工作量是否确认不能为空");
    				return false;    				
    			}
    				
    			return true;
    		}
    
    /**
  		function inputNull(form){
			for(i=0;i<form.length;i++){
                    //form属性的elements的首字母e要小写
				if(form.elements[i].value == ""){ 
					alert("亲！：" + form.elements[i].placeholder + "不能为空");
					form.elements[i].focus();	
					return false;
				}
			}
  	  	}
  	  **/	
  	  	
  	</script>
  </head>
  <body>
  <h1><center>=====新增渠道公共信息====</center></h1> 
  
    <form action="<%=request.getContextPath()%>/configinfo/add.do" method="post"  onSubmit="return inputNull(this)"> 
	<!--  	<input type="text" name="id" style="display:none;"> --> <br><br>
    	渠道编号:<input type="text" name="channelid" id="channelid"> <br><br>
    	渠道名称:<input type="text" name="descinfo" id="descinfo"> <br><br>
    	UAT请求url:<br>
    	<input type="text" style="width:500;" name="wfwuaturl" id="wfwuaturl"><br>
    	CMIS请求url:<br>
    	<input type="text" style="width:500;" name="wfwcmisurl" id="wfwcmisurl"><br>
    	SIT请求url:<br>
    	<input type="text" style="width:500;" name="wfwsiturl" id="wfwsiturl"><br>
                        报文存放路径:<br>
    	<input type="text" style="width:500;" name="filepath" id="filepath"><br>
                       测试公钥:<br>
        <input type="text" style="width:1800;" name="publickey" id="publickey"><br>       
                       测试私钥:<br>
        <input type="text" style="width:1800;" name="privatekey" id="privatekey"><br>       
                      老渠道url:<br>
        <input type="text" style="width:500;" name="oldurl" id="oldurl"><br>       
        UAT产品编码:
    	<br>
        <input type="text" name="uatloantyp" id="uatloantyp"><br>      
        CMIS产品编码:
    	<br>
        <input type="text" name="cmisloantyp" id="cmisloantyp"><br>       
        SIT产品编码:
    	<br>
        <input type="text" name="sitloantyp" id="sitloantyp"><br>       
        UAT商户编码:
    	<br>
        <input type="text" name="uatsupercode" id="uatsupercode"><br>       
        UAT门店编码:
    	<br>
        <input type="text" name="uatcoopercode" id="uatcoopercode"><br>       
        CMIS商户编码:
    	<br>
        <input type="text" name="cmissupercode" id="cmissupercode"><br>       
        CMIS门店编码:
    	<br>
        <input type="text" name="cmiscoopercode" id="cmiscoopercode"><br>       
        SIT商户编码:
    	<br>
        <input type="text" name="sitsupercode" id="sitsupercode"><br>                    
        SIT门店编码:
    	<br>
        <input type="text" name="sitcoopercode" id="sitcoopercode"><br>
    	<!-- 
    	<br>
        <input type="date" class="form-control" name="sitstarttime" id="sitstarttime">       
        <br><br>
    	SIT结束时间: 
    	<input type="text" style="display:none;" name="sitendtime"> -->
    	<!-- UAT开始时间: 
    	<input type="text" style="display:none;" name="uatstarttime"> -->
    	<!-- UAT结束时间: 
    	<input type="text" style="display:none;" name="uatendtime"> -->
    	<!--  UAT分配人员: 
    	<input type="text" style="display:none;" name="uattoperson">
    	-->
        <!--  
    	UAT开始时间1:<br>
        <input type="date" class="form-control"  name="sitstarttime">
         UAT结束时间:<br><input type="date"  class="form-control"  name="sitendtime">
    	预计投产时间:
    	<input type="date" name="producttime">
    	是否变更投产时间:<input type="text" name="isupdate" >
    	--><!--   
    	工作量是否确认:&nbsp;&nbsp;
   	    <select name="beizhu" id="beizhu" >
   	      <option value=""  style="color:#c2c2c2;">--请选择--</option>
   	      <option value="0">已确认</option>
   	      <option value="1">未确认</option>
   	    </select>
   	    --><br>
   	    <input type="submit" value="提交数据">
      </form>
  </body>
</html>