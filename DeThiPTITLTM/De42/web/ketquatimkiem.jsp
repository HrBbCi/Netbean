<%-- 
    Document   : ketquatimkiem
    Created on : Dec 3, 2018, 1:24:10 PM
    Author     : HrBbCi
--%>

<%@page import="java.util.List"%>
<%@page import="model.HangHoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<HangHoa> listhh = (List) session.getAttribute("hanghoa");
    String msg = (String) request.getParameter("ok");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kết quả</title>
    </head>
    <body>
        <p id="message"></p>
        <div class="point-table" align="center" >
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th>Select</th>
                </tr>
                <% for (HangHoa hh : listhh) {%>
                <tr>
                    <td style="padding: 10px"><%= hh.getIdHangHoa()%></td>
                    <td style="padding: 10px" ><%= hh.getTenHH()%></td>
                    <td style="padding: 10px"><%= hh.getGia()%></td>
                    <td><a href="edithanghoa.jsp?id=<%= hh.getIdHangHoa()%>">Cập nhật</a>
                    </td>
                </tr>
                <%}%>
            </table>
            <% if (msg.equals("1")) {%>
            <script>
                alert("Cập nhật thành công");
            </script>
            <%} else if (msg.equals("0")) {%>
            <script>
                document.getElementById("message").innerHTML = "Cập nhật ko thành công";
            </script>
            <%} else {%>
            <script>
                document.getElementById("message").innerHTML = "";
            </script>
            <%}%>
        </div>
    </body>
</html>
