<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mt-2">
	<h4>Nhận xét & đánh giá</h4>
</div>
<div class="rate">
	<div
		class="col-md-2 col-8 d-flex justify-content-center align-items-center">
		<h2>${rate}/5</h2>
	</div>
	<hr />
	<div class="col-md-5 col-8 ms-4 d-flex flex-column-reverse">
			<c:forEach var="star" begin="1" end="5">
			<div class="row d-flex align-items-center">
				<div class="row d-flex align-items-center">
					<div class="col-md-1 col-2 d-flex flex-row me-1">
						${star}<i class="star bi bi-star-fill ms-1"></i>
					</div>
					<div class="progress col-md-9 col-8" role="progressbar"
						aria-label="Basic example" aria-valuenow="${StarStatistics[star] * 100 / ListReview.size()}" aria-valuemin="0"
						aria-valuemax="100">
						<div class="progress-bar"
							style="width: ${StarStatistics[star] * 100 / ListReview.size()}%"></div>
					</div>
					<span class="col-md-1 col-1">(${StarStatistics[star]})</span>
				</div>
			</div>
		</c:forEach>


	</div>
	<div
		class="col-md-3 col-8 d-flex justify-content-center align-items-center">
		
		<c:if test="${not empty User}">
		<button type="button" class="btn btn-outline-success"
			data-bs-toggle="modal" data-bs-target="#voteModal">Gửi đánh
			giá của bạn</button>
			</c:if>
			<c:if test="${empty User}">
		<button type="button" class="btn btn-outline-success"
			onclick="requireLogin()">Gửi đánh
			giá của bạn</button>
			</c:if>
	</div>
</div>
<hr class="mt-4" />
<c:forEach var="review" items="${ListReview}">
	<div class="ms-3">
		<div class="d-flex flex-row">
			<div class="d-flex align-items-center">
				<img style="width: 2.5rem; border-radius: 100%; border: solid"
					src="${review.image}" alt="" />
			</div>
			<div class="me-3 ms-2 d-flex align-items-center">${review.lastName}
				${review.firstName}</div>
			<div class="d-flex align-items-center">
				<i class="bi bi-clock"></i> <span>${review.createdAt}</span>
			</div>
		</div>
		<div class="d-flex flex-row ms-5">
			<div class="star d-flex flex-row">
				<c:forEach var="star" begin="1" end="5">
					<i class="bi bi-star-fill"
						style="color: ${star <= review.rate ? 'gold' : 'grey'};"></i>
				</c:forEach>
			</div>
			<div class="ms-3">
				<p>${review.comment}</p>
			</div>
		</div>
	</div>
</c:forEach>