<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <style type="text/css">
  <%@include file='styles/menu.css' %>
</style>
     <meta charset="UTF-8">
     <title>Authorization History</title>
  </head>
  
  <body>
  <jsp:include page="_header.jsp"></jsp:include>
	<br>
	<p>Активных сессии: ${active_sessions}</p>
	<p>Активных пользователи: ${active_users}</p>
	<br>
	<table align="center" border="1">
	<th>Id</th>
	<th>Начало сессии</th>
	<th>Конец сессии</th>
	<th>IP</th>
	<th>HOST</th>
	<th>GETWAY</th>
	<th>Пользователь</th>
	<th>Пароль</th>
	<th>ID сессии</th>
	<th>Статус</th>
	<c:forEach var="a" items="${auth}">
	<tr>
	<td>${a.id()}</td>
	
	<td>${a.date_start()}</td>
	<td>${a.date_end()}</td>
	
	<td>${a.ip}</td>
	<td>${a.host}</td>
	<td>${a.getway}</td>
	
	<td>${a.user_in}</td>
	
	<td>${a.pass_in}</td>
	
	<td>${a.session}</td>
	
	<td>${a.status}</td>
	</tr>
	</c:forEach>
	</table>
<jsp:include page="_footer.jsp"></jsp:include>
  </body>
   
</html>