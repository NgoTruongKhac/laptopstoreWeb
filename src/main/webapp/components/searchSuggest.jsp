<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="p-1 rounded-2"
	style="background-color: white; border: solid 1px;">
	<c:forEach var="product" items="${ListProductSuggest}">
		<a href="${pageContext.request.contextPath}/detailProduct?productId=${product.productId}&type=${product.type}" style="text-decoration: none; color: black;">
			<div class="product-suggest d-flex align-items-center rounded-1 mt-1"
				style="border: solid 1px #0d6efd">
				<div class="col-md-2 col-2 ms-2">
					<img class="image-search" src="${product.image}" alt="" />
				</div>
				<div class="row col-md-10 col-10">
					<div class="name-search">
						<p>${product.name}</p>
					</div>
					<div class="price-search">
						<p class="text-danger">
							<c:out value="${String.format('%,d', product.price)} đ" />
						</p>
					</div>
				</div>
			</div>
		</a>
	</c:forEach>
	<c:if test="${empty ListProductSuggest}">
		<div style="margin-bottom: -10px; margin-top: 10px;">
			<p class="text-center text-muted">Không tìm thấy sản phẩm phù
				hợp.</p>
		</div>
	</c:if>
</div>