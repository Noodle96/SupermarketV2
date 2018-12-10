<%-- 
    Document   : tienda
    Created on : 08/12/2018, 11:23:19 PM
    Author     : russel
--%>

<%@page import="Modelo.DAOTienda"%>
<%@page import="Uml.Tienda"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
    
        <br>
        <hr>
        <br>
        <center>
            <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Departamento</th>
                    <th>Provincia</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //hacer un recorrido sobre el resultado
                    // de la consulta
                    List<Tienda> datos = new ArrayList();
                    DAOTienda dao = new DAOTienda();
                    datos = dao.consultarTienda();
                    for(Tienda p : datos){
                        %>
                        <tr>
                            <td><%= p.getIdTienda()%>  </td>
                            <td> <%= p.getNameTienda() %> </td>
                            <td> <%= p.getDepartamento() %>  </td>
                            <td> <%= p.getProvincia() %>  </td>
                            <td> <%=p.getDireccion() %>  </td>
                            <td> <%= p.getTelefono() %> </td>
                        </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
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
