<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBean Test</title>
</head>
<body>
<p>输入用户信息：
<br>
<jsp:useBean id="user" class="jsp.User" scope="page"/>
<jsp:setProperty property="username" name="user" value="jack"/>
<jsp:setProperty property="age" name="user" value="27"/>
用户名：<jsp:getProperty property="username" name="user"/>
<br>
年龄：<jsp:getProperty property="age" name="user"/>
</body>
</html>