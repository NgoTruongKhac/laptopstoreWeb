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

<link rel="stylesheet" href="${includeCss}" />
</head>
<body>
	<jsp:include page="components/navbar.jsp"></jsp:include>
	<jsp:include page="components/alert.jsp"></jsp:include>
	<div  class="container d-flex justify-content-center mt-2">
		<div class="row col-12 col-md-8 d-flex justify-content-center">
			<div class="mt-2 mb-2">
				<button  onclick="window.history.back();" style="background-color: transparent; border: none;">
					<i class="bi bi-arrow-left me-2"></i><span>${nameBtnBack}</span>
				</button>
			</div>
			<div
				class="d-flex justify-content-around align-items-center mt-2 rounded-1"
				style="border: solid 1px">
				<div id="cart" class="d-flex flex-column">
					<div class="d-flex justify-content-center mt-2">
						<i class="process bi bi-bag-check"></i>
					</div>
					<div class="d-flex justify-content-center">
						<p>Giỏ hàng</p>
					</div>
				</div>
				<div class="line">
					<hr id="line1" />
				</div>
				<div id="orderInfo" class="d-flex flex-column">
					<div class="d-flex justify-content-center mt-2">
						<i class="process bi bi-person-vcard"></i>
					</div>
					<div class="d-flex justify-content-center">
						<p>Thông tin đặt hàng</p>
					</div>
				</div>
				<div class="line">
					<hr id="line2"/>
				</div>
				<div id="payment" class="d-flex flex-column">
					<div class="d-flex justify-content-center mt-2">
						<i class="process bi bi-credit-card"></i>
					</div>
					<div class="d-flex justify-content-center">
						<p>Thanh toán</p>
					</div>
				</div>
				<div class="line">
					<hr />
				</div>
				<div id="complete" class="d-flex flex-column">
					<div class="d-flex justify-content-center mt-2">
						<i class="process bi bi-clipboard-check"></i>
					</div>
					<div class="d-flex justify-content-center">
						<p>Hoàn tất</p>
					</div>
				</div>
			</div>

			<jsp:include page="${includePage}"></jsp:include>





		</div>


	</div>

	<%@ include file="components/footer.jsp"%>

	<script type="text/javascript" src="javaScript/alertDeleteCartItem.js"></script>
	<script type="text/javascript"
		src="javaScript/ajaxUpdateQuantityCart.js"></script>
	<script type="text/javascript" src="javaScript/totalPrice.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

	<script type="text/javascript" src="javaScript/addressVietNamAPI.js"></script>


</body>
</html>