<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:if test="${empty ListCart}">

	<div class="text-center mt-5 mb-5">
		<p>Giỏ hàng trống</p>
	</div>


</c:if>


<c:if test="${not empty ListCart}">
	<div class="mt-4 mb-2">
		<input id="allCheck" class="form-check-input" type="checkbox" /> <label
			class="form-check-label" for="selectAll">chọn tất cả</label>
	</div>

	<form action="listCartItemOrder" method="post">
		<c:forEach var="product" items="${ListCart}">
			<div class="cartItem d-flex flex-column rounded-1 mb-2">
				<div class="row d-flex align-items-center mt-1 mb-1">
					<div class="col-md-1 col-2">
						<input class="myCheckbox form-check-input" type="checkbox" name="selectCartItem" value="${product.cartId}" />
					</div>
					<div class="col-md-3 col-5 d-flex justify-content-center">
						<img src="${product.image}" alt="" style="width: 55%" />
					</div>
					<div class="col-md-5 col-5 d-flex flex-column">
						<a
							href="${pageContext.request.contextPath}/detailProduct?productId=${product.productId}"
							style="text-decoration: none;">
							<h6 class="d-flex justify-content-center">${product.name}</h6>
						</a>
						<h5 class="d-flex justify-content-center text-danger">
							<c:out value="${String.format('%,d', product.price)} đ" />
						</h5>
					</div>
					<div class="col-md-2 col-6 d-flex flex-column">
						<div class="d-flex flex-row d-flex align-self-center">
							<button type="button" onclick="downQuantityCart(${product.cartId})"
								class="btnNumber btn">
								<i class="bi bi-dash-lg"></i>
							</button>
							<input id="quantity-${product.cartId}" min="1" max="20"
								class="quantity" name="quantity" value="${product.quantity}"
								type="number" />
							<button type="button" onclick="upQuantityCart(${product.cartId})"
								class="btnNumber btn">
								<i class="bi bi-plus-lg"></i>
							</button>
						</div>
					</div>
					<div class="col-md-1 col-6">
						<a onclick="deleteCartItem(${product.cartId})"
							class="buttonDelete d-flex align-self-center"> <i
							class="trash bi bi-trash"></i>
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<div
			class="sticky-bottom d-flex justify-content-between align-items-center rounded-1 mb-2"
			style="margin-top: 7rem; background-color: white; z-index: 10">
			<div class="d-flex flex-column mt-1">
				<h5>Tính tổng:</h5>
				<h4 class="text-danger">0 đ</h4>
				<input id="totalPriceInput" type="text" hidden="true" name="totalPrice" value="0" >
			</div>
			<div>
				<button type="submit" class="btn btn-outline-primary">Mua ngay</button>
			</div>
		</div>
	</form>
</c:if>