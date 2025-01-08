var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function confirmReceived(orderId,pageOrder){
	Swal.fire({
		title: 'Xác nhận đã nhận được hàng?',

		icon: 'question',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'xác nhận',
		cancelButtonText: 'chưa'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
			       url: contextPath+"/confirmReceived?orderId="+orderId+"&pageOrder="+pageOrder,
			       type: "get",
			       dataType: "html",
			       success: function(response) {
					document.getElementById("listMyOrder").innerHTML = response;
					const notyf = new Notyf();
					       notyf.open({
					           type : "success",
					           message : "xác nhận thành công",
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
