<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://cdn.cnn.com/cnnnext/dam/assets/190423135710-girls-in-car-coupons-travel-widget.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Kreiranje rezervacije</title>
</head>
<body>
<p><br/></p>
   <form method="POST" action="/kreiranjeRezervacijeServlet">
   <div class = "container">
   <div class="col-md-6 col-xl-5 mb-4">
   <h3 style="color: black"><b>Kreiranje rezervacije</b></h3>
   <p><br/></p>
      <table class="table table-light">
                 
         
         <tr>
            <td>Izaberite apartman:</td>
            <td><select name="apartman" id="apartman" class="form-control form-control-sm" >
            <c:forEach items="${listaApartmana}" var="apartmani"> 
            <option>${apartmani.getId()}</option> 
            </c:forEach>  
            </select>
  </td>
         </tr> 
          <tr>
            <td>Datum pocetka rezervacije:</td>


            <td><input type="date" name="datum"  class="form-control form-control-sm">
  </td>

         </tr> 
         
         <tr>
            <td>Broj nocenja:</td>
            <td><input type="text" name="brojNocenja" class="form-control form-control-sm"  pattern="[0-9]+" title="Samo brojevi mogu!" required/></td>

         </tr>
         <tr>
            <td>Poruka:</td>

            <td><input type="text" class="form-control form-control-sm" placeholder="Unesite poruku.." name="poruka"/></td>

         </tr>
         <tr>
            <td></td>
            <td><input type="submit" class="form-control form-control-sm btn btn-primary"  value="Kreiraj"></td>
        </tr>
      </table>
   </form>

</body>
</html>