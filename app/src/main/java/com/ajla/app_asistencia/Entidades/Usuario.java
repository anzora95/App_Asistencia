package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Usuario implements Serializable {

    private Character idUsuario;
    private String nomUsuario;
    private  Character clave;

    public Usuario(Character idUsuario, String nomUsuario, Character clave) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.clave = clave;
    }

    public Character getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Character idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Character getClave() {
        return clave;
    }

    public void setClave(Character clave) {
        this.clave = clave;
    }
}
