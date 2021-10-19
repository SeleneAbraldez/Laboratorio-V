package com.seleneab.clase9;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(this);

        EjecutarHttp miHilo = new EjecutarHttp("https://www.clarin.com/rss/deportes/hockey/", handler, false);
        //EjecutarHttp miHilo = new  EjecutarHttp("http://cosecharoja.org/feed/", handler);
        //EjecutarHttp miHilo = new  EjecutarHttp("https://capuchainformativa.org/feed/", handler);
        miHilo.start();

    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        List<Noticia> noticias = null;
        if (msg.arg1 == 1) {
            TextView tvRespuesta = findViewById(R.id.tvRSS);
            tvRespuesta.setText(msg.obj.toString());
        } else if (msg.arg1 == 2) {
            noticias = (List<Noticia>) msg.obj;
            TextView tvRespuesta = findViewById(R.id.tvRSS);
            tvRespuesta.setText(noticias.get(0).titulo);
            EjecutarHttp buscoImg = new EjecutarHttp(noticias.get(0).urlImg, handler, true);
            buscoImg.start();
        } else if (msg.arg1 == 3) {
            byte[] imgArray = (byte[]) msg.obj;
            ImageView imageView = this.findViewById(R.id.img);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(imgArray, 0, imgArray.length));
        }

        return false;
    }
}