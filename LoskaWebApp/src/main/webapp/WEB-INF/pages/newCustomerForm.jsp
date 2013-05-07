<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form method="POST" action="newCustomer" modelAttribute="customerForm">
	<div class="grid_3">
		<table>
			<tr>
				<th colspan="2">Asiakkaan tiedot:</th>
			</tr>
			<tr>
				<td><form:label path="name">Nimi: </form:label></td>
				<td><form:input path="name" /><br>
				<form:errors path="name" cssClass="validation_error"/></td>
			</tr>
			<tr>
				<td><form:label path="y_tunnus">Y-tunnus:</form:label></td>
				<td><form:input path="y_tunnus" /><br>
				<form:errors path="y_tunnus" cssClass="validation_error"/></td>
			</tr>
		</table>
	</div>

	<div id="address_info">

		<!-- 		Bill to -->
		<div id="bill_to" class="grid_3">
			<table>
				<tr>
					<th colspan="2">Laskutusosoite:</th>
				</tr>
				<tr>
					<td><form:label path="bill_to_name">Nimi:</form:label></td>
					<td><form:input path="bill_to_name" /><br>
					<form:errors path="bill_to_name" cssClass="validation_error"/>
					</td>
				</tr>
				<tr>
					<td><form:label path="bill_to_name2">Nimi2:</form:label></td>
					<td><form:input path="bill_to_name2" /><br>
					<form:errors path="bill_to_name2" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_address">Katuosoite:</form:label></td>
					<td><form:input path="bill_to_address" /><br>
					<form:errors path="bill_to_address" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_postcode">Postinumero:</form:label></td>
					<td><form:input path="bill_to_postcode" /><br>
					<form:errors path="bill_to_postcode" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_city">Kaupunki:</form:label></td>
					<td><form:input path="bill_to_city" /><br>
					<form:errors path="bill_to_city" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="bill_to_country">Maa:</form:label></td>
					<td><form:input path="bill_to_country" /><br>
					<form:errors path="bill_to_country" cssClass="validation_error"/></td>
				</tr>
			</table>
		</div>

		<!-- 		Ship to -->
		<div id="ship_to" class="grid_3 sufix_1">

			<table>
				<tr>
					<th colspan="2">Toimitusosoite:</th>
				</tr>
				<tr>
					<td><form:label path="ship_to_name">Nimi:</form:label></td>
					<td><form:input path="ship_to_name" /><br>
					<form:errors path="ship_to_name" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_name2">Nimi2:</form:label></td>
					<td><form:input path="ship_to_name2" /><br>
					<form:errors path="ship_to_name2" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_address">Katuosoite:</form:label></td>
					<td><form:input path="ship_to_address" /><br>
					<form:errors path="ship_to_address" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_postcode">Postionumero:</form:label></td>
					<td><form:input path="ship_to_postcode" /><br>
					<form:errors path="ship_to_postcode" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_city">Kaupunki:</form:label></td>
					<td><form:input path="ship_to_city" /><br>
					<form:errors path="ship_to_city" cssClass="validation_error"/></td>
				</tr>
				<tr>
					<td><form:label path="ship_to_country">Maa:</form:label></td>
					<td><form:input path="ship_to_country" /><br>
					<form:errors path="ship_to_country" cssClass="validation_error"/></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="grid_4 prefix_6">
		<br /> <input type="submit" class="myButton" value="Luo uusi asiakas" /><a href='<c:url value="/customers"/>'>
		<input class="myButton" type="button" value="Peruuta" /></a>
	</div>
</form:form>