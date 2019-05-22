<%-- 
    Document   : search
    Created on : May 22, 2019, 7:42:26 AM
    Author     : Thien Phuc
--%>

<%@page import="phuctt.dtos.FoodDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <form action="MainController" method="GET">
            Minimum Price:
            <input type="text" name="txtMinimum" value="<%= (request.getParameter("txtMinimum") != null) ? request.getParameter("txtMinimum") : ""%>"/><br/>
            <font color="red"><%= (request.getAttribute("ERROR_MINIMUM") != null) ? request.getAttribute("ERROR_MINIMUM") : ""%></font><br/>

            Maximum Price:
            <input type="text" name="txtMaximum" value="<%= (request.getParameter("txtMaximum") != null) ? request.getParameter("txtMaximum") : ""%>"/><br/>
            <font color="red"><%= (request.getAttribute("ERROR_MAXIMUM") != null) ? request.getAttribute("ERROR_MAXIMUM") : ""%></font><br/>

            <input type="submit" name="action" value="Search"/>
        </form>
        <a href="index.jsp">Home</a>
        <%! List<FoodDTO> result; %>
        <% 
            result = (List<FoodDTO>) request.getAttribute("RESULT");
            if (result != null) {   
                if (!result.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <th>No.</th>
                <th>FoodID</th>
                <th>FoodName</th>
                <th>Price</th>
                <th>Description</th>
                <th>Type</th>
                <th>Status</th>
                <th colspan="2">Action</th>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (FoodDTO dto : result) { 
                        count++;
                %>
                <tr>
                    <td><%= count %></td>
                    <td><%= dto.getFoodID() %></td>
                    <td><%= dto.getFoodName()%></td>
                    <td><%= dto.getPrice()%></td>
                    <td><%= dto.getDescription()%></td>
                    <td><%= dto.getType()%></td>
                    <td><%= dto.getStatus()%></td>
                    <td>
                        <a href="MainController?action=Edit&foodID=<%= dto.getFoodID() %>">Edit</a>
                    </td>
                    <td>
                        <a href="MainController?action=Delete&foodID=<%= dto.getFoodID() %>">Delete</a>
                    </td>
                </tr>            
                <%
                        }
                %>
            </tbody>
        </table>
        <%
                } else {        
        %>
        <h2>Not found!</h2>
        <%
                }
            }
        %>
    </body>
</html>
