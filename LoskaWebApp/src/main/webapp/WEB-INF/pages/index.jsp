<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Loska</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/960.css">
<link rel="stylesheet" href="css/text.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="container_area" class="container_12">
		<div id="index_links" class="grid_4 prefix_1">
						<h2>Terveltuloa</h2>
			<li><a href='<c:url value="/newInvoice"/>'>Luo uusi lasku</a></li>
			<li><a href='<c:url value="/invoices"/>'>Näytä omat laskut</a></li>
			<li><a href='<c:url value="/newCustomer"/>'>Luo uusi asiakas</a></li>
			<li><a href='<c:url value="/customers"/>'>Näytä omat
					asiakkaat</a></li>
			<li><a href="<c:url value="/j_spring_security_logout" />">Kirjaudu
					ulos</a></li>
		</div>
	</div>
</body>
</html>