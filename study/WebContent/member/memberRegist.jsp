<%@page import="com.study.member.dao.MemberDaoOracle"%>
<%@page import="com.study.member.dao.IMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/common_header.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/top_menu.jsp"%>
<div class="container">
<jsp:useBean id="member" class="com.study.member.vo.MemberVO"/>
<jsp:setProperty property="*" name="member"/>
<%
request.setCharacterEncoding("UTF-8");
IMemberDao memberDao = new MemberDaoOracle();
int res = memberDao.insertMember(member);
%>

<div>
<%=res %>
</div>
</div>
</body>
</html>