<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Izmena apartmana</title>
</head>
<body>
	<h1 style="color: black"><b>Izmena apartmana</b></h1>
   <form method="POST" action="/IzmenaApartmanaServlet">
      <table>
                  <tr>
            <td>Broj soba:</td>
            <td><input type="text" name="brojSoba" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>    
         <tr>
            <td>Broj gostiju:</td>
            <td><input type="text" name="brojGostiju" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>  
         <tr>
            <td>Tip apartmana:</td>
            <td><select name="tip" id="tip">
  <option value="apartman">Apartman</option>
  <option value="soba">Soba</option>
  
  
</select></td>
         </tr> 
         
         
         <tr>
            <td>Lokacija:</td>
            <td><select name="lokacija" id="lokacija">
            <c:forEach items="${listaLokacija}" var="lokacija"> 
            <option value="lokacija">${lokacija.getId()}</option> 
            </c:forEach>  
            </select>
  </td>
         </tr> 
          <tr>
            <td>Pogodnosti:</td>
            <td><select name="Pogodnosti" id="Pogodnosti">
            <c:forEach items="${listaPogodnosti}" var="Pogodnosti"> 
            <option value="Pogodnosti">${Pogodnosti.getNaziv()}</option> 
            </c:forEach>  
            </select>
  </td>
         </tr> 
         
         <tr>
            <td>Cena po noci:</td>
            <td><input type="text" name="cenaPoNoci" pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>
         </tr>
         <tr>
            <td></td>
            <td><input type="submit" value="Izmeni"></td>
        </tr>
      </table>
   </form>
</body>
</html>