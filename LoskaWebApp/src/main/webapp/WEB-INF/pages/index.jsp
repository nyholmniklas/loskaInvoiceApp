<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loska</title>
<link rel="stylesheet" href="css/base.css">
<!-- <link rel="stylesheet" href="css/skeleton.css"> -->
<!-- <link rel="stylesheet" href="css/layout.css"> -->
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Tervetuloa</h2>
<!-- 	<div class="container"> -->
		<div class="three columns sidebar">
<!-- 			<nav> -->
			<ul>
				<li><a href='<c:url value="/newInvoice"/>'>Luo uusi lasku</a></li>
				<li><a href='<c:url value="/invoices"/>'>Näytä omat laskut</a></li>
				<li><a href="<c:url value="/j_spring_security_logout" />">Kirjaudu
						ulos</a></li>
			</ul>
<!-- 			</nav> -->
		</div>
<!-- 	</div> -->
</body>
</html>