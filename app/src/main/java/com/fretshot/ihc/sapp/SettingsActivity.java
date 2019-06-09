package com.fretshot.ihc.sapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

    public static final String KEY_CONTACTO="contacto_boton";
    public static final String KEY_MAPA_SATELITAL="mapa_satelital";
    public static final String KEY_CONTACTO_EMERGENCIA="contacto_emergencia";
}
