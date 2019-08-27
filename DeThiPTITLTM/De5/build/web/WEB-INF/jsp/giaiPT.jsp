<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GiaiPT</title>
    </head>
    <body>
        <div align="center">
            <form:form method="post" action="${pageContext.request.contextPath}/giaiPT" modelAttribute="giaiPTB2">
                <table>
                    <tr>
                        <td>a: </td>
                        <td><form:input path="a" type="text"/></td>
                    </tr>
                    <tr>
                        <td>b: </td>
                        <td><form:input path="b" type="text"/></td>
                    </tr>
                    <tr>
                        <td>c: </td>
                        <td><form:input path="c" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Kết quả: </td>
                        <td>
                            <textarea rows="5" cols="20">${kq}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="Giải PT">
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
