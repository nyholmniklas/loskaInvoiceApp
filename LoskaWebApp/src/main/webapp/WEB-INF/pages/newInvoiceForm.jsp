<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form method="POST" action="newInvoice"
	modelAttribute="invoiceForm">
	<div class="grid_2">
		<form:label path="date">Pvm:</form:label>
		</br>
		<form:input path="date" class="datepicker" />
		</br>
		<form:label path="due_date">Eräpäivä:</form:label>
		</br>
		<form:input path="due_date" class="datepicker" />
		</br>
		<table>
			<th></th>
			<tr></tr>
			<th></th>
			<tr></tr>
		</table>
	</div>

	<br />

	<!-- 		Bill to -->
	<div class="grid_4">

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

	<!-- 		Ship to -->
	<div class="grid_4">
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


	<div class="grid_10">
		<div id="list">
			<table>
				<tr>
					<th>Nimi</th>
					<th>Kpl</th>
					<th>Hinta</th>
					<th>ALV</th>
					<th>Yht</th>
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
						<td><a href="#" class="list-remove">Poista</a></td>

					</tr>
					<!-- 			</div> -->
				</c:forEach>
			</table>
			<a href="#" class="list-add">Add</a>
		</div>


		<input type="submit" value="Luo lasku" /> <a
			href='<c:url value="/index"/>'><input type="button"
			value="Peruuta" /></a>
</form:form>