var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))

function confirmOrder(oderId, pageOrder) {
	Swal.fire({
		title: 'Bạn muốn xác nhận đơn hàng?',
		icon: 'question',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Đồng ý',
		cancelButtonText: 'Hủy bỏ'
	}).then((result) => {
		if (result.isConfirmed) {

			$.ajax({
				url: contextPath + "/adminPage/confirmOrder?orderId=" + oderId + "&pageOrder=" + pageOrder,
				type: "get",
				dataType: "html",
				success: function(response) {
					document.getElementById("listOrderManage").innerHTML = response;
					const notyf = new Notyf();
					notyf.open({
						type: "success",
						message: "xác nhận đơn hàng thành công",
						position: {
							x: "center",
							y: "center",
						},
						duration: 2500,
						dismissible: true
					});
				},
				error: function(xhr, status, error) {
					console.error("Error loading section:", error);
				}
			});

		}
	});
}

function delivery(oderId, pageOrder) {
	Swal.fire({
		title: 'Bàn giao cho đơn vị vận chuyển?',
		icon: 'question',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Đồng ý',
		cancelButtonText: 'Hủy bỏ'
	}).then((result) => {
		if (result.isConfirmed) {

			$.ajax({
				url: contextPath + "/adminPage/delivery?orderId=" + oderId + "&pageOrder=" + pageOrder,
				type: "get",
				dataType: "html",
				success: function(response) {
					document.getElementById("listOrderManage").innerHTML = response;
					const notyf = new Notyf();
					notyf.open({
						type: "success",
						message: "bàn giao thành công",
						position: {
							x: "center",
							y: "center",
						},
						duration: 2500,
						dismissible: true
					});
				},
				error: function(xhr, status, error) {
					console.error("Error loading section:", error);
				}
			});

		}
	});
}
