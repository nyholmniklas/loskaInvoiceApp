<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loska</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/960.css">
<link rel="stylesheet" href="css/text.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container_area" class="container_12">
		<div class="grid_5 prefix_1">
			<h2>Asiakkaat</h2>
			<table id="hor-zebra">
				<tr>
					<th>Nimi</th>
					<th>Y-tunnus</th>
					<th>Laskutusnimi</th>
					<th>Laskutusmaa</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${customers}" var="i" varStatus="loopStatus">
					<tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
						<td>${i.name}</td>
						<td>${i.y_tunnus}</td>
						<td>${i.bill_to.name}</td>
						<td>${i.bill_to.country}</td>
						<td><a href='<c:url value="/newInvoiceForCustomer?customer_id=${i.customer_id}"/>'><input
								class="myButton" type="button" value="Uusi lasku" /></a></td>
						<td><a href='<c:url value="editCustomer?customer_id=${i.customer_id}"/>'><input
								class="myButton" type="button" value="Muokkaa" /></a></td>
					</tr>
				</c:forEach>
			</table>
			<a href='<c:url value="/newCustomer"/>'>Luo uusi asiakas.</a>
		</div>
	</div>
</body>
</html>