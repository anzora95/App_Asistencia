package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class OpcionCrud implements Serializable{
    private Character idOpcion;
    private String desOpcion;
    private Integer numCrud;

    public OpcionCrud(Character idOpcion, String desOpcion, Integer numCrud) {
        this.idOpcion = idOpcion;
        this.desOpcion = desOpcion;
        this.numCrud = numCrud;
    }

    public Character getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Character idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDesOpcion() {
        return desOpcion;
    }

    public void setDesOpcion(String desOpcion) {
        this.desOpcion = desOpcion;
    }

    public Integer getNumCrud() {
        return numCrud;
    }

    public void setNumCrud(Integer numCrud) {
        this.numCrud = numCrud;
    }
}
