<%@page language="java" import = " java.util.*, java.awt.*, model.*, control.*" %>
<%  String msg = request.getParameter("ok"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">   
<HTML><HEAD><TITLE>JSP demo test</TITLE>
        <META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
    </HEAD>
    <BODY leftMargin=0 topMargin=0>
        <table border="0" cellpadding="0" cellspacing="0" >
            <tr>
                <td width="100%" height="133">&nbsp;
                    <form method="POST" action="doLogin.jsp" >
                        <p>So a:
                            <input type="number" name="a" size="12"></p>
                        <p>So b : 
                            <input type="number" name="b" size="12"></p> 
                        <p>So c : 
                            <input type="number" name="c" size="12"></p> 
                        <p> <input type="submit" value="Submit" name="B1">
                            <input type="reset" value="Reset" name="B2"></p>       
                    </form>
                    <p></td> </tr>  </table>
                    <%    if ((msg != null) && (msg.equals("0"))) {   %>                 
        <SCRIPT language=JavaScript>
            alert("Loi!");
        </SCRIPT>
        <p align="center"></p>
    </BODY>
    <%}%>                   
</HTML>
