
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
