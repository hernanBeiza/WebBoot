/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Controllers;

import DAO.UsuarioDAO;
import Negocio.Models.UsuarioModel;

/**
 *
 * @author hernanBeiza
 */
public class RegistroController {

    public RegistroController() {
        
    }
    
    public String validar(String email, String contrasena, String contrasenaConfirmar,String nombre){
        boolean enviar = true;
        String mensaje = "Te faltó:<br/>";
        if(email.isEmpty()){
            enviar = false;
            mensaje+="Email<br/>";
        }
        if(contrasena.isEmpty()){
            enviar = false;
            mensaje+="Contraseña<br/>";
        }
        if(contrasenaConfirmar.isEmpty()){
            enviar = false;
            mensaje+="Contraseña para confirmar<br/>";
        }
        if(!contrasena.equals(contrasenaConfirmar)){
            enviar = false;
            mensaje+="Las contraseñas no son iguales<br/>";
        }
        if(nombre.isEmpty()){
            enviar = false;
            mensaje+="Nombre<br/>";
        }
        if(enviar){
            return "OK";
        } else {
            return mensaje;
        }       
    }

    
    public UsuarioModel registrar(String email, String contrasena, String nombre){
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioModel resultModel = dao.registrar(email, contrasena,nombre);
        if(resultModel!=null){
            return resultModel;
        } else {
            return null;
        }
    }

}
