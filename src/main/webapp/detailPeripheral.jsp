<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@ include file="styleCSS/allCss.jsp"%>
</head>
<body>
	<jsp:include page="components/navbar.jsp"></jsp:include>
	<main class="d-flex flex-column mt-4 mb-4">
		<div class="row d-flex align-self-center rounded-2"
			style="width: 92%; border: solid 1px">
			<div class="col-md-5 col-12 d-flex justify-content-center">
				<img src="${Peripheral.image}" alt="" style="width: 70%" />
			</div>
			<div class="col-md-7 col-12" style="border-left: solid 1px">
				<div class="d-flex justify-content-center mt-4">
					<h3>${Peripheral.name}</h3>
				</div>
				<div class="d-flex flex-row ms-5 mt-2">
					<div class="d-flex flex-row me-4">
						<p class="text-warning me-1">0.0</p>
						<i class="bi bi-star-fill text-warning" ></i>
					</div>
					<a href="#" id="scroll-to-review" style="text-decoration: none">xem đánh giá</a>
				</div>
				<div class="d-flex justify-content-center mt-3">
					<h1 class="text-danger">
						<c:out value="${String.format('%,d', Peripheral.price)} đ" />
					</h1>
				</div>
				<div class="d-flex justify-content-evenly mt-3 mb-3">
					<button class="btn btn-outline-primary"
						style="width: 50%; font-size: xx-large">Mua ngay</button>
					<button class="btn btn-outline-primary"
						style="width: 15%; font-size: xx-large">
						<i class="bi bi-cart-plus"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="row d-flex align-self-center mt-3 rounded-2"
			style="width: 92%; border: solid 1px">
			<div class="col-md-6 col-12">
				<div class="mt-3 mb-3">
					<h4>Thông tin chi tiết</h4>
				</div>
				<div>
					<p>${Peripheral.description}</p>
				</div>
			</div>
			<div class="col-md-6 col-12" style="border-left: solid 1px">
				<div class="mt-3 mb-3">
					<h4>Thông số kĩ thuật</h4>
				</div>
				<div>
					<table class="table table-striped">
						<tbody>
							<tr>
								<td>Thương hiệu</td>
								<td>${Peripheral.brand}</td>
							</tr>
							<tr>
								<td>Kết nối</td>
								<td>${Peripheral.connect}</td>
							</tr>
							<tr>
								<td>led RGB</td>
								<td>${Peripheral.ledRGB}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row d-flex align-self-center mt-3" style="width: 92%">
			<div id="review" class="col-md-7 col-12 rounded-2" style="border: solid 1px">
				<div>
					<h4>Nhận xét & đánh giá</h4>
				</div>
				<div class="row">
					<div class="col-4">
						<h2>0.0/5</h2>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="components/footer.jsp"%>

<script type="text/javascript" src="javaScript/scrollToReview.js"></script>

</body>
</html>