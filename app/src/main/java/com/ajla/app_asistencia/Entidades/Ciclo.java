package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Ciclo implements Serializable{

    private String ciclo_anio;
    private String estado;

    public Ciclo() {
    }

    public String getCiclo_anio() {
        return ciclo_anio;
    }

    public void setCiclo_anio(String ciclo_anio) {
        this.ciclo_anio = ciclo_anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciclo(String ciclo_anio, String estado) {
        this.ciclo_anio = ciclo_anio;
        this.estado = estado;
    }
}
