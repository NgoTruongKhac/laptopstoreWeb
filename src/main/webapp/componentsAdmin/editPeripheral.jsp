<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<form id="editPeripheralForm" method="post">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel2">Chỉnh sửa
					sản phẩm</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-6">
						<input type="text" name="peripheralId"
							value="${Peripheral.peripheralId}" hidden="true">
						<div class="mb-3">
							<input name="name" class="form-control" type="text"
								placeholder="Tên" value="${Peripheral.name}" />
						</div>
						<div class="mb-3">
							<input name="price" class="form-control" type="text"
								placeholder="Giá" value="${Peripheral.price}" />
						</div>
						<div class="mb-3">
							<input class="form-control" type="text" placeholder="Thương hiệu"
								name="brand" value="${Peripheral.brand}" />
						</div>
						<div class="mb-1">
							<div class="mb-1">
								<label class="form-check" for="">Loại :</label>
							</div>

							<div class="form-check form-check-inline">
								<input id="mouseEdit" name="category" class="form-check-input"
									type="radio" value="mouse"
									${Peripheral.category.trim() =='mouse' ? 'checked' : ''} /> <label
									class="form-check-label" for="mouseEdit">Chuột</label>
							</div>
							<div class="form-check form-check-inline">
								<input id="keyboardEdit" name="category" class="form-check-input"
									type="radio" value="keyboard"
									${Peripheral.category.trim() =='keyboard' ? 'checked' : ''} /> <label
									class="form-check-label" for="keyboardEdit">bàn phím</label>
									
									
							</div>
							<div class="form-check form-check-inline">
								<input id="headphoneEdit" name="category" class="form-check-input"
									type="radio" value="headphone"
									${Peripheral.category.trim() =='headphone' ? 'checked' : ''} /> <label
									class="form-check-label" for="headphoneEdit">tai nghe</label>
							</div>
						</div>
					</div>
					<div class="col-6">
						<div class="row">
							<div class="col-6 mb-3">
								<label for="file-upload-p-edit" class="custom-file-upload">
									<i class="bi bi-upload me-1"></i> Ảnh
								</label> <input onchange="changeImage()" id="file-upload-p-edit"
									type="file" accept="image/*" name="file-upload-p-edit"
									style="display: none" />

								<!-- Vùng hiển thị bản xem trước -->
							</div>
							<input hidden="true" type="text" value="${Peripheral.image}"
								name="imagePath">
							<div class="col-6">
								<img id="preview-p-edit" alt="" src="${Peripheral.image}"
									style="display: block;" name="preview-p-edit" />
							</div>
						</div>

						<div class="row">
							<div class="mb-3 d-flex flex-row">
								<div class="mb-1">
									<label class="form-check me-2" for="">Kết nối :</label>
								</div>

								<div class="form-check form-check-inline">
									<input id="yesEdit" name="connect" class="form-check-input"
										type="radio" value="có dây"
										${Peripheral.connect.trim() == 'có dây' ? 'checked' : ''} /> <label
										class="form-check-label" for="yesEdit">Có dây</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="noEdit" name="connect" class="form-check-input"
										type="radio" value="không dây"
										${Peripheral.connect.trim() == 'không dây' ? 'checked' : ''} /> <label
										class="form-check-label" for="noEdit">Không dây</label>
										
								</div>
							</div>
							<div class="mb-3 d-flex flex-row">
								<div class="mb-1">
									<label class="form-check me-2" for="">led RGB :</label>
								</div>

								<div class="form-check form-check-inline">
									<input id="rgbEdit" name="ledRGB" class="form-check-input"
										type="radio" value="1" ${Peripheral.ledRGB ? 'checked' : ''} />
									<label class="form-check-label" for="rgbEdit">Có</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="noRgbEdit" name="ledRGB" class="form-check-input"
										type="radio" value="0" ${!Peripheral.ledRGB ? 'checked' : ''} />
									<label class="form-check-label" for="noRgbEdit">Không</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				

				<div>
					<div>
						<label class="form-label" for="">Mô tả chi tiết</label>
					</div>
					<textarea class="form-control" name="description" rows="5">"${Peripheral.description}"</textarea>
				</div>
			</div>
			<div class="modal-footer">
				<button onclick="updatePeripheral(${pagePeripheral})" 
					type="submit" class="btn btn-primary">Cập nhật</button>
			</div>
		</form>
	</div>
</div>