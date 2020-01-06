<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
	
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/themes/default/easyui.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/themes/icon.css"/>">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript">
var util = {
        basePath : function basePath() {// 返回项目路径
            var context = document.getElementsByTagName('base')[0].href;
            return context;
        },
        file_upload : function file_upload() {

            // 创建表单数据对象
            var obj = new FormData();

            // 获取文件框中的数据
            var file1 = document.getElementById("file3").files[0];
            var file2 = document.getElementById("file4").files[0];

            // 将文件数据添加至表单数据对象中
            obj.append("file3", file3);
            obj.append("file4", file4);

            console.log("请求参数---》》》" + obj);

            // 使用ajax异步文件上传
            $.ajax({
                url : util.basePath() + 'secure/upload-file/uploadDemo',
                type : 'POST',
                data : obj,
                contentType : false,
                processData : false,
                mimeType : 'multipart/form-data',
                success : function(data) {

                    console.log(data);
                }
            })
        }

    }





function formSubmit()
  {
  document.getElementById("myForm").submit();
  
  }

function getValue()
{
var x=document.getElementById("myHeader")
alert(x.innerHTML)
}

</script>
<title>渠道测试平台</title>
</head>
<body>

<!--  <h1 class="page-title" style="text-align: center;">用户管理</h1>	  -->
	<header id="head" class="secondary" style="text-align: center;"></header>
	
<h1 class="myHeader" id="myHeader" onclick="getValue()" style="text-align: center;">渠道进件测试平台</h1>
<!--  <p>欢迎到此！！！!!</p> -->


<form id="myForm" action="<%=request.getContextPath()%>/qudao/jinjiantest.do" method="POST">
<!--   客户名称       : <input type="text"  name="custname" size="40"><br /> <br />
                  用户身份证: <input type="text"  name="idno" size="40"><br />  <br />
                 手机号码: <input type="text"   name="phoneno" size="20"><br />  <br />   -->
                  客户名称: <input id="custname" type="text" style="WIDTH: 230px; HEIGHT: 30px" name="custname" value="123" maxlength="15" size="40"><br /> <br />
                  用户身份证: <input id="idno" type="text"  style=" WIDTH: 230px; HEIGHT: 30px" name="idno" value="456" maxlength="30" size="40"><br />  <br />
                 手机号码: <input id="phoneno" type="text" style=" WIDTH: 230px; HEIGHT: 30px" name="phoneno" value="15021293987" maxlength="20" size="20"><br />  <br />                                                 
                 渠道编号： <input id="channelid" type="text" placeholder="请输入渠道编号" style=" WIDTH: 230px; HEIGHT: 30px" name="channelid" value="" maxlength="20" size="20">
       <br />  <br />          
       <input type="submit"  value="单用户测试提交">
 <!--  <input type="button" onclick="formSubmit()" value="单用户测试提交">--> 
</form><br /><br />

<h1 class="myHeader" id="myHeader"  style="text-align: center;">请上传该渠道所有报文文件 </h1><br/>
<form id="uploadfile" action="<%=request.getContextPath()%>/file/uploadxml.do" method="POST">                
                  渠道编码: <input id="code" type="text" style="WIDTH: 230px; HEIGHT: 30px" name="code" maxlength="20" size="40"><br /> <br />                      
    XML文件名称: <input id="filename" type="text" style="WIDTH: 230px; HEIGHT: 30px" name="filename" maxlength="20" size="40"><br /> <br />
     <input type="submit"  value="报文存储">
</form><br /><br />
 
<!-- 使用post表单提交，设置类型为：multipart/form-data -->
    <form action="<%=basePath%>secure/upload-file/uploadDemo"
        enctype="multipart/form-data" method="POST">
        <h2>基本form表单上传文件</h2>
        文件一：<input type="file" name="file1" /><br /><br /> <br /> 
        文件二：<input type="file" name="file2" /><br /><br /><br />
    <input type="submit" value="提交" />
    </form>

<!-- 使用ajax上传文件方式
    <div>
        <h3>ajax上传文件</h3>
        文件三：<input type="file" id="file3" /><br /><br /><br /> 文件四：<input type="file"
            id="file4" /><br /> <br /><input type="button"
            onclick="util.file_upload()" value="上传提交">
    </div>   
    
    -->

    <!-- 循环遍历出图片
    <c:forEach items="${fileUrlList}" var="item">
        <img style="width:200px;height:200px"  src="http://localhost:8080/${item}">
    </c:forEach>

 -->


<form id="patchapply" action="<%=request.getContextPath()%>/demo//applypatch.do" method="POST">
                  进件启始编号(数字): <input id="num" type="text" style="WIDTH: 230px; HEIGHT: 30px" name="num" maxlength="20" size="40"><br /> <br />                      
<!--   XML文件名称: <input id="filename" type="text" style="WIDTH: 230px; HEIGHT: 30px" name="filename" maxlength="20" size="40"><br /> <br />   -->
     <input type="submit"  value="批量进件">
</form><br /><br />


 <!--
<button id="btn_uploadfile1" action="<%=request.getContextPath() %>/file/uploadfile.do" type="button" class="btn btn-default" method="post">
<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;文件上传
</button>  <br /> <br />                  					
<br /><br />
 <form action="<%=request.getContextPath() %>/uploadFile/upload.do" method="post" enctype="multipart/form-data">
  <label>用户名：</label><input type="text" name="name"><br>
  <label>密码：</label><input type="password" name="pwd"><br>
  <label>上传头像：</label><input type="file" name="file"><br>
  <input type="submit"  value="图片上传">
  </form>
-->

</body>
</html>