/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Negocio.Models.UsuarioModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hernanBeiza
 */
public class UsuarioDAO extends DBDAO {

    public UsuarioDAO() {
    }
 
    public UsuarioModel login(String emailUsuario, String contrasenaUsuario){        
        UsuarioModel modeloResult = null;
        try {
            if(this.conectar()){
                System.out.println("LoginDAO: Conectado");
                //System.out.println("UsuarioDAO: Conectado");                
                Statement querySQL = getMiConexion().createStatement();
                String queryString = "SELECT * FROM usuario WHERE email='"+emailUsuario+"' AND contrasena ='" +contrasenaUsuario+"'";
                System.out.println(queryString);
                //querySQL.execute(queryString);   
                ResultSet rs = querySQL.executeQuery(queryString);
                if ( rs.next() ) {
                    int idusuario = rs.getInt(1);
                    String email = rs.getString("email");
                    String contrasena = rs.getString("contrasena");
                    String nombre = rs.getString("nombre");
                    System.out.println("idusuario: " + idusuario);
                    System.out.println("email: " + email);
                    System.out.println("contrasena: " + contrasena);
                    System.out.println("nombre: " + nombre);                    
                    UsuarioModel usuarioObtenido = new UsuarioModel(idusuario, email, contrasena, contrasena, nombre);
                    return usuarioObtenido;
                }
                this.desconectar();
            } else {
                System.out.println("LoginDAO: Error al conectar");
                return null;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }                
        return modeloResult;
    }
    
        public UsuarioModel registrar(String email,String contrasena,String nombre){
            //System.out.println("NotaDAO: registrar();");
            try {
                if(this.conectar()){
                    System.out.println("UsuarioDAO: Conectado");        
                    //REvisar que no haya un usuario con el mismo email registrado antes...
                    Statement queryStatement = getMiConexion().createStatement();
                    String queryString = "INSERT INTO usuario (nombre,email,contrasena) VALUES ('"+nombre+"','"+email+"','"+contrasena+"')";
                    System.out.println(queryString);
                    //querySQL.execute(queryString);   
                    queryStatement.execute(queryString,Statement.RETURN_GENERATED_KEYS);   
                    ResultSet rs = queryStatement.getGeneratedKeys();
                    if ( rs.next() ) {
                        // Retrieve the auto generated key(s).
                        int idusuario = rs.getInt(1);
                        //System.out.println("idusuario: " + idusuario);
                        UsuarioModel usuario = login(email, contrasena);
                        return usuario;
                    }

                    //System.out.println("NotaDAO: guardar(); Nota insertada correctamente en la DB");   
                    this.desconectar();
                } else {
                    //System.out.println("NotaDao: guardar(); Error al conectar");
                    return null;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;        
    }

}