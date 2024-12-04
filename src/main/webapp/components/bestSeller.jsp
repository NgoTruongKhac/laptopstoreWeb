<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="carouselExampleControls" class="carousel">
	<div class="carousel-inner">
		<c:if test="${not empty BestSeller}">
			<c:forEach var="laptop" items="${BestSeller}" varStatus="status">
				<div class="carousel-item ${status.first ? 'active' : ''}">
					<div class="card-seller"
						style="background-color: white; flex: 1 0 20%; height: 24rem">
						<div class="card-body" style="margin-top: -13px">
							<a href="${pageContext.request.contextPath}/detailLaptop?laptopId=${laptop.laptopId}" style="text-decoration: none; color: black"
								draggable="false">
								<div class="d-flex justify-content-center">
									<img src="${laptop.image}" class="cardSellerImg card-img-top" alt="..."
										 draggable="false" />
								</div>
								<h6 class="name mb-2 card-title" style="padding-left: 30px">
									${laptop.name}</h6>

								<div class="spec mb-2 bg-info-subtle rounded-1 d-flex flex-wrap"
									style="padding-left: 24px">
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
										<i class="bi bi-tv me-1"></i>${laptop.size}
										${laptop.resolution}
									</div>
								</div>

								<div class="price text-danger text-center">
									<span id="price"> <c:out
											value="${String.format('%,d', laptop.price)} đ" /></span>
								</div>

								<div 
									class="vote mb-1 d-flex justify-content-center">
									<span class="text-warning me-1">0.0</span> <i
										class="bi bi-star-fill text-warning me-1"></i> (0 đánh giá)
								</div>
							</a>
							<div class="col d-flex justify-content-between">
								<a href="#" class="btn btn-outline-primary"
									style="font-size: 13px"> Mua Ngay </a> <button onclick="addToCart(${laptop.laptopId})"
									title="thêm vào giỏ hàng" class="btn btn-outline-primary"
									style="font-size: 13px"> <i class="bi bi-cart-plus-fill"></i>
								</button>
							</div>
						</div>
					</div>

				</div>
			</c:forEach>
		</c:if>
	</div>
	<button class="carousel-control-prev bg-info" type="button"
		data-bs-target="#carouselExampleControls" data-bs-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Previous</span>
	</button>
	<button class="carousel-control-next bg-info" type="button"
		data-bs-target="#carouselExampleControls" data-bs-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Next</span>
	</button>
</div>


<script type="text/javascript" src="javaScript/bestSeller.js">
	
</script>

