package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Area implements Serializable{
    private String cod_area;
    private String mon_area;

    public Area() {
    }

    public Area(String cod_area, String mon_area) {
        this.cod_area = cod_area;
        this.mon_area = mon_area;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    public String getMon_area() {
        return mon_area;
    }

    public void setMon_area(String mon_area) {
        this.mon_area = mon_area;
    }
}
