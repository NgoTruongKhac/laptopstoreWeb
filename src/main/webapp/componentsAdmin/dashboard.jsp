<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="dashboard" class="content-section active container-fluid mt-2">
	<div class="row">
		<div class="mb-4 d-flex justify-content-center">
			<h4>Dashboard</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 mb-3">
			<div class="card text-dark h-100">
				<div class="card-body py-3 d-flex flex-row justify-content-between">
					<div>
						Tài Khoản<i class="fas fa-solid fa-users ms-2"></i>
					</div>
					<div>
						<em class="me-1 text-decoration-through">số lượng</em>(${Dashboard.quantityUser})
					</div>
				</div>
				<a class="card-footer d-flex"
					href="${pageContext.request.contextPath}/adminPage/listUser">
					xem chi tiết <span class="ms-auto"> <i
						class="bi bi-chevron-right"></i>
				</span>
				</a>
			</div>
		</div>
		<div class="col-md-4 mb-3">
			<div class="card text-dark h-100">
				<div class="card-body py-3 d-flex flex-row justify-content-between">
					<div>Sản phẩm<i class="fas fa-solid fa-table ms-2"></i></div>
					<div>
						<em class="me-1 text-decoration-through">số lượng</em>(${Dashboard.quantityProduct})
					</div>
				</div>
				<a class="card-footer d-flex"
					href="${pageContext.request.contextPath}/adminPage/listProduct">
					xem chi tiết <span class="ms-auto"> <i
						class="bi bi-chevron-right"></i>
				</span>
				</a>
			</div>
		</div>
		<div class="col-md-4 mb-3">
			<div class="card text-dark h-100">
				<div class="card-body py-3 d-flex flex-row justify-content-between">
					<div>Đơn hàng<i class="fas fa-solid fa-clipboard-list ms-2"></i></div>
					<div>
						<em class="me-1 text-decoration-through">số lượng</em>(${Dashboard.quantityOrder})
					</div>
				</div>
				<a class="card-footer d-flex"
					href="${pageContext.request.contextPath}/adminPage/listOrder"
					style="text-decoration: none"> xem chi tiết <span
					class="ms-auto"> <i class="bi bi-chevron-right"></i>
				</span>
				</a>
			</div>
		</div>
	</div>
</div>