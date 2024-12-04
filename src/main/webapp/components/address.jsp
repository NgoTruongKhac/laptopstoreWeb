<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade mt-3" id="address" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Thêm Địa
					Chỉ</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="addAddress" method="post">
				<div class="modal-body">


					<div>

						<div class="mb-3">
							<label for="" class="form-label">Tên địa chỉ</label> <input
								type="text" class="form-control" name="nameAddress"
								required="required">
						</div>
						<select class="form-select form-select-sm mb-4" id="city"
							name="province">
							<option value="" selected>Chọn tỉnh thành</option>
						</select> <select class="form-select form-select-sm mb-4" id="district"
							name="district">
							<option value="" selected>Chọn quận huyện</option>
						</select> <select class="form-select form-select-sm mb-4" id="ward"
							name="ward">
							<option value="" selected>Chọn phường xã</option>
						</select>
						<div class="mb-4">
							<label class="form-label" for="">Số nhà/Tên đường</label> <input
								class="form-control" type="text" name="street"
								required="required">
						</div>
						<div class="mb-2">
							<label class="form-check-label" for="">Đặt làm địa chỉ
								mặc định</label> <input class="form-check-input" type="checkbox"
								name="isDefault">
						</div>

					</div>


				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Thêm</button>
				</div>
			</form>
		</div>
	</div>
</div>



