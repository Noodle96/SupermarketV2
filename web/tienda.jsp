<%-- 
    Document   : tienda
    Created on : 08/12/2018, 11:23:19 PM
    Author     : russel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css"/>
        <title>Tienda Plaza Vea Peru</title>
    </head>
    <body>
         <pre>
            Agregar Tiendas   |   Nivel Administrador Humanidades  | <a href="vistaPersona.jsp">Home</a> <hr>
        </pre>
        <center>
            <h1>Tienda</h1>
            <form action="servertienda.do" method="POST">
                <input type="text" name="txtnombret" placeholder="nombreTienda" /><br>
                <input type="text" name="txtdepartamentot" placeholder="Departamentot" /><br>
                <input type="text" name="txtprovinciat" placeholder="Provincia Tienda" /><br>
                <input type="text" name="txtdirecciont" placeholder="Direccion Tienda" /><br>
                <input type="text" name="txttelefono" placeholder="telefono" /><br>
                <input type="submit" name="btnAgregarTienda" value="Insertar"/>
                <br>
            </form>
        </center>
        
        <%
            if(request.getAttribute("Good") != null){
                out.print("<script>alert('Se ingreso Correctamente')</script>");
            }
            else if(request.getAttribute("Fail") != null){
                out.print("<script>alert('No se Ingreso con exito')</script>");
            }
        %>
        
    </body>
</html>
