<%-- 
    Document   : error
    Created on : May 22, 2019, 7:54:46 AM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error</h1>
        <%= request.getAttribute("ERROR") %>
        <a href="index.jsp">Back to Home</a>
    </body>
</html>
