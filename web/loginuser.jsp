
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><br><br>
        <center>
        <h1>Pagina de Acceso Usuario</h1>
        <hr> 
        <form action="serverusuario.do" method="POST">
            <input type="email" name="txtemailuser" placeholder="email user"  /><br>
            <input type="password" name="txtpass" placeholder="password"  /><br>
            <input type="submit" value="iniciarsesion"name="btnIniciarSesionUser" /><br>
        </form>
        <a href="index.jsp" class = "user">Home</a><br>
    </center>
    
    
   
     <%
        HttpSession sesion = request.getSession();
        if(request.getAttribute("Fail") != null){
            out.print("<script>alert('NUd todavia no es usuario, Registrese!!')</script>");
        }
        if(request.getAttribute("emailU") != null  ){
            String em = (String)request.getAttribute("emailU");
            sesion.setAttribute("emailM", em);
            //"adminRecursos";"adminHumanidades"
            //System.out.println("dentro de != null");
            response.sendRedirect("vistaUsuario.jsp");
        }
        
        if(request.getParameter("cerrar") != null){
            sesion.invalidate();
            response.sendRedirect("loginuser.jsp");
        }
    %>
    

    </body>
</html>