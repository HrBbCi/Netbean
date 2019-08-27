<%-- 
    Document   : edithanghoa
    Created on : Dec 3, 2018, 5:11:00 PM
    Author     : HrBbCi
--%>

<%@page import="control.HangHoaController"%>
<%@page import="model.HangHoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String idH =  request.getParameter("id"); 
    HangHoaController hhc = new HangHoaController();
    HangHoa hh = hhc.findByID(idH);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT</title>
    </head>
    <body align="center">
        <form action="xulycapnhat.jsp" method="POST">
            ID: <input type="text" readonly="true" name ="idHH" value="<%= hh.getIdHangHoa() %>"/><br />
            Tên: <input type="text"  required="" name ="ten" value="<%= hh.getTenHH()%>"/><br />
            Giá: <input type="text" required="" name ="gia" value="<%= hh.getGia()%>"/><br />
            <button>Edit</button>
        </form>
    </body>
</html>
