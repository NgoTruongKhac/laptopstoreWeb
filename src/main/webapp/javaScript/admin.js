// const hamBurger = document.querySelector(".toggle-btn");

// hamBurger.addEventListener("click", function () {
//   document.querySelector("#sidebar").classList.toggle("expand");
// });
// document.addEventListener("DOMContentLoaded", () => {
//   // Hiển thị Quản trị mặc định
//   showSection("dashboard");
// });

const hamBurger = document.querySelector(".toggle-btn");

hamBurger.addEventListener("click", function () {
  const sidebar = document.querySelector("#sidebar");
  sidebar.classList.toggle("expand");

  // Kiểm tra kích thước màn hình khi mở sidebar
  if (window.innerWidth <= 768) {
    document.body.classList.toggle("sidebar-open");
  }
});

// Đóng sidebar khi nhấp bên ngoài trên màn hình di động
document.addEventListener("click", function (event) {
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

// // Hàm hiển thị nội dung theo section và cập nhật sidebar
function showSection(sectionId) {
  // Ẩn tất cả nội dung
  document.querySelectorAll(".content-section").forEach((section) => {
    section.classList.remove("active");
  });

  // Hiện nội dung được chọn
  document.getElementById(sectionId).classList.add("active");

  // Xóa trạng thái active của tất cả sidebar items
  document.querySelectorAll(".sidebar-item").forEach((item) => {
    item.classList.remove("active");
  });

  // Thêm trạng thái active cho item được chọn
  document
    .querySelector(`.sidebar-item[data-section='${sectionId}']`)
    .classList.add("active");
}

// function showSection(section) {
//   // Xóa lớp active khỏi tất cả các sidebar-item
//   document.querySelectorAll(".sidebar-item").forEach((item) => {
//     item.classList.remove("active");
//   });

//   // Thêm lớp active vào mục được chọn
//   const activeItem = document.querySelector(
//     `.sidebar-item[data-section="${section}"]`
//   );
//   if (activeItem) {
//     activeItem.classList.add("active");
//   }

//   // Ẩn tất cả các phần nội dung
//   document.querySelectorAll(".content-section").forEach((section) => {
//     section.classList.remove("active");
//   });

//   // Hiển thị phần nội dung tương ứng
//   const activeSection = document.getElementById(section);
//   if (activeSection) {
//     activeSection.classList.add("active");
//   }
// }

// // Đảm bảo rằng phần `dashboard` được active ngay từ đầu
// document.addEventListener("DOMContentLoaded", () => {
//   showSection("dashboard");
// });
