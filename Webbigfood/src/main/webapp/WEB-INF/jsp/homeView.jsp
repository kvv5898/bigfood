<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <style type="text/css">
  <%@include file='styles/home.css' %>
  <%@include file='styles/menu.css' %>
</style>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <jsp:include page="_header.jsp"></jsp:include>
  <body>
    <center><form name="calc" id="calculator" >
	<table >
	<tr><td><input type="text" disabled name="fio" size="16" class="display" placeholder="ФИО"/></td></tr>
	<tr><td><input type="text" disabled name="podr" size="16" placeholder="Подразделение" class="display"></td></tr>
	<tr><td><input type="text" disabled name="dol" size="16" placeholder="Должность" class="display"></td></tr>
	<tr><td><input type="text" readonly name="input" size="16" placeholder="Скидка" class="display"></td></tr>
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
		<input type="button" name="div"  value="," OnClick="calc.input.value += ','">
	</td>
	</tr>
	</table>
</form></center>
  <jsp:include page="_footer.jsp"></jsp:include>      
  </body>
</html>