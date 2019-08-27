
<%@page import="java.util.List"%>
<%@page import="model.HangHoa"%>
<%@page import="control.HangHoaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String idhanghoa = request.getParameter("idhanghoa");
    HangHoaController hhc = new HangHoaController();
    List<HangHoa> hh = hhc.findByIDList(idhanghoa);
    if(hh == null){
        response.sendRedirect("timkiemhanghoa.jsp?nfid");
    }
    else{
        session.setAttribute("hanghoa", hh);
        response.sendRedirect("ketquatimkiem.jsp?ok=2");
    }
%>
