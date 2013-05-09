//Add change listener to rows
$(document).ready(function () {
    $("#invoice_row_table").on("change", 'input[name$="price"], input[name$="ammount"]', function (event) {
        calculateRow($(this).closest("tr"));
        calculateGrandTotal();
    });
});

//Calculate row totals
function calculateRow(row) {
    var price = parseFloat(row.find('input[name$="price"]').val());
    var qty = parseFloat(row.find('input[name$="ammount"]').val());
    var tax = parseFloat(row.find('select[name$="tax"]').val());
    var rowtotal = parseFloat(price * qty).toFixed(2);
    if (isNaN(rowtotal)) rowtotal = 0;
    row.find(".total_inc_tax").html(rowtotal);
    var totalWithoutTax = 0;
    if (rowtotal!=0) totalWithoutTax = parseFloat(rowtotal / (1+(tax/100))).toFixed(2);
    row.find(".total_without_tax").html(totalWithoutTax);
    return parseFloat(rowtotal);
}

//Calculate grand total
function calculateGrandTotal() {
    var grandTotal = 0;
    var grandTotalTaxFree = 0;
    $('input[name$="price"]').each(function () {
        grandTotal += parseFloat(calculateRow($(this).closest("tr")));
        grandTotalTaxFree += parseFloat($(this).closest("tr").find(".total_without_tax").html());
    });
    $("#grandtotal").html(grandTotal.toFixed(2));
    $("#grandtotal_taxfree").html(grandTotalTaxFree.toFixed(2));
}
