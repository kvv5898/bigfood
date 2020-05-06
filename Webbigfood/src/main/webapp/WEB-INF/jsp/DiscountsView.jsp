<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Discounts View</title>
<style type="text/css">
<%@include file='styles/menu.css' %>
</style>
</head>
<body>
     <jsp:include page="_header.jsp"></jsp:include>
	<p>Информация о скидках</p>
	<br>
	<a href="${pageContext.request.contextPath}/home">На главную</a>
	<br>
	<a href="${pageContext.request.contextPath}/info">Назад</a>
	<p style="color: red;">${error}</p>
	<table border="1">
		<th>ID</th>
		<th>Код пропуска</th>
		<th>Фото</th>
		<th>Фамилия</th>
		<th>Имя</th>
		<th>Отчество</th>
		<th>Отдел</th>
		<th>Должность</th>
		<th>Скидка</th>
		 <c:forEach items="${discounts}" var="discount" >
			<tr>
				<td>${discount.id()}</td>
				<td>${discount.cod_id()}</td>
				<td><img src="${discount.foto}" width="30" height="20"/></td>
				<td>${discount.surname}</td>
				<td>${discount.first_name}</td>
				<td>${discount.otchestvo}</td>
				<td>${discount.otdel}</td>
				<td>${discount.position}</td>
				<td>${discount.discount}</td>
			</tr>
		</c:forEach>
	</table>

	<div class="footer"><jsp:include page="_footer.jsp"></jsp:include> </div>
</body>
</html>