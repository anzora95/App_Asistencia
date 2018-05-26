package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DocenteAsistenciaGL extends AppCompatActivity {
    private ListView listaalumno;
    ArrayList<String> itemseleccionados=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_asistenciagl);
        ListView chl = (ListView) findViewById(R.id.checkable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] item = {"Alfonso Guillen", "Juan Perez", "Blanca De la Cruz", "Eliel Mauricio ", "Siriaco De los angeles"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_lan, item);
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

    public void showSelectedItem(View view){
        String items="";
        for(String item:itemseleccionados){
            items+="-"+item+"/n";


        }
        Toast.makeText(this,"ha venido\n"+items,Toast.LENGTH_SHORT).show();


    }




    //https://www.youtube.com/watch?v=a-dvLs1g3Ec
}

