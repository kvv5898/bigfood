<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <style type="text/css">
  <%@include file='styles/menu.css' %>
   TABLE {
    table-layout: fixed; /* Ячейки фиксированной ширины */
   }
  
  .header {
  width: 600px;
  height: 90px;
  <!--background: #CCA69E;-->
  }
  .page {
  width: 300px;
  height: 200px;
  float: left;
  background-size: contain;
  <!--background: red;-->
  }
  .content {
  width: 300px;
  height: 200px;
  margin-left: 300px;
  <!--background: green;-->
  }
  .stat {
  width: 600px;
  float: left;
  margin-left: 300px;
  <!--background: blue;-->
  }
  .footer {
  width: 600px;
  height: 50px;
  
  <!--background: maroon;-->
  }
</style>
     <meta charset="UTF-8">
     <title>Statistics</title>
  </head>
  
  <body>
  <div class="header"><jsp:include page="_header.jsp"></jsp:include></div>
    <div class="page"><img src="${foto}" width="300" height="200"/></div>
     <p style="color: red;">${error}</p>
    <div class="content"><form method="POST" action="statistics">
	<br>
	<input type="text" name="input" placeholder="Введите ID">
	<input type="submit" value="Применить" />
	<table width="100%" cellspacing="0" cellpadding="4" border="1">
	<tr><td>ID</td>
	<td>${cod_id}</td></tr>
	<tr><td>ФИО</td>
	<td>${fio}</td></tr>
	<tr><td>Отдел</td>
	<td>${otdel}</td></tr>
	<tr><td>Должность</td>
	<td>${position}</td>
	</tr>
	</table>
	<br>
</form>
</form>
</div>
<div class="stat"><table border="0">
	<table border="3">
	<th>Дата операции</th>
	<th>Скидка</th>
	<th>Результат</th>
	<c:forEach var="stat" items="${idstat}">
	<tr>
	<td>${stat.date}</td>
	<td>${stat.discount}</td>
	<td>${stat.total}</td>
	</tr>
	</c:forEach>
	</table>
</div>
  <div class="footer"><jsp:include page="_footer.jsp"></jsp:include> </div>
  </body>
   
</html>