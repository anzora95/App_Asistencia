package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Jefe_Departamento implements Serializable{

    private Character perido;

    public Jefe_Departamento(Character perido) {
        this.perido = perido;
    }

    public Character getPerido() {
        return perido;
    }

    public void setPerido(Character perido) {
        this.perido = perido;
    }
}
