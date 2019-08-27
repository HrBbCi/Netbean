<%@page contentType="text/html" 
        import="java.util.*, java.awt.*, control.*" pageEncoding="UTF-8"%>
<%
    String number = request.getParameter("number");
    Float numberr = Float.parseFloat(number);
    
    ClientControl cc = new ClientControl();
    cc.openConnection();
    cc.sendData(numberr);
    String ok = (String) cc.receiveData();
    cc.closeConnection();
    session.setAttribute("Number", number);
    if(ok.equals("ok")){
        response.sendRedirect("nhanketqua.jsp?ok=ok");
    }
    else{
        response.sendRedirect("nhanketqua.jsp?ok=notok");
    }
%>
