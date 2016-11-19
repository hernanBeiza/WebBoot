package Negocio.Controllers;

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
        String mensaje = "";
        if(email.isEmpty()){
            enviar = false;
            mensaje+="\nEmail";
        }
        if(contrasena.isEmpty()){
            enviar = false;
            mensaje+="\nContraseña";
        }
        if(enviar){
            return "OK";
        } else {
            return mensaje;
        }       
    }
    
    public boolean loguear(String email, String contrasena){  
        boolean resultado = true;
        if(!email.equals("hernan@hiperactivo.cl")){
            resultado = false;
        }
        if(!contrasena.equals("9040207")){
            resultado = false;
        }
        return resultado;
    }
}
