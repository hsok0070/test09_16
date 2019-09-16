<%@page import="vo.UserVO"%>
<%@page import="dao.UserDao"%>
<%@page import="service.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<h3> login 처리 </h3>

<!--  자바코드영역 -->
<%
	String id = request.getParameter("id");
String pw = request.getParameter("pw");

UserDao dao = new UserDao();
UserService service = new UserServiceImpl(dao);

UserVO vo = new UserVO();
vo.setId(id);
vo.setPassword(pw);

UserVO data = service.LoginUser(vo);
%>




로그인 정보: <%= data %>

<%= id %> / <%= pw %><br>
<a href="login.html">첫 화면으로</a>
<a href="Travel_main.html">메인으로</a>
</body>
</html>