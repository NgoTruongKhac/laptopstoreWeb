var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

function updateLaptop(pageLaptop){
	
document.getElementById("editLaptopForm").addEventListener("submit", function(event) {
	event.preventDefault(); // Chặn hành vi mặc định của form

	// Lấy dữ liệu từ form
	var form = event.target;
	var formData = new FormData(form);

	// Gửi dữ liệu qua Ajax
	$.ajax({
		url: contextPath + "/adminPage/updateLaptop?pageLaptop="+pageLaptop, // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false, // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)
			$('#editLaptop').modal('hide');

			document.getElementById("listLaptopManage").innerHTML = response;
			const notyf = new Notyf();
			notyf.open({
				type: "success",
				message: "cập nhật sản phẩm thành công",
				position: {
					x: "center",
					y: "center",
				},
				duration:   2500,
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

function updatePeripheral(pagePeripheral){
	
document.getElementById("editPeripheralForm").addEventListener("submit", function(event) {
	event.preventDefault(); // Chặn hành vi mặc định của form

	// Lấy dữ liệu từ form
	var form = event.target;
	var formData = new FormData(form);

	// Gửi dữ liệu qua Ajax
	$.ajax({
		url: contextPath + "/adminPage/updatePeripheral?pagePeripheral="+pagePeripheral, // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false, // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)
			$('#editPeripheral').modal('hide');
		
			document.getElementById("listPeripheralManage").innerHTML = response;
			const notyf = new Notyf();
			notyf.open({
				type: "success",
				message: "cập nhật sản phẩm thành công",
				position: {
					x: "center",
					y: "center",
				},
				duration: 2500,
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

function editLaptop(laptopId,pageLaptop) {
	$.ajax({
		url: contextPath + "/adminPage/editLaptop?laptopId=" + laptopId+"&pageLaptop="+pageLaptop,
		type: "GET",
		dataType: "html",
		success: function(response) {

			document.getElementById("editLaptop").innerHTML = response;
			
			changeImage();
			

		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});
}
function editPeripheral(peripheralId,pagePeripheral) {
	$.ajax({
		url: contextPath + "/adminPage/editPeripheral?peripheralId=" + peripheralId+"&pagePeripheral="+pagePeripheral,
		type: "GET",
		dataType: "html",
		success: function(response) {

			document.getElementById("editPeripheral").innerHTML = response;
			
			changeImage();
			

		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});
}