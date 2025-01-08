<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
			<h1 class="modal-title fs-5" id="orderModalLabel">Đánh giá</h1>
			<button type="button" class="btn-close" data-bs-dismiss="modal"
				aria-label="Close"></button>
		</div>
			<div class="modal-body row d-flex justify-content-center">

				<div class="mt-3">
					<h6>Chọn sản phẩm để đánh giá</h6>
				</div>
				<c:forEach var="orderDetail" items="${ListOrderDetail}">
					<a href="${pageContext.request.contextPath}/detailProduct?productId=${orderDetail.productId}&type=${orderDetail.type}"
						class="product row col-md-11 d-flex align-items-center rounded-1 mt-1">
						<div class="col-5 col-md-3 d-flex justify-content-center">
							<img src="${orderDetail.image}" alt="" style="width: 50%" />
						</div>
						<div class="col-7 col-md-5 d-flex flex-column justify-content-center">
							<h6 class="d-flex justify-content-center">${orderDetail.name}</h6>
							<h5 class="d-flex justify-content-center text-danger">
								<c:out value="${String.format('%,d', orderDetail.price)} đ" />
							</h5>
						</div>
					</a>
				</c:forEach>
			</div>
			
	</div>
</div>
