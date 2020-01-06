<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>折叠菜单</title>
 
<style type="text/css">
html,body,ul,li,h1,h2,h3{
    padding: 0;
    margin: 0;
}
ul {
    list-style: none;
}
a {
    text-decoration: none;
}
.first-title {
    display: block;
    width: 200px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    background:#1c4275 url(images/pro_left.png) center right no-repeat;
    background-color: #1c4275;
    font-size: 18px;
    color: #9b5900;
    font-weight: 700;
}
.current {
    background:#1c4275 url(images/pro_down.png) center right no-repeat;
}
.first-title:hover {
    background-color: #0a3775;
    color: #fff;
}
#second-floor {
    display: none;
}
.second-title {
    display: block;
    width: 200px;
    height: 40px;
    line-height: 40px;
    text-align: center;
    font-size: 16px;
    color: #fff;
    font-weight: 500;
    background-color:#e78300;
}
.second-title:hover {
    color: #fff;
    background-color: #9222e7;
}
#third-floor {
    display: none;
}
.third-title {
    display: block;
    width: 200px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    color: #000;
    font-size: 14px;
    font-weight: 500;
    background-color: #ccc;
}
.third-title:hover {
    color:#ff4c98; 
    background-color: #eee;
}
</style>
<script src="<%=request.getContextPath()%>/jquery/jquery-1.7.2.js"></script>
<script src="<%=request.getContextPath()%>js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#first-floor #second-floor:eq(0)").show();
    $("#first-floor .first-title:eq(0)").addClass("current");
    $("#first-floor .first-title").click(function(){
        var secondFloor = $(this).next("ul #second-floor");
        //为啥跟页面显示情况是相反的display")!="none"？？？
        if (secondFloor.css("display")!="none") {
            //console.log("none");
            $(this).removeClass("current");
        }else{
            //console.log("block");
            $(this).addClass("current");
        }   
        secondFloor.slideToggle(300).siblings("ul #second-floor").slideUp("slow");
    });
})

</script>
</head>
<body>
<ul>
    <li id="first-floor">
        <a href="#" class="first-title">我是一级菜单</a>
        <ul id="second-floor">
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
        </ul>
    </li>
    <li id="first-floor">
        <a href="#" class="first-title">我是一级菜单</a>
        <ul id="second-floor">
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
        </ul>
    </li>
    <li id="first-floor">
        <a href="#" class="first-title">我是一级菜单</a>
        <ul id="second-floor" class="has-children">
            <li><a href="#" class="second-title">我是二级菜单</a>
                <ul id="third-floor">
                    <li><a href="#" class="third-title">我是三级菜单</a></li>
                    <li><a href="#" class="third-title">我是三级菜单</a></li>
                    <li><a href="#" class="third-title">我是三级菜单</a></li>
                </ul>
            </li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
            <li><a href="#" class="second-title">我是二级菜单</a></li>
        </ul>
    </li>
</ul>

</body>
</html>