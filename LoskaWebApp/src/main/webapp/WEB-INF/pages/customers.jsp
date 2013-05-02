<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loska</title>
<link rel="stylesheet" href="css/base.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Asiakkaat</h2>
	<table>
				<tr>
				<th>Nimi</th>
				<th>Y-tunnus</th>
				<th>Laskutusnimi</th>
				<th>Laskutusmaa</th>
				<th></th>
				<th></th>
			</tr>
		<c:forEach items="${customers}" var="i">

			<tr>
				<td>${i.name}</td>
				<td>${i.y_tunnus}</td>
				<td>${i.bill_to.name}</td>
				<td>${i.bill_to.country}</td>
				<td><a href="newInvoiceForCustomer?customer_id=${i.customer_id}">Uusi lasku</a></td>
				<td><a href="editCustomer?customer_id=${i.customer_id}">Muokkaa</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href='<c:url value="/newCustomer"/>'>Luo uusi asiakas.</a>
	<br>
	<a href="<c:url value="/j_spring_security_logout" />">Kirjaudu ulos</a>
</body>
</html>