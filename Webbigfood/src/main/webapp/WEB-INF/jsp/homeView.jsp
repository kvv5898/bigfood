<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <style type="text/css">
  <%@include file='styles/home.css' %>
  <%@include file='styles/menu.css' %>
  .header {
  width: 600px;
  height: 120px;
  }
  .page {
  width: 260px;
  height: 260px;
  float: left;
  background-size: contain;
  }
  .content {
  width: 370px;
  height: 530px;
  margin-left: 305px;
  }
  
  .scann {
  width: 250px;
  height: 0px;
  margin-left: 10px;
  }
  
  .footer {
  width: 600px;
  height: 120px;
  }
</style>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  
  <body>
  
  <p>${data.surname}</p>

  <p style="color: red;">${errorString}</p>
  <div class="header"><jsp:include page="_header.jsp"></jsp:include></div>
    <div class="page"><img src="${foto}" width="300" height="200" /></div>
    <div class="scann"><form method="POST">
    <input type="submit" class="sc" name="scann" value="scann" />
    </form></div>
    <div class="content"><form method="POST" action="${pageContext.request.contextPath}/home" name="calc" id="calculator" >
	<table>
	<tr><td><input type="hidden" name="cod_id" value="${cod_id}"/></td></tr>
	<tr><td>ФИО</td></tr>
	<tr>
	<td><input type="text" disabled name="fio" size="16" class="display" placeholder="${fio}"/></td></tr>
	<tr><td>Отдел</td></tr>
	<tr>
	<td><input type="text" disabled name="otdel" size="16" placeholder="${otdel}" class="display"></td></tr>
	<tr><td>Должность</td></tr>
	<tr>
	<td><input type="text" disabled name="position" size="16" placeholder="${position}" class="display"></td></tr>
	<tr><td>Скидка</td></tr>
	<tr>
	<td><input type="text" readonly name="input" size="16" class="display"></td></tr>
	<tr><td>
	<br>
	<input type="reset" class="esc" name="otmena" value="Отмена"/>
	<input type="submit" class="ok" value="Применить" />
	</td>
	</tr>
	<tr>
	<td class="buttons">
		<input type="button" name="seven" value="7" OnClick="calc.input.value += '7'">
		<input type="button" name="eight" value="8" OnClick="calc.input.value += '8'">
		<input type="button" name="nine" value="9" OnClick="calc.input.value += '9'">
		<br>
		<input type="button" name="four" value="4" OnClick="calc.input.value += '4'">
		<input type="button" name="five" value="5" OnClick="calc.input.value += '5'">
		<input type="button" name="six" value="6" OnClick="calc.input.value += '6'">
		<br>
		<input type="button" name="one" value="1" OnClick="calc.input.value += '1'">
		<input type="button" name="two" value="2" OnClick="calc.input.value += '2'">
		<input type="button" name="three" value="3" OnClick="calc.input.value += '3'">
		<br>
		<input type="button" name="zero" value="0" OnClick="calc.input.value += '0'">
		<input type="button" name="clear" value="Очистить" OnClick="calc.input.value = ''">
		<input type="button" name="div"  value="." OnClick="calc.input.value += '.'">
	</td>
	</tr>
	</table>
</form>
</div>
  <div class="footer"><jsp:include page="_footer.jsp"></jsp:include> </div>
  </body>
   
</html>