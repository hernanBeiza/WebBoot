package Negocio.Controllers;

import DAO.UsuarioDAO;
import Negocio.Models.UsuarioModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hernanBeiza
 */
public class LoginController {

    public LoginController() {
    }
    
    public String validar(String email, String contrasena){
        boolean enviar = true;
        String mensaje = "Te faltó:";
        if(email.isEmpty()){
            enviar = false;
            mensaje+="<br/>Email";
        }
        if(contrasena.isEmpty()){
            enviar = false;
            mensaje+="<br/>Contraseña";
        }
        if(enviar){
            return "OK";
        } else {
            return mensaje;
        }       
    }
    
    public UsuarioModel loguear(String email, String contrasena){  
        // Solucionar esto
        //UsuarioModel modelo = new UsuarioModel(-1, email, contrasena, contrasena, "");        
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioModel resultModel = dao.login(email, contrasena);
        if(resultModel!=null){
            return resultModel;
        } else {
            return null;
        }
    }
    
}
