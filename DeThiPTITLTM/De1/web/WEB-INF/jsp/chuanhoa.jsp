<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chuẩn hóa văn bản</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <div align="center">
            <form:form method="post" action="${pageContext.request.contextPath}/chuanhoa" modelAttribute="chuanHoaVB">
                <table>
                    <tr>
                        <td>Chuỗi: </td>
                        <td><form:input type="text" path="chuoi"/></td>
                       
                    </tr>
                    <tr>
                        <td>Chuỗi sau khi chuẩn hóa: </td>
                        <td><form:textarea type="text" path="chuoiChuanHoa" readonly="true" value="${a}"/></td>
                      
                    </tr>
                    <tr>
                        <td colspan = "2" align="right">
                            <input class="btn btn-default" type = "submit" value = "Chuẩn hóa"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
