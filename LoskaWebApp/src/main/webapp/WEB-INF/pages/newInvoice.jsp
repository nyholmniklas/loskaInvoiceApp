<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Luo Uusi Lasku</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/960.css">
<link rel="stylesheet" href="css/text.css">
<link rel="stylesheet" href="css/style.css">
<link href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="js/jquery.dynamiclist.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>

<script>
	$(document).ready(function() {
		$("#list").dynamiclist();
	});
</script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container_12">
		<div id="container_area">
			<div class="grid_3 prefix_1">
				<h2>Luo Uusi Lasku</h2>
			</div>
			<div id="new_invoice_form" class="grid_11 prefix_1">
				<jsp:include page="newInvoiceForm.jsp" />
			</div>
		</div>
	</div>
</body>
</html>