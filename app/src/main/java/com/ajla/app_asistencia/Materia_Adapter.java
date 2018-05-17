package com.ajla.app_asistencia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class Materia_Adapter extends BaseAdapter {

    private Context context;
    private List<Alumno_Materia.Item_Materia> ls;
    private int layout;


    Materia_Adapter(Context c, List<Alumno_Materia.Item_Materia> l, int layo){

        this.context=c;
        this.ls=l;
        this.layout=layo;

    }

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public boolean isChecked(int position){

        return ls.get(position).checked;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView= convertView;

        //usando el patron ViewHolder

        Alumno_Materia.ViewHolder holder;

        if(rowView==null){
            LayoutInflater inflater= LayoutInflater.from(this.context);
            rowView=inflater.inflate(R.layout.item_materia,null);//crear el item en un layout luego agregarlo aqui por medio de referencia

            holder=new Alumno_Materia.ViewHolder();
            holder.chkBox_Materia= rowView.findViewById(R.id.chk_row);//En este punto creare a vista parapoder terminar de inflar
            holder.txt_nom_materia=rowView.findViewById(R.id.txt_row);

            rowView.setTag(holder);

        }else {

            holder = (Alumno_Materia.ViewHolder) rowView.getTag();

        }

        holder.chkBox_Materia.setChecked(ls.get(position).checked);
        String itemStr = ls.get(position).nom_materia;
        holder.txt_nom_materia.setText(itemStr);

        holder.chkBox_Materia.setTag(position);

        holder.chkBox_Materia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean newState = !ls.get(position).isChecked();
                ls.get(position).checked=newState;
                //aqui llenare una variable que me dira si esta chequeada para que cuando precione el boton de abajo se envie a otra activity




            }

        });

        holder.chkBox_Materia.setChecked(isChecked(position));
        return rowView;
    }


}
