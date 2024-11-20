
const hamBurger = document.querySelector(".toggle-btn");
const sidebar = document.querySelector("#sidebar");

// Mở/đóng sidebar khi nhấn vào nút
hamBurger.addEventListener("click", function() {
	sidebar.classList.toggle("expand");

	// Kiểm tra kích thước màn hình khi mở sidebar
	if (window.innerWidth <= 768) {
		document.body.classList.toggle("sidebar-open");
	}
});

// Đóng sidebar khi click bên ngoài
document.addEventListener("click", function(event) {
	// Kiểm tra nếu sidebar đang mở
	if (sidebar.classList.contains("expand")) {
		// Kiểm tra nếu click nằm ngoài sidebar và nút toggle
		if (!sidebar.contains(event.target) && !hamBurger.contains(event.target)) {
			sidebar.classList.remove("expand");
			document.body.classList.remove("sidebar-open"); // Xóa class khi sidebar bị đóng
		}
	}
});



// Đóng sidebar khi nhấp bên ngoài trên màn hình di động
document.addEventListener("click", function(event) {
	const sidebar = document.querySelector("#sidebar");
	if (
		sidebar.classList.contains("expand") &&
		window.innerWidth <= 768 &&
		!sidebar.contains(event.target) &&
		!hamBurger.contains(event.target)
	) {
		// sidebar.classList.remove("expand");
		// document.body.classList.remove("sidebar-open");
		sidebar.classList.remove("expand");
		setTimeout(() => {
			document.body.classList.remove("sidebar-open");
		}, 300);
	}
});


function showSection(sectionId) {
	// Ẩn tất cả nội dung
	document.querySelectorAll(".content-section").forEach((section) => {
		section.classList.remove("active");
	});

	// Hiện nội dung được chọn
	const selectedSection = document.getElementById(sectionId);
	selectedSection.classList.add("active");

	// Xóa trạng thái active của tất cả sidebar items
	document.querySelectorAll(".sidebar-item").forEach((item) => {
		item.classList.remove("active");
	});

	// Thêm trạng thái active cho item được chọn
	document
		.querySelector(`.sidebar-item[data-section='${sectionId}']`)
		.classList.add("active");

	// Đặt URL servlet tương ứng dựa trên sectionId
	var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
	let url;
	switch (sectionId) {
		case "User":
			url = contextPath + "/adminPage/listUser";
			break;
		case "Product":
			url = contextPath + "/adminPage/listProduct";
			break;
		case "Order":
			url = contextPath + "/adminPage/listOrder";
			break;
		default:
			console.error("Unknown section ID:", sectionId);
			return; // Dừng hàm nếu không có section hợp lệ
	}

	// Gọi AJAX để tải nội dung cho section
	$.ajax({
		url: url,
		type: "get",
		dataType: "html",
		success: function(response) {
			selectedSection.innerHTML = response;


			var previewImage = document.createElement('script');
			previewImage.type = 'text/javascript';
			previewImage.src = 'javaScript/previewImage.js';
			document.body.appendChild(previewImage);

			

			var ajaxAddLaptop = document.createElement('script');
			ajaxAddLaptop.type = 'text/javascript';
			ajaxAddLaptop.src = 'javaScript/ajaxAddProduct.js';
			document.body.appendChild(ajaxAddLaptop);

			var ajaxEditProduct = document.createElement('script');
			ajaxEditProduct.type = 'text/javascript';
			ajaxEditProduct.src = 'javaScript/ajaxEditProduct.js';
			document.body.appendChild(ajaxEditProduct);



		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});
}


