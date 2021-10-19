package com.seleneab.clase7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int MENSAJE_TEXTO = 1;
    private TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        //no esta nueno que los hilos esten siemrpe vivos haciendo cosas, deben nacer para hwscer algo
        //EjecutarHttp miHilo = new  EjecutarHttp("http://cosecharoja.org/feed/", handler);
        EjecutarHttp miHilo = new  EjecutarHttp("https://restcountries.eu/rest/v2/region/americas", handler);
        miHilo.start();
        //Log.d("Main", "Termino el onCreate!");

    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        if(msg.arg1 == MENSAJE_TEXTO){
            TextView tvRespuesta = findViewById(R.id.tvRSS);
            tvRespuesta.setText(msg.obj.toString());
        }else if(msg.arg1 == 2){
            List<String> lista = (List<String>) msg.obj;
            TextView tvRespuesta = findViewById(R.id.tvRSS);
            tvRespuesta.setText(lista.get(20));
        }

        return false;
    }
}