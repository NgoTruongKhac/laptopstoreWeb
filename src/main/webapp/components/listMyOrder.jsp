<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="table-responsive">
	<table class="table table table-bordered table-striped text-center"
		style="vertical-align: middle">
		<thead>
			<tr>
				<th scope="col" class="col-md">Mã đơn</th>
				<th scope="col" class="col-md">Tổng giá</th>
				<th scope="col" class="col-md">Pt thanh toán</th>
				<th scope="col" class="col-md">ngày đặt</th>
				<th scope="col" class="col-md">Trạng thái</th>
				<th scope="col" class="col-md">Chi tiết</th>
				<th scope="col" class="col-md">Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty ListOrder}">
				<c:forEach var="order" items="${ListOrder}">
					<tr>
						<th scope="row">${order.orderId}</th>

						<td><c:out
								value="${String.format('%,d', order.totalPrice)} đ" /></td>
						<td>${order.payment}</td>
						<td>${order.orderDate}</td>
						<td>${order.state}</td>
						<td>
							<button data-bs-toggle="modal" data-bs-target="#orderDetail"
								class="btn btn-outline-primary"
								onclick="myOrderDetail(${order.orderId},${pageOrder})">chi
								tiết</button>
						</td>
						<c:if test="${order.state == 'chưa xác nhận'}">
							<td>
								<button onclick="cancelMyOrder(${order.orderId},${pageOrder})"
									class="btn btn-outline-danger">Huỷ</button>
							</td>
						</c:if>

						<c:if test="${order.state == 'đã giao'}">
							<td>
								<button type="button" class="btn btn-outline-success"
									onclick="confirmReceived(${order.orderId},${pageOrder})">Xác nhận</button>
							</td>
						</c:if>
						<c:if test="${order.state == 'đã huỷ'}">
							<td>
								<button onclick="deleteMyOrder(${order.orderId},${pageOrder})"
									class="btn btn-outline-danger">Xoá</button>
							</td>
						</c:if>
						<c:if test="${order.state == 'đã nhận'}">
							<td>
								<button type="button" class="btn btn-outline-success"
								data-bs-toggle="modal" data-bs-target="#selectReview"	onclick="selectReview(${order.orderId},${pageOrder})">Đánh giá</button>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>
<div class="modal fade" id="orderDetail" tabindex="-1"
	aria-labelledby="orderModalLabel" aria-hidden="true">
	<%@include file="myOrderDetail.jsp"%>
</div>
<div class="modal fade mt-5" id="selectReview" tabindex="-1"
	aria-labelledby="orderModalLabel" aria-hidden="true">
	<%@include file="selectReview.jsp"%>
</div>

<div class="d-flex justify-content-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item ${pageOrder== 1 ? 'disabled' : ''}"><a
				class="page-link" href="javascript:void(0);"
				onclick="loadPageMyOrder(${pageOrder - 1})" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach var="i" begin="1" end="${totalPageOrder}">
				<li class="page-item ${i == pageOrder? 'active' : ''}"><a
					class="page-link" href="javascript:void(0);"
					onclick="loadPageMyOrder(${i})">${i}</a></li>
			</c:forEach>
			<li
				class="page-item ${pageOrder == totalPageOrder ? 'disabled' : ''}">
				<a class="page-link" href="javascript:void(0);"
				onclick="loadPageMyOrder(${pageOrder + 1})" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</a>
			</li>
		</ul>
	</nav>
</div>