<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="mb-4 d-flex justify-content-center">
	<h4>Sản Phẩm</h4>
</div>


<div class="d-flex flex-row justify-content-between">
	<div>
		<h5>Laptop</h5>
	</div>
	<div class="mb-4">
		<button class="btn btn-outline-primary btn-sm" data-bs-toggle="modal"
			data-bs-target="#addLaptop">
			<i class="bi bi-plus-lg me-1"></i>Laptop
		</button>
		<%@include file="addLaptop.jsp"%>
		<div id="editLaptop" class="modal fade" tabindex="-1"
			aria-labelledby="exampleModalLabel1" aria-hidden="true">
			<%@include file="editLaptop.jsp"%>
		</div>

	</div>
</div>
<div id="listLaptopManage">
	<jsp:include page="manageLaptop.jsp"></jsp:include>
</div>





<div class="d-flex flex-row justify-content-between">
	<div>
		<h5>Phụ kiện</h5>
	</div>
	<div class="mb-4">
		<button class="btn btn-outline-primary btn-sm" data-bs-toggle="modal"
			data-bs-target="#addPeripheral">
			<i class="bi bi-plus-lg me-1"></i>Phụ kiện
		</button>
		<%@include file="addPeripheral.jsp"%>
		<div id="editPeripheral" class="modal fade" tabindex="-1"
			aria-labelledby="exampleModalLabel2" aria-hidden="true">
			<%@include file="editPeripheral.jsp"%>
		</div>
	</div>

</div>
<div id="listPeripheralManage">
	<jsp:include page="managePeripheral.jsp"></jsp:include>
</div>
