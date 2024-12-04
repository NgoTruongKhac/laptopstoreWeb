var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function upQuantityCart(cartId) {

	const input = document.getElementById(`quantity-${cartId}`);

	// Tăng giá trị của input
	input.stepUp();

	// Lấy giá trị hiện tại của input
	const quantity = input.value;
	$.ajax({
		url: contextPath + "/updateQuantityCart?cartId=" + cartId + "&quantity=" + quantity,
		type: "get",
		dataType: "json",
		success: function(response) {

			document.getElementById('cartCount').textContent = response.cartCount;
			totalPrice();

		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});

}

function downQuantityCart(cartId) {

	const input = document.getElementById(`quantity-${cartId}`);

	// Tăng giá trị của input
	input.stepDown();

	// Lấy giá trị hiện tại của input
	const quantity = input.value;
	$.ajax({
		url: contextPath + "/updateQuantityCart?cartId=" + cartId + "&quantity=" + quantity,
		type: "get",
		dataType: "json",
		success: function(response) {


			document.getElementById('cartCount').textContent = response.cartCount;
			totalPrice();

		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});

}
