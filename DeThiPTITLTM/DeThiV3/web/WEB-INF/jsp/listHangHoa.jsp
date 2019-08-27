<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>
            <h4><a href="nhaphangmoi">Thêm Hàng Hóa</a> </h4>
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${listHH}" var="hh">
                    <tr>
                        <td>${hh.idHangHoa}</td>
                        <td>${hh.tenHH}</td>
                        <td>${hh.gia}</td>
                        <td><a href="${request.contextPath}/DeThiV3/editHH/${hh.idHangHoa}">Edit</a></td>
                        <td><a href="${request.contextPath}/DeThiV3/deleteHH/${hh.idHangHoa}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
