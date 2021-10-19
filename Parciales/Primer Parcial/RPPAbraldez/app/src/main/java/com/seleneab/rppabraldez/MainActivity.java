package com.seleneab.rppabraldez;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int MENSAJE_TEXTO = 1;

    private static final List<ProductoModel> productos = new ArrayList<>();
    private ProductoAdapter productoAdapter;

    public static List<ProductoModel> getLista() {
        return productos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        EjecutarHttp miHilo = new EjecutarHttp("https://restcountries.eu/rest/v2/region/americas", handler);
        miHilo.start();

//        for (int i = 0; i < 12; i++) {
//            productos.add(new ProductoModel("Producto" + i, 4, (float) 30.50));
//        }

        productoAdapter = new ProductoAdapter(productos, this);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(productoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        productoAdapter.setProductos(MainActivity.getLista());
        this.productoAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        List<ProductoModel> lista = (List<ProductoModel>) msg.obj;
        Log.d("TamañoLista", String.valueOf(lista.size()));
        Log.d("Lista", lista.toString());

        for (int i = 0; i < lista.size(); i++) {
            productos.add(new ProductoModel(lista.get(i).getNombre(), lista.get(i).getCantidad(), lista.get(i).getPrecio()));
        }

        productoAdapter = new ProductoAdapter(productos, this);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(productoAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
        return false;
    }

    public void seleccionarProducto(int index) {
        List<ProductoModel> productos = MainActivity.getLista();
        ProductoModel producto = productos.get(index);
        Intent intent = new Intent(this, EditActivity.class);

        intent.putExtra("index", index);
        startActivity(intent);
    }


}