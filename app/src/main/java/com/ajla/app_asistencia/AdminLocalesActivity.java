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
import com.ajla.app_asistencia.Entidades.Lugar;
import com.ajla.app_asistencia.Entidades.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminLocalesActivity extends AppCompatActivity {

    private ListView listLocales;
    ConexionSQLiteHelper conn;
    ArrayList<String> lsLo;
    ArrayList<Lugar> lsLocal;
    String puente;
    String cod_luagar,tipo;
    Integer capa;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_locales);

        ActionBar action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);

        conn = new ConexionSQLiteHelper(getApplicationContext());
        listLocales = (ListView) findViewById(R.id.listLocales);


        


        listLocales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cod_luagar = lsLocal.get(i).getCod_Lugar() ;
                tipo = lsLocal.get(i).getTipo();
                capa = lsLocal.get(i).getCapacidad();

                Intent lista = new Intent(AdminLocalesActivity.this, AdminLocalesActualizarActivity.class);  //Onda del video
                lista.putExtra("editcodligar",cod_luagar);
                lista.putExtra("edittipo",tipo);
                lista.putExtra("editcapa",capa);
                startActivity(lista);


            }
        });
        listLocales.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                puente = lsLocal.get(i).getCod_Lugar() ;
                Context context = AdminLocalesActivity.this;
                AlertDialog.Builder DialogoAlerta = new AlertDialog.Builder(context);
                DialogoAlerta.setTitle("ELIMINAR LOCAL");
                DialogoAlerta.setMessage("¿Realmente desea eliminiar este local?");
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

    }

    private void aceptar() {
        SQLiteDatabase db=conn.getWritableDatabase();
        db.execSQL("Delete from lugar where cod_lugar='"+puente+"'");
        Toast.makeText(this,"Lugar eliminado", Toast.LENGTH_SHORT).show();
        Intent P= new Intent(this,AdminLocalesActivity.class);
        startActivity(P);
    }
    private void cancelar() {
        closeContextMenu();
    }


    private void consultarListaLocales() {
                SQLiteDatabase db = conn.getReadableDatabase();
                Lugar local = null;
                lsLocal = new ArrayList<Lugar>();
                Cursor cursor = db.rawQuery("SELECT * FROM " + ConexionSQLiteHelper.DatosTabla.TABLA_LUGAR, null);

                while (cursor.moveToNext()) {
                    local = new Lugar();
                    local.setCod_Lugar(cursor.getString(0));
                    local.setCapacidad(cursor.getInt(1));
                    local.setTipo(cursor.getString(2));

                    lsLocal.add(local);

                }
                obtenerlista();
            }

            private void obtenerlista() {

                lsLo=new ArrayList<String>();

                for(int i=0; i<lsLocal.size();i++)
                {
                    lsLo.add(lsLocal.get(i).getCod_Lugar()+"   "+lsLocal.get(i).getCapacidad()+"  "+lsLocal.get(i).getTipo());
                }
            }

            public void agregar(View view) {
                Intent intn= new Intent(AdminLocalesActivity.this,AdminLocalNuevoActivity.class);
                startActivity(intn);
            }





}

