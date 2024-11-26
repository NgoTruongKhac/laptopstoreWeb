<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<form id="editLaptopForm" method="post">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel1">Chỉnh sửa
					sản phẩm</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-5 col-12">
						<input id="laptopIdUpdate" name="laptopId" type="text"
							value="${Laptop.laptopId}" hidden="true" />
						<div class="mb-3">
							<input id="nameUpdate" class="form-control" type="text"
								placeholder="Tên" name="name" value="${Laptop.name}" />
						</div>
						<div class="mb-3">
							<input id="priceUpdate" class="form-control" type="text"
								placeholder="Giá" name="price" value="${Laptop.price}" />
						</div>
						<div class="mb-3">
							<input id="brandUpdate" class="form-control" type="text"
								placeholder="Thương hiệu" name="brand" value="${Laptop.brand}" />
						</div>
						<div class="mb-1">
							<input id="categoryUpdate" class="form-control" type="text"
								placeholder="Loại" name="category" value="${Laptop.category}" />
						</div>
					</div>
					<div class="col-md-7 col-12">
						<div class="row">
							<div class="col-6 mb-3">
								<label for="file-upload-edit" class="custom-file-upload">
									<i class="bi bi-upload me-1"></i> Ảnh
								</label>
									<input onchange="changeImage()" id="file-upload-edit" type="file" accept="image/*"
										name="file-upload-edit" style="display: none;" />

								<!-- Vùng hiển thị bản xem trước -->
							</div>

							<input hidden="true" type="text" value="${Laptop.image}"
								name="imagePath">
							<div class="col-6">
								<img id="preview-edit" src="${Laptop.image}"
									style="display: block;" name="preview-edit" />
							</div>
						</div>

						<div class="row">
							<div class="col-6">
								<div class="mb-3">
									<input id="cpuUpdate" class="form-control" type="text"
										placeholder="CPU" name="cpu" value="${Laptop.cpu}" />
								</div>
								<div class="mb-3">
									<input id="gpuUpdate" class="form-control" type="text"
										placeholder="GPU" name="gpu" value="${Laptop.gpu}" />
								</div>
								<div class="mb-1">
									<input id="ramUpdate" class="form-control" type="text"
										placeholder="RAM" name="ram" value="${Laptop.ram}" />
								</div>
							</div>
							<div class="col-6">
								<div class="mb-3">
									<input id="driveUpdate" class="form-control" type="text"
										placeholder="Dung lượng lưu trữ" name="drive"
										value="${Laptop.drive}" />
								</div>
								<div class="mb-3">
									<input id="sizeUpdate" class="form-control" type="text"
										placeholder="kích thước màn hình" name="size"
										value="${Laptop.size}" />
								</div>
								<div class="mb-1">
									<input id="resolutionUpdate" class="form-control" type="text"
										placeholder="Độ phân giải" name="resolution"
										value="${Laptop.resolution}" />
								</div>
							</div>
						</div>
					</div>
				</div>

				<div>
					<div>
						<label class="form-label" for="">Mô tả chi tiết</label>
					</div>
					<textarea id="descriptionUpdate" class="form-control"
						name="description" rows="5">${Laptop.description}</textarea>
				</div>
			</div>
			<div class="modal-footer">
				<button onclick="updateLaptop(${pageLaptop})" id="submitBtn"
					type="submit" class="btn btn-primary">Cập nhật</button>
			</div>
		</form>
	</div>
</div>

