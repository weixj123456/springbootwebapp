<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询页面测试</title>
<script type="text/javascript">
window.onload=function(){
document.getElementById("slt1").value=${pageInfo.keyWord.thirdCondition}
}
</script>
</head>
<body>
<div>
<form action="<%=request.getContextPath()%>/student/queryList.action" method="post">
<select id="slt1" name="thirdCondition">
<option value="">请选择</option>
<option>1</option>
<option>2</option>
<option>3</option>
</select>
姓名: <input type="text" name="firstCondition" value="${pageInfo.keyWord.firstCondition}" >
每页大小:<input type="text" name="pageSize" value="${pageInfo.pageSize}">
<input type="submit" value="查询">
</form>
</div>
<div>
<table>
<tr>
<td>姓名</td>
<td>生日</td>
<td>班级</td>
<td>爱好</td>

<td>操作</td>
</tr>
<c:forEach items="${list}" var="student">
<tr>
	<td>${student.name }</td>
	<td><fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd"/></td>
	<td>${student.cid}</td>
	<td>${student.favorite}</td>
	<td>删除</td>
	</tr>
</c:forEach>

</table>

</div>
<div>
<a href="<%=request.getContextPath()%>/student/queryList.action?pageIndex=1&pageSize=${pageInfo.pageSize}&thirdCondition=${pageInfo.keyWord.thirdCondition}&firstCondition=${pageInfo.keyWord.firstCondition}">首页</a>
  <c:if test="${pageIndex>1}">
  <a href="<%=request.getContextPath()%>/student/queryList.action?pageIndex=${pageIndex-1 }&pageSize=${pageInfo.pageSize}&thirdCondition=${pageInfo.keyWord.thirdCondition}&firstCondition=${pageInfo.keyWord.firstCondition}">上一页</a>
  </c:if>
   
   <c:if test="${pageIndex == 1}">
    <a>上一页</a>
    </c:if>
    
  <c:if test="${pageIndex<pageCount }">
  <a  href="<%=request.getContextPath()%>/student/queryList.action?pageIndex=${pageIndex+1}&pageSize=${pageInfo.pageSize}&thirdCondition=${pageInfo.keyWord.thirdCondition}&firstCondition=${pageInfo.keyWord.firstCondition}" >下一页</a> 
  </c:if>
  
  <c:if test="${pageIndex == pageCount}">
    <a>下一页</a>
    </c:if>
     <a href="<%=request.getContextPath()%>/student/queryList.action?pageIndex=${pageCount}&pageSize=${pageInfo.pageSize}&thirdCondition=${pageInfo.keyWord.thirdCondition}&firstCondition=${pageInfo.keyWord.firstCondition} ">尾页</a>
        
</div>

</body>
</html>