<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报文测试页面</title>
<style type="text/css">
	input{
		margin-top: 20px;
	}
	.bw_style{
		width: 750px;
		height: 500px;
		margin-top: 20px;
		margin-left: 6px;
		float:left;
	}
	.sp_style{
		height:500px;
		line-height: 500px;
		float:left;
	}
	.dz_style{
		width:820px;
	}
	.tj_style{
		width: 100px;
		height: 30px;
		color:white;
		background-color: gray;
		margin: 0 auto;
	}
	.content{
		float:left;
		width: 100px;
		margin-bottom: 10px;
	}
	.msg_button{
		height:20px;
		width: 250px;
		margin-top: 5px;
	}
	select{
		width: 235px;
	}
	
</style>
<script type="text/javascript" src="jquery/jquery-1.7.2.js"></script>
<script type="text/javascript">
	var hj = 'http://10.10.0.31:9153/iLoan/';
	var mb = 'servlet/XMLReqServlet';
	$(document).ready(function(){
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"msgList"},
			success:function(data){
				var ops = data.split("$");
				$("#se_ix").html('<option value="0" >请选择</option>'+ops[0]);
				$("#se_gx").html('<option value="0" >请选择</option>'+ops[1]);
				$("#se_go").html('<option value="0" >请选择</option>'+ops[2]);
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
		$("#se_ix").change(function(){
			var code = $("#se_ix").val();
			if(code == 0){
				return;
			}
			$.ajax({
				url:"servlet/TestServlet.do",
				data:{page:"msgInfo",code:code,type:"IX"},
				success:function(data){
					document.getElementById("qqnr").value=data;
				},
				error:function(data){
					alert("操作失败");
				},
				dataType:'text'
			});
		});
		$("#se_gx").change(function(){
			var code = $("#se_gx").val();
			if(code == 0){
				return;
			}
			$.ajax({
				url:"servlet/TestServlet.do",
				data:{page:"msgInfo",code:code,type:"GX"},
				success:function(data){
					document.getElementById("qqnr").value=data;
				},
				error:function(data){
					alert("操作失败");
				},
				dataType:'text'
			});
		});
		$("#se_go").change(function(){
			var code = $("#se_go").val();
			if(code == 0){
				return;
			}
			$.ajax({
				url:"servlet/TestServlet.do",
				data:{page:"msgInfo",code:code,type:"GO"},
				success:function(data){
					document.getElementById("qqnr").value=data;
				},
				error:function(data){
					alert("操作失败");
				},
				dataType:'text'
			});
		});
		
		
		
		
	});
	function doFromat(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"format",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	
	function doJsonFromat(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"formatJson",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	function xmlToJson(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"xmlToJson",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	
	function jsonToXml(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"jsonToXml",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	
	function doBaiduBw(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"baiduBw",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	
	function doBaiduMy(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"baiduMy",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	
	function doBaiduDb(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"baiduDb",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	function doBaiduJm(){
		var content = document.getElementById("qqnr").value;
		$.ajax({
			url:"servlet/TestServlet.do",
			data:{page:"baiduJm",content:content},
			success:function(data){
				document.getElementById("qqnr").value = data;
			},
			error:function(data){
				alert("操作失败");
			},
			dataType:'text'
		});
	}
	
	function doHjChange(value){
		if(value=='iLoansit'){
			hj='http://10.10.0.31:9153/iLoan/';
		}else if(value=='iLoanuat'){
			hj='http://10.10.0.31:9086/iLoan/';
		}else if(value=='iLoanz_pro'){
			hj='http://10.10.0.61:9082/iLoan/';
		}else if(value=='iLoanpro'){
			hj='http://10.8.0.56:9080/iLoan/';
		}else if(value=='Gatewaysit'){
			hj='http://10.10.0.31:9150/Gateway/';
		}else if(value=='Gatewayuat'){
			hj='http://10.10.0.31:9086/Gateway/';
		}else if(value=='Gatewayz_pro'){
			hj='http://10.10.0.61:9083/Gateway/';
		}else if(value=='Gatewaypro'){
			hj='http://10.16.0.18:9080/Gateway/';
		}else if(value=='XMLReqServlet'){
			mb='servlet/XMLReqServlet';
		}else if(value=='OutsiteReqServlet'){
			mb='servlet/OutsiteReqServlet';
		}else if(value=='BaiDuReqServlet'){
			mb='servlet/BaiDuReqServlet/';
		}
		
		var mbdz = hj+mb;
		document.getElementById("mbdz").value= mbdz;
	}
</script>
</head>
<body>
	<div style="width: 100%; text-align: right; ">
		<a href="request.jsp" style="margin-right: 50px;">报文列表</a>
	</div>
	<span>请求环境：</span>
		 <input checked="checked" type="radio" name="env" onclick="doHjChange('iLoansit')"/>iLoan(sit)
		 <input type="radio" name="env" onclick="doHjChange('iLoanuat')"/>iLoan(uat)
		 <input type="radio" name="env" onclick="doHjChange('iLoanz_pro')"/>iLoan(z_pro)
		 <input type="radio" name="env" onclick="doHjChange('iLoanpro')"/>iLoan(pro)&nbsp||
		 <input type="radio" name="env" onclick="doHjChange('Gatewaysit')"/>Gateway(sit)
		 <input type="radio" name="env" onclick="doHjChange('Gatewayuat')"/>Gateway(uat)
		 <input type="radio" name="env" onclick="doHjChange('Gatewayz_pro')"/>Gateway(z_pro)
		 <input type="radio" name="env" onclick="doHjChange('Gatewaypro')"/>Gateway(pro)<br>
	<span>请求目标：</span>
		 <input checked="checked" type="radio" name="goal" onclick="doHjChange('XMLReqServlet')"/>XMLReqServlet
		 <input type="radio" name="goal" onclick="doHjChange('OutsiteReqServlet')"/>OutsiteReqServlet
		 <input type="radio" name="goal" onclick="doHjChange('BaiDuReqServlet')"/>BaiDuReqServlet<br>
	<form action="servlet/TestServlet.do" method="post" target="_blank">
		 <span>请求方式：</span>
			<input type="radio" name="xings" value="01" checked="checked" />报文
		 	<input type="radio" name="xings" value="02"/>参数<br>
		 <span>请求地址：</span>
		 	<input name="mbdz" type="text" class="dz_style" id="mbdz" value='http://10.10.0.31:9153/iLoan/servlet/XMLReqServlet'/><br>
		 	<div style="height: 15px;"></div>
		 <span>获取报文：</span>	
		 	IX：<select id="se_ix">
		 			
		 		</select>
		 	GX：<select id="se_gx">
		 			
		 		</select>
		 	GO：<select id="se_go">
		 			
		 		</select>
		 <div >
		 	<div class="sp_style" >请求报文：</div>
		 	<textarea class="bw_style" rows="" cols="" name="qqnr" id="qqnr"></textarea><br>
		 </div>
		 <input type="text" name="page" value="submit" style="display: none">
		<div class="content">
		 		<input type="submit" value="提交" class="tj_style" style="background-color:#5abdf5;" />
				<input type="button" value="XML格 式 化" class="tj_style" onclick="doFromat()"/>
				<input type="button" value="XML转JSON" class="tj_style" onclick="xmlToJson()"/>
				<input type="button" value="JSON格式化" class="tj_style" onclick="doJsonFromat()"/>
				<input type="button" value="JSON转XML" class="tj_style" onclick="jsonToXml()"/>
				<input type="button" value="百度报文生成" class="tj_style" onclick="doBaiduBw()"/>
				<input type="button" value="百度挡板生成" class="tj_style" onclick="doBaiduDb()"/>
				<input type="button" value="百度密钥生成" class="tj_style" onclick="doBaiduMy()"/>
				<input type="button" value="百度响应解密" class="tj_style" onclick="doBaiduJm()"/>
		 </div>
	 </form>
</body>
</html>