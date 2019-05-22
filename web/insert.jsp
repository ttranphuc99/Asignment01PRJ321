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
        <form action="MainController" method="POST">
            ID: <input type="text" name="txtFoodID" required="true"/> <br/>
            Name: <input type="text" name="txtFoodName" required="true"/> <br/>
            Price: <input type="text" name="txtPrice" required="true"/> <br/>
            Description: <input type="text" name="txtDescription" required="true"/> <br/>
            Type: <input type="text" name="txtType" required="true"/> <br/>
            Status: <br/>
            <input type="radio" name="txtStatus" value="Available"/>Available<br/>
            <input type="radio" name="txtStatus" value="Unavailable"/>Unavailable<br/>
            
            <input type="submit" name="action" value="Insert"/>
        </form>
    </body>
</html>
