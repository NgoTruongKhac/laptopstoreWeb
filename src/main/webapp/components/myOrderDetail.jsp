<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<h1 class="modal-title fs-5" id="orderModalLabel">Chi tiết đơn
				hàng</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal"
				aria-label="Close"></button>
		</div>
		<div class="modal-body row d-flex justify-content-center">
			<div class="mt-3">
				<h6>Sản phẩm đã chọn</h6>
			</div>
			
			<c:forEach var="orderDetail" items="${ListOrderDetail}">
			<div
				class="product row col-md-11 d-flex align-items-center rounded-1 mt-1">
				<div class="col-3 col-md-3">
					<img
						src="${orderDetail.image}"
						alt="" style="width: 50%" />
				</div>
				<div class="col-5 col-md-5 d-flex flex-column">
					<h6 class="d-flex justify-content-center">${orderDetail.name}</h6>
					<h5 class="d-flex justify-content-center text-danger">
						<c:out value="${String.format('%,d', orderDetail.price)} đ" />
					</h5>
				</div>
				<div class="col-4 col-md-4 d-flex justify-content-center">
					số lượng: <span class="quantity ms-1">${orderDetail.quantity}</span>
				</div>
			</div>
			</c:forEach>
			<div class="mt-3 mb-1">
				<h6>Thông tin đặt hàng</h6>
			</div>
			<div
				class="info row col-md-11 d-flex justify-content-center rounded-1">
				<div class="d-flex justify-content-between flex-row mt-2">
					<p class="d-flex align-items-center"><i class="bi bi-person me-2"></i>Khách hàng :</p>
					<div class="d-flex flex-row">
						<p class="me-2">${userInfo.lastName}</p>
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
						<p style="text-align: right">
							${userInfo.street},${userInfo.ward},${userInfo.district},${userInfo.province}
						</p>
					</div>
				</div>
					<div class="d-flex justify-content-between flex-row">
					<div class="col-md-5 col-5">
						<p><i class="bi bi-journal-text me-1"></i>ghi chú :</p>
					</div>
					<div class="col-md-7 col-7">
						<p style="text-align: right">
							${userInfo.note}
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button onclick="cancelMyOrder(${orderDetail.orderId},${pageOrder})" type="button" class="btn btn-primary">Huỷ</button>
		</div>
	</div>
</div>
