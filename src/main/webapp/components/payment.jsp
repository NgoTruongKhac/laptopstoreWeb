<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mt-2">
	<h5>Thông tin đặt hàng</h5>
</div>
<div class="info row d-flex justify-content-center rounded-1">
	<div class="d-flex justify-content-between flex-row mt-2">
		<p class="d-flex align-items-center"><i class="bi bi-person me-2"></i>Khách hàng :</p>
		<div class="d-flex flex-row">

			<p class="me-1">${userInfo.lastName}</p>
			<p>${userInfo.firstName}</p>
		</div>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<p><i class="bi bi-telephone me-2"></i>số điện thoại :</p>
		<p>${userInfo.phoneNumber}</p>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<p><i class="bi bi-envelope me-2"></i>email :</p>
		<p>${userInfo.email}</p>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<div class="col-md-5 col-5">

			<p><i class="bi bi-geo-alt me-2"></i>địa chỉ nhận hàng :</p>
		</div>
		<div class="col-md-7 col-7">
			<p style="text-align: right;">${userInfo.street},${userInfo.ward},${userInfo.district},${userInfo.province}</p>
		</div>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<div class="col-md-5 col-5">

			<p><i class="bi bi-journal-text me-2"></i>ghi chú :</p>
		</div>
		<div class="col-md-7 col-7">
			<p style="text-align: right;">${userInfo.note}</p>
		</div>
	</div>
</div>
<div class="mt-2">
	<h5>Giảm giá & ưu đãi</h5>
</div>
<div class="price row d-flex justify-content-center rounded-1">
	<div class="d-flex justify-content-between flex-row mt-3 mb-3">
		<div class="col-md-9 col-8">
			<input type="text" placeholder="  Nhập mã giảm giá (voucher)"
				class="form-control" />
		</div>
		<div class="col-md-2 col-4 d-flex justify-content-center">
			<button class="btn btn-outline-primary">Áp dụng</button>
		</div>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<p>Giá gốc :</p>
		<p>
			<c:out value="${String.format('%,d', totalPrice)} đ" />
		</p>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<p>Phí vận chuyển :</p>
		<p>15,000 đ</p>
	</div>
	<div class="d-flex justify-content-between flex-row">
		<p>Giá được giảm :</p>
		<p>0 đ</p>
	</div>
	<hr style="border-top: 2px solid;" />
	<div class="d-flex justify-content-between flex-row">
		<p>Tổng tiền :</p>
		<p>
			<c:out value="${String.format('%,d', totalPrice)} đ" />
		</p>
	</div>
</div>
<div class="mt-3">
	<h5>Phương thức thanh toán</h5>
</div>
<div class="methodPayment row d-flex justify-content-center rounded-1">
	<div class="mt-4 mb-4">
		<div class="row d-flex justify-content-center">
			<button type="button" class="paymentMethod btn btn-outline-primary"
				data-bs-toggle="modal" data-bs-target="#paymentMethodModal"
				style="width: 70%">Chọn phương thức thanh toán</button>
		</div>
	</div>
</div>


<form action="orderComplete" method="post"
	class="sticky-bottom row d-flex justify-content-between align-items-center rounded-1 mb-2"
	style="margin-top: 2rem; background-color: white; z-index: 10;">

	<div class="col-md-6 d-flex flex-column mt-1">
		<h5>Tính tổng:</h5>
		<h4 class="text-danger">
			<c:out value="${String.format('%,d', totalPrice)} đ" />
		</h4>

	</div>
	<input type="text" name="finalPrice" value="${totalPrice}" hidden="true">
	<div class="col-md-6 d-flex justify-content-end">
		<button type="submit" class="btn btn-outline-primary">Thanh
			toán</button>
	</div>
</form>



<!-- modal -->

<div class="modal fade mt-5" id="paymentMethodModal" tabindex="-1"
	aria-labelledby="paymentModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="paymentModalLabel">phương thức
					thanh toán</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="payment row rounded-1 d-flex align-items-center mb-1"
					style="border: solid 1px">
					<div class="col-md-3 col-3">
						<img class="imagePayment" src="images/cod.png" alt="" />
					</div>
					<div class="col-md-8 col-7">
						<h6>Thanh toán khi nhận hàng</h6>
					</div>
					<div class="col-md-1 col-2">
						<i class="checked bi bi-check-circle"></i>
					</div>
				</div>
				<div class="payment row rounded-1 d-flex align-items-center mb-1"
					style="border: solid 1px">
					<div class="col-md-3 col-3">
						<img class="imagePayment"
							src="https://static.vecteezy.com/system/resources/previews/021/115/776/non_2x/qr-code-free-png.png"
							alt="" />
					</div>
					<div class="col-md-8 col-7">
						<h6>Chuyển khoản</h6>
					</div>
					<div class="col-md-1 col-2">
						<i class="checked bi bi-check-circle"></i>
					</div>
				</div>
				<div class="payment row rounded-1 d-flex align-items-center mb-1"
					style="border: solid 1px">
					<div class="col-md-3 col-3">
						<img class="imagePayment"
							src="https://cdn.haitrieu.com/wp-content/uploads/2022/10/Icon-VNPAY-QR-350x274.png"
							alt="" />
					</div>
					<div class="col-md-8 col-7">
						<h6>ví VNPay</h6>
					</div>
					<div class="col-md-1 col-2">
						<i class="checked bi bi-check-circle"></i>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">áp dụng</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="javaScript/payment.js">
	
</script>
