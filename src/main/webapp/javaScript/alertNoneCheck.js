document.addEventListener("DOMContentLoaded", function() {
	const form = document.querySelector("form[action='orderInfo']");
	const submitButton = form.querySelector("button[type='submit']");

	submitButton.addEventListener("click", function(event) {
		// Lấy tất cả các checkbox sản phẩm
		const checkboxes = form.querySelectorAll("input[name='selectCartItem']:checked");

		// Kiểm tra nếu không có checkbox nào được chọn
		if (checkboxes.length === 0) {
			event.preventDefault(); // Ngăn chặn việc gửi form
			const notyf = new Notyf({
				types: [{
					type: 'warning',
					background: 'orange',
					icon: {
						className: 'material-icons',
						tagName: 'i',
						text: 'warning',
						color: 'white'
					}
				}]
			});
			notyf.open({
				type: "warning",
				message: "bạn chưa chọn sản phẩm",
				position: {
					x: "center",
					y: "center",
				},
				duration: null,

				dismissible: true
			});
		}
	});
});