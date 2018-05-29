package com.ajla.app_asistencia;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Alumno;


import java.util.ArrayList;

public class DocenteAsistenciaGL extends AppCompatActivity {
    private ListView listaalumno;
    ArrayList<String> itemseleccionados = new ArrayList<>();
    ConexionSQLiteHelper conec;

    ArrayList<String> item;
    ArrayList<Alumno> listadoalumno;
    String odigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_asistenciagl);
        ListView chl = (ListView) findViewById(R.id.checkable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        Bundle listav = getIntent().getExtras();
        odigo = listav.getString("Mateasislab");
        conec = new ConexionSQLiteHelper(getApplicationContext()); //Conexion a la BD

        consultarlistaalumnos();
        //String[] item = {"Alfonso Guillen", "Juan Perez", "Blanca De la Cruz", "Eliel Mauricio ", "Siriaco De los angeles"};

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

    public void showSelectedItem(View view) {
        String items = "";
        for (String item : itemseleccionados) {
            items += "-" + item + "/n";


        }
        Toast.makeText(this, "ha venido\n" + items, Toast.LENGTH_SHORT).show();


    }


    private void consultarlistaalumnos() {
        SQLiteDatabase db = conec.getReadableDatabase();

        Alumno alumno;
///aqui modificar
        String sql = "Select * from alumno inner join inscripcion_lab on alumno.carnet=inscripcion_lab.carnet inner join control_lab on inscripcion_lab.id_insLab=control_lab.id_insLab inner join asis_lab on control_lab.fecha_lab=asis_lab.fecha_lab where asis_lab.id_ofer_lab='"+odigo+"'";

        Cursor cursor = db.rawQuery(sql, null);
        listadoalumno = new ArrayList<Alumno>();
        while (cursor.moveToNext()) {
            alumno = new Alumno();

            alumno.setCarnet(cursor.getString(2));
            alumno.setApel_alum(cursor.getString(0));
            alumno.setNom_alum(cursor.getString(1));
            listadoalumno.add(alumno);
        }
        obtenerlista();
    }

    private void obtenerlista() {
        item = new ArrayList<String>();

        for (int i = 0; i < listadoalumno.size(); i++) {
            item.add(listadoalumno.get(i).getCarnet() + "   " + listadoalumno.get(i).getApel_alum() + " " + listadoalumno.get(i).getNom_alum());
        }


        //https://www.youtube.com/watch?v=a-dvLs1g3Ec
    }
}
