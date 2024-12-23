<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%> --%>
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


		<div class="container d-flex justify-content-center mt-2">
			<div class="row col-12 col-md-11 d-flex justify-content-center">
				<div class="mt-2 mb-2">
					<button onclick="window.location.href ='${pageContext.request.contextPath}/index.jsp';"
						style="background-color: transparent; border: none">
						<i class="bi bi-arrow-left me-2"></i><span>Về trang chủ</span>
					</button>
				</div>
				<div class="d-flex justify-content-center mb-3">
					<h3>Theo dõi đơn hàng</h3>
				</div>

			<div id="listMyOrder">
				<jsp:include page="components/listMyOrder.jsp"></jsp:include>
			</div>
		</div>
	</div>



	<%@ include file="components/footer.jsp"%>



	<script type="text/javascript" src="javaScript/pagination.js"></script>
	<script type="text/javascript" src="javaScript/ajaxOrderDetail.js"></script>
	<script type="text/javascript" src="javaScript/alertCancelMyOrder.js"></script>





</body>

</html>