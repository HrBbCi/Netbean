
<%@page contentType="text/html" 
        import = " java.util.*, java.awt.*, model.*, control.*" pageEncoding="UTF-8"%>
<%
    String number = (String) session.getAttribute("Number");
    String ok = (String) request.getParameter("ok");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <p id="so"></p>
        <% if (ok.equals("ok")) { %>
        <script>
            document.getElementById("so").innerHTML = <%= number %>+" is prime number";
        </script>
        <%} else { %>
         <script>
            document.getElementById("so").innerHTML = <%= number %>+" not is prime number";
        </script>
        <%}%>


    </body>
</html>
