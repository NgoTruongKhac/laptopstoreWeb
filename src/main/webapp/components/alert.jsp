<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty message and not empty type}">
    <script type="text/javascript">
        const notyf = new Notyf({
            types : [ {
                type : 'warning',
                background : 'orange',
                icon : {
                    className : 'material-icons',
                    tagName : 'i',
                    text : 'warning',
                    color:'white'
                }
            } ]
        });
        notyf.open({
            type : "${type}",
            message : "${message}",
            position : {
                x : "center",
                y : "center",
            },
            duration : "${type}" === "error" || "${type}" === "warning" ? null : 2500,
            dismissible : true
        });
    </script>
    <!-- Xóa thông báo khỏi session sau khi hiển thị -->
</c:if>


