<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History discounts</title>
<style type="text/css">
<%@include file='styles/menu.css' %>
</style>
</head>
<body>
     <jsp:include page="_header.jsp"></jsp:include>
	<p>Подробная Информация о скидках</p>
	<br>
	<a href="${pageContext.request.contextPath}/home">На главную</a>
	<br>
	<a href="${pageContext.request.contextPath}/info">Назад</a>
	<p style="color: red;">${error}</p>
	<table border="1">
		<th>ID</th>
		<th>Код пропуска</th>
		<th>Дата</th>
		<th>Разавая скидка</th>
		<th>Итоговая скидка</th>
		 <c:forEach items="${history}" var="his" >
			<tr>
				<td>${his.id()}</td>
				<td>${his.cod_id()}</td>
				<td>${his.date}</td>
				<td>${his.discount}</td>
				<td>${his.total}</td>
			</tr>
		</c:forEach>
	</table>

	<div class="footer"><jsp:include page="_footer.jsp"></jsp:include> </div>
</body>
</html>