<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 <fmt:setLocale value="" scope = "session"/>
<%=session.getAttribute("lang")
%>


    <% 
    response.sendRedirect(request.getContextPath() + "/index.jsp");
    %>