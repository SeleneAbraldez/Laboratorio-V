package com.seleneab.rppabraldez;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int MENSAJE_TEXTO = 1;

    private static final List<AutoModel> autos = new ArrayList<>();
    private AutoAdapter autoAdapter;

    public static List<AutoModel> getLista() {
        return autos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        EjecutarHttp miHilo = new EjecutarHttp("http://192.168.0.14:3000/autos", handler);
        miHilo.start();


        autoAdapter = new AutoAdapter(autos, this);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(autoAdapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rc.setLayoutManager(manager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        autoAdapter.setProductos(MainActivity.getLista());
        this.autoAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        List<AutoModel> lista = (List<AutoModel>) msg.obj;
        Log.d("TamañoLista", String.valueOf(lista.size()));
        Log.d("Lista", lista.toString());

        for (int i = 0; i < lista.size(); i++) {
            autos.add(new AutoModel(lista.get(i).getNModelo(), lista.get(i).getMarca(), lista.get(i).getAnio()));
        }

        autoAdapter = new AutoAdapter(autos, this);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(autoAdapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        rc.setLayoutManager(manager);
        return false;
    }

    public void seleccionarAuto(int index) {
        List<AutoModel> autos = MainActivity.getLista();
        AutoModel auto = autos.get(index);
        Intent intent = new Intent(this, EditActivity.class);

        intent.putExtra("index", index);
        startActivity(intent);
    }


}