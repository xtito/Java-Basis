<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@include file="/inc.jsp" %>
<!DOCTYPE html>
<html lang="en">

<%--
  
  Created by User: Zy
  Created Date: 2017/10/9 11:25
--%>

<head>
    <meta charset="UTF-8">
    <title>列表页面</title>
</head>

<body>

    <h1>登录成功，欢迎您 <shiro:principal/> 访问本页面</h1>

    <shiro:hasRole name="admin">
        <br/>
        <h1><a href="${ctx}/jsp/admin.jsp">Admin Page</a></h1>
    </shiro:hasRole>

    <shiro:hasRole name="user">
        <br/>
        <h1><a href="${ctx}/jsp/user.jsp">User Page</a></h1>
    </shiro:hasRole>

    <br/>
    <h2><a href="${ctx}/loginCtrl/testShiroAnnotation">Test ShiroAnnotation</a></h2>

    <br/>
    <h4><a href="${ctx}/loginCtrl/loginOut">登出</a></h4>

</body>

</html>