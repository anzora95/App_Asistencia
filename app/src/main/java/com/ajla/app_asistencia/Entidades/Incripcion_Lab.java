package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Incripcion_Lab implements Serializable{
    private Integer id_insLab;
    private String carnet;

    public Incripcion_Lab() {
    }

    public Incripcion_Lab(Integer id_insLab, String carnet) {
        this.id_insLab = id_insLab;
        this.carnet = carnet;
    }

    public Integer getId_insLab() {
        return id_insLab;
    }

    public void setId_insLab(Integer id_insLab) {
        this.id_insLab = id_insLab;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
}
