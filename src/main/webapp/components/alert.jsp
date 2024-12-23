<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty message and not empty type}">
	<script type="text/javascript">
		const notyf = new Notyf();

		notyf.open({
			type : "${type}",
			message : "${message}",
			position : {
				x : "center",
				y : "center",
			},
			duration : "${type}" === "error" || "${type}" === "warning" ? null
					: 2500,
			dismissible : true
		});
	</script>

	<!-- Xóa thông báo khỏi request sau khi hiển thị -->
	<c:remove var="message" scope="session" />
	<c:remove var="type" scope="session" />

</c:if>


