$(function() {
	$('input[name$="ammount"]').change(function() {	
		var $unitprice = $(this).closest('td').siblings().find('input[name$="price"]').val();
		var $ammount = $(this).val();
		var $total = $unitprice * $ammount;
		$(this).closest('td').siblings().find('.total_inc_tax').html($total);
	});
	
	$('input[name$="price"]').change(function() {
		var $ammount = $(this).closest('td').siblings().find('input[name$="ammount"]').val();
		var $unitprice = $(this).val();
		var $total = $unitprice * $ammount;
		$(this).closest('td').siblings().find('.total_inc_tax').html($total);
	});
});
