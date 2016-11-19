/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Models;

/**
 *
 * @author hernanBeiza
 */
public class UsuarioModel {
    
    private int idusuario;
    private String email;
    private String contrasena;
    private String contrasenaConfirmar;
    private String nombre;

    public UsuarioModel(int idusuario, String email, String contrasena, String contrasenaConfirmar, String nombre) {
        this.idusuario = idusuario;
        this.email = email;
        this.contrasena = contrasena;
        this.contrasenaConfirmar = contrasenaConfirmar;
        this.nombre = nombre;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasenaConfirmar() {
        return contrasenaConfirmar;
    }

    public void setContrasenaConfirmar(String contrasenaConfirmar) {
        this.contrasenaConfirmar = contrasenaConfirmar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" + "idusuario=" + idusuario + ", email=" + email + ", contrasena=" + contrasena + ", contrasenaConfirmar=" + contrasenaConfirmar + ", nombre=" + nombre + '}';
    }
    
}
