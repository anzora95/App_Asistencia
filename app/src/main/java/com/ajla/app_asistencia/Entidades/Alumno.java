package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Alumno implements Serializable{

    private Character carnet;
    private String nom_alum;
    private String apel_alum;
    private String contra_alum;

    public Alumno(Character carnet, String nom_alum, String apel_alum, String contra_alum) {
        this.carnet = carnet;
        this.nom_alum = nom_alum;
        this.apel_alum = apel_alum;
        this.contra_alum = contra_alum;
    }



    public Character getCarnet() {
        return carnet;
    }

    public void setCarnet(Character carnet) {
        this.carnet = carnet;
    }

    public String getNom_alum() {
        return nom_alum;
    }

    public void setNom_alum(String nom_alum) {
        this.nom_alum = nom_alum;
    }

    public String getApel_alum() {
        return apel_alum;
    }

    public void setApel_alum(String apel_alum) {
        this.apel_alum = apel_alum;
    }

    public String getContra_alum() {
        return contra_alum;
    }

    public void setContra_alum(String contra_alum) {
        this.contra_alum = contra_alum;
    }
}
