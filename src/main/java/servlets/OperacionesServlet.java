/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import DAO.DAOProductoImpl;
import DAO.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author darkl
 */
@WebServlet(name = "OperacionesServlet", urlPatterns = {"/operaciones"})
public class OperacionesServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd;
        Gson gson =new Gson();
        try {
            DAOProductoImpl productoDAO = new DAOProductoImpl();
            switch (request.getParameter("ACTION")) {
                case "GET_FORM":
                    rd = request.getRequestDispatcher("/vista/FormProducto.jsp");
                    rd.forward(request, response);
//                    try (PrintWriter out = response.getWriter()) {
//                        out.println("Voy a mostrar el form");
//                    }
                break;
                case "ADD_DATA":
                    Producto producto = (Producto) gson.fromJson(request.getParameter("DATA"),Producto.class);
                    productoDAO.registrar(producto);
                    try (PrintWriter out = response.getWriter()) {
                        out.println("Se guardo el producto");
                    }
                break;
                case "UPDATE_DATA":
                        try (PrintWriter out = response.getWriter()) {
                    out.println("Voy a actualizar un registro");
                }
                break;
                case "DELETE_DATA":
                        try (PrintWriter out = response.getWriter()) {
                    out.println("Voy a borrar un registro");
                }
                break;
                default:
                        try (PrintWriter out = response.getWriter()) {
                    out.println("ERROR: Opción invalida: " + request.getParameter("ACTION"));
                }
                break;
            }
        } catch (Exception e) {
            Logger.getLogger(OperacionesServlet.class.getName()).log(Level.SEVERE, null, e);
            try (PrintWriter out = response.getWriter()) {
                out.println("ERROR: " + e.getMessage());
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
