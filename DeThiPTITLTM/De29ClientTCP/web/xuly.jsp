
<%@page import="model.CoSo"%>
<%@page import="control.ClientControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String strso = request.getParameter("so");
    String strcoso = request.getParameter("coso");

    int so = Integer.parseInt(strso);
    int coso = Integer.parseInt(strcoso);
    if (coso == 2 || coso == 8 || coso == 10 || coso == 16) {
        ClientControl cc = new ClientControl();
        CoSo cs = new CoSo(so, coso);
        cc.openCon();
        cc.sendData(cs);
        String kq = (String) cc.receiveData();
        cc.closeCon();
        session.setAttribute("kq", kq);
        session.setAttribute("so", String.valueOf(so));
        session.setAttribute("coso", String.valueOf(coso));
        response.sendRedirect("kq.jsp");
    } else {
        response.sendRedirect("nhapDL.jsp?msg=2");
    }
%>