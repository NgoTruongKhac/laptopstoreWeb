var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

document.getElementById("addLaptopForm").addEventListener("submit", function(event) {

	event.preventDefault(); // Chặn hành vi mặc định của form

	// Lấy dữ liệu từ form
	var form = event.target;
	var formData = new FormData(form);

	// Gửi dữ liệu qua Ajax
	$.ajax({
		url: contextPath + "/adminPage/addLaptop", // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false, // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)
			$('#addLaptop').modal('hide');
			$('#addLaptopForm')[0].reset(); // Reset form về giá trị mặc định
			$('#preview').attr('src', '').css('display', 'none');
			document.getElementById("listLaptopManage").innerHTML = response;
			const notyf = new Notyf();
			notyf.open({
				type: "success",
				message: "thêm sản phẩm thành công",
				position: {
					x: "center",
					y: "center",
				},
				duration:  2500 ,
				dismissible: true
			});
			
		},
		error: function(error) {
			console.error("Error:", error);
		}
	});
});


document.getElementById("addPeripheralForm").addEventListener("submit", function(event) {
	
	console.log(contextPath)

	event.preventDefault(); // Chặn hành vi mặc định của form

	// Lấy dữ liệu từ form
	var form = event.target;
	var formData = new FormData(form);

	// Gửi dữ liệu qua Ajax
	$.ajax({
		url: contextPath + "/adminPage/addPeripheral", // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false, // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)
			$('#addPeripheral').modal('hide');
			$('#addPeripheralForm')[0].reset(); // Reset form về giá trị mặc định
			$('#preview-p').attr('src', '').css('display', 'none');
			document.getElementById("listPeripheralManage").innerHTML = response;
			const notyf = new Notyf();
			notyf.open({
				type: "success",
				message: "thêm sản phẩm thành công",
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



