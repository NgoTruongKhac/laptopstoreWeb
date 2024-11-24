var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

function editUser(userId,page) {
	$.ajax({
		url: contextPath + "/adminPage/editUser?userId=" + userId+"&page="+page,
		type: "GET",
		dataType: "html",
		success: function(response) {

			document.getElementById("editUser").innerHTML = response;
			
			
		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});
}

function updateUser(page){
	
document.getElementById("editUserForm").addEventListener("submit", function(event) {
	event.preventDefault(); // Chặn hành vi mặc định của form

	// Lấy dữ liệu từ form
	var form = event.target;
	var formData = new FormData(form);

	// Gửi dữ liệu qua Ajax
	$.ajax({
		url: contextPath + "/adminPage/updateUser?page="+page, // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false, // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)
			$('#editUser').modal('hide');

			document.getElementById("listUserManage").innerHTML = response;
			const notyf = new Notyf();
			notyf.open({
				type: "success",
				message: "cập nhật tài khoản thành công",
				position: {
					x: "center",
					y: "center",
				},
				duration:  2500,
				dismissible: true
			});
			for (var pair of formData.entries()) {
				console.log(pair[0] + ': ' + pair[1]);
			}
		},
		error: function(xhr, status, error) {
			console.error("Error:", error);
		}
	});
});
}