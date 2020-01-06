<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    getByPageBean(1);
    $("#qureyBut").click(function(){
        getByPageBean(1);
    });
});
function getByPageBean(pageNo){
    //设置表单的 页号参数
    $("[name=pageNo]").val(pageNo);
    /*表单数据 序列化-->表单中有个隐藏域 储存的是 页号
     *                每次异步刷新的是表格信息
     *                表单中的数据不会变动
     *                根据方法的  pageNo 参数的变动
     *                查询不同页号的 信息
     */          
    var params= $("#selectName").serialize();
//ajax 请求
$.getJSON("UserListServlet",params,function(data){
        //删除表格之前数据(标题栏除外)--->防止出现几页的数据叠加的情况
        $("#selectTable tr").not(":first").remove();
        //设置上一页 下一页连接
        $("a:eq(0)").attr("href","javascript:getByPageBean(1)");
        $("a:eq(1)").attr("href","javascript:getByPageBean("+data.previous+")");
        $("a:eq(2)").attr("href","javascript:getByPageBean("+data.next+")");
        $("a:eq(3)").attr("href","javascript:getByPageBean("+data.totalPage+")");
        //设置显示信息(当前页号,总页号,总条数)
        $("#pageNo").html(data.pageNo);
        $("#totalPage").html(data.totalPage);
        $("#totalCount").html(data.count);
//在表格添加数据 使用each方法遍历 控制器传回的数据中的list集合
$.each(data.list,function(){
var tr="<tr>"+
            "<td height='23'><span class='STYLE1'>"+this.id+"</span></td>"+
            "<td><span class='STYLE1'> "+
                "<a href=UserViewServlet?userId="+this.id+">" +this.name+ "</a></span></td>"+
            "<td><span class='STYLE1'> "+this.loginName+" </span></td>"+
            "<td><span class='STYLE1'> "+(this.gender==1?"男":"女") +"</span></td>"+
            "<td><span class='STYLE1'> "+this.age+"</span></td>"+
            "<td><span class='STYLE1'>"+this.phone+"</span></td>"+
            "<td><span class='STYLE1'> "+(this.type==1?"管理员":"普通员工")+" </span></td>"+
        "</tr>";
        //把每次遍历的一行数据 添加到 表格中
        $("#selectTable").append(tr);
        });
    });
</script>
</head>
<body>
           
         <div class="menu">
        <table>         
                <tr>
                    <td>
                    <form method="post" action="UserListServlet" id="selectName">
                            <input name="pageNo"  type="text" value="1" style="display: none;">
                             用户名： 
                            <input name="name" class="input-text" type="text" value="">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <input value="查 询" type="button" id="qureyBut">
                    </form>
                    </td>
                </tr>           
        </table>
    </div>
    <br>
    <div class="main">
        <div class="optitle clearfix">
            <em><input value="添加用户" class="input-button" onclick="window.location='jsp/userAdd.jsp'" type="button"> </em>
            <br><br>
            <div class="title">用户管理&gt;&gt;</div>
        </div>
        <div class="content">
            <table class="list" id="selectTable">
                    <tr>
                        <td width="70" height="29"><div class="STYLE1" align="center">编号</div>
                        </td>
                        <td width="80"><div class="STYLE1" align="center">用户名</div>
                        </td>
                        <td width="80"><div class="STYLE1" align="center">用户账号</div>
                        </td>
                        <td width="100"><div class="STYLE1" align="center">性别</div>
                        </td>
                        <td width="100"><div class="STYLE1" align="center">年龄</div>
                        </td>
                        <td width="150"><div class="STYLE1" align="center">电话</div>
                        </td>
                        <td width="150"><div class="STYLE1" align="center">权限</div>
                        </td>
                    </tr>
            </table>
            <a href="">首页</a>
            <a href="">上一页</a>
            <a href="">下一页</a>
            <a href="">末页</a>
            当前第<span id="pageNo"></span> 页 ,
            总页数:<span id="totalPage"> </span>,
            总条数:<span id="totalCount"></span>
        </div>
    </div>
 <h3>自定义查询表单</h3>
  <div  class="mycustom" style="text-align: center;" >
	<form action="Search.jsp" >
		用户名：<input type="text" name = "CORP_NAME" id = "CORP_NAME" />
		<input type="submit" onclick="Search.jsp" value="搜索"/>
    </form>  
  </div>
               
</body>
</html>