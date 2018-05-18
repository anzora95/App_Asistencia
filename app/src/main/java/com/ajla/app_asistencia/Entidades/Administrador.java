package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Administrador implements Serializable{
    private String usuario;
    private String contraseaña;



    public Administrador(String usuario, String contraseaña) {
        this.usuario = usuario;
        this.contraseaña = contraseaña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseaña() {
        return contraseaña;
    }

    public void setContraseaña(String contraseaña) {
        this.contraseaña = contraseaña;
    }
}
