<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Kirjaudu Sis‰‰n</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/960.css">
<link rel="stylesheet" href="css/text.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body onload='document.f.j_username.focus();'>
	<jsp:include page="header.jsp" />
	<div id="container_area" class="container_12">
		<div class="grid_7 prefix_1">
		<br>
			<img src="images/index_splash.jpg">
		</div>
		<div id="login_area" class="grid_4">

			<h1>Kirjaudu sis‰‰n</h1>
			<form name='f' action="<c:url value='j_spring_security_check' />"
				method='POST'>

					<h3>
						<c:if test="${not empty error}">
							<div class="errorblock">
								Sis‰‰nkirjautuminen ep‰onnistui. Yrit‰ uudestaan.<br /> Caused
								:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
							</div>
						</c:if>
					</h3>
					<p><input type='text' name='j_username' value='' placeholder="K‰ytt‰j‰tunnus"/></p>
					<p><input type='password' name='j_password' placeholder="Salasana"/></p>
						<p><input class="myButton" name="submit" type="submit" value="Kirjaudu" /></p>

						<p><a href='<c:url value="/newUser"/>'>Luo uusi k‰ytt‰j‰tili.</a></p>
			</form>

		</div>
	</div>
</body>
</html>