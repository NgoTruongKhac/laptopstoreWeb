


function avatarPicker() {

	const avatarOptions = document.getElementById('avatar-options-edit');
	avatarOptions.style.display = avatarOptions.style.display === 'block' ? 'none' : 'block';
};


function selectAvatar(avatar) {
	// Cập nhật avatar cho cả hai trường hợp
	document.getElementById('selected-avatar').src = avatar;
	document.getElementById('avatarSrc').value = avatar;

	document.getElementById('selected-avatar-edit').src = avatar;
	document.getElementById('avatarSrc-edit').value = avatar;

	// Đóng cửa sổ chọn avatar
	document.getElementById('avatar-options-edit').style.display = 'none';
	document.getElementById('avatar-options').style.display = 'none';
}
