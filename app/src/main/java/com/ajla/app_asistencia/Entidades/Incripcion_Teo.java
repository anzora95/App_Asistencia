package com.ajla.app_asistencia.Entidades;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Incripcion_Teo {
    private Integer id_insTeo;
    private String carnet;

    public Incripcion_Teo() {
    }

    public Incripcion_Teo(Integer id_insTeo, String carnet) {
        this.id_insTeo = id_insTeo;
        this.carnet = carnet;
    }

    public Integer getId_insTeo() {
        return id_insTeo;
    }

    public void setId_insTeo(Integer id_insTeo) {
        this.id_insTeo = id_insTeo;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
}
