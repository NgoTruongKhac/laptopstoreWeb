<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="product row d-flex align-self-center rounded-2"
	style="width: 90%;">
	<div class="col-md-5 col-12 d-flex justify-content-center">
		<img src="${Laptop.image}" alt="" style="width: 65%" />
	</div>
	<div class="col-md-7 col-12" style="border-left: solid 1px #0d6efd">
		<div class="d-flex justify-content-center mt-4">
			<h3>${Laptop.name}</h3>
		</div>
		<div class="d-flex flex-row ms-5 mt-2">
			<div class="d-flex flex-row me-4">
				<p class="text-warning me-1">${rate}/5</p>
				<i class="bi bi-star-fill text-warning"></i>
			</div>
			<a href="#" id="scroll-to-review" style="text-decoration: none">xem
				đánh giá</a>
		</div>
		<div class="d-flex justify-content-center mt-3">
			<h2 class="text-danger">
				<c:out value="${String.format('%,d', Laptop.price)} đ" />
			</h2>
		</div>
		<div class="d-flex justify-content-evenly mt-3 mb-3">
			<a
				href="${pageContext.request.contextPath}/buyNow?productId=${Laptop.laptopId}"
				class="buy-now btn btn-outline-primary"
				style="width: 40%;">Mua ngay</a>
			<button onclick="addToCart(${Laptop.laptopId})"
				class="add-cart btn btn-outline-primary"
				style="width: 15%;">
				<i class="bi bi-cart-plus"></i>
			</button>
		</div>
	</div>
</div>
<div class="detail row d-flex align-self-center mt-3 rounded-2"
	style="width: 90%;">
	<div class="col-md-6 col-12">
		<div class="mt-3 mb-3">
			<h4>Thông tin chi tiết</h4>
		</div>
		<div>
			<p>${Laptop.description}</p>
		</div>
	</div>
	<div class="col-md-6 col-12" style="border-left: solid 1px #0d6efd">
		<div class="mt-3 mb-3">
			<h4>Thông số kĩ thuật</h4>
		</div>
		<div>
			<table class="table table-striped">
				<tbody>
					<tr>
						<td>CPU</td>
						<td>${Laptop.cpu}</td>
					</tr>
					<tr>
						<td>Card đồ hoạ</td>
						<td>${Laptop.gpu}</td>
					</tr>
					<tr>
						<td>RAM</td>
						<td>${Laptop.ram}</td>
					</tr>
					<tr>
						<td>Dung lượng lưu trữ</td>
						<td>${Laptop.drive}</td>
					</tr>
					<tr>
						<td>Kích thước màn hình</td>
						<td>${Laptop.size}</td>
					</tr>
					<tr>
						<td>Độ phân giải</td>
						<td>${Laptop.resolution}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>