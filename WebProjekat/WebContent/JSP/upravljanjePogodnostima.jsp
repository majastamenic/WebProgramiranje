<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="POST" action="/OdrzavanjeSadrzajaServlet">
      <table>
      
         <tr>
         <td><b>Pogodnosti</b></td>
            
            
         </tr>  
         <c:forEach items="${listaPogodnosti}" var="pogodnost">    
         <tr>
         <td>${pogodnost.getNaziv()}</td>
           
         </tr>
         </c:forEach>
         
      </table>
      
     
      <table>
         <tr>
            <td>Unesite pogodnost:</td>
            <td><input type="text" name="pogodnost"/></td>
         </tr>    
          <tr>
            <td></td>
            <td><input type="submit" value="Potvrda pogodnosti"></td>
        </tr>
         </table>
   </form>

</body>
</html>