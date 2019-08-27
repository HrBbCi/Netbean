
<%@page import="java.util.List"%>
<%@page import="model.HangHoa"%>
<%@page import="control.HangHoaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String idhh = (String) request.getParameter("idHH");
    String tenHH = (String) request.getParameter("ten");
    HangHoaController hhc = new HangHoaController();
    HangHoa hh = new HangHoa(idhh, tenHH, Float.parseFloat(request.getParameter("gia")));
    hhc.updateHH(hh);
    System.out.println(a());
    List<HangHoa> listh = hhc.findByIDList(idhh);
    session.setAttribute("hanghoa", listh);
    response.sendRedirect("ketquatimkiem.jsp?ok=1");
%>
<%! 
    public String a(){
        return "aaa";
    }
%> 