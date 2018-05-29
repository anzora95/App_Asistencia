package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Ciclo implements Serializable{

    private Integer ciclo_anio;
    private String estado;

    public Ciclo() {
    }

    public Integer getCiclo_anio() {
        return ciclo_anio;
    }

    public void setCiclo_anio(Integer ciclo_anio) {
        this.ciclo_anio = ciclo_anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciclo(Integer ciclo_anio, String estado) {
        this.ciclo_anio = ciclo_anio;
        this.estado = estado;
    }
}
