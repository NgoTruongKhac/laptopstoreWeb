var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

function orderDetail(orderId,pageOrder) {
	$.ajax({
		url: contextPath + "/adminPage/orderDetail?orderId=" + orderId+"&pageOrder="+pageOrder,
		type: "GET",
		dataType: "html",
		success: function(response) {

			document.getElementById("orderDetail").innerHTML = response;
			
			
		},
		error: function(xhr, status, error) {
			console.error("Error loading section:", error);
		}
	});
}



