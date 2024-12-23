var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function cancelMyOrder(orderId,pageOrder) {
	Swal.fire({
		title: 'Bạn có muốn huỷ đơn hàng này?',

		icon: 'question',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Đồng ý',
		cancelButtonText: 'Hủy bỏ'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
			       url: contextPath+"/cancelMyOrder?orderId="+orderId+"&pageOrder="+pageOrder,
			       type: "get",
			       dataType: "html",
			       success: function(response) {
					document.getElementById("listMyOrder").innerHTML = response;
					const notyf = new Notyf();
					       notyf.open({
					           type : "success",
					           message : "huỷ đơn hàng thành công",
					           position : {
					               x : "center",
					               y : "center",
					           },
					           duration : 2500,
					           dismissible : true
					       });
			       },
			       error: function(xhr, status, error) {
			           console.error("Error loading section:", error);
			       }
			   });
		}
	});
}