<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Luo Uusi K‰ytt‰j‰tili</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Luo Uusi K‰ytt‰j‰tili</h2>
	<form:form method="POST" action="newUser" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="username">K‰ytt‰j‰tunnus: </form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Salasana:</form:label></td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Rekisterˆidy" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href='<c:url value="/login"/>'>Kirjaudu sis‰‰n olemassaolevilla
		tunnuksilla.</a>
</body>
</html>