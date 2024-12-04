var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function deleteCartItem(cartId) {
	Swal.fire({
		title: 'Bạn có muốn xoá sản phẩm này?',

		icon: 'question',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Đồng ý',
		cancelButtonText: 'Hủy bỏ'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				url: contextPath + "/deleteCartItem?cartId=" + cartId,
				type: "get",
				dataType: "json",
				success: function(response) {


					const deleteButton = document.querySelector(`a[onclick="deleteCartItem(${cartId})"]`);

					// Tìm phần tử cha có class "cartItem" và xóa nó
					const cartItemDiv = deleteButton.closest('.cartItem');
					if (cartItemDiv) {
						cartItemDiv.remove(); // Xóa thẻ div "cartItem"
					}



					if (response.cartCount > 0) {
						document.getElementById('cartCount').textContent = response.cartCount;
					} else {
						document.getElementById('cartCount').style.display = 'none';
					}
					
					totalPrice();


					const notyf = new Notyf();
					notyf.open({
						type: "success",
						message: "xoá sản phẩm thành công",
						position: {
							x: "center",
							y: "center",
						},
						duration: 2500,
						dismissible: true
					});
				},
				error: function(xhr, status, error) {
					console.error("Error loading section:", error);
				}
			});
		}
	});
}


