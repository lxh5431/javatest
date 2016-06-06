<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>taglib</title>
</head>
<body>
<% 
System.out.println("跳转前");
%>
<jsp:forward page="Myjsp.jsp"></jsp:forward>
<% 
System.out.println("跳转后");
%>
</body>
</html>