<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Pocetna strana</title>
</head>
<body>
	<h3 style="color: black"><b>Pocetna strana</b></h3>
	<p><br/></p>
	<p>  <a href= "/PrikaziApartmanGostNeulogovaniServlet"> Prikazi sve aktivne apartmane, pretraga, sortiranje.</a></p><br/>
	<p>  <a href= "/PregledKomentaraGostijuNaApartmaneServlet"> Pregled komentara gostiju.</a></p><br/>
</body>
</html>