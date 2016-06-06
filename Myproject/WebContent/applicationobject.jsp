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
   String count=(String)application.getAttribute("count");
if(count==null){
	count="1";
}else{
	count=Integer.parseInt(count)+1+"";
	
}
application.setAttribute("count", count);%>
<%="<h1>到目前为止，访问该网站的人数为："+count+"</h1><br>" %>
</body>
</html>