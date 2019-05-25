<%-- 
    Document   : searchID
    Created on : May 25, 2019, 9:22:12 AM
    Author     : Thien Phuc
--%>

<%@page import="phuctt.dtos.FoodDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp">Home</a>
        <form action="MainController" method="POST">
            ID: <input type="text" name="txtSearch" required="true" value="<%= request.getParameter("txtSearch") != null ? request.getParameter("txtSearch") : ""%>"/><br/>
            <input type="submit" value="Search ID" name="action"/>
        </form>
        <%
            FoodDTO dto = (FoodDTO) request.getAttribute("DTO");
            if (dto != null) {
        %>
        <table border="1">
            <thead>
                <th>FoodID</th>
                <th>FoodName</th>
                <th>Price</th>
                <th>Description</th>
                <th>Type</th>
                <th>Status</th>
                <th colspan="2">Action</th>
            </thead>
            <tbody>
                <td><%= dto.getFoodID() %></td>
                <td><%= dto.getFoodName()%></td>
                <td><%= dto.getPrice()%></td>
                <td><%= dto.getDescription()%></td>
                <td><%= dto.getType()%></td>
                <td><%= dto.getStatus()%></td>
                <td>
                    <a href="MainController?action=Edit&txtFoodID=<%= dto.getFoodID()%>">Edit</a>
                </td>
                <td>
                    <a href="MainController?action=Delete&txtFoodID=<%= dto.getFoodID()%>">Delete</a>
                </td>
            </tbody>
        </table>
        <%
            } else if (request.getParameter("txtSearch") != null) {
        %>
        <h2>
            <font color="red">Not found ID</font>
        </h2>
        <%
            }
        %>
    </body>
</html>
