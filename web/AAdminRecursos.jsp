<%-- 
    Document   : AAdminRecursos
    Created on : 10/12/2018, 06:55:36 PM
    Author     : russel
--%>

<%@page import="Uml.Persona"%>
<%@page import="Modelo.DAOPersona"%>
<%@page import="Uml.ContratoEspecial"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOContratoEspecial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <pre>
           Agregar Administrador de Recursos  | Nivel Administrador Humanidades | <a href="vistaPersona.jsp">Home</a><hr>
        </pre>
        <center>
            <h1>Agregar Administrador de Recursos</h1>
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
                <select name="txttipocontrato">
                     <option value="" selected disabled hidden>tipo Contrato</option>
                    <%
                         DAOContratoEspecial dao = new DAOContratoEspecial();
                         List<ContratoEspecial> datos = new ArrayList();
                         datos = dao.consultar();
                         for(ContratoEspecial p : datos){
                    %>
                    <option><%= p.getNombre()%></option>
                        <%
                          }          
                        %>
                </select><br>
                <input type="submit" name="btninsertarAdminRecursos" value="Insertar"/>
                <br>
            </form>
        </center>
                
                
        <!-- mostrando lo que se agrego de AdminRecursos-->
        <center>
            <table border="1">
            <thead>
                <tr>
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>FechaInicioContrato</th>
                    <th>FechaNacimiento</th>
                    <th>Sexo</th>
                    <th>TipoContrato</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //hacer un recorrido sobre el resultado
                    // de la consulta
                    DAOPersona dao1 = new DAOPersona();
                    List<Persona> datos1 = new ArrayList();
                    datos1 = dao1.consultarAdminRecursos();
                    for(Persona p1 : datos1){
                        %>
                        <tr>
                            <td><%= p1.getDniPersona() %>  </td>
                            <td> <%= p1.getNames() %> </td>
                            <td> <%= p1.getEmail() %> </td>
                            <td> <%= p1.getFechaInicioCon() %>  </td>
                            <td> <%= p1.getFechaNacimiento() %>  </td>
                            <td> <%= p1.getSexo() %>  </td>
                            <td> <%= p1.getTipoContrato() %>  </td>
                        </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
        </center>
                
                
                
                
                
                
         <%
            if(request.getAttribute("GoodbtninsertarAdminRec") != null){
                out.print("<script>alert('Se ingreso Correctamente')</script>");
            }
            else if(request.getAttribute("FailbtninsertarAdminRec") != null){
                String erL = (String)request.getAttribute("FailbtninsertarAdminHum");
                //out.print("<script>alert('"+erL+"')</script>");
                out.print("<script>alert('No se Ingreso con exito')</script>");
            }
        %>
                
    </body>
</html>
