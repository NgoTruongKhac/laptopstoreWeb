<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="addLaptop" class="modal fade" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form id="addLaptopForm" method="post">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Thêm sản
						phẩm</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-5">
							<div class="mb-3">
								<input id="name" class="form-control" type="text"
									placeholder="Tên" name="name" />
							</div>
							<div class="mb-3">
								<input id="price" class="form-control" type="text"
									placeholder="Giá" name="price" />
							</div>
							<div class="mb-3">
								<input id="brand" class="form-control" type="text"
									placeholder="Thương hiệu" name="brand" />
							</div>
							<div class="mb-1">
								<input id="category" class="form-control" type="text"
									placeholder="Loại" name="category" />
							</div>
						</div>
						<div class="col-7">
							<div class="row">
								<div class="col-6 mb-3">
									<label for="file-upload-add" class="custom-file-upload">
										<i class="bi bi-upload me-1"></i> Ảnh
									</label> <input id="file-upload-add" type="file" accept="image/*"
										name="image" style="display: none" />

									<!-- Vùng hiển thị bản xem trước -->
								</div>
								<div class="col-6">
									<img id="preview-add" />
								</div>
							</div>

							<div class="row">
								<div class="col-6">
									<div class="mb-3">
										<input id="cpu" class="form-control" type="text"
											placeholder="CPU" name="cpu" />
									</div>
									<div class="mb-3">
										<input id="gpu" class="form-control" type="text"
											placeholder="GPU" name="gpu" />
									</div>
									<div class="mb-1">
										<input id="ram" class="form-control" type="text"
											placeholder="RAM" name="ram" />
									</div>
								</div>
								<div class="col-6">
									<div class="mb-3">
										<input id="drive" class="form-control" type="text"
											placeholder="Dung lượng lưu trữ" name="drive" />
									</div>
									<div class="mb-3">
										<input id="size" class="form-control" type="text"
											placeholder="kích thước màn hình" name="size" />
									</div>
									<div class="mb-1">
										<input id="resolution" class="form-control" type="text"
											placeholder="Độ phân giải" name="resolution" />
									</div>
								</div>
							</div>
						</div>
					</div>

					<div>
						<div>
							<label class="form-label" for="">Mô tả chi tiết</label>
						</div>
							<textarea id="description" class="form-control"
								name="description" rows="5"></textarea>

					</div>
				</div>
				<div class="modal-footer">
					<button id="submitBtn" type="submit" class="btn btn-primary">Thêm
						sản phẩm</button>
				</div>
			</form>
		</div>
	</div>
</div>
