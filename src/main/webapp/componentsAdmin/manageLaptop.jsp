<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<div class="table-responsive">
	<table class="table table table-bordered table-striped text-center"
		style="vertical-align: middle;">
		<thead>
			<tr>
				<th scope="col">LaptopId</th>
				<th scope="col">Tên</th>
				<th scope="col">Ảnh</th>
				<th scope="col">Giá</th>
				<th scope="col">Thương hiệu</th>
				<th scope="col">Loại</th>
				<th scope="col">Sửa</th>
				<th scope="col">Xoá</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty ListLaptop}">
				<c:forEach var="laptop" items="${ListLaptop}">
					<tr>
						<th scope="row">${laptop.laptopId}</th>
						<td>${laptop.name}</td>
						<td><img src="${laptop.image}" style="width: 70px;"></img></td>
						<td><c:out value="${String.format('%,d', laptop.price)} đ" /></td>
						<td>${laptop.brand}</td>
						<td>${laptop.category}</td>
						<td><button data-bs-toggle="modal"
								data-bs-target="#editLaptop" class="btn"
								onclick="editLaptop(${laptop.laptopId},${pageLaptop})">
								<i class="bi bi-pencil-square" style="color: blue;"></i>
							</button></td>
						<td><button class="btn"
								onclick="deleteLaptop(${laptop.laptopId},${pageLaptop})">
								<i class="bi bi-trash3-fill" style="color: red;"></i>
							</button></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>

	</table>
</div>



<div class="d-flex justify-content-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<%-- Nút "Previous" sẽ trừ 1 vào `page` hiện tại --%>
			<li class="page-item ${pageLaptop == 1 ? 'disabled' : ''}"><a
				class="page-link" href="javascript:void(0);"
				onclick="loadPageLaptop(${pageLaptop - 1})" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:forEach var="i" begin="1" end="${totalPageLaptop}">
				<li class="page-item ${i == pageLaptop ? 'active' : ''}"><a
					class="page-link" href="javascript:void(0);"
					onclick="loadPageLaptop(${i})">${i}</a></li>
			</c:forEach>
			<li
				class="page-item ${pageLaptop == totalPageLaptop ? 'disabled' : ''}">
				<a class="page-link" href="javascript:void(0);"
				onclick="loadPageLaptop(${pageLaptop + 1})" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</a>
			</li>
		</ul>
	</nav>
</div>



