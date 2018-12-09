package Controlador;

import Modelo.DAOUsuario;
import Modelo.TestReferencia;
import Uml.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author russel
 */
public class SERVERUsuario extends HttpServlet {

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
            throws ServletException, IOException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             DAOUsuario dao = new DAOUsuario();
            Usuario u = new Usuario();
            String respuesta = null;
            RequestDispatcher rd = null;
            if (request.getParameter("btnRegister") != null) {
                try {
                    u.setName(request.getParameter("txtname"));
                u.setLastName(request.getParameter("txtlastname"));

                String startDate= request.getParameter("txtfechaNac");
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
                java.util.Date date = sdf1.parse(startDate);
                java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
                System.out.println(sqlStartDate);
                u.setFechaNacimiento(sqlStartDate);

                u.setEmail(request.getParameter("txtemail"));
                u.setPassword(request.getParameter("txtpassword"));

                Date date2 = new Date(System.currentTimeMillis());
                u.setCreated_at(date2);
                u.setLastSesion(date2);
                u.setSexo(request.getParameter("txtsexo"));
                u.setDireccion(request.getParameter("txtdireccion"));

                respuesta = dao.register(u);
                request.setAttribute("respuesta", respuesta);
                rd = request.getRequestDispatcher("registerUser.jsp");
                rd.forward(request, response);
                    System.out.println(respuesta);
                System.out.println("Registro de usuarios correctamente");
                } catch (IOException | ParseException | ServletException e) {
                    System.out.println("Error detectado en ");
                    System.out.println(e);
                    request.getRequestDispatcher("registerUser.jsp").forward(request, response);
                    out.print("<script>alert('"+e+"')</script>");

                }
            }else if(request.getParameter("btnIniciarSesionUser")!= null ){
                 String email = request.getParameter("txtemailuser");
                 String pass = request.getParameter("txtpass");
                 boolean  flag = dao.AutentificacionUsuario(email, pass);
                 if (flag){
                  request.setAttribute("emailU", email);
                  System.out.println(email);
                  request.getRequestDispatcher("loginuser.jsp").forward(request, response);
                } else {
                  request.setAttribute("Fail", "No hay Acceso 1, registrese!!!");
                  request.getRequestDispatcher("loginuser.jsp").forward(request, response);
                }
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
        } catch (ParseException ex) {
            Logger.getLogger(SERVERUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SERVERUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(SERVERUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SERVERUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
