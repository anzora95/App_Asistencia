package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Solicitud_Diferido;
import com.ajla.app_asistencia.Entidades.VolleySingleton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.security.AccessController.getContext;

public class jefeListDiferidos extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    ListView listadif;
    ConexionSQLiteHelper conec;
    ArrayList<String> liDife;
    ArrayList<Solicitud_Diferido> listadoDife;
    String cod_oferta,carnet_AlumDi,codigo;
      JsonObjectRequest jsonObjectRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_list_diferidos);

        ActionBar action = getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);

        listadif = (ListView) findViewById(R.id.listadif);
        cargarWebService();
       //conec = new ConexionSQLiteHelper(getApplicationContext());

        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("jefecodmate");

        //consultarlistadiferidos();

        //ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, liDife);
        //listadif.setAdapter(adaptador); //Adaptador
        listadif.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cod_oferta = listadoDife.get(position).getCarnet().toString();
                carnet_AlumDi=listadoDife.get(position).getCarnet().toString();

                Intent oferta = new Intent(jefeListDiferidos.this, jefeDiferido.class);
                oferta.putExtra("jefecoddife", cod_oferta);
                oferta.putExtra("carnetAlumDif",carnet_AlumDi);
                startActivity(oferta);


            }
        });


    }


     //private void consultarlistadiferidos(){
      /*  SQLiteDatabase db = conec.getReadableDatabase();

        Solicitud_Diferido materiaO;
///aqui modificar
        String sql ="Select * from solicitud_diferido inner join asis_exam on solicitud_diferido.fecha_exam= asis_exam.fecha_exam inner join oferta_materia on asis_exam.cod_ofer_mate=oferta_materia.cod_ofer_mate where solicitud_diferido.isss='456789908' and oferta_materia.cod_materia=='"+codigo+"' and solicitud_diferido.estado== 0 ";
        Cursor cursor =db.rawQuery(sql,null);
        listadoDife = new ArrayList<Solicitud_Diferido>();
        while (cursor.moveToNext()) {
            materiaO = new Solicitud_Diferido();
            materiaO.setId_solicitud(cursor.getInt(0));
            materiaO.setCarnet(cursor.getString(1));
            materiaO.setIsss(cursor.getString(2));

            listadoDife.add(materiaO);
}*/


       // obtenerlista();


    private void cargarWebService(){




        String url="https://pdmconsumo.000webhostapp.com/consultarDiferidos.php";


        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        // request.add(jsonObjectRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(jsonObjectRequest);


    }



    private void obtenerlista() {
        liDife=new ArrayList<String>();

        for(int i=0; i<listadoDife.size();i++)
        {
            liDife.add( " "+listadoDife.get(i).getCarnet());
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(getApplicationContext(),"No se pudo Consultar ",Toast.LENGTH_SHORT).show();
        Log.i("ERROR",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Solicitud_Diferido soliDife=null;
        listadoDife= new ArrayList<>();

        JSONArray json=response.optJSONArray("codigoCD");

        try {

            for (int i=0;i<json.length();i++){
                soliDife=new Solicitud_Diferido();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                soliDife.setCarnet(jsonObject.optString("carnet"));
                listadoDife.add(soliDife);
            }
            obtenerlista();
            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, liDife);
            listadif.setAdapter(adaptador);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "No se ha podido establecer conexión con el servidor" + " "+response, Toast.LENGTH_LONG).show();

        }


    }
}