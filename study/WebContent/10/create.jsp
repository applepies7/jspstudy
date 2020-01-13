<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 10/ create.jsp</title>
</head>
<body>

<%
Cookie cookie = new Cookie("love","");
cookie.setValue(URLEncoder.encode("밀키스 love","utf-8"));

//쿠키를 클라이언트로 보내기

cookie.setPath("/");
cookie.setDomain("milkis.com");


response.addCookie(cookie);
%>
<br><br>
<a href="view.jsp">쿠키</a><br><br><br>
<a href="../09/view.jsp">09/쿠키</a>
</body>
</html>