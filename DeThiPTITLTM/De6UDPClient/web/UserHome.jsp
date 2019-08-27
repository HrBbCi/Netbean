<%@page language="java" import = " java.util.*, java.awt.*, model.*, control.*" %>
<%
    GiaiPTB2 g = (GiaiPTB2) session.getAttribute("giaiPTB2");
    if (g == null) {
        response.sendRedirect("Home.jsp?ok=0");
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>JSP demo test</TITLE>
        <META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
    </HEAD>
    <BODY>
        <%= g.getKq()%>
        <%= g.getX1()%>
        <%= g.getX2()%>
    </BODY>
</HTML>