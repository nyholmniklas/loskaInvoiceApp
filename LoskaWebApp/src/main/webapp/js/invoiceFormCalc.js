//$(function() {
//	$('input[name$="ammount"]').change(function() {	
//		var $unitprice = $(this).closest('tr').children().find('input[name$="price"]').val();
//		var $ammount = $(this).val();
//		var $total = $unitprice * $ammount;
//		$(this).closest('tr').children().find('.total_inc_tax').html($total);
//	});
//	
//	$('input[name$="price"]').change(function() {
//		var $ammount = $(this).closest('td').siblings().find('input[name$="ammount"]').val();
//		var $unitprice = $(this).val();
//		var $total = $unitprice * $ammount;
//		$(this).closest('tr').children().find('.total_inc_tax').html($total);
//	});
//});

$(document).ready(function () {
    $("#invoice_row_table").on("change", 'input[name$="price"], input[name$="ammount"]', function (event) {
        calculateRow($(this).closest("tr"));
        calculateGrandTotal();
    });
});

function calculateRow(row) {
    var price = +row.find('input[name$="price"]').val();
    var qty = +row.find('input[name$="ammount"]').val();
    row.find('.total_inc_tax').html((price * qty));
}

function calculateGrandTotal() {
    var grandTotal = 0;
    $("table.invoice_row_table").find('.total_inc_tax').each(function () {
        grandTotal += +$(this).val();
    });
    $("#grandtotal").text(grandTotal.toFixed(2));
}