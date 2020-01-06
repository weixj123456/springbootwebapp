<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.t_head td{
		background-color: #5abdf5;
		font-weight: bold;
		
	}
	.t_body td{
		background-color: #DDDDDD;	
	}
	td{
		height: 25px;
		width: 200px;
	}
	.f_div{
		margin-top: 30px;
		margin-bottom: 10px;
	}
	select{
		width: 170px;
	}
	.q_btn{
		background-color:#5abdf5;
		width: 80px;
		margin-left: 20px;
	}
</style>
<script type="text/javascript" src="jquery/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		doQuery();
	});
	function doEdit(){
		
	}
	function doDelete(code,type){
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"requestDelete",msgCode:code,msgType:type},
			success:function(data){
				alert("操作成功");
				doQuery();
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	function doEdit(code,type){
		window.location.href="edit.jsp?code="+code+"&type="+type+"&tp=update";
	}
	function doAdd(code,type){
		window.location.href="edit.jsp?tp=add";
	}
	function doQuery(){
		var msgCode = $("#msgCode").val();
		var msgName = $("#msgName").val();
		var msgType = $("#msgType").val();
		var msgStatus = $("#msgStatus").val();
		$("#content").html("");
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"requestList",msgCode:msgCode,msgName:msgName,msgType:msgType,msgStatus:msgStatus},
			success:function(data){
				$("#content").html(data);
				$(".edit_btn").click(function(){
					var code= $(this).parent().parent().find("td[name='td_code']").html();
					var type= $(this).parent().parent().find("td[name='td_type']").html();
					doEdit(code,type);
				});
				$(".delete_btn").click(function(){
					if(confirm("删除后将不可恢复，是否确认删除！")){
						var code= $(this).parent().parent().find("td[name='td_code']").html();
						var type= $(this).parent().parent().find("td[name='td_type']").html();
						doDelete(code,type);
					}
				});
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
		
	}
	
</script>
<title>请求报文列表</title>
</head>
<body>
	<div style="width: 100%; text-align: right; ">
		<a href="test.jsp" style="margin-right: 50px;">报文模拟器</a>
	</div>
 	<center>
 		<div class = "f_div">
	 		接口编号:<input id="msgCode" type="text" >
	 		接口名称:<input id="msgName"  type="text" >
	 		接口类型:<select  id="msgType" >
	 				<option selected="selected" value="">全部</option>
		 			<option value="IX">XMLReqServlet(iLoan)</option>
		 			<option value="GX">XMLReqServlet(Gateway)</option>
		 			<option value="GO">OutsiteReqServlet(Gateway)</option>
	 				</select>
	 		接口状态:<select  id="msgStatus"  >
	 			 	<option selected="selected" value="">全部</option>
		 			<option value="1">生效</option>
		 			<option value="0">失效</option>
	 				</select>
	 		挡板状态:<select  id="msgDbStatus"  >
	 			 	<option selected="selected" value="">全部</option>
		 			<option value="1">启用</option>
		 			<option value="0">停用</option>
	 				</select>
 			<input type="button" value="查询" class="q_btn" onclick="doQuery()">
 			<input type="button" value="新增" class="q_btn" onclick="doAdd()">
 		</div>
 		<table id="content">
 			<tr class="t_head">
 				<td>接口编号</td>
 				<td>接口类型</td>
 				<td>接口名称</td>
 				<td>接口状态</td>
 				<td>更新时间</td>
 				<td>操作</td>
 			</tr>
 		</table>
 	</center>
</body>
</html>