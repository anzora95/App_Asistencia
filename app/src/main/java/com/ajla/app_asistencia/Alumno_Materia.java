package com.ajla.app_asistencia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Alumno_Materia extends AppCompatActivity {

    Button btn_alumMat_inscri;
    List <Item_Materia> materias;
    ListView lv_Materia;
   // Materia_Adapter matAdapter;
   // boolean checkInscri=false;


    //private ListView listaalumno;
    ArrayList<String> itemseleccionados=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_asistenciaeva);
        ListView chl = (ListView) findViewById(R.id.chek_ls);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] item = {"Alejandra Campos", "Andres MC", "Nathaly MC", "Eliana RM", "Nehemias M"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Alumno_Materia.this, R.layout.rowlayout,item);

        chl.setAdapter(adapter);

        chl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                String itemsseleccionados = ((TextView) view).getText().toString();
                if (itemseleccionados.contains(itemseleccionados)) {
                    itemseleccionados.remove(itemseleccionados);
                } else itemseleccionados.add(itemsseleccionados);

            }
        });
    }


    private void initMaterias(){

        materias=new ArrayList<Item_Materia>();

        TypedArray arraytxt=getResources().obtainTypedArray(R.array.restext);

        for(int i=0; i<arraytxt.length();i++){

            String st = arraytxt.getString(i);
            boolean bo=false;
            Item_Materia item  = new Item_Materia(st,bo);
            materias.add(item);


        }

        arraytxt.recycle();


    }
    public class Item_Materia{

        boolean checked;
        String nom_materia;

        Item_Materia(String n, boolean b){

            checked=b;
            nom_materia=n;

        }

        public boolean isChecked(){

            return checked;

        }


    }

    static class ViewHolder{

        CheckBox chkBox_Materia;
        TextView txt_nom_materia;

    }

    /*public class Materia_Adapter extends BaseAdapter{

        private Context context;
        private List <Item_Materia> ls;
        private int layout;


        Materia_Adapter(Context c, List<Item_Materia> l, int layo){

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

            ViewHolder holder= new ViewHolder();

            if(rowView==null){
                LayoutInflater inflater= LayoutInflater.from(Alumno_Materia.this);
                rowView=inflater.inflate(R.layout.item_materia,null);//crear el item en un layout luego agregarlo aqui por medio de referencia

                holder.chkBox_Materia= rowView.findViewById(R.id.chk_row);//En este punto creare a vista parapoder terminar de inflar
                holder.txt_nom_materia=rowView.findViewById(R.id.txt_row);

                rowView.setTag(holder);

            }else {

                holder = (ViewHolder) rowView.getTag();

            }

            holder.chkBox_Materia.setChecked(ls.get(position).checked);
            final String itemStr = ls.get(position).nom_materia;
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


    }*/
}
