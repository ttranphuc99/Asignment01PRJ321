<%-- 
    Document   : insert
    Created on : May 22, 2019, 7:42:16 AM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <h1>Insert New Food</h1>
        <font color="red"><%= (request.getAttribute("ERROR") != null ? request.getAttribute("ERROR") : "")%></font>
        <form action="MainController" method="POST">
            ID: 
            <input type="text" name="txtFoodID" required="true" value="<%= request.getParameter("txtFoodID") != null ? request.getParameter("txtFoodID") : ""%>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_ID") != null) ? request.getAttribute("ERROR_ID") : "")%></font><br/>

            Name: 
            <input type="text" name="txtFoodName" required="true" value="<%= request.getParameter("txtFoodName") != null ? request.getParameter("txtFoodName") : ""%>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_NAME") != null) ? request.getAttribute("ERROR_NAME") : "")%></font><br/>

            Price: 
            <input type="text" name="txtPrice" required="true" value="<%= request.getParameter("txtPrice") != null ? request.getParameter("txtPrice") : ""%>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_PRICE") != null) ? request.getAttribute("ERROR_PRICE") : "")%></font><br/>

            Description: 
            <input type="text" name="txtDescription" required="true" value="<%= request.getParameter("txtDescription") != null ? request.getParameter("txtDescription") : ""%>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_DES") != null) ? request.getAttribute("ERROR_DES") : "")%></font><br/>

            Type: 
            <input type="text" name="txtType" required="true" value="<%= request.getParameter("txtType") != null ? request.getParameter("txtType") : ""%>"/> <br/>
            <font color="red"><%= ((request.getAttribute("ERROR_TYPE") != null) ? request.getAttribute("ERROR_TYPE") : "")%></font><br/>

            Status: <br/>
            <input type="radio" name="txtStatus" value="Available"/>Available<br/>
            <input type="radio" name="txtStatus" value="Unavailable"/>Unavailable<br/>
            <font color="red"><%= ((request.getAttribute("ERROR_STATUS") != null) ? request.getAttribute("ERROR_STATUS") : "")%></font><br/>

            <input type="submit" name="action" value="Insert"/>
        </form>
        <a href="index.jsp">Home</a>
    </body>
</html>
