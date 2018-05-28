package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

public class Listagrupos implements Serializable {
    private String grupo;
    private String docente;
    private String salon;

    public Listagrupos() {
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }
}
