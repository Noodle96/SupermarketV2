<%-- 
    Document   : vistaUsuario
    Created on : 08/12/2018, 10:51:06 PM
    Author     : russel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%
    HttpSession ses = request.getSession();
    String emailUsuario = null;
    if(ses.getAttribute("emailM") != null && ses != null ){
        emailUsuario = (String)ses.getAttribute("emailM");
    }else{
        response.sendRedirect("loginuser.jsp");
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <pre>
            Bienvenido <%=emailUsuario%> | Usuario | <a href="loginuser.jsp?cerrar=true">Cerrar Sesion</a><hr>
        </pre>
        <h1>pagina del usuario</h1>
    </body>
</html>
