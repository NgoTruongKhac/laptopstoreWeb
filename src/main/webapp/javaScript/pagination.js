var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
function loadPageLaptop(pageNumber) {
    var url = contextPath+"/adminPage/listLaptop?pageLaptop=" + pageNumber;

    $.ajax({
        url: url,
        type: "get",
        dataType: "html",
        success: function(response) {
             document.getElementById("listLaptopManage").innerHTML = response;
        },
        error: function(xhr, status, error) {
            console.error("Error loading section:", error);
        }
    });
}
function loadPagePeripheral(pageNumber) {
    var url =contextPath+"/adminPage/listPeripheral?pagePeripheral=" + pageNumber;

    $.ajax({
        url: url,
        type: "get",
        dataType: "html",
        success: function(response) {
             document.getElementById("listPeripheralManage").innerHTML = response;
        },
        error: function(xhr, status, error) {
            console.error("Error loading section:", error);
        }
    });
}

function loadPageUser(pageNumber) {
    var url =contextPath+"/adminPage/listUser?page=" + pageNumber;

    $.ajax({
        url: url,
        type: "get",
        dataType: "html",
        success: function(response) {
             document.getElementById("listUserManage").innerHTML = response;
        },
        error: function(xhr, status, error) {
            console.error("Error loading section:", error);
        }
    });
}

function loadPageOrder(pageOrder) {
    var url =contextPath+"/adminPage/renderListOrder?pageOrder=" + pageOrder;

    $.ajax({
        url: url,
        type: "get",
        dataType: "html",
        success: function(response) {
             document.getElementById("listOrderManage").innerHTML = response;
        },
        error: function(xhr, status, error) {
            console.error("Error loading section:", error);
        }
    });
}

function loadPageMyOrder(pageOrder) {
    var url =contextPath+"/renderListMyOrder?pageOrder=" + pageOrder;

    $.ajax({
        url: url,
        type: "get",
        dataType: "html",
        success: function(response) {
             document.getElementById("listMyOrder").innerHTML = response;
        },
        error: function(xhr, status, error) {
            console.error("Error loading section:", error);
        }
    });
}


