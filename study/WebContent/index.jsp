<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 수업이 조아~</title>
</head>
<body>
<h3>JSP수업 조앙~</h3>
<a href="03/regist.jsp">회원가입</a><br><hr>
<a href="03/q.jsp">두수 사이의 짝수 합</a><br><hr>
<a href="04/header.jsp">헤더 정보</a><br><hr>
<%
	String idchk = (String)session.getAttribute("SES_ID");
	if(idchk != null){
		out.println("<h3>"+ idchk + "님  어서오세요</h3><br>");
		
	}else{
		out.println("<a href='07/regist.jsp'>/07/regist.jsp로 돌아가기</a>");
	}
		
		
%>

</body>
</html>