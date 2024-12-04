<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if
	test="${not empty sessionScope.message and not empty sessionScope.type}">
	<script type="text/javascript">
		const notyf = new Notyf({
			types : [ {
				type : 'warning',
				background : 'orange',
				icon : {
					className : 'material-icons',
					tagName : 'i',
					text : 'warning',
					color:'white'
				}
			} ]
		});
		notyf.open({
			type : "${sessionScope.type}",
			message : "${sessionScope.message}",
			position : {
				x : "center",
				y : "center",
			},
			duration : "${sessionScope.type}" === "error" || "${sessionScope.type}" === "warning" ? null : 2500,
			dismissible : true
		});
	</script>
	<!-- Xóa thông báo khỏi session sau khi hiển thị -->
	<c:remove var="message" scope="session" />
	<c:remove var="type" scope="session" />
</c:if>

