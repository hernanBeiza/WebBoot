<%-- 
    Document   : registro
    Created on : Nov 19, 2016, 10:03:39 AM
    Author     : hernanBeiza
--%>

<%@page import="Negocio.Controllers.RegistroController"%>
<%@page import="Negocio.Models.UsuarioModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page contentType="application/json"%>--%>

<!DOCTYPE html>
<%
    System.out.print("------>registro.jsp");
    //response.setContentType("application/json");            
    String email = request.getParameter("email");
    String contrasena = request.getParameter("contrasena"); 
    String contrasenaConfirmar = request.getParameter("contrasenaConfirmar"); 
    String nombre = request.getParameter("nombre"); 
    RegistroController controller = new RegistroController();
    String resultado = controller.validar(email, contrasena,contrasenaConfirmar,nombre);
    System.out.print(resultado);
    if(resultado.equals("OK")){        
        UsuarioModel usuario = controller.registrar(email, contrasena,nombre);
        if(usuario!=null){
            System.out.print("No es nulo");
            session.setAttribute("session=idusuario", usuario.getIdusuario());
            //response.setContentType("application/json");
            response.sendRedirect("../dashboardForm.jsp");                                                     
        } else {
            System.out.print("Es nulo");
            session.setAttribute("session=mensajes", "Este usuario no existe");
            response.sendRedirect("../registroForm.jsp");                    
        }                     
    } else {
        session.setAttribute("session=mensajes", resultado);
        response.sendRedirect("../registroForm.jsp");                    
    }
%>