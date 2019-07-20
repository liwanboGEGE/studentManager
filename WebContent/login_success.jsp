<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.hrbu.vo.*" %>
    <% String username = (String) session.getAttribute("username");%>
    <% List<User> userList = (ArrayList<User>)session.getAttribute("userList");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
登录成功！欢迎<%=username%>进入学生管理系统
<br/>
所有用户信息如下：
<%
	for(int i=0;i<userList.size();i++){
		User user = userList.get(i);
	%>
	<p>用户名：<%=user.getUsername() %>
	年龄：<%=user.getage() %></p>
	<%
	}
%>
	
</body>
</html>