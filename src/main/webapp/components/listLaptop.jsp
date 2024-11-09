<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container my-4">
	<div class="row">
		<c:if test="${not empty ListLaptop}">
			<c:forEach var="laptop" items="${ListLaptop}">
				<div class="col-6 col-md-3 mb-4">
					<div class="card">
						<div class="card-body" style="margin-top: -13px">
							<a href="http://" style="text-decoration: none; color: black">
								<img
								src="${laptop.image}"
								class="card-img-top" alt="..." />
								<h6 class="mb-2 card-title" style="padding-left: 30px">
									${laptop.name}</h6>

								<div class="mb-2 bg-info-subtle rounded-1 d-flex flex-wrap"
									style="font-size: 15px; padding-left: 24px">
									<div class="me-3 ms-1">
										<i class="bi bi-cpu-fill me-1"></i>${laptop.cpu}
									</div>
									<div class="me-3 ms-1">
										<i class="bi bi-gpu-card me-1"></i>${laptop.gpu }
									</div>
									<div class="me-3 ms-1">
										<i class="bi bi-memory me-1"></i>${laptop.ram }
									</div>
									<div class="me-3 ms-1">
										<i class="bi bi-device-ssd-fill me-1"></i>${laptop.drive }
									</div>
									<div class="me-3 ms-1">
										<i class="bi bi-tv me-1"></i>${laptop.size} ${laptop.resolution}
									</div>
								</div>

								<div class="text-danger text-center" style="font-size: 20px">
									<span id="price"> <c:out value="${String.format('%,d', laptop.price)} đ" /></span>
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
	</div>
</div>