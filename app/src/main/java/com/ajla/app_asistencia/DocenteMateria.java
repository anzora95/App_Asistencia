package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DocenteMateria extends AppCompatActivity implements ListView.OnItemClickListener{
    ListView listagt;//para instanciar la lista y mostrarlo pero como ,lista nada mas
    TextView textogt;
    String[] valoresgt= new String[]{"GT01","GT02","GT03","GT04","GT05","GT06"};
    ListView view;


    ListView listagl;
    TextView textogl;
    String[] valoresgl= new String[]{"GL01","GL02","GL03","GL04","GL05","GL06"};


    private ListView listaeva;
    TextView textoeva;
    String[] valoreseva= new String[]{"ev01","ev02","ev03","ev04","ev05","ev06"};



    String coordinador;
    String docente= coordinador;
    Button botonasignar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_materia);

//muestra lo datos
        textogt=(TextView)findViewById(R.id.gt);

        listagt=(ListView) findViewById(R.id.listagt);

        textogl=(TextView)findViewById(R.id.gl);

        listagl=(ListView) findViewById(R.id.listagl);

        textoeva=(TextView)findViewById(R.id.eva);

        listaeva=(ListView) findViewById(R.id.listaeva);

        botonasignar=(Button)findViewById(R.id.botonasignar);

       
       
        //llenado de arreglos quemados
        


        ArrayAdapter<String> adaptergt = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valoresgt);
        ArrayAdapter<String> adaptergl = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valoresgl);
        ArrayAdapter<String> adaptereva = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valoreseva);
        listagt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaGT.class);
                //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

                //nuevoformulario.putExtra("Materias", valor);
                startActivity(nuevoformulario);
            }
        });
        listagl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaGL.class);
                //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

                //nuevoformulario.putExtra("Materias", valor);
                startActivity(nuevoformulario);
            }
        });
        listaeva.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaEVA.class);
                //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

                //nuevoformulario.putExtra("Materias", valor);
                startActivity(nuevoformulario);
            }
        });




        listagt.setAdapter(adaptergt);
        listagl.setAdapter(adaptergl);
        listaeva.setAdapter(adaptereva);

        //para que el boton lo lleve a otra pantalla
        botonasignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(docente==coordinador) {
                    Intent siguientepantalla = new Intent(DocenteMateria.this, DocenteEvaluacion.class);
                    startActivity(siguientepantalla);
                }
                else{
                    Toast.makeText(DocenteMateria.this,"no es coordinador",Toast.LENGTH_LONG).show();
                }

            }
        });




}
//que en gt asigte una pantalla para gt y otra para gl
@Override


    public void onItemClick(AdapterView<?> parent, View view, int position, long id ){//de la misma forma se crea para que un elemento de la lista aparesca otra pantalla

//NO HACE NADA




        String valor= (String) parent.getItemAtPosition(position);

    switch (view.getId()){
        case R.id.listagt:
            Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaGT.class);
            //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

            //nuevoformulario.putExtra("Materias", valor);
            startActivity(nuevoformulario);
            break;
        case R.id.listagl:
            Intent nuevoformulario2 = new Intent(DocenteMateria.this, DocenteAsistenciaGL.class);
            //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

            //nuevoformulario2.putExtra("Materias", valor);
            startActivity(nuevoformulario2);
            break;
        case R.id.listaeva:
            Intent nuevoformulario3 = new Intent(DocenteMateria.this, DocenteAsistenciaEVA.class);
            //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

            //nuevoformulario3.putExtra("Materias", valor);
            startActivity(nuevoformulario3);
    }

//https://www.youtube.com/watch?v=1E9y9JNnS1I PARA OCULTAR BOTON PODRIA SERVIR




//HASTA AQUI NO HACE NADA!!
}

}


