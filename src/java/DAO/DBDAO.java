/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hernanBeiza
 */
public class DBDAO {
    
    //usuario de la db
    private String usuario = "root";
    //contraseña de la db
    private String password = "j5U1Hcui";        
           
    private Connection miConexion;    

    /***
     * Conectar con la DB
     * @return true si se conectó correctamente. false en caso contrario
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    protected boolean conectar() throws ClassNotFoundException, SQLException{                
        System.out.println("DBDAO: conectar();");
        // Crear conexión
        miConexion = null;
        boolean estado = false;
        try {
            //Datos de la DB                
            //Conector
            String conector = "com.mysql.jdbc.Driver";
            //Driver JAVA para mysql
            String ruta = "jdbc:mysql://192.168.0.25:3306/webboot";        
            System.out.println("DBDAO:" + ruta);
            //jdbc:postgresql://ip:puerto/nombredb
            //java database connectivity
            //puede ser la dirección IP
            //puerto
            //con / nombre de la base de datos
            //Obtener el nombre de la clase del conector
            //Class.forName(conector);
            //mysql
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //Importar la librería para manejar el driver desde java
            //ruta de la db, usuario y contrasena de la db
            miConexion = DriverManager.getConnection(ruta, usuario, password); 
            //System.out.println("DBDAO: conectar(); OK");
            estado = true;
        } catch (Exception e) {
            System.out.println("DBDAO:");
            System.out.println("exception");
            System.out.println(e);
            estado = false;
        } finally {
            System.out.println("finally");
            //miConexion.close();
            //return true;   
        }
        return estado;        
    }

    public Connection getMiConexion() {
        return miConexion;
    }
       
    public void desconectar(){
        //System.out.println("DBDAO: desconectar();");        
        try {
            //System.out.println("DBDAO: desconectar(); OK");
            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
