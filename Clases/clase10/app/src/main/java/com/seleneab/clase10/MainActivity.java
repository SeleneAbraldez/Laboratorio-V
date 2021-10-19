package com.seleneab.clase10;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        String sPref = preferences.getString("user", null);

        if (sPref == null){
            Log.d("Usuario", "No configurado");
            Intent i = new Intent(this, SinUserActivity.class);
            startActivity(i);
        }else{
            ActionBar actionBar = super.getSupportActionBar();
            actionBar.setTitle("Hola "+ sPref);
        }
    }
}