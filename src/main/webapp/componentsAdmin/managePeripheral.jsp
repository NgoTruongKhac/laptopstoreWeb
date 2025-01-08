<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


	<div  class="table-responsive">
		<table class="table table-bordered table-striped text-center"
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
				<c:if test="${not empty ListPeripheral}">
					<c:forEach var="peripheral" items="${ListPeripheral}">
						<tr>
							<th scope="row">${peripheral.peripheralId}</th>
							<td class="name-product">${peripheral.name}</td>
							<td><c:choose>
								<c:when test="${fn:contains(peripheral.image, 'uploads')}">
									<img class="image-product" src="${pageContext.request.contextPath}/${peripheral.image}"
										 />
								</c:when>
								<c:otherwise>
									<img class="image-product" src="${peripheral.image}" />
								</c:otherwise>
							</c:choose></td>
							<td data-order="${laptop.price}"><c:out value="${String.format('%,d', peripheral.price)} đ" /></td>
							<td>${peripheral.brand}</td>
							<td>${peripheral.category}</td>
							<td><button data-bs-toggle="modal"
								data-bs-target="#editPeripheral" class="btn" onclick="editPeripheral(${peripheral.peripheralId},${pagePeripheral})">
									<i class="bi bi-pencil-square" style="color: blue;"></i>
								</button></td>
							<td><button class="btn" onclick="deletePeripheral(${peripheral.peripheralId},${pagePeripheral})">
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
				<li class="page-item ${pagePeripheral == 1 ? 'disabled' : ''}"><a
					class="page-link" href="javascript:void(0);"
					onclick="loadPagePeripheral(${pagePeripheral - 1})" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="1" end="${totalPagePeripheral}">
					<li class="page-item ${i == pagePeripheral ? 'active' : ''}"><a
						class="page-link" href="javascript:void(0);"
						onclick="loadPagePeripheral(${i})">${i}</a></li>
				</c:forEach>
				<li class="page-item ${pagePeripheral == totalPagePeripheral ? 'disabled' : ''}">
					<a class="page-link" href="javascript:void(0);"
					onclick="loadPagePeripheral(${pagePeripheral + 1})" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span>
				</a>
				</li>

			</ul>
		</nav>
	</div>




