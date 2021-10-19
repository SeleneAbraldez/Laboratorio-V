package com.example.esqueletoprimerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.esqueletoprimerparcial.clases.ProductoModel;
import com.example.esqueletoprimerparcial.clases.ProductoAdapter;
import com.example.esqueletoprimerparcial.servicios.Servicio;

public class MainActivity extends AppCompatActivity {

    Servicio servicio=Servicio.getInstancia();
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicio.agregarElemento(new ProductoModel("Celulares",Integer.valueOf(25),Float.valueOf(5452)));
        servicio.agregarElemento(new ProductoModel("Cajas",Integer.valueOf(250),Float.valueOf(45)));
        servicio.agregarElemento(new ProductoModel("Cables usb",Integer.valueOf(120),Float.valueOf(150)));
        servicio.agregarElemento(new ProductoModel("Cargadores",Integer.valueOf(54),Float.valueOf(350)));
        servicio.agregarElemento(new ProductoModel("Film de vidrios",Integer.valueOf(1024),Float.valueOf(200)));

        productoAdapter= new ProductoAdapter(this,servicio.getLista());
        RecyclerView recyclerView= super.findViewById(R.id.myRecyclerView);
        recyclerView.setAdapter(productoAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);



    }



    @Override
    protected void onResume() {
        super.onResume();
        productoAdapter.setProductos(servicio.getLista());
        this.productoAdapter.notifyDataSetChanged();
    }

    public void funcionRara(int posProducto) {
        ProductoModel producto = this.servicio.getLista().get(posProducto);
        Intent intent = new Intent(this,DetalleDeProductoActivity.class);



        intent.putExtra("position",posProducto);
        startActivity(intent);


    }

}
