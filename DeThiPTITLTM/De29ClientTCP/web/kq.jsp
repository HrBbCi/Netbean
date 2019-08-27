<%-- 
    Document   : kq
    Created on : Dec 5, 2018, 9:35:37 PM
    Author     : HrBbCi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String so=(String) session.getAttribute("so");
    String coso =(String) session.getAttribute("coso");
    String kq =(String) session.getAttribute("kq");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        So: <span style="font-weight: bold"><%= so %></span> chuyen sang co so 
    <span style="font-weight: bold"><%= coso %> </span> la :<%= kq %>
    </body>
</html>
