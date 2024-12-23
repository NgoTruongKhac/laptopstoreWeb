<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade modal-lg" id="filterPeripheral" tabindex="-1"
	aria-labelledby="filterPeripheralLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="filterPeripheralLabel">Lọc Phụ
					kiện</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="filterPeripheral" method="post">
			<input name="title" type="hidden" value="Kết quả lọc">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-6 col-12">
							<div class="mb-3" style="font-weight: bold">Loại phụ kiện</div>
							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="mouse"
										id="mouse" name="category" /> <label class="form-check-label"
										for="mouse">Chuột</label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox"
										value="keyboard" id="keyboard" name="category" /> <label
										class="form-check-label" for="keyboard">bàn phím</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="headphone" id="headphone" name="category" /> <label
										class="form-check-label" for="headphone">tai nghe</label>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-6">
							<div class="mb-3" style="font-weight: bold">Kết nối</div>
							<div class="form-check me-3">
								<input class="form-check-input" type="checkbox" value="có dây"
									id="coday" name="connect" /> <label class="form-check-label"
									for="coday">có dây</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox"
									value="không dây" id="koday" name="connect" /> <label
									class="form-check-label" for="koday">không dây</label>
							</div>
						</div>
						<div class="col-md-3 col-6">
							<div class="mb-3" style="font-weight: bold">Đèn led</div>
							<div class="form-check me-3">
								<input class="form-check-input" type="checkbox" value="1"
									id="led" name="ledRGB" /> <label class="form-check-label"
									for="led">có led</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="0"
									id="noled" name="ledRGB" /> <label class="form-check-label"
									for="noled">không led</label>
							</div>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-md-5 col-10">
							<div class="mb-2" style="font-weight: bold">Mức giá</div>

							<div id="slider2"></div>
							<div class="d-flex flex-row mt-3">
								<div>
									<p>
										từ : <span id="rangeFrom2" class="text-danger"></span> đ
									</p>
									<input type="hidden" name="from" id="fromValue2" />
								</div>

								<div class="ms-auto">
									<p>
										đến: <span id="rangeTo2" class="text-danger"></span> đ
									</p>
									<input type="hidden" name="to" id="toValue2" />
								</div>
							</div>

							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.7.0/nouislider.min.js"></script>
							<script>
                  const slider2 = document.getElementById("slider2");
                  noUiSlider.create(slider2, {
                    start: [0, 10000000],
                    connect: true,
                    range: {
                      min: 0,
                      max: 10000000,
                    },
                  });

                  const rangeFrom2 = document.getElementById("rangeFrom2");
                  const rangeTo2 = document.getElementById("rangeTo2");
                  const fromValue2 = document.getElementById("fromValue2"); // input hidden for "from"
                  const toValue2 = document.getElementById("toValue2");
                  slider2.noUiSlider.on("update", (values) => {
                    const from = Math.round(values[0]);
                    const to = Math.round(values[1]);

                    // Cập nhật nội dung hiển thị
                    rangeFrom2.textContent = from.toLocaleString("vi-VN");
                    rangeTo2.textContent = to.toLocaleString("vi-VN");

                    // Cập nhật giá trị vào input ẩn
                    fromValue2.value = from;
                    toValue2.value = to;
                  });
                </script>
						</div>
						<div class="col-md-6 col-10 ms-5">
							<div class="mb-2" style="font-weight: bold">Thương hiệu</div>
							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox"
										value="logitech" id="logitech" name="brand" /> <label
										class="form-check-label" for="logitech">logitech</label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="razor"
										id="razor" name="brand" /> <label class="form-check-label"
										for="razor">razor</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="corsair"
										id="corsair" name="brand" /> <label class="form-check-label"
										for="corsair">corsair</label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-4">
									<input class="form-check-input" type="checkbox" value="akko"
										id="AKKO" name="brand" /> <label class="form-check-label"
										for="AKKO">akko</label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="dare u"
										id="Dare U" name="brand" /> <label class="form-check-label"
										for="Dare U">dare u</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="steelseries" id="steelseries" name="brand" /> <label
										class="form-check-label" for="steelseries">steelseries</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Lọc</button>
				</div>
			</form>
		</div>
	</div>
</div>