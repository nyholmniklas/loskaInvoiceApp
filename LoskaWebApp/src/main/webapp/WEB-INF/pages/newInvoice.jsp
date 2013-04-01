<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Luo Uusi Lasku</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Luo Uusi Lasku</h2>
	<form:form method="POST" action="newInvoice" modelAttribute="invoice">
		<!-- 		<table> -->
		<!-- 			<tr> -->
		<%-- 				<td><form:label path="reference">Viite: </form:label></td> --%>
		<%-- 				<td><form:input path="reference" /></td> --%>
		<%-- 				<td><form:errors path="reference" /></td> --%>
		<!-- 			</tr> -->
		<!-- 			<tr> -->
		<%-- 				<td><form:label path="totalsum">Summa:</form:label></td> --%>
		<%-- 				<td><form:input path="totalsum" /></td> --%>
		<%-- 				<td><form:errors path="totalsum" /></td> --%>
		<!-- 			</tr> -->
		<!-- 						<tr> -->
		<%-- 				<td><form:label path="description">Kuvaus:</form:label></td> --%>
		<%-- 				<td><form:textarea path="description" /></td> --%>
		<%-- 				<td><form:errors path="description" /></td> --%>
		<!-- 			</tr> -->
		<!-- 			<tr> -->
		<!-- 				<td><input type="submit" value="Luo lasku" /></td> -->
		<%-- 				<td><a href='<c:url value="/index"/>'><input type="button" --%>
		<!-- 						value="Peruuta" /></a></td> -->
		<!-- 			</tr> -->
		<!-- 		</table> -->
		<form:label path="reference">Viite: </form:label><form:input path="reference" />
		<form:errors path="reference" />
		<br>

		<form:label path="totalsum">Summa:</form:label><form:input path="totalsum" />
		<form:errors path="totalsum" />
		<br>


		<form:label path="description">Kuvaus:</form:label><form:textarea path="description" />
		<form:errors path="description" />
		<br>

		<input type="submit" value="Luo lasku" /><a href='<c:url value="/index"/>'><input type="button"
			value="Peruuta" /></a>

	</form:form>
</body>
</html>