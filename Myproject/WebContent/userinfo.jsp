<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<p>用户信息如下：
<br>
<% String username=request.getParameter("username");
String age=request.getParameter("age");
%>
<%="用户名为："+username %>
<br>
<%="用户年龄为："+age %>
</body>
</html>