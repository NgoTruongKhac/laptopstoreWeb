var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function deleteLaptop(laptopId,pageLaptop) {
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
			       url: contextPath+"/adminPage/deleteLaptop?laptopId="+laptopId+"&pageLaptop="+pageLaptop,
			       type: "get",
			       dataType: "html",
			       success: function(response) {
					document.getElementById("listLaptopManage").innerHTML = response;
					const notyf = new Notyf();
					       notyf.open({
					           type : "success",
					           message : "xoá sản phẩm thành công",
					           position : {
					               x : "center",
					               y : "center",
					           },
					           duration : "success" === "error" ? null : 2500,
					           dismissible : true
					       });
			       },
			       error: function(xhr, status, error) {
			           console.error("Error loading section:", error);
			       }
			   });
		}
	});
}

function deletePeripheral(peripheralId,pagePeripheral) {
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
			       url: contextPath+"/adminPage/deletePeripheral?peripheralId="+peripheralId+"&pagePeripheral="+pagePeripheral,
			       type: "get",
			       dataType: "html",
			       success: function(response) {
					document.getElementById("listPeripheralManage").innerHTML = response;
					const notyf = new Notyf();
					       notyf.open({
					           type : "success",
					           message : "xoá sản phẩm thành công",
					           position : {
					               x : "center",
					               y : "center",
					           },
					           duration : "success" === "error" ? null : 2500,
					           dismissible : true
					       });
			       },
			       error: function(xhr, status, error) {
			           console.error("Error loading section:", error);
			       }
			   });
		}
	});
}