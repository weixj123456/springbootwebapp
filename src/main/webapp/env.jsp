<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"><font color="blue">测试环境导航</font></h2>
<table align="center" width="95%" border="1">
	<tr height="50px">
		<th align="center"><font color="blue">应用名称</font></th>
		<th align="center"><font color="blue">sit:对应核心(<a href="http://10.10.0.31:9120/cmis" target="_blank">http://10.10.0.31:9120/cmis</a>)</font></th>
		<th align="center"><font color="blue">uat:对应核心(<a href="http://10.10.0.31:9132/cmis" target="_blank">http://10.10.0.31:9132/cmis</a>)</font></th>
		<th align="center"><font color="blue">准生产:对应核心(<a href="http://10.10.0.62:9081/cmis" target="_blank">http://10.10.0.62:9081/cmis</a>)</font></th>
		<th align="center"><font color="blue">uat2:对应核心(<a href="http://10.10.0.31:9138/cmis" target="_blank">http://10.10.0.31:9138/cmis</a>)</font></th>
		<th align="center"><font color="blue">微服务:对应核心(<a href="http://10.10.0.110:9083/cmis" target="_blank">http://10.10.0.110:9083/cmis</a>)</font></th>
	<tr>
	<tr height="50px">
		<td align="center"><font color="blue">iLoan</font></td>
		<td align="center"><a href="http://10.10.0.31:9153/iLoan" target="_blank">http://10.10.0.31:9153/iLoan</a></td>
		<td align="center"><a href="http://10.100.10.5:9081/iLoan" target="_blank">http://10.100.10.5:9081/iLoan</a></td>
<!--    <td align="center"><a href="http://10.10.0.61:9082/iLoan" target="_blank">http://10.10.0.61:9082/iLoan</a></td>  -->
		<td align="center"><a href="http://10.100.10.2:9081/iLoan" target="_blank">http://10.100.10.2:9081/iLoan</a></td>		
		<td align="center"><a href="http://10.100.10.6:9081/iLoan" target="_blank">http://10.100.10.6:9081/iLoan</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">person</font></td>
		<td align="center"><a href="http://10.10.0.31:9156/person" target="_blank">http://10.10.0.31:9156/person</a></td>
		<td align="center"><a href="http://10.100.10.5:9082/person" target="_blank">http://10.100.10.5:9082/person</a></td>
		<td align="center"><a href="http://10.10.0.61:9082/person" target="_blank">http://10.10.0.61:9082/person</a></td>
		<td align="center"><a href="http://10.10.0.230:9082/person" target="_blank">http://10.10.0.230:9082/person</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">weixinServer</font></td>
		<td align="center"><a href="http://10.10.0.31:9159/weixinServer" target="_blank">http://10.10.0.31:9159/weixinServer</a></td>
		<td align="center"><a href="http://10.10.0.31:9086/weixinServer" target="_blank">http://10.10.0.31:9086/weixinServer</a></td>
		<td align="center"><a href="http://10.10.0.61:9086/weixinServer" target="_blank">http://10.10.0.61:9086/weixinServer</a></td>
		<td align="center"><a href="http://10.10.0.230:9086/weixinServer" target="_blank">http://10.10.0.230:9086/weixinServer</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">微信内管（生产）</font></td>
		<td align="center"><a href="http://10.10.0.31:9086/weixinManage/index.html" target="_blank">http://10.10.0.31:9086/weixinManage/index.html</a></td>
		<td align="center"><a href="http://10.10.0.31:9086/weixinManage/index.html" target="_blank">http://10.10.0.31:9086/weixinManage/index.html</a></td>
		<td align="center"><a href="http://10.10.0.31:9086/weixinManage/index.html" target="_blank">http://10.10.0.31:9086/weixinManage/index.html</a></td>
		<td align="center"><a href="http://10.10.0.31:9086/weixinManage/index.html" target="_blank">http://10.10.0.31:9086/weixinManage/index.html</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">taskman</font></td>
		<td align="center"><a href="http://10.10.0.60:9081/taskman" target="_blank">http://10.10.0.60:9081/taskman</a></td>
		<td align="center"><a href="http://10.100.10.5:9084/taskman" target="_blank">http://10.100.10.5:9084/taskman</a></td>
		<td align="center"><a href="http://10.10.0.60:9083/taskman" target="_blank">http://10.10.0.60:9083/taskman</a></td>
		<td align="center"><a href="http://10.10.0.230:9084/taskman" target="_blank">http://10.10.0.230:9084/taskman</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">Gateway</font></td>
		<td align="center"><a href="http://10.100.10.4:9081/Gateway" target="_blank">http://10.100.10.4:9081/Gateway</a></td>
		<td align="center"><a href="http://10.100.10.7:9081/Gateway" target="_blank">http://10.100.10.7:9081/Gateway</a></td>
		<td align="center"><a href="http://10.10.0.61:9083/Gateway" target="_blank">http://10.10.0.61:9083/Gateway</a></td>
		<td align="center"><a href="http://10.10.0.230:9083/Gateway" target="_blank">http://10.10.0.230:9083/Gateway</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">innermanage</font></td>
		<td align="center"><a href="http://10.100.10.3:9083/innermanage" target="_blank">http://10.100.10.3:9083/innermanage</a></td>
     	<td align="center"><a href="http://10.100.10.5:9083/innermanage" target="_blank">http://10.100.10.5:9083/innermanage</a></td> 
<!--	<td align="center"><a href="http://10.10.0.60:9084/innermanage" target="_blank">http://10.10.0.60:9084/innermanage</a></td>  -->
        <td align="center"><a href="http://10.100.10.2:9083/innermanage" target="_blank">http://10.100.10.2:9083/innermanage</a></td>
		<td align="center"><a href="http://10.100.10.6:9083/innermanage" target="_blank">http://10.100.10.6:9083/innermanage</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">控制台</font></td>
		<td align="center"><a href="https://10.10.0.31:9043/ibm/console" target="_blank">https://10.10.0.31:9043/ibm/console</a></td>
		<td align="center"><a href="https://10.10.0.60:9043/ibm/console" target="_blank">https://10.10.0.60:9043/ibm/console</a></td>
		<td align="center"><a href="https://10.10.0.61:9044/ibm/console" target="_blank">https://10.10.0.61:9044/ibm/console</a></td>
		<td align="center"><a href="https://10.10.0.230:9043/ibm/console" target="_blank">https://10.10.0.230:9043/ibm/console</a></td>
	</tr>
	<tr height="50px">
		<td align="center"><font color="blue">测试报文</font></td>
		<td align="center"><a href="http://10.100.10.4:9081/Gateway/test.jsp" target="_blank">http://10.100.10.4:9081/Gateway/test.jsp</a></td>
		<td align="center"><a href="http://10.100.10.7:9081/Gateway/test.jsp" target="_blank">http://10.100.10.7:9081/Gateway/test.jsp</a></td>
<!--  	<td align="center"><a href="http://10.10.0.61:9083/Gateway/test.jsp" target="_blank">http://10.10.0.61:9083/Gateway/test.jsp</a></td> -->
        <td align="center"><a href="http://10.100.10.9:9081/Gateway/test.jsp" target="_blank">http://10.100.10.9:9081/Gateway/test.jsp</a></td>
		<td align="center"><a href="http://10.100.10.8:9081/Gateway/test.jsp" target="_blank">http://10.100.10.8:9081/Gateway/test.jsp</a></td>
	</tr>
	<tr>
		<td colspan="5" style="padding:15px 0 15px 30px;line-height:5px">
			<p>备注：</p>
			<p>1. iLoan、person、weixinServer、Gateway 的 sit、uat 环境对应控制台 https://10.10.0.31:9043/ibm/console</p>
			<p>2. iLoan、person、weixinServer、Gateway 的 准生产 环境对应控制台 https://10.10.0.61:9044/ibm/console</p>
			<p>3. innermanage、taskman 的 sit、uat、准生产 环境对应控制台 https://10.10.0.60:9043/ibm/console</p>
			<p>4. iLoan、person、weixinServer 的 压力测试 环境对应控制台 https://10.10.0.162:9043/ibm/console</p>
			<p>5. innermanage、taskman 的 压力测试 环境对应控制台 https://10.10.0.161:9044/ibm/console</p>
			<p>6. 微信Server环境对应的数据库IP 10.10.0.171 端口50001 数据库 hbxfjr 数据库用户/密码  yxcfc_wx/xfjr2016；</p>
		</td>
		</td>
	</tr>
</table>
</body>
</html>