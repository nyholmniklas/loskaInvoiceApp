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
	<h2>Laskut</h2>
	<!-- 	<br> -->
	<table>
		<c:forEach items="${invoices}" var="i">
			<tr>
				<td>${i.invoice_id}</td>
				<td>${i.bill_to.name2}</td>
				<td>${i.date}</td>
				<td>${i.description}</td>
<%-- 				<td>${i.buyer_id }</td> --%>
			</tr>
			<!-- 			<br> -->
		</c:forEach>
	</table>
	<br>
	<a href='<c:url value="/newInvoice"/>'>Luo uusi lasku.</a>
	<br>
	<a href="<c:url value="/j_spring_security_logout" />">Kirjaudu ulos</a>
</body>
</html>