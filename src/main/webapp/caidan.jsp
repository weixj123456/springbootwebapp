<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <base href="<%=basePath%>" />
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>0000</title>
 <style>
 html{
     padding:0px;margin:0px;}
 body{
     padding:0px;margin:0px;background-color:#f1f2f2;}
 a{
     text-decoration:none;}
 a:hover{
     text-decoration:none;
     }
 
 #left{
     float:left;width:210.4px; background-color:#1d6ab2;}
 #main{
     float:left;width:84.4%;position:absolute;left:210.4px;}
 #left table{
     margin-left:20px;margin-right:auto;margin-top:4px; text-align:left;}
 #left table td{
     color:#FFF;font-size:14px;font-family:宋体; font-weight:400;}
 #left table td a{
     color:#1d6ab2;font-size:12px;font-family:宋体; font-weight:400; background-color:#fff;
     border-radius:4px;padding:5px;}
 #left table td a:hover{
     background-color:#1d6ab2;color:#FFF;
     }
 #left table td button{
     background:#3f85c0;color:#fff;border:0px;padding:6px;border-radius:4px;font-size:12px;
     }
 #left table td button:hover{
     background:#2e2d80;
     }
 #menu{
     width:100%; margin-left:auto; margin-right:auto;margin-bottom:4px;}
 #menu1,#menu2{
      width:144px;display:none;margin-left:auto; margin-right:auto;clear:left;margin-bottom:3px;margin-top:3px;}
 #menu button{
     width:100%;height:30px;border:0px;margin:0px 0px 0px 0px; background-color:#1D6ab2;color:#FFF;
     font-size:14px;font-family:宋体; font-weight:600;border-radius:1px; 
     }
 #menu button:hover{
     background-color:#f1f2f2;color:#1D6ab2;
     }
 #menu1 a,#menu2 a{
      font-size:14px;font-family:宋体; font-weight:600;padding:0px 50px 0px 50px;
      background-color:#f1f2f2;color:#1D6ab2; text-align:center;}
 #menu1 a:hover,#menu2 a:hover{
     background-color:#AAD5E8;color:#1D6ab2;
     }
 </style>
 <script src="<%=request.getContextPath()%>/jquery/jquery-1.7.2.js"></script>
 <script type="text/javascript">
$(function(){
    $("#1,#2").toggle(
      function(){
          var ss=$(this).attr("id");         
          $(this).children().parent().next().slideDown(1000);
          },
      function(){
          $(this).children().parent().next().hide(500);                  
          });    
});

</script>
 </head>
 
 <body>
       <div id="left" >
       <table>
         <tr><td>用户名：</td><td>李丽</td></tr>
         <tr><td>学&nbsp; 号：</td><td>12</td></tr>
         <tr height="30px"><td ><a href="#">[修改资料]</a></td>
                           <td><a href="#">[修改密码]</a></td></tr>
         <tr ><td><button type="button">切换账户</button></td>
              <td><button type="button">用户登录</button></td></tr>
       </table>
       <hr style="border:1px solid #f1f2f2;height:0px;">
       
       <div id="menu" >
          <button type="button" id="1" >左边导航&nbsp;&nbsp;&nbsp;<span style="float:right;margin-right:74px;">></span></button>
            <div id="menu1">
              <a href="userlogon.jsp">用户登录查询</a><br>
              <a href="frame.jsp">报文上传地址</a><br>
              <a href="#">text2</a><br>
              <a href="#">text2</a><br>
            </div>
          <button type="button" id="2">左边导航&nbsp;&nbsp;&nbsp;<span style="float:right;margin-right:74px;">></span></button>
               <div id="menu2">
              <a href="#">text2</a><br>
              <a href="#">text2</a><br>
              <a href="#">text2</a><br>
              <a href="#">text2</a><br>
            </div>
          <button type="button" >左边导航&nbsp;&nbsp;&nbsp;<span style="float:right;margin-right:74px;">></span></button>
          <button type="button" >左边导航&nbsp;&nbsp;&nbsp;<span style="float:right;margin-right:74px;">></span></button>
          <button type="button" >左边导航&nbsp;&nbsp;&nbsp;<span style="float:right;margin-right:74px;">></span></button>
          <button type="button" >左边导航&nbsp;&nbsp;&nbsp;<span style="float:right;margin-right:74px;">></span></button>
        </div>
      
       </div>
 </body>
 </html>