package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Teo implements Serializable{

    private Integer id_ofer_teo;
    private Character num_grup_teo;

    public Oferta_Teo(Integer id_ofer_teo, Character num_grup_teo) {
        this.id_ofer_teo = id_ofer_teo;
        this.num_grup_teo = num_grup_teo;
    }

    public Integer getId_ofer_teo() {
        return id_ofer_teo;
    }

    public void setId_ofer_teo(Integer id_ofer_teo) {
        this.id_ofer_teo = id_ofer_teo;
    }

    public Character getNum_grup_teo() {
        return num_grup_teo;
    }

    public void setNum_grup_teo(Character num_grup_teo) {
        this.num_grup_teo = num_grup_teo;
    }
}
