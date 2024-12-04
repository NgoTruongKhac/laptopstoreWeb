<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Laptop Store</title>
<link rel="stylesheet" href="styleCSS/hoverCard.css">
<%@ include file="styleCSS/allCss.jsp"%>

<link rel="stylesheet" href="styleCSS/bestSeller.css">

</head>
<body>


	<jsp:include page="components/navbar.jsp"></jsp:include>

	<jsp:include page="components/alert.jsp"></jsp:include>

	<main class="mt-2 d-flex justify-content-center flex-column">

		<!-- 	Best seller -->
		<section class="bg-info-subtle mt-3  align-self-center"
			style="padding-top: 8px; width: 95%; border-radius: 20px;">
			<div class="d-flex justify-content-center">
				<div>
					<img class="titleSeller" src="images/Sản Phẩm Bán Chạy.png"  />
				</div>
			</div>
			<jsp:include page="components/bestSeller.jsp"></jsp:include>
		</section>
		<!-- Laptop -->
		<section class="mt-3">
			<div style="padding-left: 71px">
				<h2>Laptop</h2>
			</div>
			<div class="container my-4">
				<div id="productLaptop" class="row">
					<jsp:include page="components/listLaptop.jsp"></jsp:include>

				</div>

				<div class="d-flex justify-content-center">
					<button class="btn btn-primary" onclick="moreLaptop()">Xem
						thêm</button>
				</div>

			</div>
		</section>
		<section class="mt-3">

			<!-- phụ kiện -->
			<div style="padding-left: 71px">


				<h2>Phụ kiện</h2>
			</div>
			<div class="container my-4">
				<div id="productPeripheral" class="row">
					<jsp:include page="components/listPeripheral.jsp"></jsp:include>

				</div>

				<div class="d-flex justify-content-center">
					<button class="btn btn-primary" onclick="morePeripheral()">Xem
						thêm</button>
				</div>

			</div>

		</section>


	</main>


	<%@ include file="components/footer.jsp"%>
	<script type="text/javascript" src="javaScript/moreProduct.js"></script>
	<script type="text/javascript" src="javaScript/ajaxAddToCart.js"></script>



</body>

</html>