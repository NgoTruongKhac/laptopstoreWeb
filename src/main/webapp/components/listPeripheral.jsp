<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:if test="${not empty ListPeripheral}">
	<c:forEach var="peripheral" items="${ListPeripheral}">
		<div class="peripheralItem col-6 col-md-3 mb-4">
			<div class="card" style="height: 23rem">
				<div class="card-body" style="margin-top: -13px">
					<a href="http://" style="text-decoration: none; color: black">
						<div class="d-flex justify-content-center">
							<img src="${peripheral.image}" class="card-img-top" alt="..."
								style="width: 11rem; height: 11rem" />
						</div>
						<h6 class="mb-2 card-title" style="padding-left: 30px">
							${peripheral.name}</h6>
						<div class="mb-2 bg-info-subtle rounded-1 d-flex flex-wrap"
							style="font-size: 15px; padding-left: 24px">
							<div class="me-3 ms-1">
								<i class="bi bi-usb-plug-fill me-2"></i>${peripheral.connect}

							</div>
							<c:if test="${peripheral.ledRGB}">
								<div class="me-3 ms-1">
									<i class="bi bi-lightbulb me-2"></i>led RGB
								</div>
							</c:if>

						</div>

						<div class="text-danger text-center" style="font-size: 20px">
							<span id="price"> <c:out
									value="${String.format('%,d', peripheral.price)} đ" /></span>
						</div>

						<div style="font-size: 15px"
							class="mb-1 d-flex justify-content-center">
							<span class="text-warning me-1">0.0</span> <i
								class="bi bi-star-fill text-warning me-1"></i> (0 đánh giá)
						</div>
					</a>
					<div class="col d-flex justify-content-between">
						<a href="#" class="btn btn-outline-primary"
							style="font-size: 13px"> Mua Ngay </a> <a href="#"
							title="thêm vào giỏ hàng" class="btn btn-outline-primary"
							style="font-size: 13px"> <i class="bi bi-cart-plus-fill"></i>
						</a>
					</div>

				</div>
			</div>
		</div>
	</c:forEach>
</c:if>
