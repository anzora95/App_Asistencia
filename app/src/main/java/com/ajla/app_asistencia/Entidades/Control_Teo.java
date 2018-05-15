package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Control_Teo implements Serializable{

    private Character asistencia;

    public Control_Teo(Character asistencia) {
        this.asistencia = asistencia;
    }

    public Character getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Character asistencia) {
        this.asistencia = asistencia;
    }
}
