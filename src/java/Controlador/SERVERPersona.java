package Controlador;

import Modelo.DAOPersona;
import Modelo.TestReferencia;
import Uml.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                  Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("txtfechaInicioC"));
                  p.setFechaInicioCon(date1);
                  Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("txtfechaNacimiento"));
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

                }
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
