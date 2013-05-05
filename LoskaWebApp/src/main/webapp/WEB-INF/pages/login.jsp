<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Kirjaudu Sis‰‰n</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/960.css">
<link rel="stylesheet" href="css/text.css">
</head>
<body onload='document.f.j_username.focus();'>
	<jsp:include page="header.jsp" />
	<div id="container_area" class="container_12">
		<div id="new_invoice_link" class="grid_4 prefix_1">
			<h3>
				<c:if test="${not empty error}">
					<div class="errorblock">
						Sis‰‰nkirjautuminen ep‰onnistui. Yrit‰ uudestaan.<br /> Caused
						:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>
			</h3>
			<h2>Kirjaudu Sis‰‰n</h2>
			<form name='f' action="<c:url value='j_spring_security_check' />"
				method='POST'>
				K‰ytt‰j‰tunnus: <input type='text' name='j_username' value='' />
				Salasana: <input type='password' name='j_password' />
				<br> 
				<input
					name="submit" type="submit" value="Kirjaudu" />
			</form>
			<a href='<c:url value="/newUser"/>'>Luo uusi k‰ytt‰j‰tili.</a>
		</div>
	</div>
</body>
</html>