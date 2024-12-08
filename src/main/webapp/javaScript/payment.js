// Biến lưu phương thức thanh toán đã chọn
let selectedPayment = null;

// Xử lý khi chọn phương thức thanh toán
document.querySelectorAll(".payment").forEach((payment) => {
	payment.addEventListener("click", function() {
		// Xóa "checked" và hiệu ứng từ tất cả các phần tử
		document.querySelectorAll(".payment").forEach((p) => {
			p.classList.remove("selected");
			p.querySelector(".checked").style.display = "none";
		});

		// Đánh dấu phần tử được chọn
		this.classList.add("selected");
		this.querySelector(".checked").style.display = "block";

		// Lưu lại phương thức đã chọn
		selectedPayment = this.cloneNode(true); // Sao chép phần tử
	});
});

// Xử lý khi click nút "áp dụng"
document
	.querySelector(".modal-footer .btn-primary")
	.addEventListener("click", function() {
		if (selectedPayment) {
			// Thay thế nội dung trong div.paymentMethod
			const paymentMethodDiv = document.querySelector(".paymentMethod");
			paymentMethodDiv.innerHTML = "";
			paymentMethodDiv.appendChild(selectedPayment);

			// Ẩn modal
			const modal = bootstrap.Modal.getInstance(
				document.getElementById("paymentMethodModal")
			);
			modal.hide();
		} else {
			alert("Vui lòng chọn phương thức thanh toán trước khi áp dụng!");
		}
	});
