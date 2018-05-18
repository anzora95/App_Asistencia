package com.ajla.app_asistencia.Entidades;


import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Lugar implements Serializable{
    private String cod_Lugar;
    private Integer capacidad;
    private String tipo;

    public Lugar() {
    }

    public Lugar(String cod_Lugar, Integer capacidad, String tipo) {
        this.cod_Lugar = cod_Lugar;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public String getCod_Lugar() {
        return cod_Lugar;
    }

    public void setCod_Lugar(String cod_Lugar) {
        this.cod_Lugar = cod_Lugar;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
