<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Luo Uusi Lasku</title>
<link rel="stylesheet" href="css/base.css">
<!-- <link rel="stylesheet" href="css/skeleton.css"> -->
<!-- <link rel="stylesheet" href="css/layout.css"> -->

<!-- TEST START -->
<!--  <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> -->
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="js/jquery.dynamiclist.js"></script>
<!-- <script> -->
<!-- // 	$(function() { -->
<!-- // 		$("#datepicker").datepicker(); -->
<!-- // 	}); -->
<!-- </script> -->
<!-- TESTEND -->

<script>
	$(document).ready(function() {
		$("#list").dynamiclist();
	});
</script>

</head>
<body>
	<jsp:include page="header.jsp" />

	<h2>Luo Uusi Lasku</h2>

	<form:form method="POST" action="newInvoice"
		modelAttribute="invoiceForm">
		<div id="address_info">

			<!-- 		Bill to -->
			<div id="bill_to">
				<b>Laskutusosoite: </b><br />
				<form:label path="bill_to_name">Nimi:</form:label>
				<form:input path="bill_to_name" />
				<form:errors path="bill_to_name" />
				<br />
				<form:label path="bill_to_name2">Nimi2:</form:label>
				<form:input path="bill_to_name2" />
				<form:errors path="bill_to_name2" />
				<br />
				<form:label path="bill_to_address">Katuosoite:</form:label>
				<form:input path="bill_to_address" />
				<form:errors path="bill_to_address" />
				<br />
				<form:label path="bill_to_postcode">Postiosoite:</form:label>
				<form:input path="bill_to_postcode" />
				<form:errors path="bill_to_postcode" />
				<br />
				<form:label path="bill_to_city">Kaupunki:</form:label>
				<form:input path="bill_to_city" />
				<form:errors path="bill_to_city" />
				<br />
				<form:label path="bill_to_country">Maa:</form:label>
				<form:input path="bill_to_country" />
				<form:errors path="bill_to_country" />
			</div>

			<!-- 		Ship to -->
			<div id="ship_to">
				<b>Toimitusosoite: </b><br />
				<form:label path="ship_to_name">Nimi:</form:label>
				<form:input path="ship_to_name" />
				<form:errors path="ship_to_name" />
				<br />

				<form:label path="ship_to_name2">Nimi2:</form:label>
				<form:input path="ship_to_name2" />
				<form:errors path="ship_to_name2" />
				<br />
				<form:label path="ship_to_address">Katuosoite:</form:label>
				<form:input path="ship_to_address" />
				<form:errors path="ship_to_address" />
				<br />
				<form:label path="ship_to_postcode">Postiosoite:</form:label>
				<form:input path="ship_to_postcode" />
				<form:errors path="ship_to_postcode" />
				<br />
				<form:label path="ship_to_city">Kaupunki:</form:label>
				<form:input path="ship_to_city" />
				<form:errors path="ship_to_city" />
				<br />
				<form:label path="ship_to_country">Maa:</form:label>
				<form:input path="ship_to_country" />
				<form:errors path="ship_to_country" />
				<br>
			</div>
		</div>

		<!-- 		Products -->
		<div id="products">
<!-- 						<table> -->
			<tr>
				<th>Nimi</th>
				<th>Kpl</th>
				<th>Hinta</th>
				<th>ALV</th>
				<th>Yht</th>
			</tr>
			<div id="list">
				<c:forEach items="${invoiceForm.rows}" var="row" varStatus="status">
					<div class="list-item">
					<tr>
						<td><input name="rows[${status.index}].name"
							value="${row.name}" /></td>
						<td><input name="rows[${status.index}].ammount"
							value="${row.ammount}" /></td>
						<td><input name="rows[${status.index}].price"
							value="${row.price}" /></td>
						<td><input name="rows[${status.index}].tax"
							value="${row.tax}" /></td>
						<td><a href="#" class="list-remove">Poista</a></td>
					</tr>
			</div>
			</c:forEach>
			<a href="#" class="list-add">Add</a>
<!-- 								</table> -->
		</div>



		<!-- 		TEST START -->
		<!-- <input type="text" id="datepicker" /> -->
		<!-- TESTEND -->

		<input type="submit" value="Luo lasku" />
		<a href='<c:url value="/index"/>'><input type="button"
			value="Peruuta" /></a>
	</form:form>
</body>
</html>