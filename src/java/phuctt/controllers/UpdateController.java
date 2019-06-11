/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.controllers;

import java.io.IOException;
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
public class UpdateController extends HttpServlet {

    private static final String UPDATE = "edit.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String SUCCESS_ID = "index.jsp";
    private static final String ERROR = "error.jsp";

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
        String url = UPDATE;
        boolean isValid = true;

        String foodID = request.getParameter("txtFoodID");
        String foodName = request.getParameter("txtFoodName");
        float price = 0;
        try {
            price = Float.parseFloat(request.getParameter("txtPrice"));
        } catch (NumberFormatException e) {
            request.setAttribute("ERROR_PRICE", "Price must be in float");
            isValid = false;
        }
        String description = request.getParameter("txtDescription");
        String type = request.getParameter("txtType");
        String status = request.getParameter("txtStatus");
        if (status == null) {
            request.setAttribute("ERROR_STATUS", "Status cannot be empty");
            isValid = false;
        }
        
        FoodDTO dto = new FoodDTO(foodID, foodName, description, type, status, price);

        if (!isValid) {
            url = UPDATE;
            request.setAttribute("DTO", dto);
        } else {
            try {
                FoodDAO dao = new FoodDAO();
                boolean check = dao.update(dto);
                
                if (check) {
                    request.setAttribute("NOTI", "Update Food ID: " + foodID + " Successfully!");
                    
                    String minimum = request.getParameter("txtMinimum");
                    
                    if (!minimum.equals("null")) {
                        url = SUCCESS;
                    } else {
                        url = SUCCESS_ID;
                    }
                } else {
                    url = ERROR;
                    request.setAttribute("ERROR", "Update Food ID: " + foodID + " Failed!");
                }
            } catch (Exception e) {
                e.printStackTrace();
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
