<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改数据</title>
  </head>
  <body>
    <form action="<%=request.getContextPath() %>/require/update.do" method="post"> 
		    &nbsp &nbsp<input type="text" name="id" value="${add.id}" style="display: none;"> <br><br>
    	需求编号：&nbsp &nbsp <input type="text" name="reqid" value="${add.reqid}"> <br><br>
    	类型： &nbsp &nbsp<input type="text" name="type" value="${add.type}"> <br><br>
    	需求名称：&nbsp &nbsp<input type="text" name="reqname" value="${add.reqname}"> <br><br>
    	是否完成测试：&nbsp &nbsp<input type="text" name="istest" value="${add.istest}"> <br><br>
    	提出及测试部门：<input type="text" name="reqpartment" value="${add.reqpartment}"><br><br>
    	涉及系统：&nbsp &nbsp <input type="text" name="relatesys" value="${add.relatesys}"><br><br>
    	业务测试人员：<input type="text" name="yewuer" value="${add.yewuer}"><br><br>
    	测试对接人员：<input type="text" name="tester" value="${add.tester}"><br><br>
    	是否完成签报：<input type="text" name="isproduct" value="${add.isproduct}"><br><br>
    	开发人员：&nbsp &nbsp<input type="text" name="developer" value="${add.developer}"><br><br>
    	是否变更投产时间：<input type="text" name="isupdate" value="${add.isupdate}"><br><br>
    	投产时间：&nbsp &nbsp<input type="text" name="productdate" value="${add.productdate}"><br><br>
    	其他描述：&nbsp &nbsp<input type="text" name="descp" value="${add.descp}"><br><br>
<!--  				<input type="hidden" name="id" value="${add.id }">  -->
   				 <input type="submit" value="提交数据">
      </form>
  </body>
</html>