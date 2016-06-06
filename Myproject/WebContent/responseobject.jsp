<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str=null;
str=request.getParameter("username");
if(str==null){
	str="";
	
}
byte b[]=str.getBytes("UTF-8");
str=new String(b);
if(str.equals("")){
	response.sendRedirect("responseform.jsp");
}
else{
	out.println("欢迎来到本页面");
	out.println(str);
}
%>
</body>
</html>