var contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1))
var amountPeripheral = document.getElementsByClassName("peripheralItem").length;
function morePeripheral() {
    $.ajax({
      url: contextPath + "/loadMorePeripheral",
      type: "get",
      dataType: "html",
      data: {
        peripheralExist: amountPeripheral,
      },
      success: function (respone) {
        var productMore = document.getElementById("productPeripheral");
        productMore.innerHTML +=respone;
        amountPeripheral += 8;
      },
    });
  }
  
 var amountLaptop = document.getElementsByClassName("laptopItem").length;
 function moreLaptop() {
      $.ajax({
        url:  contextPath + "/loadMoreLaptop",
        type: "get",
        dataType: "html",
        data: {
          laptopExist: amountLaptop,
        },
        success: function (respone) {
          var productMore = document.getElementById("productLaptop");
          productMore.innerHTML +=respone;
          amountLaptop += 8;
        },
      });
    }  