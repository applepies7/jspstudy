<%@page import="com.study.util.ProductList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>

<style>
.btn-basic-area { padding-top: 10px; border-top: 1px dashed;  text-align: center; }
.btn-basic-area span {padding: 10px 30px 10px; min-width: 100px;}
</style>

</head>
<body>
<h3>상품 상세보기</h3>
<table class="prod-list">
	<colgroup>
		<col style="width: 25%;">
		<col />
	</colgroup>
	<tbody class="prod-detail">
	
<%
//ProductList <String,ProdVO> 
%>
		<tr>
			<td>제품명</td>			
			<td>삼성전자 DDR4 8G PC4-21300</td>
		</tr>	
		<tr>
			<td>이미지</td>			
			<td><img alt="" src="/study/image/prod/MEM001.jpg"></td>
		</tr>	
		<tr>
			<td>가격</td>			
			<td>40,000원</td>
		</tr>
		<tr>
			<td>등록일</td>			
			<td>2018.03</td>
		</tr>
		<tr>
			<td>상세설명</td>			
			<td></td>
		</tr>
	</tbody>

</table>

<div class="btn-basic-area" >
	<span><a href="/study/index.jsp" >Home</a> </span>
	<span><a href="prodList.jsp" >상품목록</a> </span>
</div>


</body>
</html>
