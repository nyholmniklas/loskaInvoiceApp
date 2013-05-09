<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form method="POST" action="newInvoice"
	modelAttribute="invoiceForm" id="invoice_form">
	<div class="grid_3 prefix_1">
		<table>
			<tr>
				<th colspan="2">Maksuehdot:</th>
			</tr>
			<tr>
				<td><form:label path="date">Pvm: </form:label></td>
				<td><form:input path="date" class="datepicker" /><br> <form:errors
						path="ship_to_country" cssClass="validation_error" /></td>
			</tr>
			<tr>
				<td><form:label path="due_date">Eräpäivä:</form:label></td>
				<td><form:input path="due_date" class="datepicker" /><br>
					<form:errors path="ship_to_country" cssClass="validation_error" /></td>
			</tr>
		</table>
	</div>
	<div id="address_info">
		<!-- 		Bill to -->
		<div id="bill_to" class="grid_3 prefix_1">
			<table>
				<tr>
					<th colspan="2">Laskutusosoite:</th>
				</tr>
				<tr>
					<td><form:label path="bill_to_name">Nimi:</form:label></td>
					<td><form:input path="bill_to_name" /><br> <form:errors
							path="bill_to_name" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_name2">Nimi2:</form:label></td>
					<td><form:input path="bill_to_name2" /><br> <form:errors
							path="bill_to_name2" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_address">Katuosoite:</form:label></td>
					<td><form:input path="bill_to_address" /><br> <form:errors
							path="bill_to_address" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_postcode">Postinumero:</form:label></td>
					<td><form:input path="bill_to_postcode" /><br> <form:errors
							path="bill_to_postcode" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_city">Kaupunki:</form:label></td>
					<td><form:input path="bill_to_city" /><br> <form:errors
							path="bill_to_city" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_country">Maa:</form:label></td>
					<td><form:input path="bill_to_country" /><br> <form:errors
							path="bill_to_country" cssClass="validation_error" /></td>
				</tr>
			</table>
		</div>
		<!-- 		Ship to -->
		<div id="ship_to" class="grid_3">

			<table>
				<tr>
					<th colspan="2">Toimitusosoite:</th>
				</tr>
				<tr>
					<td><form:label path="ship_to_name">Nimi:</form:label></td>
					<td><form:input path="ship_to_name" /><br> <form:errors
							path="ship_to_name" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_name2">Nimi2:</form:label></td>
					<td><form:input path="ship_to_name2" /><br> <form:errors
							path="ship_to_name2" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_address">Katuosoite:</form:label></td>
					<td><form:input path="ship_to_address" /><br> <form:errors
							path="ship_to_address" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_postcode">Postionumero:</form:label></td>
					<td><form:input path="ship_to_postcode" /><br> <form:errors
							path="ship_to_postcode" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_city">Kaupunki:</form:label></td>
					<td><form:input path="ship_to_city" /><br> <form:errors
							path="ship_to_city" cssClass="validation_error" /></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_country">Maa:</form:label></td>
					<td><form:input path="ship_to_country" /><br> <form:errors
							path="ship_to_country" cssClass="validation_error" /></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="grid_10 prefix_1 suffix_1">
		<table>
			<tr>
				<th><form:label path="description">Saate:</form:label></th>
			</tr>
			<tr>
				<td><form:input path="description" cssClass="description" /><br>
					<form:errors path="description" cssClass="validation_error" /></td>
			</tr>
		</table>
	</div>
	<div class="grid_10 prefix_1 suffix_1"">
		<div id="list">
			<table id="invoice_row_table">
				<thead>
					<tr>
						<th>Nimi</th>
						<th>Kpl</th>
						<th>Hinta</th>
						<th>Veroton</th>
						<th>Veroton</th>
						<th>Yht</th>
						<td><a href="#" class="list-add"
							onClick="calculateGrandTotal()">Add</a></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${invoiceForm.rows}" var="row" varStatus="status">
						<tr class="list-item">
							<td><input name="rows[${status.index}].name"
								id="rows[${status.index}].name" value="${row.name}" /></td>
							<td><input name="rows[${status.index}].ammount"
								id="rows[${status.index}].ammount" value="${row.ammount}" /></td>
							<td><input name="rows[${status.index}].price"
								id="rows[${status.index}].price" value="${row.price}" /></td>

							<td><select name="rows[${status.index}].tax"
								id="rows[${status.index}].tax">
									<option value="24">24%</option>
									<option value="14">14%</option>
									<option value="10">10%</option>
							</select></td>
							<td><span class="total_without_tax">0.00</span><span>
									EUR</span></td>
							<td><span class="total_inc_tax">0.00</span><span> EUR</span></td>
							<td><a href="#" class="list-remove"
								onClick="calculateGrandTotal()">Poista</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="grid_2 prefix_7 suffix_4">
		Yht. ilm.alv <span id="grandtotal_taxfree">0.00</span><span> EUR</span><br>
			Yht <b><span id="grandtotal">0.00</span></b><span> EUR</span>
		</div>
		<div class="grid_3">
			<br /> <input type="submit" class="myButton" value="Luo lasku" /><a
				href='<c:url value="/invoices"/>'><input class="myButton"
				type="button" value="Peruuta" /></a>
		</div>
	</div>
</form:form>