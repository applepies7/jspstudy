<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <fmt:setBundle basename="resource.message" var ="bundle"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 수업이 조아~</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">

</head>
<body>

	<div class="container">
		<jsp:include page="/inc/top.jsp" />
		<jsp:include page="/inc/left.jsp" />

		<!-- main menu -->
		<div id="main">
<h3><fmt:message bundle="${bundle}" key="front.welcome"/></h3>
<a href="03/regist.jsp">회원가입</a><br><hr>
<a href="04/header.jsp">헤더 정보</a><br><hr>
<%
/* 	String idchk = (String)session.getAttribute("SES_ID");
	if(idchk != null){
		out.println("<h3>"+ idchk + "님  어서오세요</h3><br>");
	}else{
		out.println("<a href='07/regist.jsp'>/07/regist.jsp로 돌아가기</a>");
	}
 */%>

		
		</div>
		<!-- footer menu -->
		<jsp:include page="/inc/footer.jsp" />


	</div>

</body>
</html>