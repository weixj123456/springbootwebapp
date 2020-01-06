<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>JSP 自定义标签的实现</title>
	</head>
	<body>
		请选择：
		<html:select name="sex" style="width:100px">
			<html:options collection="SEX"></html:options>
		</html:select>
		显示性别：
		<html:selectDisplay collection="SEX" value="1" name="sex"></html:selectDisplay>		
	</body>
</html>