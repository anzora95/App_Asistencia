package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Incripcion_Teo implements Serializable {

    private Integer id_insTeo;
    private Character carnet;

    public Incripcion_Teo(Integer id_insTeo, Character carnet) {
        this.id_insTeo = id_insTeo;
        this.carnet = carnet;
    }

    public Character getCarnet() {
        return carnet;
    }

    public void setCarnet(Character carnet) {
        this.carnet = carnet;
    }

    public Integer getId_insTeo() {
        return id_insTeo;
    }

    public void setId_insTeo(Integer id_insTeo) {
        this.id_insTeo = id_insTeo;
    }
}

