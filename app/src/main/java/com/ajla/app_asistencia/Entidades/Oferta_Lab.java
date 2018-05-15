package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Lab implements Serializable {
    private Integer id_ofer_lab;
    private Character num_grup_lab;

    public Oferta_Lab(Integer id_ofer_lab, Character num_grup_lab) {
        this.id_ofer_lab = id_ofer_lab;
        this.num_grup_lab = num_grup_lab;
    }

    public Integer getId_ofer_lab() {
        return id_ofer_lab;
    }

    public void setId_ofer_lab(Integer id_ofer_lab) {
        this.id_ofer_lab = id_ofer_lab;
    }

    public Character getNum_grup_lab() {
        return num_grup_lab;
    }

    public void setNum_grup_lab(Character num_grup_lab) {
        this.num_grup_lab = num_grup_lab;
    }
}
