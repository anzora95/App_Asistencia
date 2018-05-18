package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Jefe_Departamento implements Serializable{

    private String perido;
    private String isss;
    private String cod_area;
    private String contraseña;

    public Jefe_Departamento() {
    }

    public Jefe_Departamento(String perido, String isss, String cod_area, String contraseña) {
        this.perido = perido;
        this.isss = isss;
        this.cod_area = cod_area;
        this.contraseña = contraseña;
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
