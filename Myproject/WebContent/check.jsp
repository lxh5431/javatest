<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进入邮箱</title>
</head>
<body>
<%
  String name=null;
name=request.getParameter("username");
if(name==null)
	session.setAttribute("username", name);
   %>
 <a href="login.jsp">登陆</a>&nbsp;&nbsp;&nbsp;
 <a href="logout.jsp">注销</a>&nbsp;&nbsp;&nbsp;
 <p>当前用户为：<%=name %></p>
 <p>邮箱中共有50封邮件</p>
</body>
</html>