<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<p><br/></p>
<div class ="row">
	<div class="col-md-4">
		<h3>Pregled apartmana</h3>
	</div>
	<div class="col-md-4">
		<form action="PrikaziApartmanServlet" method="get">
			<input type="text" name="pretraga" class = "form-control" placeholder="Pretraga...">
			<input type="submit" value="Pretraga">
			<a href="DodajApartmanServlet" class="btn btn-primary">Dodaj apartman</a>
			<a href="VisestrukaPretragaServlet" class="btn btn-primary">Visestruka pretraga</a>
			<a href="SortiraniApartmaniRastuceServlet">Sortiraj apartmane po ceni rastuce</a>
			<a href="SortiraniApartmaniOpadajuceServlet">Sortiraj apartmane po ceni opadajuce</a>
		</form>
	</div>
</div>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<form method="POST" action="PrikaziApartmanServlet">
      <table class="table table-boardered table-striped table-hover">
      <thead>
         <tr>
         
            <td>Tip apartmana: </td>
            <td>Broj soba: </td>
            <td>Broj gostiju: </td>
            <td>Lokacija: </td>
            <td>Domacin: </td>
            <td>Cena po noci: </td>
            <th class="text-center">Akcije </th>
         </tr>  
         </thead>
         <tbody>
         <c:forEach items="${mapaApartmana}" var="apartman">   
         <tr>
         
            <td>${apartman.getTip()}</td>
            <td>${apartman.getBrojSoba()}</td>
            <td>${apartman.getBrojGostiju()}</td>
            <td>${apartman.getLokacija().getId()}</td>
            <td>${apartman.getDomacin().getId()}</td>
            <td>${apartman.getCenaPoNoci()}</td>
            <td class="text-center">
            	<a href='/IzmenaApartmanaServlet?id=${apartman.id} ' class="btn btn-warning">Izmeni</a>
            	<a href="BrisanjeApartmanaServlet?id=${apartman.id} " class="btn btn-danger">Obrisi</a>
            </td>
         </tr>
         </c:forEach>
         </tbody>
      </table>
      
</form>
</body>
</html>