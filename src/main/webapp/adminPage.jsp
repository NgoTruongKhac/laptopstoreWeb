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
<%@ include file="styleCSS/allCss.jsp"%>
<link rel="stylesheet" href="styleCSS/adminCSS.css" />
<link rel="stylesheet" href="styleCSS/modalAddLaptop.css" />
<link rel="stylesheet" href="styleCSS/avatar.css" />


</head>
<body>

<jsp:include page="components/alert.jsp"></jsp:include>
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
				<li class="sidebar-item active" data-section="dashboard"><a
					href="javascript:void(0)" class="sidebar-link"
					onclick="showSection('dashboard')"> <i
						class="bi bi-speedometer2"></i> <span>Quản trị</span>
				</a></li>
				<li class="sidebar-item" data-section="User"><a
					href="javascript:void(0)" class="sidebar-link"
					onclick="showSection('User')"> <i class="bi bi-people"></i> <span>Tài
							Khoản</span>
				</a></li>
				<li class="sidebar-item" data-section="Product"><a
					href="javascript:void(0)" class="sidebar-link"
					onclick="showSection('Product')"> <i class="lni lni-agenda"></i>
						<span>Sản Phẩm</span>
				</a></li>
				<li class="sidebar-item" data-section="Order"><a
					href="javascript:void(0)" class="sidebar-link"
					onclick="showSection('Order')"> <i class="bi bi-bag-check"></i>
						<span>Đặt hàng</span>
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
								<li><a class="dropdown-item" href="userInfo"><i
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
					<div id="dashboard"
						class="content-section active container-fluid mt-2"
						style="height: 87vh">
						<div class="row">
							<div class="col-md-12">
								<h4>Quản trị</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4 mb-3">
								<div class="card text-dark h-100" style="border: solid red">
									<div class="card-body py-3">Tài Khoản</div>
									<div class="card-footer d-flex">
										xem chi tiết <span class="ms-auto"> <i
											class="bi bi-chevron-right"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-3">
								<div class="card text-dark h-100" style="border: solid yellow">
									<div class="card-body py-3">Sản phẩm</div>
									<div class="card-footer d-flex">
										xem chi tiết <span class="ms-auto"> <i
											class="bi bi-chevron-right"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-3">
								<div class="card text-dark h-100" style="border: solid green">
									<div class="card-body py-3">Đặt hàng</div>
									<div class="card-footer d-flex">
										xem chi tiết <span class="ms-auto"> <i
											class="bi bi-chevron-right"></i>
										</span>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div id="User" class="content-section">
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
						<div id="listUserManage"></div>



					</div>
					<div id="Product" class="content-section"></div>

					<div id="Order" class="content-section">
						<h4>Dat hang</h4>
					</div>
				</main>
			</div>
		</div>
	</div>

	
	<script type="text/javascript" src="javaScript/admin.js"></script>
	<script type="text/javascript" src="javaScript/alertLogout.js"></script>
	<script type="text/javascript" src="javaScript/pagination.js"></script>
	<script type="text/javascript" src="javaScript/alertDeleteProduct.js"></script>
	<script type="text/javascript" src="javaScript/selectAvatar.js"></script>




</body>
</html>
