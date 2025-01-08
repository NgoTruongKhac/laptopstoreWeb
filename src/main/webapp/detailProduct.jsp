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
<link rel="stylesheet" href="styleCSS/detailProduct.css">
<link rel="stylesheet" href="styleCSS/evaluate.css">
</head>
<body>
	<jsp:include page="components/navbar.jsp"></jsp:include>
	<jsp:include page="components/alert.jsp"></jsp:include>
	<main class="d-flex flex-column mt-4 mb-4">
		<jsp:include page="${detailProduct}"></jsp:include>
		<div class="row d-flex align-self-center mt-3" style="width: 90%">
			<div id="review" class="col-md-12 col-12 rounded-2">
			<jsp:include page="components/listReview.jsp"></jsp:include>
			</div>
		</div>
	</main>
	<%@include file="components/evaluate.jsp"%>
	<%@ include file="components/footer.jsp"%>

	<script type="text/javascript" src="javaScript/scrollToReview.js"></script>
	<script type="text/javascript" src="javaScript/ajaxAddToCart.js"></script>
	<script type="text/javascript" src="javaScript/ajaxSearchSuggest.js"></script>
	<script type="text/javascript" src="javaScript/rate.js"></script>
	<script type="text/javascript" src="javaScript/ajaxAddReview.js"></script>
	<script type="text/javascript" src="javaScript/requireLogin.js"></script>

</body>
</html>