package com.example.practicaprimerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final List<Producto> productos=new ArrayList<Producto>();

    public static  List<Producto> obtenerLista(){
        return  productos;
    }
    private ProductoAdapter productoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos.add(new Producto("Celulares",Integer.valueOf(25),Float.valueOf(5452)));
        productos.add(new Producto("Cajas",Integer.valueOf(250),Float.valueOf(45)));
        productos.add(new Producto("Cables usb",Integer.valueOf(120),Float.valueOf(150)));
        productos.add(new Producto("Cargadores",Integer.valueOf(54),Float.valueOf(350)));
        productos.add(new Producto("Film de vidrios",Integer.valueOf(1024),Float.valueOf(200)));




        productoAdapter= new ProductoAdapter(this,productos);
        RecyclerView recyclerView= super.findViewById(R.id.myRecyclerView);
        recyclerView.setAdapter(productoAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);



    }
    public void controlDeStock(int indice,int idBtn) {
        List<Producto> productos=MainActivity.obtenerLista();
        Producto producto;
        switch (idBtn)
        {
            case R.id.btnSumar:

                producto= productos.get(indice);
                producto.setCantidad( producto.getCantidad()+1);
                productos.set(indice,producto);

                break;
            case R.id.btnRestar:
                producto= productos.get(indice);
                producto.setCantidad( producto.getCantidad()-1);
                productos.set(indice,producto);
                Log.d("PRODUCTO", productos.get(indice).toString());
                break;
            case R.id.btnEditar:
                DialogGenerico dialog = new DialogGenerico(productoAdapter,"Administrador de productos","Ingresa el nuevo nombre",true,false,true,indice);
                dialog.show(getSupportFragmentManager(),"onOptionItemSelected desde aca");
                break;
        }

        productoAdapter.setPersonas(productos);
        productoAdapter.notifyDataSetChanged();



    }

}
