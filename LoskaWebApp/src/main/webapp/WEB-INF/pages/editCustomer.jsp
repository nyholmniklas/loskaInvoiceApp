<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Muokkaa asiakasta</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/960.css">
<link rel="stylesheet" href="css/text.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container_12" id="container_are">
		<div class="grid_11 prefix_1">
		<h2>Muokkaa asiakasta</h2>
			<jsp:include page="editCustomerForm.jsp" />
		</div>
	</div>
</body>
</html>