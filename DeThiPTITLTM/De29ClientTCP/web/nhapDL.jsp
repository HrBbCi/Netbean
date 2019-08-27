<%-- 
    Document   : nhapDL
    Created on : Dec 5, 2018, 9:34:25 PM
    Author     : HrBbCi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import = " java.util.*, java.awt.*, model.*, control.*" %> 
<%
    String msg = request.getParameter("msg");
    if(msg == null){
        msg = String.valueOf(1);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <form method="post" action="xuly.jsp">
            so: <input name="so" type="number" required="required"/><br/> 
            coso: <input name="coso" type="number" required="required"/><br/>  
            <%if (msg.equals("2") && msg != null) {%>
                <p id="errorcs">Lỗi cơ số</p> 
            <% }%>
            <button>Chuyen doi</button>
        </form>

    </body>
</html>
