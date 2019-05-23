<%-- 
    Document   : edit
    Created on : May 23, 2019, 10:09:44 AM
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
        <h1>Update Food</h1>
        <font color="red"><%= (request.getAttribute("ERROR") != null ? request.getAttribute("ERROR") : "")%></font>
        <%
            FoodDTO dto = (FoodDTO) request.getAttribute("DTO");
            if (dto != null) {
        %>
        <form action="MainController" method="POST">
            <input type="text" name="txtMinimum" value="<%= request.getParameter("txtMinimum") %>" hidden="true"/>
            <input type="text" name="txtMaximum" value="<%= request.getParameter("txtMaximum") %>" hidden="true"/>
            
            ID: 
            <input type="text" name="txtFoodID" required="true" value="<%= dto.getFoodID() %>" readonly="true"/> <br/>

            Name: 
            <input type="text" name="txtFoodName" required="true" required="true" value="<%= dto.getFoodName() %>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_NAME") != null) ? request.getAttribute("ERROR_NAME") : "")%></font><br/>

            Price: 
            <input type="text" name="txtPrice" required="true" required="true" value="<%= dto.getPrice() %>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_PRICE") != null) ? request.getAttribute("ERROR_PRICE") : "")%></font><br/>

            Description: 
            <input type="text" name="txtDescription" required="true" value="<%= dto.getDescription() %>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_DES") != null) ? request.getAttribute("ERROR_DES") : "")%></font><br/>

            Type: 
            <input type="text" name="txtType" required="true" value="<%= dto.getType() %>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_TYPE") != null) ? request.getAttribute("ERROR_TYPE") : "")%></font><br/>

            <%
                String status = dto.getStatus();
            %>
            Status: <br/>
            <input type="radio" required="true" name="txtStatus" <%= status.equals("Available") ? "checked" : "" %> value="Available"/>Available<br/>
            <input type="radio" name="txtStatus" <%= status.equals("Unavailable") ? "checked" : "" %> value="Unavailable"/>Unavailable<br/>
            <font color="red"><%= ((request.getAttribute("ERROR_STATUS") != null) ? request.getAttribute("ERROR_STATUS") : "")%></font><br/>

            <input type="submit" name="action" value="Update"/>
        </form>
        <%
            }
        %>
        <a href="index.jsp">Home</a>
    </body>
</html>
