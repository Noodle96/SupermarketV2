<%-- 
    Document   : AAPersonal
    Created on : 10/12/2018, 10:08:07 PM
    Author     : russel
--%>

<%@page import="Uml.Persona"%>
<%@page import="Modelo.DAOPersona"%>
<%@page import="Uml.SistemaPrevisional"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.DAOSistemaPrevisional"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <pre>
           Agregar Personal  | Nivel Administrador Humanidades | <a href="vistaPersona.jsp">Home</a><hr>
        </pre>
        <center>
            <h1>Agregar Personal</h1>
            <form action="serverpersona.do" method="POST">
                <input type="text" name="txtdnipersona" placeholder="Dni Personal" /><br>
                <input type="text" name="txtname" placeholder="Nombre Personal" /><br>
                <input type="text" name="txtapellido1" placeholder="Apellido 1 Personal" /><br>
                <input type="text" name="txtapellido2" placeholder="Apellido 2 Personal" /><br>
                <input type="email" name="txtemail" placeholder="email" /><br>
                <input type="text" name="txttelefono" placeholder="telefono" /><br>
                <input type="text" name="txtfechaNacimiento" placeholder="dd-mmm-yyyy" /><br>
                <input type="text" name="txtdireccion" placeholder="Direccion" /><br>
                <input type="text" name="txtsexo" placeholder="sexo" /><br>
                <input type="text" name="txtidtienda" placeholder="id Tienda" /><br>
                <select name="txtsistemap">
                     <option value="" selected disabled hidden>tipo Contrato</option>
                    <%
                         DAOSistemaPrevisional daoC = new DAOSistemaPrevisional();
                         List<SistemaPrevisional> datos = new ArrayList();
                         datos = daoC.consultarSistemaPrevisional();
                         for(SistemaPrevisional p : datos){
                    %>
                    <option value=<%=p.getIdSistema()%>  ><%= p.getNameSistema()%></option>
                        <%
                          }          
                        %>
                </select><br>
                <input type="submit" name="btninsertarPersonal" value="Insertar"/>
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
                    <th>Nombre Sistema</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //hacer un recorrido sobre el resultado
                    // de la consulta
                    DAOPersona dao1 = new DAOPersona();
                    List<Persona> datos1 = new ArrayList();
                    datos1 = dao1.consultarPersonal();
                    for(Persona p1 : datos1){
                        %>
                        <tr>
                            <td><%= p1.getDniPersona() %>  </td>
                            <td> <%= p1.getNames() %> </td>
                            <td> <%= p1.getApellido1()%>  </td>
                            <td> <%= p1.getEmail() %> </td>
                            <td> <%= p1.getFechaInicioCon() %>  </td>
                            <td> <%= p1.getFechaNacimiento() %>  </td>
                            <td> <%= p1.getSexo() %>  </td>
                            <td> <%= p1.getNameSistema() %>  </td>
                        </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
        </center>
                 
               
        <%
        if(request.getAttribute("GoodbtninsertPersonal") != null){
            out.print("<script>alert('Se ingreso Correctamente')</script>");
        }
        else if(request.getAttribute("FailbtninsertPersonal") != null){
            //String erL = (String)request.getAttribute("FailbtninsertarAdminHum");
            //out.print("<script>alert('"+erL+"')</script>");
            out.print("<script>alert('No se Ingreso con exito')</script>");
        }
      %>
    </body>
</html>
