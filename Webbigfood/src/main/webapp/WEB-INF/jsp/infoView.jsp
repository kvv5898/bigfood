<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <style type="text/css">
  <%@include file='styles/menu.css' %>
  </style>
     <meta charset="UTF-8">
     <title>Info</title>
     <jsp:include page="_header.jsp"></jsp:include>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/home">Главная</a>
  <br>
<ul>               
    <li><a href="${pageContext.request.contextPath}/techinfo">Информация о подключении</a></li>
    <li><a href="${pageContext.request.contextPath}/discounts">Итоговая информация по скидкам</a></li>
    <li><a href="${pageContext.request.contextPath}/hdiscounts">Подробная история по операциям</a></li>
    <li><a href="${pageContext.request.contextPath}/statistics">Статистика по коду</a></li>
         
</ul>
<div class="footer"><jsp:include page="_footer.jsp"></jsp:include> </div>
</body>
</html>