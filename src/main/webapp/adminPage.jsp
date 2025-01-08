<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge" /> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sidebar With Bootstrap</title>
<%@ include file="/styleCSS/allCss.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styleCSS/adminCSS.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styleCSS/modalAddLaptop.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styleCSS/avatar.css" />

</head>
<body>

	<jsp:include page="/components/alert.jsp"></jsp:include>

	<div class="d-flex" id="wrapper">
		<!-- Sidebar -->
		<div class="bg-info-subtle" id="sidebar-wrapper"
			style="border-right: solid 1px;">
			<div
				class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
				<img src="images/laptopStoreLogo.png" alt="" style="width: 150px" />
			</div>
			<div class="list-group list-group-flush my-3">
				<a href="${pageContext.request.contextPath}/adminPage"
					class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeDashboard}"><i
					class="fas fa-tachometer-alt me-2"></i>Dashboard</a> <a
					href="${pageContext.request.contextPath}/adminPage/listUser"
					class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeUser}"><i
					class="fas fa-solid fa-users me-2"></i>Tài khoản</a> <a
					href="${pageContext.request.contextPath}/adminPage/listProduct"
					class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeProduct}"><i
					class="fas fa-solid fa-table me-2"></i>Sản Phẩm</a> <a
					href="${pageContext.request.contextPath}/adminPage/listOrder"
					class="list-group-item list-group-item-action bg-transparent second-text fw-bold ${activeOrder}"><i
					class="fas fa-solid fa-clipboard-list me-2"></i>Đơn hàng</a>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<nav
				class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4"
				style="border-bottom: solid 1px">
				<div class="d-flex align-items-center">
					<i class="fas fa-align-left primary-text fs-4 me-3"
						id="menu-toggle"></i>

				</div>

				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse me-2"
					id="navbarSupportedContent">
					<form class="d-flex flex-grow-1"
						style="display: flex; justify-content: center;" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Tìm kiếm" aria-label="Search"
							style="max-width: 200px" />
						<!-- Thêm btn-sm để giảm kích thước nút ở màn hình nhỏ -->
						<button class="ms-2 btn btn-outline-primary btn-sm" type="submit">
							Tìm kiếm</button>
					</form>
					<div>
						<a href="#" style="font-size: 22px; margin-right: 13px"> <i
							class="bi bi-bell"></i>
						</a>
					</div>
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-4">
						<li class="nav-item dropdown"><button
								class="nav-link dropdown-toggle fw-bold" id="navbarDropdown"
								data-bs-toggle="dropdown" aria-expanded="false">
								<i class="fas fa-user me-2"></i>${User.firstName}
							</button>

							<ul class="dropdown-menu">
								<li><a class="dropdown-item"
									href="${pageContext.request.contextPath}/userInfo"><i
										class="bi bi-person-vcard me-2"></i>Xem thông tin</a></li>
								<li>
									<button class="dropdown-item" onclick="confirmLogout()">
										<i class="bi bi-box-arrow-right me-2"></i>Đăng xuất
									</button>
								</li>
							</ul>
					</ul>
				</div>
			</nav>

			<!-- main -->
			<main class="content px-3 py-4">
				<c:if test="${not empty activeDashboard}">
					<jsp:include page="${dynamicSection}"></jsp:include>
				</c:if>
				<!-- session product -->
				<c:if test="${not empty activeProduct}">
					<jsp:include page="${dynamicSection}"></jsp:include>
				</c:if>
				<!-- session user -->
				<c:if test="${not empty activeUser}">

					<div class="mb-4 d-flex justify-content-center">
						<h4>Tài Khoản</h4>
					</div>
					<div class="mb-4 d-flex justify-content-end">
						<button data-bs-toggle="modal" data-bs-target="#addUser"
							class="btn btn-outline-primary btn-sm">
							<i class="bi bi-plus-lg me-1"></i>Tài khoản
						</button>
						<%@include file="/componentsAdmin/addUser.jsp"%>
					</div>
					<jsp:include page="${dynamicSection}"></jsp:include>
				</c:if>
				<!-- session order -->
				<c:if test="${not empty activeOrder}">
					<div class="mb-4 d-flex justify-content-center">
						<h4>Đơn Hàng</h4>
					</div>
					<jsp:include page="${dynamicSection}"></jsp:include>
				</c:if>
			</main>

		</div>
	</div>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javaScript/admin.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javaScript/alertLogout.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javaScript/pagination.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javaScript/selectAvatar.js"></script>

	<c:if test="${not empty activeProduct}">

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/ajaxAddProduct.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/alertDeleteProduct.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/ajaxEditProduct.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/previewImage.js"></script>

	</c:if>

	<c:if test="${not empty activeUser}">

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/ajaxAddUser.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/alertDeleteUser.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/ajaxEditUser.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/previewImage.js"></script>


	</c:if>
	<c:if test="${not empty activeOrder}">
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/ajaxOrderDetail.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/javaScript/confirmOrder.js"></script>

	</c:if>



</body>
</html>
