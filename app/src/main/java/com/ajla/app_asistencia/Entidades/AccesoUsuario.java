package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class AccesoUsuario implements Serializable{

    private Character idUsuario;
    private Character idOpcion;

    public AccesoUsuario(Character idUsuario, Character idOpcion) {
        this.idUsuario = idUsuario;
        this.idOpcion = idOpcion;
    }

    public Character getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Character idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Character getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Character idOpcion) {
        this.idOpcion = idOpcion;
    }
}

