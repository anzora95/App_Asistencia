package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Docente implements Serializable{
    private Character isss;
    private String nom_doce;
    private String ape_doce;

    public Docente(Character isss, String nom_doce, String ape_doce) {
        this.isss = isss;
        this.nom_doce = nom_doce;
        this.ape_doce = ape_doce;
    }

    public Character getIsss() {
        return isss;
    }

    public void setIsss(Character isss) {
        this.isss = isss;
    }

    public String getNom_doce() {
        return nom_doce;
    }

    public void setNom_doce(String nom_doce) {
        this.nom_doce = nom_doce;
    }

    public String getApe_doce() {
        return ape_doce;
    }

    public void setApe_doce(String ape_doce) {
        this.ape_doce = ape_doce;
    }
}
