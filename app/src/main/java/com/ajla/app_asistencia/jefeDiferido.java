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
    EditText solicitud,nombre,apellido,carne;
    String carnet,nombres,apellidos;
    String codigo;
    // Button btnAceptar, btnDenegar;//No estoy segura.
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;
    //  ConexionSQLiteHelper conec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_diferido);

        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("jefecoddife");//Datos que recibe del activity anterior.
        carnet = listav.getString("carnetAlumDif");
        //nombres= listav.getString("nomAlumDif");
        //apellidos= listav.getString("apelAlumDif");



        solicitud=(EditText) findViewById(R.id.idnombre);
        carne=(EditText)findViewById(R.id.idnombre);
        nombre=(EditText) findViewById(R.id.idMateria);
        apellido=(EditText) findViewById(R.id.idapedif);
        //btnAceptar=(Button) findViewById(R.id.aceptardife); //No estoy segura
        //btnDenegar=(Button) findViewById(R.id.denegardife); //No estoy segura

        solicitud.setText(codigo);

        cargarWebService();



        //EVENTOS DE LOS BOTONES --------------No estoy segura

   /*    btnAceptar.setOnClickListener(new View.OnClickListener() {
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
        });*/

    }  //Fin del OnCreate





    /*private void webServiceActualizarAceptado(){

        String url="https://pdmconsumo.000webhostapp.com/ws_actualizarDiferido_Aceptado.php";


        stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.trim().equalsIgnoreCase("actualiza")){
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

        String url="https://pdmconsumo.000webhostapp.com/ws_actualizarDiferido_Rechazado.php";


        stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.trim().equalsIgnoreCase("actualiza")){
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
                String id_solicitud=codigo.toString();
                String nom_alum=nombres.toString();
                String apel_alum=apellidos.toString();


                Map<String,String> parametros=new HashMap<>();
                parametros.put("id_sol",id_solicitud);
                parametros.put("nom_alu",nom_alum);
                parametros.put("ape_alu",apel_alum);


                return parametros;
            }
        };
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(stringRequest);


    } */


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


    public void aceptar(View view) {
        String url="https://pdmconsumo.000webhostapp.com/ws_actualizarDiferido_Aceptado.php";


        stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.trim().equalsIgnoreCase("actualiza")){
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
                String id_solicitud=codigo.toString();
                String nom_alum=nombre.getText().toString();
                String apel_alum=apellido.getText().toString();


                Map<String,String> parametros=new HashMap<>();
                parametros.put("id_sol",id_solicitud);
                parametros.put("nom_alu",nom_alum);
                parametros.put("ape_alu",apel_alum);



                return parametros;
            }
        };
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(stringRequest);

    }


    public void denegar(View view) {


        String url="https://pdmconsumo.000webhostapp.com/ws_actualizarDiferido_Rechazado.php";


        stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.trim().equalsIgnoreCase("actualiza")){
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
                String id_solicitud=codigo.toString();
                String nom_alum=nombres.toString();
                String apel_alum=apellidos.toString();


                Map<String,String> parametros=new HashMap<>();
                parametros.put("id_sol",id_solicitud);
                parametros.put("nom_alu",nom_alum);
                parametros.put("ape_alu",apel_alum);


                return parametros;
            }
        };
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(stringRequest);

    }
}
