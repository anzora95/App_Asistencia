package com.ajla.app_asistencia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Docente;
import com.ajla.app_asistencia.Entidades.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminAlumnoActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    ListView listViewAlumnos;
    ConexionSQLiteHelper conec;
    ArrayList<String> laluminfo;
    ArrayList<Alumno> listaalumno;
    String puen;
    String tv_carnet,tv_nombre,tv_apellido,tv_contraseña;
    ArrayAdapter adaptado;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;//SE MODIFICA





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_alumno);


        ActionBar action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);



        listViewAlumnos = (ListView) findViewById(R.id.listalumno);


        cagarwebservice();



        listViewAlumnos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                puen = listaalumno.get(i).getCarnet();

                Context context = AdminAlumnoActivity.this;
                AlertDialog.Builder DialogoAlerta = new AlertDialog.Builder(context);
                DialogoAlerta.setTitle("ELIMINAR ALUMNO");
                DialogoAlerta.setMessage("¿Realmente desea eliminiar este alumno?");
                DialogoAlerta.setCancelable(false);
                DialogoAlerta.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aceptar();
                    }
                });
                DialogoAlerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cancelar();
                    }
                });
                DialogoAlerta.show();
                return true;
            }
        });

        listViewAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_carnet =listaalumno.get(i).getCarnet();
                tv_nombre =listaalumno.get(i).getNom_alum();
                tv_apellido= listaalumno.get(i).getApel_alum();
                tv_contraseña =listaalumno.get(i).getContra_alum();


            }
        });

    }

    private void aceptar() {
        webServiceEliminar();
        Toast.makeText(this,"Registro eliminado", Toast.LENGTH_SHORT).show();
        Intent P= new Intent(this,AdminAlumnoActivity.class);
        startActivity(P);
    }
    private void cancelar(){
        closeContextMenu();

    }

    private void cagarwebservice() {

        String url = "https://pdmconsumo.000webhostapp.com/consultarAlumno.php";// string el cual vamos a ponr la url a enviar

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);

        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(jsonObjectRequest);

        /*SQLiteDatabase db=conec.getReadableDatabase();

        Alumno doce;
        listaalumno = new ArrayList<Alumno>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_ALUMNO,null );

        while(cursor.moveToNext()){
            doce= new Alumno();
            doce.setCarnet(cursor.getString(0));
            doce.setNom_alum(cursor.getString(1));
            doce.setApel_alum(cursor.getString(2));
            doce.setContra_alum(cursor.getString(3));


            listaalumno.add(doce);*/
        //obtenerlista();
        }



    private void obtenerlista() {
        laluminfo=new ArrayList<String>();

        for(int i=0; i<listaalumno.size();i++)
        {
            laluminfo.add(listaalumno.get(i).getCarnet()+"   "+listaalumno.get(i).getNom_alum()+"  "+listaalumno.get(i).getApel_alum());
        }
    }


    public void agregara(View view) {
        Intent lista = new Intent(AdminAlumnoActivity.this, AdminAlumnoNuevoActivity.class);  //Onda del video
        startActivity(lista);


    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "No se puede conectar ",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onResponse(JSONObject response) {

        Alumno alumno=null;
        listaalumno=new ArrayList<>();

        JSONArray json=response.optJSONArray("Nombre");

        try {

            for (int i=0;i<json.length();i++){
                alumno=new Alumno();
                JSONObject jsonObject=null;
                jsonObject=json.getJSONObject(i);

                alumno.setCarnet(jsonObject.optString("CARNET"));
                alumno.setNom_alum(jsonObject.optString("NOM_ALUM"));
                alumno.setApel_alum(jsonObject.optString("APEL_ALUM"));
                alumno.setContra_alum(jsonObject.optString("CONTRA_ALUM"));
                listaalumno.add(alumno);
            }

            obtenerlista();

            adaptado = new ArrayAdapter(this,android.R.layout.simple_list_item_1,laluminfo);
            listViewAlumnos.setAdapter(adaptado);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "No se ha podido establecer conexión con el servidor" +
                    " "+response, Toast.LENGTH_LONG).show();

        }

    }

    private void webServiceEliminar() {




        String url="https://pdmconsumo.000webhostapp.com/ws_eliminar_alumno.php?carnet="+puen; //String con el url de el servicio web a consumir hacer otro web service para consumir con un request del carnet

        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.trim().equalsIgnoreCase("elimina")){


                    Toast.makeText(getApplicationContext(),"Se ha Eliminado con exito",Toast.LENGTH_SHORT).show();
                }else{
                    if (response.trim().equalsIgnoreCase("noExiste")){
                        Toast.makeText(getApplicationContext(),"No se encuentra la persona ",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getApplicationContext(),"No se ha Eliminado ",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No se ha podido conectar",Toast.LENGTH_SHORT).show();

            }
        });
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}
