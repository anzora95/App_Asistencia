package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Jefe_Departamento implements Serializable{

    private String perido;
    private String cod_area;
    private String isss;
    private String contra_jefe;

    public Jefe_Departamento(String perido, String cod_area, String isss, String contra_jefe) {
        this.perido = perido;
        this.cod_area = cod_area;
        this.isss = isss;
        this.contra_jefe = contra_jefe;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    public String getContra_jefe() {
        return contra_jefe;
    }

    public void setContra_jefe(String contra_jefe) {
        this.contra_jefe = contra_jefe;
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
    }
}
