/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAOProveedor;
import Uml.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author russel
 */
public class SERVERProveedor extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           if(request.getParameter("btninsertarProveedor") != null ){
               try {
                   DAOProveedor daoPr = new DAOProveedor();
                   Proveedor pr1 = new Proveedor();
                   pr1.setNameProveedor(request.getParameter("txtnameP"));
                   pr1.setPaisP(request.getParameter("txtpais"));
                   pr1.setDepartamentoP(request.getParameter("txtdepartamento"));
                   pr1.setProvinciaP(request.getParameter("txtprovinvia"));
                   pr1.setDireccionP(request.getParameter("txtdireccion"));
                   pr1.setHomepageP(request.getParameter("txthomepage"));
                   pr1.setTelefonoP(request.getParameter("txttelefono"));
                   pr1.setPersonaContacto(request.getParameter("txtpersonacontacto"));
                   if(daoPr.insertarProveedor(pr1)){
                        request.setAttribute("GoodbtninsertarProveedor", "Good");
                        request.getRequestDispatcher("AAProveedores.jsp").forward(request, response);
                   }else{
                        request.setAttribute("FailbtninsertarProveedor", "fail");
                        request.getRequestDispatcher("AAProveedores.jsp").forward(request, response);
                   }
               } catch (Exception e) {
                   System.out.println("ERROR ENCONTRADO EN btninsertarProveedor: ");
                   System.out.println(e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
