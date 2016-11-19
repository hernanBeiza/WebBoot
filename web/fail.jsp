<%-- 
    Document   : fail
    Created on : Nov 12, 2016, 10:15:07 AM
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
            <h1>Fail!</h1>
            <div class="alert alert-danger" role="alert"> 
                <strong>
                <%
                //String data2 = (String)session.getAttribute("session=usuario");
                //out.println("Usuario /Clave "+ data2 +" erroneos. Por favor intentar nuevamente ");    
                String mensajes = (String)session.getAttribute("session=mensajes");
                out.println(mensajes);
                %> 
                </strong>
            </div>
                <a href="index.html">Volver</a>
        </div>
    </body>
</html>
