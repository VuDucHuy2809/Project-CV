$(document).ready(function($) {
	$(".num-order").change(function(event) {
		slm = $(this).val();
		idproduct = $(this).attr('data-idproduct');
		$.ajax({
			url: '?page=cart_perform',
			type: 'POST',
			data: "slm="+slm+"&idproduct="+idproduct,
			async: true,
			succes: function(kq){
				window.location.reload(true);
			}
		});
	});
});