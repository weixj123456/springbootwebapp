<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>idcardlogin.jsp</title>
</head>
<body>
<!--     
<form action="<%=request.getContextPath() %>/idcard/idcardsave.do" method="post">
 --> 
 <form action="idcard/idcardsave.do" method="post">      
		        客户名称：<input type="text" name="username"/> <br><br>
		        身份证：<input type="text" name="idno"/> <br><br>
		        银行卡：<input type="text" name="bankno"/> <br><br>        
		        手机号：<input type="text" name="telphone"/> <br><br>
		        描述：    <input type="text" name="descption"/> <br><br>
		        数字：    <input type="text" name="num"/> <br><br>     
		         <input type="submit" value="保存身份记录"/>
   </form>
</body>

  <form action="<%=request.getContextPath() %>/idcard/find.do" method="post">
		              数字：<input type="text" name="num"/> <br><br>     
		          <input type="submit" value="查询单一身份记录"/>
   </form>
   
   <br><br>
   <form action="<%=request.getContextPath() %>/idcard/findAll.do" method="post">
		              数字：<input type="text" name="num"/> <br><br>     
		          <input type="submit" value="查询所有身份记录"/>
   </form>
   
   <br><br>
   <form action="<%=request.getContextPath() %>/idcard/delidcard.do" method="post">
		              数字：<input type="text" name="num"/> <br><br>     
		          <input type="submit" value="删除身份记录"/>
   </form>
   
   <br><br>   
   <form action="<%=request.getContextPath() %>/idcard/update.do" method="post">
		              数字：<input type="text" name="num"/> <br><br>     
		          <input type="submit" value="更新身份记录"/>
   </form>
   
   
  </body>
</html>