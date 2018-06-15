package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import com.ajla.app_asistencia.Entidades.VolleySingleton;

import org.json.JSONObject;

public class MaestroNuevoActivity extends AppCompatActivity {
    EditText tv_isss,tv_nombre,tv_apellido,tv_contraseña;
    StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestro_nuevo);

        tv_isss = (EditText) findViewById(R.id.isssnuevo);
        tv_nombre = (EditText) findViewById(R.id.nomdocenuevo);
        tv_apellido = (EditText) findViewById(R.id.apedocenuevo);
        tv_contraseña = (EditText) findViewById(R.id.contradocenuevo);


    }

    public void guardar(View view) {

        //antes se debe importar la libreria de Volley la cual usaremos en esta ocasion

        String url= "https://pdmconsumo.000webhostapp.com/ws_insertar_docente.php";  //url del host del cual estamos consumiendo los datos esta vez ser ael host donde insertaremos

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.trim().equalsIgnoreCase("registra")){

                    Toast.makeText(getApplicationContext(),"No se ha registrado ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Se ha registrado con exito",Toast.LENGTH_SHORT).show();
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
            protected Map<String, String> getParams() throws AuthFailureError {
                String codigo_isss = tv_isss.getText().toString();
                String nombre_doce = tv_nombre.getText().toString();
                String apellido_doce = tv_apellido.getText().toString();
                String contra_doce = tv_contraseña.getText().toString();



                Map<String,String> parametros=new HashMap<>();
                parametros.put("isss",codigo_isss);
                parametros.put("nom_doce",nombre_doce);
                parametros.put("ape_doce",apellido_doce);
                parametros.put("contra_doce",contra_doce);


                return parametros;
            }
        };




        //request.add(stringRequest);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(stringRequest);
    }


}
