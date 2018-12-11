package Controlador;

import Modelo.DAOPersona;
import Modelo.TestReferencia;
import Modelo.error;
import Uml.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SERVERPersona extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             DAOPersona dao = new DAOPersona();
            Persona p = new Persona();
            List<Persona> datos = new ArrayList();
            String respuesta = null;
            RequestDispatcher rd = null;
            boolean flag = true;
            try {
                if (request.getParameter("btninsertar") != null) {
                  p.setDniPersona(request.getParameter("txtdnipersona"));
                  p.setNames(request.getParameter("txtname"));
                  p.setApellido1(request.getParameter("txtapellido1"));
                  p.setApellido2(request.getParameter("txtapellido2"));
                  p.setEmail(request.getParameter("txtemail"));
                  p.setTelefono(request.getParameter("txttelefono"));
                  Date date1 = (Date) new SimpleDateFormat("dd/MM/YYYY").parse(request.getParameter("txtfechaInicioC"));
                  p.setFechaInicioCon(date1);
                  Date date2 = (Date) new SimpleDateFormat("dd/MM/YYYY").parse(request.getParameter("txtfechaNacimiento"));
                  p.setFechaInicioCon(date2);
                  p.setDireccion(request.getParameter("txtdireccion"));
                  p.setSexo(request.getParameter("txtsexo"));
                  p.setIdTienda(Integer.parseInt(request.getParameter("txtidtienda")));
                  respuesta = dao.insertar(p);
                  request.setAttribute("respuesta", respuesta);
                  rd = request.getRequestDispatcher("vistaPersona.jsp");
                  rd.forward(request, response);
                }
                else if (request.getParameter("btnRegister") != null) {
                  p.setDniPersona(request.getParameter("txtdni"));
                  p.setNames(request.getParameter("txtnames"));
                  p.setApellido1(request.getParameter("txtfirstA"));
                  p.setApellido2(request.getParameter("txtsecondA"));
                  p.setEmail(request.getParameter("txtemail"));
                  p.setPassword(request.getParameter("txtpass"));
                  p.setSexo(request.getParameter("txtsexo"));
                  respuesta = dao.register(p);
                  request.setAttribute("respuesta", respuesta);
                  rd = request.getRequestDispatcher("registerPersona.jsp");
                  out.println("<h1>Persona register bien!!  </h1>");
                  rd.forward(request, response);

                }
                else if (request.getParameter("btnIniciarSesion") != null) {
                  String email = request.getParameter("txtemailuser");
                  String pass = request.getParameter("txtpass");
                  TestReferencia tipoadmin = new TestReferencia();
                  flag = dao.Autentificacion(email, pass, tipoadmin);
                  if (flag){
                    request.setAttribute("emailO", email);
                    request.setAttribute("tipoAdminO", tipoadmin.Valor);
                    System.out.println("flag verdadero Verdadero");
                    System.out.println(email);
                    System.out.println(tipoadmin.Valor);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                  } else {
                    request.setAttribute("Fail", "No hay Acceso");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    System.out.println("flag falso");
                  }

                } else if( request.getParameter("btninsertarAdminHum") != null){
                    try {
                        Persona p1 = new Persona();
                        String dni = request.getParameter("txtdnipersona");
                        String name = request.getParameter("txtname");
                        String apell1 = request.getParameter("txtapellido1");
                        String apell2 = request.getParameter("txtapellido2");
                        String email = request.getParameter("txtemail");
                        String telefono = request.getParameter("txttelefono");
                        java.sql.Date dateFechaInicioContrato = new java.sql.Date(System.currentTimeMillis());
                       
                        String fechaN = request.getParameter("txtfechaNacimiento");
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
                        java.util.Date date = sdf1.parse(fechaN);
                        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 

                        String direccion = request.getParameter("txtdireccion");
                        String sexo = request.getParameter("txtsexo");
                        String idTienda = request.getParameter("txtidtienda");
                        String tipoC = request.getParameter("txttipocontrato");

                        p.setDniPersona(dni);
                        p.setNames(name);
                        p.setApellido1(apell1);
                        p.setApellido2(apell2);
                        p.setEmail(email);
                        p.setTelefono(telefono);
                        p.setFechaInicioCon(dateFechaInicioContrato);
                        p.setFechaNacimiento(sqlStartDate);
                        p.setDireccion(direccion);
                        p.setSexo(sexo);
                        p.setIdTienda(Integer.parseInt(idTienda));
                        //error eR = new error();
                        if(dao.insertarAdminHumanidades(p, tipoC)){
                            request.setAttribute("GoodbtninsertarAdminHum", "Good");
                            request.getRequestDispatcher("AAdminHum.jsp").forward(request, response);
                        }
                        else{
                             //SQLException errort = eR.r;
                             //String valueE = errort;
                             request.setAttribute("FailbtninsertarAdminHum", "fail");
                             request.getRequestDispatcher("AAdminHum.jsp").forward(request, response);
                        }
                    } catch (IOException | ClassNotFoundException | NumberFormatException | SQLException | ParseException | ServletException e) {
                        
                        System.out.println("ERROR  btninsertarAdminHum EN");
                        System.out.println(e);
                    }
                }else if(request.getParameter("btninsertarAdminRecursos") != null){
                    try {
                        Persona p1 = new Persona();
                        String dni = request.getParameter("txtdnipersona");
                        String name = request.getParameter("txtname");
                        String apell1 = request.getParameter("txtapellido1");
                        String apell2 = request.getParameter("txtapellido2");
                        String email = request.getParameter("txtemail");
                        String telefono = request.getParameter("txttelefono");
                        java.sql.Date dateFechaInicioContrato = new java.sql.Date(System.currentTimeMillis());
                       
                        String fechaN = request.getParameter("txtfechaNacimiento");
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
                        java.util.Date date = sdf1.parse(fechaN);
                        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 

                        String direccion = request.getParameter("txtdireccion");
                        String sexo = request.getParameter("txtsexo");
                        String idTienda = request.getParameter("txtidtienda");
                        String tipoC = request.getParameter("txttipocontrato");

                        p.setDniPersona(dni);
                        p.setNames(name);
                        p.setApellido1(apell1);
                        p.setApellido2(apell2);
                        p.setEmail(email);
                        p.setTelefono(telefono);
                        p.setFechaInicioCon(dateFechaInicioContrato);
                        p.setFechaNacimiento(sqlStartDate);
                        p.setDireccion(direccion);
                        p.setSexo(sexo);
                        p.setIdTienda(Integer.parseInt(idTienda));
                        //error eR = new error();
                        if(dao.insertarAdminRecursos(p, tipoC)){
                            request.setAttribute("GoodbtninsertarAdminRec", "Good");
                            request.getRequestDispatcher("AAdminRecursos.jsp").forward(request, response);
                        }
                        else{
                             //SQLException errort = eR.r;
                             //String valueE = errort;
                             request.setAttribute("FailbtninsertarAdminRec", "fail");
                             request.getRequestDispatcher("AAdminRecursos.jsp").forward(request, response);
                        }
                        
                    } catch (IOException | ClassNotFoundException | NumberFormatException | SQLException | ParseException | ServletException e) {
                        System.out.println("ERROR  btninsertarRecu EN");
                        System.out.println(e); // aqui te bota el error en especifico
                        request.getRequestDispatcher("AAdminRecursos.jsp").forward(request, response);
                         out.print("<script>alert('No se Ingreso con exito')</script>");
                    }
                
                }else if(request.getParameter("btninsertarPersonal") != null){
                    try {
                        Persona p1 = new Persona();
                        String dni = request.getParameter("txtdnipersona");
                        String name = request.getParameter("txtname");
                        String apell1 = request.getParameter("txtapellido1");
                        String apell2 = request.getParameter("txtapellido2");
                        String email = request.getParameter("txtemail");
                        String telefono = request.getParameter("txttelefono");
                        java.sql.Date dateFechaInicioContrato = new java.sql.Date(System.currentTimeMillis());
                       
                        String fechaN = request.getParameter("txtfechaNacimiento");
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
                        java.util.Date date = sdf1.parse(fechaN);
                        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 

                        String direccion = request.getParameter("txtdireccion");
                        String sexo = request.getParameter("txtsexo");
                        String idTienda = request.getParameter("txtidtienda");
                        int idSis = Integer.parseInt(request.getParameter("txtsistemap"));
                        
                        p.setDniPersona(dni);
                        p.setNames(name);
                        p.setApellido1(apell1);
                        p.setApellido2(apell2);
                        p.setEmail(email);
                        p.setTelefono(telefono);
                        p.setFechaInicioCon(dateFechaInicioContrato);
                        p.setFechaNacimiento(sqlStartDate);
                        p.setDireccion(direccion);
                        p.setSexo(sexo);
                        p.setIdTienda(Integer.parseInt(idTienda));
                        if( dao.insertarPersonal(p, idSis)){
                            request.setAttribute("GoodbtninsertPersonal", "Good");
                            request.getRequestDispatcher("AAPersonal.jsp").forward(request, response);
                        }
                        else{
                             //SQLException errort = eR.r;
                             //String valueE = errort;
                             request.setAttribute("FailbtninsertPersonal", "fail");
                             request.getRequestDispatcher("AAPersonal.jsp").forward(request, response);
                        }
                        
                    } catch (Exception e) {
                        System.out.println("ERROR ENCONTRADO EN btninsertarPersonal");
                        System.out.println(e);
                    }
                }
                
                
                //other else if (...)
            }
            catch (NumberFormatException|ParseException e)
            {
              System.out.println("error en algo");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SERVERPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SERVERPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
