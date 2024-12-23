<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mt-2">
	<h5>Sản phẩm đã chọn</h5>
</div>
<c:forEach var="product" items="${ListCartItem}">
	<div class="product row d-flex align-items-center rounded-1 mt-2">

		<div class="col-3 col-md-3">
			<img src="${product.image}" alt="" style="width: 60%" />
		</div>
		<div class="col-5 col-md-5 d-flex flex-column">
			<h6 class="d-flex justify-content-center">${product.name}</h6>
			<h5 class="d-flex justify-content-center text-danger">
				<c:out value="${String.format('%,d', product.price)} đ" />
			</h5>
		</div>
		<div class="col-4 col-md-4 d-flex justify-content-center">
			số lượng: <span class="quantity ms-1">${product.quantity}</span>
		</div>
	</div>
</c:forEach>
<form action="payment" method="post">
	<div class="mt-3">
		<h5>Thông tin khách hàng</h5>
	</div>

	<div class="info row d-flex justify-content-evenly rounded-1">
		<div class="row d-flex justify-content-center mb-3 mt-4">
			<div class="row col-md-10 d-flex justify-content-end">
				<div class="col-md-1">
					<label for="" class="form-label">Họ</label>
				</div>
				<div class="col-md-3">
					<input class="form-control" type="text" name="lastName"
						value="${User.lastName}" />
				</div>
				<div class="col-md-1">
					<label for="Tên" class="form-label">Tên</label>
				</div>
				<div class="col-md-5">
					<input class="form-control" type="text" name="firstName"
						value="${User.firstName}" />
				</div>
			</div>
		</div>
		<div class="row d-flex justify-content-center mb-4">
			<div class="row col-md-10 col-12 mb-3 d-flex align-items-center">
				<div class="col-md-3">
					<label for="" class="form-label">Số điện thoại</label>
				</div>
				<div class="col-md-9">
					<input class="form-control" type="text" name="phoneNumber"
						value="${User.phoneNumber}" />
				</div>
			</div>
			<div class="row col-md-10 col-12 d-flex align-items-center">
				<div class="col-md-3">
					<label for="" class="form-label">email</label>
				</div>
				<div class="col-md-9">
					<input class="form-control" type="email" name="email"
						value="${User.email}" />
				</div>
			</div>
		</div>
	</div>
	<div class="mt-2">
		<h5>Địa chỉ</h5>
	</div>
	<div class="address row d-flex justify-content-evenly rounded-1">
		<div class="row d-flex justify-content-center mt-4 mb-3">
			<div class="col-md-6 col-12 mb-3">
				<select class="form-select form-select-sm" id="city" name="province">
					<c:if test="${empty Address}">
						<option value="" selected>Chọn tỉnh thành</option>
					</c:if>
					<c:if test="${not empty Address}">
						<option value="${Address.province}" selected>${Address.province}</option>
					</c:if>
				</select>
			</div>
			<div class="col-md-6 col-12">
				<select class="form-select form-select-sm" id="district"
					name="district">
					<c:if test="${empty Address}">
						<option value="" selected>Chọn quận huyện</option>
					</c:if>
					<c:if test="${not empty Address}">
						<option value="${Address.district}" selected>${Address.district}</option>
					</c:if>
				</select>
			</div>
		</div>
		<div class="row d-flex justify-content-center mb-3">
			<div class="col-md-6 col-12 mb-3">
				<select class="form-select form-select-sm" id="ward" name="ward">
					<c:if test="${empty Address}">
						<option value="" selected>Chọn phường xã</option>
					</c:if>
					<c:if test="${not empty Address}">
						<option value="${Address.ward}" selected>${Address.ward}</option>
					</c:if>
				</select>
			</div>
			<div class="col-md-6 col-12">
				<input class="form-control" type="text" name="street"
					value="${Address.street}" required="required"
					placeholder="số nhà,tên đường" />
			</div>
		</div>
		<div class="row d-flex justify-content-center mb-4">
			<div class="col-md-12 col-12">
				<input class="col-md-12 form-control" type="text"
					placeholder="ghi chú khác(nếu có)" name="note" />
			</div>
		</div>
	</div>


	<div
		class="sticky-bottom row d-flex justify-content-between align-items-center rounded-1 mb-2"
		style="margin-top: 2rem; background-color: white; z-index: 10;">
		<div class="col-md-6 d-flex flex-column mt-1">
			<h5>Tính tổng:</h5>
			<h4 class="text-danger">
				<c:out value="${String.format('%,d', totalPrice)} đ" />
			</h4>
		</div>
		<div class="col-md-6 d-flex justify-content-end">
			<button type="submit" class="btn btn-outline-primary">Đặt
				hàng</button>
		</div>
	</div>
</form>
