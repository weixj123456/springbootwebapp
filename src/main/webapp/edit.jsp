<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String code = request.getParameter("code");
	String type = request.getParameter("type");
	String tp = request.getParameter("tp");//update or add
	String disabled = "";
	if("update".equals(tp)){
		disabled = "disabled";
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.bw_style{
		width: 600px;
		height: 300px;
		margin-top: 20px;
	}
	.f_div{
		margin-top: 50px;
		margin-bottom: 10px;
	}
	select{
		width: 170px;
	}
	.q_btn{
		background-color:#5abdf5;
		width: 100px;
		margin-left: 50px;
	}
	input{
		margin-top: 10px;
		margin-left: 5px;
	}
	select{
		margin-top: 10px;
		margin-left: 5px;
	}
	textarea{
		margin-left: 90px;
	}
</style>
<script type="text/javascript" src="./jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var tp = '<%=tp%>';
		if(tp == "update"){
			doQuery();
		}else{
			$("#msgCode").removeAttr("disabled");
			$("#msgType").removeAttr("disabled");
		}
	});
	function doQuery(){
		var msgCode = '<%=code%>';
		var msgType = '<%=type%>';
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"requestInfo",msgCode:msgCode,msgType:msgType},
			success:function(data){
				$("#msgCode").val(data.MSG_CODE);
				$("#msgName").val(data.MSG_NAME);
				$("#msgType").val(data.MSG_TYPE);
				$("#msgStatus").val(data.MSG_STATUS);
				$("#msgDbStatus").val(data.MSG_DB_STATUS);
				$("#msgContent").val(data.MSG_CONTENT);
				$("#msgDbContent").val(data.MSG_DB_CONTENT);
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'json'
		});
		
	}
	function doSubmit(){
		$("#msgCode").removeAttr("disabled");
		$("#msgType").removeAttr("disabled");
		$("#sub_form").submit();
	}
	function goBack(){
		window.location.href="request.jsp";
	}
</script>
<title>请求报文列表</title>
</head>
<body>
	<div style="width: 100%; text-align: right; ">
		<a href="test.jsp" style="margin-right: 50px;">报文模拟器</a>
	</div>
	<center>
	<form action="servlet/TestServlet.do" method="post" id="sub_form">
		<input type="text" name="page" value="updateRequest" style="display: none" >
		<input type="text" name="tp" value="<%=tp %>" style="display: none" >
 		<div class = "f_div">
	 		接口编号：<input id="msgCode" name="msgCode" type="text" disabled="disabled" > 
	 		接口名称：<input id="msgName" name="msgName" type="text" >
	 		接口类型：<select  id="msgType" name="msgType" disabled="disabled" >
		 			<option value="IX">XMLReqServlet(iLoan)</option>
		 			<option value="GX">XMLReqServlet(Gateway)</option>
		 			<option value="GO">OutsiteReqServlet(Gateway)</option>
	 				</select><br>
	 		接口状态：<select  id="msgStatus" name="msgStatus" >
		 			<option value="1">生效</option>
		 			<option value="0">失效</option>
	 				</select>
	 		启用挡板：<select  id="msgDbStatus" name="msgDbStatus" >
		 			<option value="1">启用</option>
		 			<option value="0">停用</option>
	 				</select><br>
	 		<div style="width: 100%">
	 			<div style="width: 50% ;float: left;color: blue;">请求报文</div>
	 			<div style="width: 50% ;float: left;color: blue;">挡板报文</div>
	 		</div>
			 	<textarea class="bw_style" rows="" cols="" name="msgContent" id="msgContent"></textarea>
			 	<textarea class="bw_style" rows="" cols="" name="msgDbContent" id="msgDbContent"></textarea>	
 				<br><input type="button" value="提交" class="q_btn" onclick="doSubmit()">
 					<input type="button" value="返回" class="q_btn" onclick="goBack()">
 		</div>
 	</form>
 	</center>
</body>
</html>