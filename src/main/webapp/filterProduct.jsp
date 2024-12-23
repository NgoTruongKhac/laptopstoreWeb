<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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

		
		<div class="text-center mt-2">
			<h4>${title}</h4>
		</div>

		<section class="mt-3">
			<div class="container my-4">
				<div id="productLaptop" class="row">
					<jsp:include page="${filterProduct}"></jsp:include>
				</div>
			</div>
		</section>

	</main>


	<%@ include file="components/footer.jsp"%>
	<script type="text/javascript" src="javaScript/moreProduct.js"></script>
	<script type="text/javascript" src="javaScript/ajaxAddToCart.js"></script>
	<script type="text/javascript" src="javaScript/ajaxSearchSuggest.js"></script>





</body>

</html>