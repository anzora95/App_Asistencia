package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Materia implements Serializable{
 private Character cod_materia;
 private Character cod_area;
 private String nom_materia;

    public Materia(Character cod_materia, Character cod_area, String nom_materia) {
        this.cod_materia = cod_materia;
        this.cod_area = cod_area;
        this.nom_materia = nom_materia;
    }

    public Character getCod_area() {
        return cod_area;
    }

    public void setCod_area(Character cod_area) {
        this.cod_area = cod_area;
    }

    public Character getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(Character cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getNom_materia() {
        return nom_materia;
    }

    public void setNom_materia(String nom_materia) {
        this.nom_materia = nom_materia;
    }
}
