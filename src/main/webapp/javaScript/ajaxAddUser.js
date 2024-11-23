var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));
document.getElementById("addUserForm").addEventListener("submit", function(event) {

	event.preventDefault();

	var form = event.target;
	var formData = new FormData(form);




	$.ajax({

		url: contextPath + "/adminPage/addUser", // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false,
		dataType: "json", // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)




			if (response.type === "success") {

				$('#addUser').modal('hide');
				$('#addUserForm')[0].reset(); // Reset form về giá trị mặc định
			}

			document.getElementById("listUserManage").innerHTML = response;

			const notyf = new Notyf();
			notyf.open({
				type: response.type,
				message: response.message,
				position: {
					x: "center",
					y: "center",
				},
				duration: response.type === "error" ? null : 2500,
				dismissible: true
			});
			$.ajax({
				url: contextPath + "/adminPage/listUser",
				type: "get",
				dataType: "html",
				success: function(response) {
					document.getElementById("listUserManage").innerHTML = response;

					// Tải script liên quan đến User

				},

			});



		},
		error: function(xhr, status, error) {

			console.error("Error:", error);
		}
	});



});
