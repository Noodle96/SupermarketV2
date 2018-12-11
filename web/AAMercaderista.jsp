<%-- 
    Document   : AAMercaderista
    Created on : 10/12/2018, 11:41:20 PM
    Author     : russel
--%>

<%@page import="Uml.Persona"%>
<%@page import="Modelo.DAOPersona"%>
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
           Agregar Mercaderistas  | Nivel Administrador Humanidades | <a href="vistaPersona.jsp">Home</a><hr>
        </pre>
        <center>
            <h1>Agregar Mercaderistas</h1>
            <form action="serverpersona.do" method="POST">
                <input type="text" name="txtdnipersona" placeholder="dniAdmin" /><br>
                <input type="text" name="txtname" placeholder="nombre Admin" /><br>
                <input type="text" name="txtapellido1" placeholder="Apellido 1 Admin" /><br>
                <input type="text" name="txtapellido2" placeholder="Apellido 2 Admin" /><br>
                <input type="email" name="txtemail" placeholder="email" /><br>
                <input type="text" name="txttelefono" placeholder="telefono" /><br>
                <input type="text" name="txtfechaNacimiento" placeholder="dd-mmm-yyyy" /><br>
                <input type="text" name="txtdireccion" placeholder="Direccion" /><br>
                <input type="text" name="txtsexo" placeholder="sexo" /><br>
                <input type="text" name="txtidtienda" placeholder="id Tienda" /><br>
                <select name="idProveedor">
                     <option value="" selected disabled hidden>Seleccione Proveedor</option>
                    <%
                         DAOProveedor dao = new DAOProveedor();
                         List<Proveedor> datosp1 = new ArrayList();
                         datosp1 = dao.consultarProveedor();
                         for(Proveedor p : datosp1){
                    %>
                            <option value=<%=p.getIdProveedor()%>  ><%= p.getNameProveedor()%></option>
                        <%
                          }          
                        %>
                </select><br>
                <input type="submit" name="btninsertarMercaderista" value="Insertar"/>
                <br>
            </form>
        </center>
                
       
         <center>
            <table border="1">
            <thead>
                <tr>
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Apellido1</th>
                    <th>Email</th>
                    <th>FechaInicioContrato</th>
                    <th>FechaNacimiento</th>
                    <th>Sexo</th>
                    <th>Nombre Proveedor</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //hacer un recorrido sobre el resultado
                    // de la consulta
                    DAOPersona daoCM = new DAOPersona();
                    List<Persona> datosM = new ArrayList();
                    datosM = daoCM.consultarMercaderista();
                    for(Persona p1 : datosM){
                        %>
                        <tr>
                            <td><%= p1.getDniPersona() %>  </td>
                            <td> <%= p1.getNames() %> </td>
                            <td> <%= p1.getApellido1()%>  </td>
                            <td> <%= p1.getEmail() %> </td>
                            <td> <%= p1.getFechaInicioCon() %>  </td>
                            <td> <%= p1.getFechaNacimiento() %>  </td>
                            <td> <%= p1.getSexo() %>  </td>
                            <td> <%= p1.getNameSistema() %>  </td> <!--en namesistemas gurdamos el nombre del proveedor-->
                        </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
        </center>
         
        <%
        if(request.getAttribute("GoodbtninsertarMercaderista") != null){
            out.print("<script>alert('Se ingreso Correctamente')</script>");
        }
        else if(request.getAttribute("FailbtninsertarMercaderista") != null){
            //String erL = (String)request.getAttribute("FailbtninsertarAdminHum");
            //out.print("<script>alert('"+erL+"')</script>");
            out.print("<script>alert('No se Ingreso con exito')</script>");
        }
        %>
                
       
    </body>
</html>
