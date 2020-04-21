<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <html>
  <head>
   </html>
<body>
  
<table border="3" align="center">
   <th width="150">
   
   <ul id="menu">
        <li>
            <a href="#">Меню</a>
               <ul class="sub-menu">
                   <li><a href="${pageContext.request.contextPath}/exit">Выход</a></li>
                   <li><a href="${pageContext.request.contextPath}/techinfo">Информация по подключению</a></li>
               </ul>
        </li>
       
</ul>
    </th>
   <th width="800">Система</th>
   <th width="150">Логотип</th>
</table>
</body>
</html>