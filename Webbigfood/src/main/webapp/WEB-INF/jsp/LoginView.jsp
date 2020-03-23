<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
 
      <h3>Авторизация</h3>
 
      <p style="color: red;">${errorMessage}</p>
 
      <form >
         <table >
            <tr>
               <td>Имя пользователя</td>
               <td><input type="text" name="userName" /> </td>
            </tr>
            <tr>
               <td>Пароль</td>
               <td><input type="password" name="password" /> </td>
            </tr>
          
            <tr>
               <td colspan ="2">
                  <input type="submit" value= "Применить" />
                  <a href="/">Назад</a>
               </td>
            </tr>
         </table>
      </form> 
      
   </body>
</html>