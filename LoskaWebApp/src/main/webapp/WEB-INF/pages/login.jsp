<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Kirjaudu Sis‰‰n</title>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>
	<c:if test="${not empty error}">
		<div class="errorblock">
			Sis‰‰nkirjautuminen ep‰onnistui. Yrit‰ uudestaan.<br /> 
<%-- 			Caused :${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} --%>
		</div>
	</c:if>
	</h3>
		<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 		<h1>Tervetuloa Loska Laskutusj‰rjestelm‰‰n</h1>
		<table>
			<tr>
				<td>K‰ytt‰j‰tunnus:</td>
				<td><input type='text' name='j_username' value=''>
				</td>
			</tr>
			<tr>
				<td>Salasana:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Kirjaudu" />
				</td>
			</tr>
		</table>
 
	</form>
	<br>
	<a href='<c:url value="/newUser"/>'>Luo uusi k‰ytt‰j‰tili.</a>
</body>
</html>