<%-- 
    Document   : index
    Created on : May 22, 2019, 7:29:38 AM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello User!</h1>
        <%= (request.getAttribute("NOTI") != null ? request.getAttribute("NOTI") : "") %> <br/>
        
        <a href="insert.jsp">Insert New Food</a><br/>
        <a href="search.jsp">Search Food</a><br/>
    </body>
</html>
