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
    var price = parseFloat(row.find('input[name$="price"]').val());
    var qty = parseFloat(row.find('input[name$="ammount"]').val());
    var rowtotal = parseFloat(price * qty).toFixed(2);
    if (isNaN(rowtotal)) rowtotal = 0;
    row.find(".total_inc_tax").html(rowtotal);
    return parseFloat(rowtotal);
}

function calculateGrandTotal() {
    var grandTotal = 0;
    $('input[name$="price"]').each(function () {
        grandTotal += parseFloat(calculateRow($(this).closest("tr")));
    });
//    alert(grandTotal);
    $("#grandtotal").html(grandTotal.toFixed(2));
}
