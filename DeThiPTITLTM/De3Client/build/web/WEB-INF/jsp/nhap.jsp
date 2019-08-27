
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%  String msg = request.getParameter("ok"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div align="center">
            <form:form method="post" action="${pageContext.request.contextPath}/chuanhoaRMI" modelAttribute="chuanHoaVB">
                <table>
                    <tr>
                        <td>Chuỗi: </td>
                        <td><form:textarea type="text" path="chuoi" rows="10" cols="20"/></td>
                    </tr>
                    <tr>
                        <td colspan = "2" align="right">
                            <input class="btn btn-default" type = "submit" value = "Chuẩn hóa"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <%    if ((msg != null) && (msg.equals("0"))) {   %>                 
        <SCRIPT language=JavaScript>
            alert("Chuoi rong!");
        </SCRIPT>
        <p align="center"></p>
    </body>
    <%}%>    
</html>
