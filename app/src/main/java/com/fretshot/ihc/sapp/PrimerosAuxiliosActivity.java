package com.fretshot.ihc.sapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;


public class PrimerosAuxiliosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeros_auxilios);

        android.widget.ListView lista;
        android.widget.ArrayAdapter<String> adaptador;

        lista = findViewById(R.id.listView);

        final String[] prim_aux = {
                "Asfixia",
                "Envenenamiento",
                "Esguinces y Fracturas",
                "Deshidratación",
                "Hemorragia",
                "Lipotimia y Coma",
                "Mordeduras",
                "Quemaduras",
                "Reanimación Cardio Pulmonar",
        };

        adaptador = new android.widget.ArrayAdapter<>(this,android.R.layout.simple_list_item_1,prim_aux);

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                switch (pos){
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                }

            }
        });
    }



    @Override
    public void onBackPressed() {
        android.support.v4.app.NavUtils.navigateUpFromSameTask(this);

    }

}
