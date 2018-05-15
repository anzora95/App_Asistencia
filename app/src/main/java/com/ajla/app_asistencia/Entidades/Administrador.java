package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Administrador implements Serializable{
    private Character usuario;
    private String contraseaña;


    public Administrador(Character usuario, String contraseaña) {
        this.usuario = usuario;
        this.contraseaña = contraseaña;
    }

    public Character getUsuario() {
        return usuario;
    }

    public void setUsuario(Character usuario) {
        this.usuario = usuario;
    }

    public String getContraseaña() {
        return contraseaña;
    }

    public void setContraseaña(String contraseaña) {
        this.contraseaña = contraseaña;
    }
}
