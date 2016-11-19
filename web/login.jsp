<%-- 
    Document   : login.jsp
    Created on : Nov 19, 2016, 8:42:15 AM
    Author     : hernanBeiza
--%>

<%@page import="Negocio.Controllers.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String email = request.getParameter("email");
    String contrasena = request.getParameter("contrasena"); 
    LoginController controller = new LoginController();
    String resultado = controller.validar(email, contrasena);
    if(resultado.equals("OK")){
        boolean resultado2 = controller.loguear(email, contrasena);
        // COnectar con la respuesta de la db
        String idusuario = "1234";
        if(resultado2){
            session.setAttribute("session=idusuario", idusuario);
            response.sendRedirect("dashboard.html");                                                     
        } else {
            session.setAttribute("session=mensajes", "Datos no válidos");
            response.sendRedirect("index.html");                    
        }                     
    } else {
        session.setAttribute("session=mensajes", resultado);
    }
%>