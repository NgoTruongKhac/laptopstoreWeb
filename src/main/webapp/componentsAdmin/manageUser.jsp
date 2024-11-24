<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="table-responsive">
	<table class="table table table-bordered table-striped text-center"
		style="vertical-align: middle;">
		<thead>
			<tr>
				<th scope="col">UserId</th>
				<th scope="col">Họ</th>
				<th scope="col">Tên</th>
				<th scope="col">Email</th>
				<th scope="col">STĐ</th>
				<th scope="col">Năm sinh</th>
				<th scope="col">Sửa</th>
				<th scope="col">Xoá</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty ListUser}">
				<c:forEach var="user" items="${ListUser}">
					<tr>
						<th scope="row">${user.userId}</th>
						<td>${user.lastName}</td>
						<td>${user.firstName}</td>
						<td>${user.email}</td>
						<td>${user.phoneNumber}</td>
						<td>${user.birthday}</td>
						<td><button data-bs-toggle="modal" data-bs-target="#editUser"
								class="btn" onclick="editUser(${user.userId},${page})">
								<i class="bi bi-pencil-square" style="color: blue;"></i>
							</button></td>
						<td><button onclick="deleteUser(${user.userId}, ${page})"
								class="btn">
								<i class="bi bi-trash3-fill" style="color: red;"></i>
							</button></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>

	</table>
</div>
<div class="modal fade mt-5" id="editUser" tabindex="-1"
	aria-labelledby="userModalLabel2" aria-hidden="true">
	<%@include file="editUser.jsp"%>
</div>

<div class="d-flex justify-content-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<%-- Nút "Previous" sẽ trừ 1 vào `page` hiện tại --%>
			<li class="page-item ${page== 1 ? 'disabled' : ''}"><a
				class="page-link" href="javascript:void(0);"
				onclick="loadPageUser(${pagePeripheral - 1})" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach var="i" begin="1" end="${totalPage}">
				<li class="page-item ${i == page ? 'active' : ''}"><a
					class="page-link" href="javascript:void(0);"
					onclick="loadPageUser(${i})">${i}</a></li>
			</c:forEach>
			<li class="page-item ${page == totalPage ? 'disabled' : ''}"><a
				class="page-link" href="javascript:void(0);"
				onclick="loadPageUser(${page + 1})" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</a></li>

		</ul>
	</nav>
</div>



