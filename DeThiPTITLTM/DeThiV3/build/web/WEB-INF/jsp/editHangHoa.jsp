
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page language="java" import= " java.util.*, java.awt.*, entity.*, model.*,controller.*" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Spring Registration Example</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h4 align="center">Edit h�ng h�a</h4>
            <div align="center">
                <form:form method="POST" action="${pageContext.request.contextPath}/editHH" modelAttribute="hanghoa">
                    <table>
                        <tr>
                            <td>ID:</td>
                            <td><form:input class="form-control" path="idHangHoa" value="${idHangHoa}" readonly="true"/></td>
                            <td> <form:errors path="idHangHoa" cssClass="error" /></td>
                        </tr>
                        <tr>
                            <td>T�n:</td>
                            <td><form:input class="form-control" path="tenHH" value="${tenHH}" /></td>
                            <td><form:errors path="tenHH" cssClass="error" element="div" /></td>
                        </tr>
                        <tr>
                            <td>Gi�:</td>
                            <td><form:input class="form-control" path="gia" value="${gia}" /></td>
                            <td><form:errors path="gia" cssClass="error" element="div"/></td>
                        </tr>
                        <tr>
                            <td colspan = "2" align="right">
                                <input class="btn btn-default" type = "submit" value = "Edit"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
            
        </div>
    </body>
</html>