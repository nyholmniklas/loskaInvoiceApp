<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Kirjaudu Sis‰‰n</title>
<link rel="stylesheet" href="css/base.css">
<!-- <link rel="stylesheet" href="css/skeleton.css"> -->
<!-- <link rel="stylesheet" href="css/layout.css"> -->
</head>
<body onload='document.f.j_username.focus();'>
	<h3>
		<c:if test="${not empty error}">
			<div class="errorblock">
				Sis‰‰nkirjautuminen ep‰onnistui. Yrit‰ uudestaan.<br /> Caused
				:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
	</h3>
	<jsp:include page="header.jsp" />
	<h2>Kirjaudu Sis‰‰n</h2>
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
		K‰ytt‰j‰tunnus: <input type='text' name='j_username' value=''/><br>
		Salasana: <input type='password' name='j_password' /><br>
		<input	name="submit" type="submit" value="Kirjaudu" />
	</form>
	<a href='<c:url value="/newUser"/>'>Luo uusi k‰ytt‰j‰tili.</a>
</body>
</html>