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
<link href="https://cdn.lineicons.com/4.0/lineicons.css"
	rel="stylesheet" />
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
	<div class="wrapper">
		<aside id="sidebar"
			style="border-right: solid; position: fixed; z-index: 1002; height: 100%;">
			<div class="d-flex">
				<button class="toggle-btn" type="button">
					<i class="lni lni-grid-alt"></i>
				</button>
				<div class="sidebar-logo">
					<img src="images/laptopStoreLogo.png" alt="" style="width: 120px" />
				</div>
			</div>
			<ul class="sidebar-nav">
				<li class="sidebar-item ${activeDashboard}" data-section="dashboard"><a
					href="${pageContext.request.contextPath}/adminPage"
					class="sidebar-link"> <i class="bi bi-speedometer2"></i> <span>Quản
							trị</span>
				</a></li>
				<li class="sidebar-item ${activeUser}" data-section="User"><a
					href="${pageContext.request.contextPath}/adminPage/listUser"
					class="sidebar-link"> <i class="bi bi-people"></i> <span>Tài
							Khoản</span>
				</a></li>
				<li class="sidebar-item ${activeProduct}" data-section="Product"><a
					href="${pageContext.request.contextPath}/adminPage/listProduct"
					class="sidebar-link"> <i class="lni lni-agenda"></i> <span>Sản
							Phẩm</span>
				</a></li>
				<li class="sidebar-item ${activeOrder}" data-section="Order"><a
					href="${pageContext.request.contextPath}/adminPage/listOrder"
					class="sidebar-link"> <i class="bi bi-bag-check"></i> <span>Đơn
							hàng</span>
				</a></li>
			</ul>
		</aside>
		<div class="main">
			<div
				style="position: fixed; z-index: 1001; width: 95%; margin-left: 65px; margin-top: -5px">
				<nav class="navbar navbar-expand-md px-4 py-3 "
					style="border-bottom: solid">

					<!-- Đặt ms-auto để di chuyển nút navbar-toggler sang phải -->
					<button style="margin-left: 17rem" class="navbar-toggler"
						type="button" data-bs-toggle="collapse"
						data-bs-target="#navbarToggler" aria-controls="navbarToggler"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarToggler">
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

						<div class="dropdown" style="margin-right: 64px">
							<!-- Thêm btn-sm để nút đăng nhập nhỏ gọn hơn ở màn hình nhỏ -->
							<button id="accountIcon" type="button"
								class="d-flex align-items-center btn btn-outline-primary dropdown-toggle btn-sm"
								data-bs-toggle="dropdown" aria-expanded="false"
								style="height: 45px">
								<i class="bi bi-person"></i> ${User.firstName}
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
						</div>
					</div>
				</nav>
			</div>


			<div style="margin-top: 70px; overflow: hidden; margin-left: 70px">

				<main class="content px-3 py-4">
					<!-- session dashboard -->
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
