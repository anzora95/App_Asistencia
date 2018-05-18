package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Materia implements Serializable{
 private String cod_materia;
 private String nom_materia;
    private String cod_area;


    public Materia() {
    }

    public Materia(String cod_materia, String nom_materia, String cod_area) {
        this.cod_materia = cod_materia;
        this.nom_materia = nom_materia;
        this.cod_area = cod_area;
    }

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }





    public String getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(String cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getNom_materia() {
        return nom_materia;
    }

    public void setNom_materia(String nom_materia) {
        this.nom_materia = nom_materia;
    }
}
