<%@page language="java" import = "java.util.*, java.awt.*, model.*, control.*"%>
<%
    String a = (String) request.getParameter("a");
    String b = (String) request.getParameter("b");
    String c = (String) request.getParameter("c");
    
    float soA = Float.parseFloat(a);
    float soB = Float.parseFloat(b);
    float soC = Float.parseFloat(c);
    
    GiaiPTB2 g = new GiaiPTB2(soA, soB, soC);
    

    ClientControl cc = new ClientControl();
    cc.openConnection();
    cc.sendData(g);
    GiaiPTB2 g2 = cc.receiveData();
    session.setAttribute("giaiPTB2", g2);
    cc.closeConnection();
    response.sendRedirect("UserHome.jsp");
   
%>