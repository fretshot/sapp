package com.fretshot.ihc.sapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        }

     @Override
    public void onBackPressed() {
        android.support.v4.app.NavUtils.navigateUpFromSameTask(this);

    }

}