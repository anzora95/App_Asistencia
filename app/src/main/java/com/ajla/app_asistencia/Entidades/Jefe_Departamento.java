package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Jefe_Departamento implements Serializable{

    private Character perido;
    private Character cod_area;
    private Character isss;
    private Character contra_jefe;

    public Jefe_Departamento(Character perido, Character cod_area, Character isss, Character contra_jefe) {
        this.perido = perido;
        this.cod_area = cod_area;
        this.isss = isss;
        this.contra_jefe = contra_jefe;
    }

    public Character getCod_area() {
        return cod_area;
    }

    public void setCod_area(Character cod_area) {
        this.cod_area = cod_area;
    }

    public Character getIsss() {
        return isss;
    }

    public void setIsss(Character isss) {
        this.isss = isss;
    }

    public Character getContra_jefe() {
        return contra_jefe;
    }

    public void setContra_jefe(Character contra_jefe) {
        this.contra_jefe = contra_jefe;
    }

    public Character getPerido() {
        return perido;
    }

    public void setPerido(Character perido) {
        this.perido = perido;
    }
}
