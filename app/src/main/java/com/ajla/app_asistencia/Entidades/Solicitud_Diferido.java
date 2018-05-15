package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Solicitud_Diferido implements Serializable{

 private Integer id_solicitud;
 private Character estado;

    public Solicitud_Diferido(Integer id_solicitud, Character estado) {
        this.id_solicitud = id_solicitud;
        this.estado = estado;
    }

    public Integer getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(Integer id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
}
