<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript">
    //加载下拉菜单
	function loadSelect(){
		$.each($("select[loadData]"),function(name,value){
			var sel = $(value);
			var defaultValue = sel.attr("defaultValue");//默认值
			$.ajax({
				url : "${rc.contextPath}/param/queryParam.htm",
				type : "post",
				async : false,
				dataType:"json",
				data : {"type" : sel.attr("loadData")},
				success : function(result){
					for (var i=0; i<result.length; i++){
						if(defaultValue && defaultValue == result[i].code){
							sel.append("<option value="+result[i].code+" selected>"+result[i].value);
						}else{
							sel.append("<option value="+result[i].code+">"+result[i].value);
						}
					}
				}
			});
		});
	}
    
	$(
			function(){
				loadSelect();
			}
		)
$.post("/param", {'code':300268},
  function(dat){
    alert(dat.name);
});
 
	
	$.ajax({
		url:this.restApiUrl + "/param.do",
		type: "POST",
		data:JSON.stringify(user), 
		dataType:"json", 
		contentType:"application/json", 
		success:function(data){
		alert("注册用户成功!"); 
		}
		}); 
</script>

<title>字典项加载测试页面</title>
</head>
<body>
0000<br>
1111<br>

<div class="col-md-6">
	<select class="input-sm form-control" id="condition" name="condition" loadData="condition" defaultValue="0">
	</select>
</div>

<h2>====================2====================== </h2>
<span style="font-size:14px;">
	<form action="Handler2.ashx" method="post" enctype="application/x-www-form-urlencoded">  
		<p>客户名称: <input type="text" name="CustomerName" style="width: 300px" /></p>  
		<p>客户电话: <input type="text" name="CustomerTel" style="width: 300px" /></p>  
		<p><input type="submit" value="提交" /></p>  
	</form>
</span>

<h2>====================3====================== </h2>
<form action="Handler2.ashx" method="post" enctype="multipart/form-data">
	<p><input type="text" name="str" value="一个字符串，别管它" /></p> <p>要上传的文件１<input type="file" name="file1"/></p> 
	<p>要上传的文件２<input type="file" name="file2"/></p> 
	<p><input type="submit" value="提交" /></p>
</form>



<yy:select dictType="projectMode" id="projectMode" name="projectMode" tagClass="m-wrap medium"></yy:select>
</body>
</html>