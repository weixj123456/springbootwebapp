<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投产清单用户登录查询</title>
<script type="text/javascript">
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
  	</script>
</head>

<body>
      <h3>用户登录查询需求计划清单</h3>
      <form action="product/getall.do" method="post" onSubmit="return inputNull(this)">
  		<table>
	  		<p>
				<span>姓名：</span>
				<input type="text" id="username1" placeholder="姓名" name="username">
	  		</p>
	  		<p>
				<span>密码：</span>
				<input type="password" id="pwd1" placeholder="密码" name="pwd">
	  		</p>
			<input type="submit" value="登录">	  		
  	</form>
  	
  	<h3>用户登录查询工作量清单</h3>
  	<form action="worklist/getall.do" method="post" onSubmit="return inputNull(this)">
  		<table>
	  		<p>
				<span>姓名：</span>
				<input type="text" placeholder="姓名" name="username">
	  		</p>
	  		<p>
				<span>密码：</span>
				<input type="password" placeholder="密码" name="pwd">
	  		</p>
			<input type="submit" value="登录">	  		
  	 </form>
  	 
  	 <h3>用户登录查询渠道配置清单</h3>
  	<form action="configinfo/index.do" method="post" onSubmit="return inputNull(this)">
  		<table>
	  		<p>
				<span>姓名：</span>
				<input type="text" placeholder="姓名" name="username">
	  		</p>
	  		<p>
				<span>密码：</span>
				<input type="password" placeholder="密码" name="pwd">
	  		</p>
			<input type="submit" value="登录">	  		
  	 </form>
  	 <br>
  	          ${message}
  	 <h2 class="myFrame" style="text-align: center;"><a href="<%=request.getContextPath() %>/login.jsp">返回首页</a></h2>
</body>
</html>