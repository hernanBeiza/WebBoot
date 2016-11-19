<%-- 
    Document   : validar.jsp
    Created on : Nov 12, 2016, 10:08:57 AM
    Author     : hernanBeiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.Controllers.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena"); 
            /*
            String mensajes = "";
            if (email.equals("hernan@hiperactivo.cl") && contrasena.equals("9040207")){
                response.sendRedirect("dashboard.html");                 
            }else{
                mensajes="Datos inválidos";
            }    
            */
            LoginController controller = new LoginController();
            String resultado = controller.validar(email, contrasena);
            if(resultado.equals("OK")){
                boolean resultado2 = controller.loguear(email, contrasena);
                if(resultado2){
                    session.setAttribute("session=uid", email);
                    response.sendRedirect("dashboard.html");                                                     
                } else {
                    session.setAttribute("session=mensajes", "datos inválidos");
                    response.sendRedirect("fail.jsp");                    
                }                     
            } else {
                session.setAttribute("session=mensajes", resultado);
                response.sendRedirect("fail.jsp");
            }
        %>
    </body>
</html>
