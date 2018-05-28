package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

public class ListaOfertas implements Serializable {
    private String codmateria;
    private String codoferta;
    private String coordinador;

    public ListaOfertas() {
    }

    public String getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(String codmateria) {
        this.codmateria = codmateria;
    }

    public String getCodoferta() {
        return codoferta;
    }

    public void setCodoferta(String codoferta) {
        this.codoferta = codoferta;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }
}
