<%-- 
    Document   : login.jsp
    Created on : Nov 19, 2016, 8:42:15 AM
    Author     : hernanBeiza
--%>

<%@page import="Negocio.Controllers.LoginController"%>
<%@page import="Negocio.Models.UsuarioModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    System.out.print("------>login.jsp");
    System.out.print(request);

    String email = request.getParameter("email");
    System.out.print("login.jsp: email:" + email);
    String contrasena = request.getParameter("contrasena"); 
    System.out.print("login.jsp: contrasena:" + contrasena);
    
    LoginController controller = new LoginController();
    String resultado = controller.validar(email, contrasena);
    System.out.print("resultado: "+resultado);
    if(resultado.equals("OK")){        
        UsuarioModel usuario = controller.loguear(email, contrasena);
        if(usuario!=null){
            session.setAttribute("session=idusuario", usuario.getIdusuario());
            response.sendRedirect("../dashboardForm.jsp");                                                     
        } else {
            session.setAttribute("session=mensajes", "Este usuario no existe");
            response.sendRedirect("../index.jsp");                    
        }                     
    } else {
        session.setAttribute("session=mensajes", resultado);
        response.sendRedirect("../index.jsp");                    
    }
%>