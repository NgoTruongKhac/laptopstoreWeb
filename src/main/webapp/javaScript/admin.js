
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

	// Xóa các script đã thêm trước đó
	document.querySelectorAll("script.dynamic-script").forEach((script) => {
		script.remove();
	});
	// Đặt URL servlet tương ứng dựa trên sectionId
	var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))


	// Gọi AJAX để tải nội dung cho section
	if (sectionId === "Product") {
		$.ajax({
			url: contextPath + "/adminPage/listProduct",
			type: "get",
			dataType: "html",
			success: function(response) {
				document.getElementById("Product").innerHTML = response;

				// Tải script liên quan đến Product
				addDynamicScript('javaScript/previewImage.js');
				addDynamicScript('javaScript/ajaxAddProduct.js');
				addDynamicScript('javaScript/ajaxEditProduct.js');
			},
			error: function(xhr, status, error) {
				console.error("Error loading Product section:", error);
			}
		});
	} else if (sectionId === "User") {
		$.ajax({
			url: contextPath + "/adminPage/listUser",
			type: "get",
			dataType: "html",
			success: function(response) {
				document.getElementById("listUserManage").innerHTML = response;

				// Tải script liên quan đến User
				addDynamicScript('javaScript/ajaxAddUser.js');
				addDynamicScript('javaScript/selectAvatar.js');
				addDynamicScript('javaScript/alertDeleteUser.js');
			},
			error: function(xhr, status, error) {
				console.error("Error loading User section:", error);
			}
		});
	}
}

// Hàm để thêm script động với class "dynamic-script"
function addDynamicScript(src) {
	const script = document.createElement('script');
	script.type = 'text/javascript';
	script.src = src;
	script.classList.add('dynamic-script'); // Gắn class để nhận diện
	document.body.appendChild(script);
}


