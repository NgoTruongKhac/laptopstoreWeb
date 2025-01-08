<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal fade" id="voteModal" tabindex="-1"
	aria-labelledby="voteLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="voteLabel">Đánh giá & nhận xét</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form id="addReviewForm" method="post">
			<input type="hidden" name="productId" value="${Laptop.laptopId}">
			<input type="hidden" name="productId" value="${Peripheral.peripheralId}">
				<div class="modal-body">
					<div class="stars d-flex justify-content-center">
						<input type="radio" id="star-5" name="rating" value="5" /> <label
							for="star-5"><i class="bi bi-star-fill"></i></label> <input
							type="radio" id="star-4" name="rating" value="4" /> <label
							for="star-4"><i class="bi bi-star-fill"></i></label> <input
							type="radio" id="star-3" name="rating" value="3" /> <label
							for="star-3"><i class="bi bi-star-fill"></i></label> <input
							type="radio" id="star-2" name="rating" value="2" /> <label
							for="star-2"><i class="bi bi-star-fill"></i></label> <input
							type="radio" id="star-1" name="rating" value="1" /> <label
							for="star-1"><i class="bi bi-star-fill"></i></label>
					</div>
					<div class="d-flex justify-content-center">
						<p id="rating-result" style="font-size: 1rem">0 sao</p>
					</div>
					<div class="mt-2 row justify-content-center">
						<h5>Nhận xét</h5>
						<textarea class="col-md-11 col-12" name="comment" 
							style="height: 8rem"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Gửi</button>
				</div>
			</form>
		</div>
	</div>
</div>
