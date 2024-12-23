var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function deleteUser(userId, page) {
	Swal.fire({
		title: 'Bạn có muốn xoá tài khoản này?',
		icon: 'question',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Đồng ý',
		cancelButtonText: 'Hủy bỏ'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				url: contextPath + "/adminPage/deleteUser?userId=" + userId + "&page=" + page,
				type: "get",
				dataType: "html",
				success: function(response) {
					document.getElementById("listUserManage").innerHTML = response;
					const notyf = new Notyf();
					notyf.open({
						type: "success",
						message: "xoá tài khoản thành công",
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
