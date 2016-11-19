<%-- 
    Document   : registro
    Created on : Nov 19, 2016, 10:01:05 AM
    Author     : hernanBeiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebBoot</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css"/>        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>        
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Jumbotron!</h1>
                <p>That's me motherfucker, I am finally on!</p>
            </div>
            <div class="row">
                <%
                    String mensajes = (String)session.getAttribute("session=mensajes");
                    if(mensajes!=null){
                        out.println("<div class='alert alert-danger' role='alert'>"+mensajes+"</div>");
                    }
                %> 
                <div class="col-md-4 col-md-offset-4">
                    <h2 class="text-center form-heading">Registro</h2>
                    <form action="jsp/registro.jsp">
                        <div class="form-group">
                            <input type="email" placeholder="Email" name="email" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Contraseña" name="contrasena" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Confirma Contraseña" name="contrasenaConfirmar" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input type="text" placeholder="Nombre" name="nombre" class="form-control" />
                        </div>
                        <button class="btn btn-primary btn-block submit-button" type="submit">Registrarme</button>
                        <a href="index.jsp" class="forgot">¿Ya tienes una cuenta? ¡Inicia sesión aquí!</a>
                    </form>
                </div>
            </div>
        </div>               
    </body>
</html>
