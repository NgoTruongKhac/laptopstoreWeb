<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade mt-5" id="addUser" tabindex="-1"
	aria-labelledby="userModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form id="addUserForm"  method="post">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="userModalLabel">Thêm tài
						khoản</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<div class="row">
						<div class="col-md-6 col-12">
							<div class="row">
							
							
								<div class="col-5 mb-3">
									<input id="firstName" name="firstName" class="form-control"
										type="text" placeholder="Tên" required="required" />
								</div>
								<div class="col-7 mb-3">
									<input id="lastName" name="lastName" class="form-control"
										type="text" placeholder="Họ" required="required" />
								</div>
							</div>
							<div class="mb-3">
								<input id="pass" name="pass" class="form-control"
									type="password" placeholder="mật khẩu" required="required" />
							</div>
							<div class="mb-3">
								<input id="email" name="email" class="form-control" type="email"
									placeholder="email" />
							</div>
							<div class="mb-3">
								<input id="phoneNumber" name="phoneNumber" class="form-control"
									type="text" placeholder="Số điện thoại" />
							</div>
						</div>
						<div class="col-md-6 col-12">
							<div class="avatar-picker mb-3 d-flex justify-content-center">
								<img class="rounded-circle" width="18%"
									src="images/blank_avatar.png" alt="Avatar" class="avatar"
									id="selected-avatar" name="image" /> <input id="avatarSrc"
									type="hidden" name="avatarSrc" 
									value="images/blank_avatar.png">
							</div>
							<%@ include file="/components/selectAvatar.jsp"%>
							<div class="mb-3 ms-3 d-flex flex-row">
								<div class="mb-1">
									<label class="form-check me-2" for="">Ngày sinh :</label>
								</div>
								<div>
									<input id="birthday" class="form-control" type="date"
										name="birthday" pattern='yyyy-MM-dd' required="required" />
								</div>
							</div>
							<div class="mb-3 ms-3 d-flex flex-row">
								<div class="mb-1">
									<label class="form-check me-2" for="">Giới tính :</label>
								</div>

								<div class="form-check form-check-inline">
									<input id="male" name="sex" class="form-check-input"
										type="radio" value="Nam" /> <label class="form-check-label"
										for="male">Nam</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="female" name="sex" class="form-check-input"
										type="radio" value="Nữ" /> <label class="form-check-label"
										for="female">Nữ</label>
								</div>
							</div>
							<div class="mb-3 ms-3 d-flex flex-row">
								<div class="mb-1">
									<label class="form-check me-2" for="">Vai trò:</label>
								</div>

								<div class="form-check form-check-inline">
									<input id="admin" name="role" class="form-check-input"
										type="radio" value="admin" /> <label class="form-check-label"
										for="admin">admin</label>
								</div>
								<div class="form-check form-check-inline">
									<input id="customer" name="role" class="form-check-input"
										type="radio" value="customer" /> <label
										class="form-check-label" for="customer">customer</label>
								</div>
							</div>
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