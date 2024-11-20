<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="addPeripheral" class="modal fade" tabindex="-1"
	aria-labelledby="exampleModalLabel2" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form id="addPeripheralForm" method="post">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel2">Thêm sản
						phẩm</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-6">
							<div class="mb-3">
								<input  name="name" class="form-control" type="text"
									placeholder="Tên" />
							</div>
							<div class="mb-3">
								<input name="price" class="form-control" type="text"
									placeholder="Giá" />
							</div>
							<div class="mb-3">
								<input class="form-control" type="text"
									placeholder="Thương hiệu" name="brand" />
							</div>
							<div class="mb-1">
								<div class="mb-1">
									<label class="form-check" for="">Loại :</label>
								</div>

								<div class="form-check form-check-inline">
									<input id="mouse" name="category" class="form-check-input"
										type="radio" value="mouse" /> <label class="form-check-label"
										for="mouse">Chuột</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="keyboard" name="category" class="form-check-input"
										type="radio" value="keyboard" /> <label
										class="form-check-label" for="keyboard">bàn
										phím</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="headphone" name="category" class="form-check-input"
										type="radio" value="headphone" /> <label
										class="form-check-label" for="headphone">tai
										nghe</label>
								</div>
							</div>
						</div>
						<div class="col-6">
							<div class="row">
								<div class="col-6 mb-3">
									<label for="file-upload-p" class="custom-file-upload">
										<i class="bi bi-upload me-1"></i> Ảnh
									</label> <input id="file-upload-p" type="file" accept="image/*" name="image"
										style="display: none" />

									<!-- Vùng hiển thị bản xem trước -->
								</div>
								<div class="col-6">
									<img id="preview-p" alt="" />
								</div>
							</div>

							<div class="row">
								<div class="mb-3 d-flex flex-row">
									<div class="mb-1">
										<label class="form-check me-2" for="">Kết nối :</label>
									</div>

									<div class="form-check form-check-inline">
										<input id="yes" name="connect" class="form-check-input"
											type="radio" value="có dây" /> <label
											class="form-check-label" for="yes">Có
											dây</label>
									</div>
									<div class="form-check form-check-inline">
										<input id="no" name="connect" class="form-check-input"
											type="radio" value="không dây" /> <label
											class="form-check-label" for="no">Không
											dây</label>
									</div>
								</div>
								<div class="mb-3 d-flex flex-row">
									<div class="mb-1">
										<label class="form-check me-2" for="">led RGB :</label>
									</div>

									<div class="form-check form-check-inline">
										<input id="rgb" name="ledRGB" class="form-check-input"
											type="radio" value="1" /> <label class="form-check-label"
											for="rgb">Có</label>
									</div>
									<div class="form-check form-check-inline">
										<input id="noRgb" name="ledRGB" class="form-check-input"
											type="radio" value="0" /> <label class="form-check-label"
											for="noRgb">Không</label>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div>
						<div>
							<label class="form-label" for="">Mô tả chi tiết</label>
						</div>
						<textarea class="form-control" name="description"
							rows="5"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button id="submitBtn" type="submit" class="btn btn-primary">Thêm sản
						phẩm</button>
				</div>
			</form>
		</div>
	</div>
</div>
