<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int para=Integer.parseInt(request.getParameter("para"));
switch(para){
    case 1:
    %>
        <script language="javascript">
        alert("用户信息添加成功!");
        window.location.href="user.do?action=userQuery";
        </script>  
    <%  break;
    case 2:
    %>
        <script language="javascript">
        alert("用户权限设置成功!");
        window.location.href="user.do?action=userQuery";
        </script>          
    <%  break;
    case 3:
    %>
        <script language="javascript">
        alert("用户信息删除成功!");
        window.location.href="user.do?action=userQuery";
        </script>          
    <%  break;
    case 4:
    %>
    <script language="javascript">
        alert("用户密码修改成功!");
        window.location.href="main.jsp";
        </script>
    <%
}%>

</body>
</html>