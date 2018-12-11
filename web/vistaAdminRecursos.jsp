<%-- 
    Document   : vistaAdminRecursos
    Created on : 08/12/2018, 12:31:11 PM
    Author     : russel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%
    HttpSession sess = request.getSession();
    String emailUsuario = null;
    String tipoUsuario = null;
    if(sess.getAttribute("emailM") != null  && sess.getAttribute("tipoM") != null && sess != null ){
        emailUsuario = (String)sess.getAttribute("emailM");
        tipoUsuario = (String)sess.getAttribute("tipoM");
    }else{
        response.sendRedirect("index.jsp");
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css"/>
        <title>JSP Page</title>
    </head>
    <body>
         <pre>
            Bienvenido <%=emailUsuario%> | Nivel Administrador Recursos | <a href="index.jsp?cerrar=true">Cerrar Sesion</a><hr>
        </pre>
        <nav class="menuCSS3 vista">
		<ul>
                    <li><a href="#">Shippers</a></li>
                    <li><a href="AAProveedores.jsp">Proveedores</a></li>
                    <li><a href="#">Area</a>
                        <ul>
                            <li><a href="#">Categorias</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Productos</a></li
		</ul>
	</nav>
    </body>
</html>

