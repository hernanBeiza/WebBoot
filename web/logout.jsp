<%-- 
    Document   : logout
    Created on : Nov 12, 2016, 11:26:59 PM
    Author     : hernanBeiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css"/>        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>        
    </head>
    <body>
        <div class="container">            
            <h1>Adiós!</h1>
            <div class="alert alert-success" role="alert"> 
                <strong>
                <%
                session.invalidate();
                out.println("Sesión cerrada con éxito");
                %> 
                </strong>
            </div>
            <a href="index.html">Iniciar Sesión</a>
        </div>
    </body>
</html>