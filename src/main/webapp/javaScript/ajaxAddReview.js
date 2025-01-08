var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

document.getElementById("addReviewForm").addEventListener("submit", function(event) {

	event.preventDefault(); // Chặn hành vi mặc định của form

	// Lấy dữ liệu từ form
	var form = event.target;
	var formData = new FormData(form);

	// Gửi dữ liệu qua Ajax
	$.ajax({
		url: contextPath + "/addReview", // Đường dẫn servlet xử lý
		type: "POST",
		data: formData,
		processData: false, // Không xử lý dữ liệu
		contentType: false, // Không đặt kiểu dữ liệu
		success: function(response) {
			// Xử lý kết quả trả về (ví dụ: cập nhật nội dung trang)
			$('#voteModal').modal('hide');
			$('#addReviewForm')[0].reset(); // Reset form về giá trị mặc định
			document.getElementById("review").innerHTML = response;
			const notyf = new Notyf();
			notyf.open({
				type: "success",
				message: "gửi đánh giá thành công",
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
