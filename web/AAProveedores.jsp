<%-- 
    Document   : AAProveedores
    Created on : 11/12/2018, 01:10:03 AM
    Author     : russel
--%>

<%@page import="Uml.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOProveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <pre>
            Agregar Proveedores  | Nivel Administrador Recursos | <a href="vistaAdminRecursos.jsp?cerrar=true">Home</a><hr>
        </pre>
        <center>
            <h1>Agregar Proveedores</h1>
             <form action="serverproveedor.do" method="POST">
                <input type="text" name="txtnameP" placeholder="Nombre Proveedor" /><br>
                <input type="text" name="txtpais" placeholder="Pais" /><br>
                <input type="text" name="txtdepartamento" placeholder="Departamento" /><br>
                <input type="text" name="txtprovinvia" placeholder="Provincia" /><br>
                <input type="text" name="txtdireccion" placeholder="Dirreccion" /><br>
                <input type="text" name="txthomepage" placeholder="www.example.com" /><br>
                <input type="text" name="txttelefono" placeholder="Telefono" /><br>
                <input type="text" name="txtpersonacontacto" placeholder="Persona Contacto" /><br>
                <input type="submit" name="btninsertarProveedor" value="Insertar"/>
                <br>
            </form>
        </center>
    
        <center>
            <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Pais</th>
                    <th>Departamento</th>
                    <th>Provincia</th>
                    <th>Direccion</th>
                    <th>Homepage</th>
                    <th>Telefono</th>
                    <th>PersonaContacto</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //hacer un recorrido sobre el resultado
                    // de la consulta
                    DAOProveedor dao1 = new DAOProveedor();
                    List<Proveedor> datos1 = new ArrayList();
                    datos1 = dao1.consultarProveedor();
                    for(Proveedor p1 : datos1){
                        %>
                        <tr>
                            <td><%= p1.getIdProveedor() %>  </td>
                            <td> <%= p1.getNameProveedor() %> </td>
                            <td> <%= p1.getPaisP() %>  </td>
                            <td> <%= p1.getDepartamentoP() %> </td>
                            <td> <%= p1.getProvinciaP() %>  </td>
                            <td> <%= p1.getDireccionP() %>  </td>
                            <td> <%= p1.getHomepageP() %>  </td>
                            <td> <%= p1.getTelefonoP() %>  </td>
                            <td> <%= p1.getPersonaContacto() %>  </td>
                        </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
        </center>
               
        <%
        if(request.getAttribute("GoodbtninsertarProveedor") != null){
            out.print("<script>alert('Se ingreso Correctamente')</script>");
        }
        else if(request.getAttribute("FailbtninsertarProveedor") != null){
            //String erL = (String)request.getAttribute("FailbtninsertarAdminHum");
            //out.print("<script>alert('"+erL+"')</script>");
            out.print("<script>alert('No se Ingreso con exito')</script>");
        }
        %>
            
    </body>
</html>
