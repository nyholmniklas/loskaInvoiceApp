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


	<div class="container_12" id="container_area">
			<div class="grid_5 prefix_1">
				<h2>Laskut</h2>
				<table id="hor-zebra">
					<tr>
						<th>Toimitusnimi</th>
						<th>Laskutusnimi</th>
						<th>Laskupvm</th>
						<th>Eräpvm</th>
						<th>Saate</th>
					</tr>
					<c:forEach items="${invoices}" var="i" varStatus="loopStatus">
						<tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
							<td>${i.ship_to.name}</td>
							<td>${i.bill_to.name}</td>
							<td>${i.date}</td>
							<td>${i.due_date}</td>
							<td>${i.description}</td>
						</tr>
					</c:forEach>
				</table>
				<a href='<c:url value="/newInvoice"/>'>Luo uusi lasku.</a>
			</div>
	</div>
</body>
</html>