package com.fretshot.ihc.sapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

public class NumerosEmergenciaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.numeros_emergencia);

        android.widget.ListView lista;
        android.widget.ArrayAdapter<String> adaptador;



        lista = findViewById(R.id.listView);

        final String[] num_emer = {
        "Policia Municipal y Vialidad",
        "Fuerza Civil",
        "Bomberos",
        "Protección Civil",
        "Cruz Roja",
        "Cruz Verde",
        "Asistencia en Carretera",
        "Ecología",
        "CFE",
        };

        adaptador = new android.widget.ArrayAdapter<>(this,android.R.layout.simple_list_item_1,num_emer);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                switch (pos){
                    case 0:
                       makeCall("018181259400");
                        break;
                    case 1:
                        makeCall("018008001133");
                        break;
                    case 2:
                        makeCall("018110520700");
                        break;
                    case 3:
                        makeCall("018183439530");
                        break;
                    case 4:
                        makeCall("018114771477");
                        break;
                    case 5:
                        makeCall("018183715259");
                        break;
                    case 6:
                        makeCall("074");
                        break;
                    case 7:
                        makeCall("018181306455");
                        break;
                    case 8:
                        makeCall("01 183439189");
                        break;
                }

            }
        });
    }

    public void makeCall(String phone){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phone+"..." ));
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        android.support.v4.app.NavUtils.navigateUpFromSameTask(this);

    }

}