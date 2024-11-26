<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<form id="editUserForm" method="post">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="userModalLabel2">Cập nhật tài
					khoản</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>

			<div class="modal-body">
				<div class="row">
					<div class="col-md-6 col-12">
						<div class="row">
							<input type="text" name="userId" value="${User.userId}" hidden="true">
							<div class="col-5 mb-3">
								<input name="firstName" class="form-control" type="text"
									placeholder="Tên" value="${User.firstName}" />
							</div>
							<div class="col-7 mb-3">
								<input name="lastName" class="form-control" type="text"
									placeholder="Họ" value="${User.lastName}" />
							</div>
						</div>
						<div class="mb-3">
							<input name="pass" class="form-control" type="password"
								placeholder="mật khẩu" readonly="readonly" />
						</div>
						<div class="mb-3">
							<input name="email" class="form-control" type="email"
								placeholder="email" value="${User.email}" />
						</div>
						<div class="mb-3">
							<input name="phoneNumber" class="form-control" type="text"
								placeholder="Số điện thoại" value="${User.phoneNumber}" />
						</div>
					</div>
					<div class="col-md-6 col-12">
						<div onclick="avatarPicker()"
							class="avatar-picker mb-3 d-flex justify-content-center">
							<img class="rounded-circle" width="18%" src="${User.avatar}"
								alt="Avatar" class="avatar" id="selected-avatar-edit"
								name="image" /> <input id="avatarSrc-edit" type="hidden"
								name="avatarSrc" value="${User.avatar}">
						</div>
						<%@ include file="selectAvatarEdit.jsp"%>
						<div class="mb-3 ms-3 d-flex flex-row">
							<div class="mb-1">
								<label class="form-check me-2" for="">Ngày sinh :</label>
							</div>
							<div>
								<input class="form-control" type="date" name="birthday"
									pattern='yyyy-MM-dd'
									value="<fmt:formatDate value='${User.birthday}' pattern='yyyy-MM-dd'/>" />
							</div>
						</div>
						<div class="mb-3 ms-3 d-flex flex-row">
							<div class="mb-1">
								<label class="form-check me-2" for="">Giới tính :</label>
							</div>

							<div class="form-check form-check-inline">
								<input id="male" name="sex" class="form-check-input"
									type="radio" value="Nam"
									${User.sex.trim()=='Nam'? 'checked':'' } /> <label
									class="form-check-label" for="male">Nam</label>
							</div>
							<div class="form-check form-check-inline">
								<input id="female" name="sex" class="form-check-input"
									type="radio" value="Nữ" ${User.sex.trim()=='Nữ'? 'checked':'' } />
								<label class="form-check-label" for="female">Nữ</label>
							</div>
						</div>
						<div class="mb-3 ms-3 d-flex flex-row">
							<div class="mb-1">
								<label class="form-check me-2" for="">Vai trò:</label>
							</div>

							<div class="form-check form-check-inline">
								<input id="admin" name="role" class="form-check-input"
									type="radio" value="admin"
									${User.role.trim()=='admin'? 'checked':'' } /> <label
									class="form-check-label" for="admin">admin</label>
							</div>
							<div class="form-check form-check-inline">
								<input id="customer" name="role" class="form-check-input"
									type="radio" value="customer"
									${User.role.trim()=='customer'? 'checked':'' } /> <label
									class="form-check-label" for="customer">customer</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button onclick="updateUser(${page})" type="submit"
					class="btn btn-primary">Cập nhật</button>
			</div>
		</form>
	</div>
</div>