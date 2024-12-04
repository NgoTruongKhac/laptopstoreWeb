<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<div class="mt-3">
	<h5>Thông tin khách hàng</h5>
</div>
<div class="info row d-flex justify-content-evenly rounded-1">
	<div class="row d-flex justify-content-center mb-3 mt-4">
		<div class="col-md-4 col-5">
			<input class="form-control" type="text" placeholder="Họ"
				value="${User.firstName}" />
		</div>
		<div class="col-md-6 col-7">
			<input class="form-control" type="text" placeholder="Tên"
				value="${User.lastName}" />
		</div>
	</div>
	<div class="row d-flex justify-content-center mb-4">
		<div class="col-md-10 col-12 mb-3">
			<input class="form-control" type="text" placeholder="Số điện thoại"
				value="${User.phoneNumber}" />
		</div>
		<div class="col-md-10 col-12">
			<input class="form-control" type="email" placeholder="email"
				value="${User.email}" />
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
				placeholder="ghi chú khác(nếu có)" />
		</div>
	</div>
</div>


<div
	class="sticky-bottom d-flex justify-content-between align-items-center rounded-1 mb-2"
	style="margin-top: 7rem; background-color: white; z-index: 10">
	<div class="d-flex flex-column mt-1">
		<h5>Tính tổng:</h5>
		<h4 class="text-danger">
			<c:out value="${String.format('%,d', totalPrice)} đ" />
		</h4>
	</div>
	<div>
		<button class="btn btn-outline-primary">Thanh toán</button>
	</div>
</div>
