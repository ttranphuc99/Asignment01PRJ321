/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuctt.daos.FoodDAO;
import phuctt.dtos.FoodDTO;

/**
 *
 * @author Thien Phuc
 */
public class SearchController extends HttpServlet {

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
        String url = "error.jsp";
        float minimum = 0, maximum = 0;
        boolean isValid = true;
        try {
            minimum = Float.parseFloat(request.getParameter("txtMinimum"));
        } catch (NumberFormatException e) {
            request.setAttribute("ERROR_MINIMUM", "Price must be a float");
            isValid = false;
        }
        
        try {
            maximum = Float.parseFloat(request.getParameter("txtMaximum"));
        } catch (NumberFormatException e) {
            request.setAttribute("ERROR_MAXIMUM", "Price must be a float");
            isValid = false;
        }
        
        if (!isValid) {
            url = "search.jsp";
        } else {
            if (minimum > maximum) {
                float t = maximum;
                maximum = minimum;
                minimum = t;
            }
            
            FoodDAO dao = new FoodDAO();
            try {
                List<FoodDTO> result = dao.findByPriceInRange(minimum, maximum);
                request.setAttribute("RESULT", result);
                url = "search.jsp";
            } catch (SQLException | ClassNotFoundException e) {
                request.setAttribute("ERROR", "Error while connecting with database");
            }
        }
        
        request.getRequestDispatcher(url).forward(request, response);
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
