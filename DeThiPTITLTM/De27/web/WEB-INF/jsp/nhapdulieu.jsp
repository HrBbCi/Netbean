<%-- 
    Document   : nhapdulieu
    Created on : Dec 2, 2018, 8:25:50 PM
    Author     : HrBbCi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>De 27</title>
    </head>
    <body>
        <form:form method="POST" action="${pageContext.request.contextPath}/phantich" modelAttribute="PTSNT">
            <table>
                <tr>
                    <td>Nhập:</td>
                    <td><form:input path="number" type="number"  required="true"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Submit" /></td>
                </tr>
            </table>

        </form:form>
       
    </body>
    
</html>
