<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<p><br/></p>
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

</head>
<body>

<form method="POST" action="PrikaziApartmanServlet">
	<div class = "container">
		<div class="col-md-4">
		<h3 style="color: black"><b>Apartmani</b></h3>
		</div>
		<p><br/></p>
		<a href="SortiraniApartmaniRastuceServlet" class="btn btn-secondary">Sortiraj apartmane po ceni rastuce</a>
		<a href="SortiraniApartmaniOpadajuceServlet" class="btn btn-secondary">Sortiraj apartmane po ceni opadajuce</a>
		<div class="text-right">
		<a href="VisestrukaPretragaServlet" class="btn btn-primary">Pretraga</a>
		<a href="DodajApartmanServlet" class="btn btn-success">Dodaj apartman</a>
		</div>
      <table class="table table-boardered table-striped table-hover table-light">
       <thead class="thead-dark">
         <tr>

            <th>Tip apartmana: </th>
            <th>Broj soba: </th>
            <th>Broj gostiju: </th>
            <th>Lokacija: </th>
            <th>Domacin: </th>
            <th>Status: </th>
            <th>Cena po noci: </th>
            <th class="text-center">Akcije </th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${mapaApartmana.values()}" var="apartman">   
         <tr>
         
            <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td>${apartman.getStatus()}</td>
            <td>${apartman.getCenaPoNoci()}</td>
            <td class="text-center">

            	<a href='/IzmenaApartmanaServlet?idApartmana=${apartman.getId()} ' class="btn btn-warning">Izmeni</a>
            	<a href="BrisanjeApartmanaServlet?id=${apartman.id} " class="btn btn-danger">Obrisi</a>

            </td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
      </div>
</form>
</body>
</html>