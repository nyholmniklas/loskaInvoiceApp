<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- 	<div id="header_area"> -->
		<div class="container_12" id="header_area">
			<div id="header" class="grid_12">
				<sec:authorize ifAnyGranted="ROLE_USER">
									<img src="images/header.jpg" usemap="#header_link_map">
				<map name="header_link_map">
					<area shape="rect" coords="396,10,455,65" href="invoices"
						alt="Invoices" title="Invoices" />
					<area shape="rect" coords="478,9,537,64" href="customers"
						alt="Customers" title="Customers" />
					<area shape="rect" coords="572,9,631,64" href="tuotteet_link"
						alt="Products" title="Products" />
					<area shape="rect" coords="673,9,732,64" href="asetukset_link"
						alt="Settings" title="Settings" />
					<area shape="rect" coords="786,8,845,63"
						href="j_spring_security_logout" alt="Logout" title="Logout" />
				</map>
				</sec:authorize>
				<sec:authorize ifNotGranted="ROLE_USER">
									<img src="images/header_anon.jpg"">
				</sec:authorize>
			</div>
		</div>
<!-- 	</div> -->

