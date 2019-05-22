/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.controllers;

import java.io.IOException;
import java.sql.SQLException;
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
public class InsertController extends HttpServlet {

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

        boolean isValid = true;
        //recieve parameter
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

        if (!isValid) {
            url = "insert.jsp";
        } else {
            //call model
            FoodDTO dto = new FoodDTO(foodID, foodName, description, type, status, price);

            FoodDAO dao = new FoodDAO();
            boolean check;

            //render view
            try {
                check = dao.insert(dto);

                if (check) {
                    url = "index.jsp";
                    request.setAttribute("NOTI", "Insert Food " + foodID + " Succesfully");
                } else {
                    request.setAttribute("ERROR", "Insert Food" + foodID + "Failed");
                }
            } catch (ClassNotFoundException | SQLException e) {
                if (e.getMessage().contains("duplicate")) {
                    url = "insert.jsp";
                    request.setAttribute("ERROR", "ID is existed!");
                } else {
                    request.setAttribute("ERROR", "Error while connect with database");
                }
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
