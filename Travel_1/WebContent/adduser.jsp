<%@page import="vo.UserVO"%>
<%@page import="service.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adduser.jsp</title>
</head>
<body>
<h3>회원가입 처리</h3>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String role = request.getParameter("role");
	
	UserDao dao = new UserDao();
	UserService service = new UserServiceImpl(dao);
	UserVO vo = new UserVO();
	vo .setId(id);
	vo.setName(name);
	vo.setPassword(pw);
	vo.setRole(role);
	
	int c = service.insertUser(vo);


%>

입력정보 : <%= id %> / <%= pw %> / <%= name %> / <%= role %><br>

<%
	if(c==0) {
%>
		<h4>회원가입 실패</h4>
<%
	} 
%>

<a href="user.html">첫 화면으로</a><br>
<a href="Travel_main.html">메인으로</a>
</body>
</html>