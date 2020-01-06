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
    			if(document.getElementById("requireid").value=='')
    			{
    				alert("需求编号不能为空");
    				return false;    				
    			}
    			if(document.getElementById("requirename").value=='')
    			{
    				alert("需求名称不能为空");
    				return false;    				
    			}
    			if(document.getElementById("sitstarttime").value=='')
    			{
    				alert("工作量登记时间不能为空");
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
  <h1><center>==========================新增需求工作量===============================</center></h1> 
  
    <form action="<%=request.getContextPath()%>/worklist/add.do" method="post"  onSubmit="return inputNull(this)"> 
	<!--  	<input type="text" name="id" style="display:none;"> --> <br><br>
    	需求编号:<input type="text" name="requireid" id="requireid"> <br><br>
    	需求名称:<input type="text" name="requirename" id="requirename"> <br><br>
    	渠道组工作量:
    	<input type="text" name="qudaowork" id="qudaowork"><br><br>
    	核心组工作量:
    	<input type="text" name="hexinwork" id="hexinwork"><br><br>
    	数据组工作量:
    	<input type="text" name="shucangwork" id="shucangwork"><br><br>
    	外围组工作量:
    	<input type="text" name="waiweiwork" id="waiweiwork"><br><br>
    	工作量登记时间:
    	<br>
        <input type="date" class="form-control" name="sitstarttime" id="sitstarttime">       
        <br><br>
    	<!-- SIT结束时间: 
    	<input type="text" style="display:none;" name="sitendtime"> -->
    	<!-- UAT开始时间: 
    	<input type="text" style="display:none;" name="uatstarttime"> -->
    	<!-- UAT结束时间: 
    	<input type="text" style="display:none;" name="uatendtime"> -->
    	分配测试人员:
    	<input type="text" name="sittoperson" id="sittoperson"><br><br>
    	<!--  UAT分配人员: 
    	<input type="text" style="display:none;" name="uattoperson">
    	-->
    	SIT描述涉及系统:
    	<input type="text" name="sitdescription" id="sitdescription"><br><br>
    	UAT描述:
    	<input type="text" name="uatdescription" id="uatdescription"><br><br>
    	
        <!--  
    	UAT开始时间1:<br>
        <input type="date" class="form-control"  name="sitstarttime">
         UAT结束时间:<br><input type="date"  class="form-control"  name="sitendtime">
    	预计投产时间:
    	<input type="date" name="producttime">
    	是否变更投产时间:<input type="text" name="isupdate" >
    	-->
    	工作量是否确认:&nbsp;&nbsp;<!--  <input type="text" name="beizhu" > -->
   	    <select name="beizhu" id="beizhu" >
   	      <option value=""  style="color:#c2c2c2;">--请选择--</option>
   	      <option value="0">已确认</option>
   	      <option value="1">未确认</option>
   	    </select>
   	    <br><br><br><br>
   	    <input type="submit" value="提交数据">
      </form>
  </body>
</html>