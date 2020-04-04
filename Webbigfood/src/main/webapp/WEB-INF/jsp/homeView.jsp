<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
    
    
      <h3>Текущая сессия - ${session}</h3> <a href="${pageContext.request.contextPath}/exit">Выход</a>
      
         <table border="2">
   <th>Данные подключения</th>
   <th>Параметры</th>
   
   
       <c:forEach items="${userinfo}" var="userinfo" >
          <tr>
          <td><p>Дата создания аккаунта</p> </td>
          <td><p>${userinfo.date}</p> </td>
          </tr>
          <tr>
          <td><p>Имя</p> </td>
          <td><p>${userinfo.surname}</p> </td>
          </tr>
          <tr>
          <td><p>Фамилия</p> </td>
          <td><p>${userinfo.first_name}</p> </td>
          </tr>
          <tr>
          <td><p>Отчество</p> </td>
          <td><p>${userinfo.otchestvo}</p> </td>
          </tr>
          <tr>
          <td><p>Отдел</p> </td>
          <td><p>${userinfo.otdel}</p> </td>
          </tr>
          <tr>
          <td><p>Контактынй телефон</p> </td>
          <td><p>${userinfo.tel}</p> </td>
          </tr>
          <tr>
          <td><p>Почтовый ящик</p> </td>
          <td><p>${userinfo.email}</p> </td>
          </tr>
          <tr>
          <td><p>user_name</p> </td>
          <td><p>${userinfo.user_name}</p> </td>
          </tr>
          <tr>
          <td><p>PASSWORD</p> </td>
          <td><p>${userinfo.password}</p> </td>
          </tr>
          <tr>
          <td><p>Прова</p> </td>
          <td><p>${userinfo.rule}</p> </td>
          </tr>       
       </c:forEach>
  </table>
 
  </body>
</html>