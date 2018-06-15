package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Ciclo;
import com.ajla.app_asistencia.Entidades.VolleySingleton;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class jefeDiferido extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText solicitud,nombre,apellido,fecha;
    String carnet,nombres,apellidos;
    String codigo;
    Button btnAceptar, btnDenegar;//No estoy segura.
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;
  //  ConexionSQLiteHelper conec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_diferido);

        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("jefecoddife");
        carnet = listav.getString("carnetAlumDif");

        //conec= new ConexionSQLiteHelper(getApplicationContext());

        solicitud=(EditText) findViewById(R.id.idnombre);
        nombre=(EditText) findViewById(R.id.idMateria);
        apellido=(EditText) findViewById(R.id.idapedif);
        btnAceptar=(Button) findViewById(R.id.aceptardife); //No estoy segura
        btnDenegar=(Button) findViewById(R.id.denegardife); //No estoy segura

        solicitud.setText(codigo);

        cargarWebService();



        //EVENTOS DE LOS BOTONES --------------No estoy segura

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webServiceActualizarAceptado();
            }
        });

        btnDenegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webServiceActualizarDenegado();
            }
        });

/*
        Alumno alu;
        //SQLiteDatabase db1= conec.getReadableDatabase();
        //Cursor cursor =db1.rawQuery("SELECT * FROM alumno inner join solicitud_diferido on alumno.carnet=solicitud_diferido.carnet where solicitud_diferido.id_solicitud == "+codigo+"",null);
        while (cursor.moveToNext()) {
            alu =new Alumno();
            alu.setNom_alum(cursor.getString(1));
            alu.setApel_alum(cursor.getString(2));

            nombres = alu.getNom_alum().toString();
            apellidos= alu.getApel_alum().toString();

        }
        nombre.setText(nombres);
        apellido.setText(apellidos);

*/


    }  //Fin del OnCreate

    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aceptardife:
               // SQLiteDatabase db = conec.getWritableDatabase();
               // db.execSQL("UPDATE solicitud_diferido set estado = 1 where id_solicitud == '" + codigo+ "'");
                Toast.makeText(jefeDiferido.this,"se aprobo la solicitud",Toast.LENGTH_LONG).show();
                Intent inten = new Intent (jefeDiferido.this,jefeMenu.class);
                startActivity(inten);
            break;
            case R.id.denegardife:

                Toast.makeText(jefeDiferido.this,"se denego la solicitud",Toast.LENGTH_LONG).show();
                Intent inten1 = new Intent (jefeDiferido.this,jefeMenu.class);
                startActivity(inten1);
            break;
        }
    }*/


    private void webServiceActualizarAceptado(){

        String url="https://pdmconsumo.000webhostapp.com/ws_actualizar_estadoDiferido.php?id_solicitud="+solicitud+"&estado="+"1";


        stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.trim().equalsIgnoreCase("actualiza")){
                    // etiNombre.setText("");
                    //  txtDocumento.setText("");
                    //   etiProfesion.setText("");
                    Toast.makeText(getApplicationContext(),"Se ha Actualizado con exito",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"No se ha Actualizado ",Toast.LENGTH_SHORT).show();
                    Log.i("RESPUESTA: ",""+response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No se ha podido conectar",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                String id_solicitud=codigo;
                String nom_alum=nombres.toString();
                String apel_alum=apellidos.toString();
                String estado="1";




                Map<String,String> parametros=new HashMap<>();
                parametros.put("id_sol",id_solicitud);
                parametros.put("nom_alu",nom_alum);
                parametros.put("ape_alu",apel_alum);
                parametros.put("est",estado);


                return parametros;
            }
        };
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(stringRequest);


    }

    private void webServiceActualizarDenegado(){

    }



    private void cargarWebService(){


        String url="https://pdmconsumo.000webhostapp.com/consultarAlumno2.php?carnet=" +carnet;


        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null, this,this);
        // request.add(jsonObjectRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(jsonObjectRequest);


    }


    @Override
    public void onResponse(JSONObject response) {
        Alumno miUsuario=new Alumno();


        JSONArray json=response.optJSONArray("CarnetDi");
        JSONObject jsonObject=null;

        try {
            jsonObject=json.getJSONObject(0);
            miUsuario.setNom_alum(jsonObject.optString("NOM_ALUM"));
            miUsuario.setApel_alum(jsonObject.optString("APEL_ALUM"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"No se pudo Consultar ",Toast.LENGTH_SHORT).show();
        Log.i("ERROR",error.toString());
    }



}
