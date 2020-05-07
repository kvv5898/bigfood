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
    <li><a href="${pageContext.request.contextPath}/techinfo">Информация о пользователе</a></li>
    <li><a href="${pageContext.request.contextPath}/auth">Информация о подключениях</a></li>
    <li><a href="${pageContext.request.contextPath}/discounts">Скидки</a></li>
    <li><a href="${pageContext.request.contextPath}/hdiscounts">История по операциям</a></li>
    <li><a href="${pageContext.request.contextPath}/statistics">Поиск по коду</a></li>
         
</ul>
<div class="footer"><jsp:include page="_footer.jsp"></jsp:include> </div>
</body>
</html>