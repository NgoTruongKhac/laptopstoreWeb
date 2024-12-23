<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="sticky-top bg-white shadow-sm">

	<div class="container mt-2 mb-1">
		<div class=row>

			<div class="col-md-3 col-2 mb-1 d-flex align-items-center">
				<a href="${pageContext.request.contextPath}/" class="text-decoration-none"><img
					src="images/laptopStoreLogo.png" class="logoImg"></a>
			</div>
			<div class="col-md-6 col-10 mt-2">

				<form class="d-flex" role="search" method="get"
					action="searchProduct">
					<div class="w-75">
						<input id="searchInput" class="form-control me-2 " type="search"
							placeholder="Tìm kiếm" aria-label="Search" name="searchText">
					</div>
					<button id="btn-search"
						class="ms-2 btn btn-outline-primary btn-sm " type="submit">Tìm
						kiếm</button>
				</form>

				<div id="listProductSuggest" class="row mt-2"
					style="position: fixed;">
					<c:if test="${not empty ListProductSuggest}">
						<jsp:include page="searchSuggest.jsp"></jsp:include>
					</c:if>
				</div>


			</div>
			<div
				class="user col-md-3 col-8 d-flex justify-content-evenly align-items-center">

				<div class="cart">
					<a href="${pageContext.request.contextPath}/viewCart"
						title="Giỏ hàng" style="text-decoration: none;"><i
						class="cart bi bi-cart"></i><span id="cartCount"
						class="badge text-bg-danger"
						<c:if test="${cartCount==0}">style="display: none;"</c:if>>${cartCount}</span>

					</a>
				</div>



				<c:if test="${not empty User}">

					<div class="dropdown">
						<button id="accountIcon" type="button"
							class="login d-flex align-items-center btn btn-outline-primary dropdown-toggle"
							data-bs-toggle="dropdown" aria-expanded="false">
							<i class="bi bi-person"></i> ${User.firstName}
						</button>

						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="userInfo"><i
									class="bi bi-person-vcard me-2"></i>Xem thông tin</a></li>
							<li><a class="dropdown-item" href="myOrder"><i
									class="bi bi-clipboard2-check me-2"></i>Xem đơn hàng</a></li>
							<li><a class="dropdown-item" href="forgotPass.jsp"><i
									class="bi bi-pencil-square me-2"></i>Đổi mật khẩu</a></li>
							<li><button class="dropdown-item" onclick="confirmLogout()">
									<i class="bi bi-box-arrow-right me-2"></i>Đăng xuất
								</button></li>
						</ul>
					</div>

					<script type="text/javascript" src="javaScript/alertLogout.js">
						
					</script>
				</c:if>

				<c:if test="${empty User}">
					<button data-bs-toggle="modal" data-bs-target="#login"
						type="button"
						class="login btn btn-outline-primary d-flex align-items-center btn-sm">
						<i class="bi bi-person"></i> Đăng Nhập
					</button>

				</c:if>

				<button data-bs-toggle="modal" data-bs-target="#register"
					type="button" type="button"
					class="register btn btn-outline-primary d-flex align-items-center btn-sm">
					<i class="bi bi-person-plus me-1"></i> Đăng ký
				</button>


			</div>

		</div>
	</div>
	<nav class="navbar navbar-expand-lg bg-info">
		<div class="container-fluid">

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-text">Danh Mục</span> <span
					class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item me-4"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/"><i
							class="fa-solid fa-house"></i> Trang Chủ</a></li>
					<li class="nav-item me-4"><a class="nav-link active" href="filterLaptop?office=gaming&from=0&to=100000000&title=Laptop văn phòng"><i
							class="fa-solid fa-laptop"></i> Laptop Văn Phòng</a></li>
					<li class="nav-item me-4"><a class="nav-link active" href="filterLaptop?category=gaming&from=0&to=100000000&title=Laptop gaming"><i
							class="fa-solid fa-gamepad"></i> Laptop Gamming</a></li>

					<li class="nav-item dropdown me-4"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"><i
							class="bi bi-tags-fill"></i> Thương Hiệu </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="filterLaptop?brand=asus&from=0&to=100000000&title=Laptop Asus">Asus</a></li>
							<li><a class="dropdown-item" href="filterLaptop?brand=lenovo&from=0&to=100000000&title=Laptop Lenovo">Lenovo</a></li>
							<li><a class="dropdown-item" href="filterLaptop?brand=dell&from=0&to=100000000&title=Laptop Dell">Dell</a></li>
							<li><a class="dropdown-item" href="filterLaptop?brand=acer&from=0&to=100000000&title=Laptop acer">Acer</a></li>
						</ul></li>
					<li class="nav-item dropdown me-4"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"><i
							class='bx bxs-devices me-1'></i>Phụ Kiện</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#"><i
									class='bx bx-mouse-alt me-2'></i>chuột</a></li>
							<li><a class="dropdown-item" href="#"><i
									class="fa-regular fa-keyboard me-2"></i>bàn phím</a></li>
							<li><a class="dropdown-item" href="#"><i
									class="fa-solid fa-headphones me-2"></i>tai nghe</a></li>

						</ul></li>
					<li class="nav-item dropdown me-4"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="#" role="button"><i class="bi bi-funnel me-1"></i>Lọc</a>
						<ul class="dropdown-menu">
							<li><button class="dropdown-item" data-bs-toggle="modal"
									data-bs-target="#filterLaptop">lọc laptop</button></li>
									
									
							<li><button class="dropdown-item" data-bs-toggle="modal"
									data-bs-target="#filterPeripheral">lọc phụ kiện</button></li>


						</ul></li>

				</ul>
			</div>
		</div>
	</nav>
</div>
<%@include file="filterLaptop.jsp" %>
<%@include file="filterPeripheral.jsp" %>
<%@include file="login.jsp"%>
<%@include file="register.jsp"%>

<c:set var="type" value="${requestScope.type}" />
<c:set var="error" value="${requestScope.error}" />

<c:if test="${type == 'error'}">
	<c:if test="${error=='login'}">
		<script type="text/javascript">
			// Đảm bảo trang đã tải xong trước khi mở modal
			document.addEventListener("DOMContentLoaded", function() {
				new bootstrap.Modal(document.getElementById('login')).show();
			});
		</script>
	</c:if>
	<c:if test="${error=='register'}">
		<script type="text/javascript">
			// Đảm bảo trang đã tải xong trước khi mở modal
			document
					.addEventListener("DOMContentLoaded",
							function() {
								new bootstrap.Modal(document
										.getElementById('register')).show();
							});
		</script>
	</c:if>
</c:if>