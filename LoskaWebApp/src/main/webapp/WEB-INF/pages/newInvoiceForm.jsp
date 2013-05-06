<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="POST" action="newInvoice"
	modelAttribute="invoiceForm" id="invoice_form">
	<div class="grid_2">
		<table>
			<tr>
				<th colspan="2">Maksuehdot:</th>
			</tr>
			<tr>
				<td><form:label path="date">Pvm:</form:label></td>
			</tr>
			<tr>
				<td><form:input path="date" class="datepicker" /></td>
			</tr>
			<tr>
				<td><form:label path="due_date">Eräpäivä:</form:label></td>
			</tr>
			<tr>
				<td><form:input path="due_date" class="datepicker" /></td>
			</tr>
		</table>
	</div>
	<div class="grid_3 prefix_1">
		<table>
			<tr>
				<th colspan="2">Laskutusosoite:</th>
			</tr>
			<tr>
				<td><form:label path="bill_to_name">Nimi:</form:label></td>
				<td><form:input path="bill_to_name" /></td>
				<form:errors path="bill_to_name" />
			</tr>
			<tr>
				<td><form:label path="bill_to_name2">Nimi2:</form:label></td>
				<td><form:input path="bill_to_name2" /></td>
				<form:errors path="bill_to_name2" />
			</tr>
			<tr>
				<td><form:label path="bill_to_address">Katuosoite:</form:label></td>
				<td><form:input path="bill_to_address" /></td>
				<form:errors path="bill_to_address" />
			</tr>
			<tr>
				<td><form:label path="bill_to_postcode">Postinumero:</form:label></td>
				<td><form:input path="bill_to_postcode" /></td>
				<form:errors path="bill_to_postcode" />
			</tr>
			<tr>
				<td><form:label path="bill_to_city">Kaupunki:</form:label></td>
				<td><form:input path="bill_to_city" /></td>
				<form:errors path="bill_to_city" />
			</tr>
			<tr>
				<td><form:label path="bill_to_country">Maa:</form:label></td>
				<td><form:input path="bill_to_country" /></td>
				<form:errors path="bill_to_country" />
			</tr>
		</table>
	</div>
	<div class="grid_3 prefix_1">
		<table>
			<tr>
				<th colspan="2">Toimitusosoite:</th>
			</tr>
			<tr>
				<td><form:label path="ship_to_name">Nimi:</form:label></td>
				<td><form:input path="ship_to_name" /> <form:errors
						path="ship_to_name" /></td>

			</tr>
			<tr>
				<td><form:label path="ship_to_name2">Nimi2:</form:label></td>
				<td><form:input path="ship_to_name2" /> <form:errors
						path="ship_to_name2" /></td>

			</tr>
			<tr>
				<td><form:label path="ship_to_address">Katuosoite:</form:label></td>
				<td><form:input path="ship_to_address" /> <form:errors
						path="ship_to_address" /></td>

			</tr>
			<tr>
				<td><form:label path="ship_to_postcode">Postionumero:</form:label></td>
				<td><form:input path="ship_to_postcode" /></td>
				<form:errors path="ship_to_postcode" />
			</tr>
			<tr>
				<td><form:label path="ship_to_city">Kaupunki:</form:label></td>
				<td><form:input path="ship_to_city" /></td>
				<form:errors path="ship_to_city" />
			</tr>
			<tr>
				<td><form:label path="ship_to_country">Maa:</form:label></td>
				<td><form:input path="ship_to_country" /></td>
				<form:errors path="ship_to_country" />
			</tr>
		</table>
	</div>

	<div class="grid_10 suffix_2">
		<table>
			<tr>
				<th><form:label path="description">Saate:</form:label></th>
			</tr>
			<tr>
				<td><form:input path="description" width="100%" /></td>
			</tr>
		</table>
	</div>
	<div class="grid_10 suffix_2">
		<div id="list">
			<table>
				<tr>
					<th>Nimi</th>
					<th>Kpl</th>
					<th>Hinta</th>
					<th>ALV</th>
					<th>Yht</th>
					<td><a href="#" class="list-add">Add</a></td>
				</tr>
				<c:forEach items="${invoiceForm.rows}" var="row" varStatus="status">
					<!-- 					<div > -->
					<tr class="list-item">
						<td><input name="rows[${status.index}].name"
							value="${row.name}" /></td>
						<td><input name="rows[${status.index}].ammount"
							value="${row.ammount}" /></td>
						<td><input name="rows[${status.index}].price"
							value="${row.price}" /></td>
						<td><input name="rows[${status.index}].tax"
							value="${row.tax}" /></td>
						<td></td>
						<td><a href="#" class="list-remove">Poista</a></td>
					</tr>
					<!-- 			</div> -->
				</c:forEach>

			</table>

		</div>
		<div class="grid_3 prefix_7">
	<br/>
			<input type="submit" class="myButton" value="Luo lasku" /> <a
				href='<c:url value="/invoices"/>'><input class="myButton"
				type="button" value="Peruuta" /></a>
		</div>
</form:form>