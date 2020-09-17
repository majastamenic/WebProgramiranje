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
<script type="text/javascript" src="${contextPath}/JS/bootstrap.min.js"></script>
</head>
<body>
	<div class="text-right">
		<a href="LogOutServlet" class="btn btn-dark">Logout</a><br/>
	</div>
	<h3>  Dobrodosli, ${ulogovaniKorisnik.korisnickoIme} <br/></h3>
	<p><br/></p>
	
	<table class="table table-hover table-light">
	<tbody>
	<tr>
		<td></td>
		<td><a href="IzmenaPodatakaServlet" class="btn btn-info"> Izmeni podatke</a></td>
		<td><a href="/PregledSvihKorisnikaServlet" class="btn btn-info"> Pregled svih korisnika</a></td>
		<td><a href="/DodajApartmanServlet" class="btn btn-info"> Dodaj apartman</a></td>
	</tr>
	<tr></tr>
	</tbody>
	</table>
	<table class="table table-hover table-light">
	<tbody>
	<tr>	
		<td></td>
		<td><a href="/PrikaziApartmanServlet" class="btn btn-info"> Pregled apartmana</a></td>
		<td><a href="/OdrzavanjeSadrzajaServlet" class="btn btn-info"> Odrzavanje sadrzaja</a></td>
		<td><a href="/pregledSvihRezervacijaServlet" class="btn btn-info"> Pregled rezervacija</a></td>
		<td><a href="/PregledKomentaraServlet" class="btn btn-info"> Pregled svih komentara</a></td>
	</tr>
	</tbody>
	</table>

</body>
</html>