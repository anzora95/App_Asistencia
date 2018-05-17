package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Alumno_Asistencia extends AppCompatActivity {

    Spinner sp_asis;
    ListView lv_asis;
    ArrayList ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno__asistencia);

        sp_asis=findViewById(R.id.spi_asis);
        lv_asis=findViewById(R.id.lv_asis);

        //lista spinner
        ls=new ArrayList();
        for(int i=0;i<=4;i++){

            ls.add("Materias"+i);
        }

        //---------------------------------------------------------------
        //LIstas para listview



        //Array Adapter para spinner

        ArrayAdapter<CharSequence> adaptersp = new ArrayAdapter(Alumno_Asistencia.this,android.R.layout.simple_spinner_item,ls);
        sp_asis.setAdapter(adaptersp);



        sp_asis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                int posicion =adapterView.getSelectedItemPosition();
                Toast.makeText(Alumno_Asistencia.this,"la posicion es: "+posicion,Toast.LENGTH_LONG).show();

                if(posicion==0){
                    //Lista listview1
                    ArrayList lsv=new ArrayList();

                    for (int j=0;j<=36;j++){

                        lsv.add("Semana "+(j+1));

                    }

                    //Arrayadapter para listview

                    ArrayAdapter<String> adapterlv = new ArrayAdapter(Alumno_Asistencia.this,android.R.layout.simple_list_item_1,lsv);
                    lv_asis.setAdapter(adapterlv);
                }

                else if(posicion==1){
                    //Lista listview1
                    ArrayList lsv=new ArrayList();

                    for (int j=0;j<=36;j++){

                        lsv.add("clase "+(j+1));

                    }
                    //Arrayadapter para listview

                    ArrayAdapter<String> adapterlv = new ArrayAdapter(Alumno_Asistencia.this,android.R.layout.simple_list_item_1,lsv);
                    lv_asis.setAdapter(adapterlv);
                }

                else if(posicion==2){
                    //Lista listview1
                    ArrayList lsv=new ArrayList();

                    for (int j=0;j<=36;j++){

                        lsv.add("Evaluacion "+(j+1));

                    }
                    //Arrayadapter para listview

                    ArrayAdapter<String> adapterlv = new ArrayAdapter(Alumno_Asistencia.this,android.R.layout.simple_list_item_1,lsv);
                    lv_asis.setAdapter(adapterlv);
                }
                else if(posicion==3){
                    //Lista listview1
                    ArrayList lsv=new ArrayList();

                    for (int j=0;j<=36;j++){

                        lsv.add("Periodo "+(j+1));

                    }
                    //Arrayadapter para listview

                    ArrayAdapter<String> adapterlv = new ArrayAdapter(Alumno_Asistencia.this,android.R.layout.simple_list_item_1,lsv);
                    lv_asis.setAdapter(adapterlv);
                }
                else if(posicion == 4){
                    //Lista listview1
                    ArrayList lsv=new ArrayList();

                    for (int j=0;j<=36;j++){

                        lsv.add("Pokemon "+(j+1));

                    }
                    //Arrayadapter para listview

                    ArrayAdapter<String> adapterlv = new ArrayAdapter(Alumno_Asistencia.this,android.R.layout.simple_list_item_1,lsv);
                    lv_asis.setAdapter(adapterlv);
                }








            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
