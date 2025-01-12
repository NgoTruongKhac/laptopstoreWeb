<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade mt-3" id="filterLaptop" tabindex="-1"
	aria-labelledby="filterLaptopModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="filterLaptopModalLabel">Lọc
					laptop</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form action="filterLaptop" method="post">
				<input name="title" type="hidden" value="Kết quả lọc">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-4 col-6">
							<!-- cpu -->
							<div class="mb-2" style="font-weight: bold">CPU</div>

							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="i3"
										name="cpu" id="i3" /> <label class="form-check-label"
										for="i3"> i3 </label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="i5"
										id="i5" name="cpu" /> <label class="form-check-label"
										for="i5"> i5 </label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="i7"
										id="i7" name="cpu" /> <label class="form-check-label"
										for="i7"> i7 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="i9"
										id="i9" name="cpu" /> <label class="form-check-label"
										for="i9"> i9 </label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="R3"
										id="r3" name="cpu" /> <label class="form-check-label"
										for="r3"> r3 </label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="R5"
										id="r5" name="cpu" /> <label class="form-check-label"
										for="r5"> r5 </label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="R7"
										id="r7" name="cpu" /> <label class="form-check-label"
										for="r7"> r7 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="R9"
										id="r9" name="cpu" /> <label class="form-check-label"
										for="r9"> r9 </label>
								</div>
							</div>
						</div>

						<div class="col-md-4 col-6">
							<div class="mb-2" style="font-weight: bold">GPU</div>

							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox"
										value="RTX 2050" id="rtx2050" name="gpu" /> <label
										class="form-check-label" for="rtx2050"> RTX 2050 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="RTX 3050" id="rtx3050" name="gpu" /> <label
										class="form-check-label" for="rtx3050"> RTX 3050 </label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox"
										value="RTX 4050" id="rtx4050" name="gpu" /> <label
										class="form-check-label" for="rtx4050"> RTX 4060 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="RTX 4090" id="rtx4090" name="gpu" /> <label
										class="form-check-label" for="rtx4090"> RTX 4090 </label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox"
										value="intel UHD" id="uhd" name="gpu" /> <label
										class="form-check-label" for="uhd">intel UHD</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="AMD Radeon" id="radeon" name="gpu" /> <label
										class="form-check-label" for="radeon">AMD Radeon </label>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-6">
							<div class="mb-2" style="font-weight: bold">RAM</div>
							<div class="d-flex flex-row">
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="16 GB"
										id="16gb" name="ram" /> <label class="form-check-label"
										for="16gb">16 GB</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="24 GB"
										id="24gb" name="ram" /> <label class="form-check-label"
										for="24gb">24 GB </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="32 GB"
										id="32gb" name="ram" /> <label class="form-check-label"
										for="32gb">32 GB </label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="64 GB"
										id="64gb" name="ram" /> <label class="form-check-label"
										for="64gb">64 GB</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="8 GB"
										id="8gb" name="ram" /> <label class="form-check-label"
										for="8gb">8 GB</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-md-4 col-6">
							<div class="mb-2" style="font-weight: bold">kích thước màn
								hình</div>
							<div class="d-flex flex-row">
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="14 in"
										id="14in" name="size" /> <label class="form-check-label"
										for="14in">14 in</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="16 in"
										id="16in" name="size" /> <label class="form-check-label"
										for="16in">16 in</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="15,6 in"
										id="15,6in" name="size" /> <label class="form-check-label"
										for="15,6in">15,6 in</label>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-6">
							<div class="mb-2" style="font-weight: bold">độ phân giải</div>
							<div class="d-flex flex-row">
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="Full HD"
										id="fullhd" name="resolution" /> <label
										class="form-check-label" for="fullhd">Full HD</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox"
										value="Full HD+" id="fullhd+" name="resolution" /> <label
										class="form-check-label" for="fullhd+">Full HD+</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="2K"
										id="2k" name="resolution" /> <label class="form-check-label"
										for="2k">2K</label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-4">
									<input class="form-check-input" type="checkbox" value="2,5K"
										id="2,5k" name="resolution" /> <label
										class="form-check-label" for="2,5k">2,5K</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="3,2 K"
										id="3,2k" name="resolution" /> <label
										class="form-check-label" for="3,2k">3,2K</label>
								</div>
							</div>
						</div>
						<div class="col-md-4 col-6">
							<div class="mb-2" style="font-weight: bold">lưu trữ</div>
							<div class="d-flex flex-row">
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="256 GB"
										id="256gb" name="drive" /> <label class="form-check-label"
										for="256gb">256 GB</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="516 GB"
										id="516gb" name="drive" /> <label class="form-check-label"
										for="516gb">516 GB</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="1 TB"
										id="1tb" name="drive" /> <label class="form-check-label"
										for="1tb">1 TB</label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="2 TB"
										id="2tb" name="drive" /> <label class="form-check-label"
										for="2tb">2 TB</label>
								</div>
								<div class="form-check me-2">
									<input class="form-check-input" type="checkbox" value="4 TB"
										id="4tb" name="drive" /> <label class="form-check-label"
										for="4tb">4 TB</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-md-5 col-10">
							<div class="mb-2" style="font-weight: bold">Mức giá</div>

							<div id="slider" class="ms-2"></div>
							<div class="d-flex flex-row mt-3">
								<div>
									<p>
										từ : <span id="rangeFrom" class="text-danger">20</span> đ
									</p>
									<input type="hidden" name="from" id="fromValue" />
								</div>

								<div class="ms-auto">
									<p>
										đến: <span id="rangeTo" class="text-danger">80 </span> đ
									</p>
									<input type="hidden" name="to" id="toValue" />
								</div>
							</div>

							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.7.0/nouislider.min.js"></script>
							<script>
                  const slider = document.getElementById("slider");
                  noUiSlider.create(slider, {
                    start: [0, 100000000],
                    connect: true,
                    range: {
                      min: 0,
                      max: 100000000,
                    },
                  });

                  const rangeFrom = document.getElementById("rangeFrom");
                  const rangeTo = document.getElementById("rangeTo");
                  const fromValue = document.getElementById("fromValue"); // input hidden for "from"
                  const toValue = document.getElementById("toValue");
                  slider.noUiSlider.on("update", (values) => {
                    const from = Math.round(values[0]);
                    const to = Math.round(values[1]);

                    // Cập nhật nội dung hiển thị
                    rangeFrom.textContent = from.toLocaleString("vi-VN");
                    rangeTo.textContent = to.toLocaleString("vi-VN");

                    // Cập nhật giá trị vào input ẩn
                    fromValue.value = from;
                    toValue.value = to;
                  });
                </script>
						</div>
						<div class="col-md-6 col-10 ms-5">
							<div class="mb-2" style="font-weight: bold">Thương hiệu</div>
							<div class="d-flex flex-row">
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="lenovo"
										id="lenovo" name="brand" /> <label class="form-check-label"
										for="lenovo">lenovo</label>
								</div>
								<div class="form-check me-3">
									<input class="form-check-input" type="checkbox" value="asus"
										id="asus" name="brand" /> <label class="form-check-label"
										for="asus">asus</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="dell"
										id="dell" name="brand" /> <label class="form-check-label"
										for="dell">dell</label>
								</div>
							</div>
							<div class="d-flex flex-row">
								<div class="form-check me-4">
									<input class="form-check-input" type="checkbox" value="MSI"
										id="MSI" name="brand" /> <label class="form-check-label"
										for="MSI">MSI</label>
								</div>
								<div class="form-check me-4">
									<input class="form-check-input" type="checkbox" value="acer"
										id="acer" name="brand" /> <label class="form-check-label"
										for="acer">acer</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="HP"
										id="HP" name="brand" /> <label class="form-check-label"
										for="HP">HP</label>
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