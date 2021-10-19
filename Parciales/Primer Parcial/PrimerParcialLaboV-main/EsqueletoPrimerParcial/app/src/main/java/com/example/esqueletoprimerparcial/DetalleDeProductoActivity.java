package com.example.esqueletoprimerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.esqueletoprimerparcial.clases.ProductoModel;
import com.example.esqueletoprimerparcial.clases.ProductoView;
import com.example.esqueletoprimerparcial.servicios.Servicio;

public class DetalleDeProductoActivity extends AppCompatActivity  {

    Servicio servicio= Servicio.getInstancia();
    ProductoView productoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_de_producto);
        Bundle bandle=super.getIntent().getExtras();

       ProductoModel producto= servicio.getLista().get(bandle.getInt("position"));
        productoView=new ProductoView(this,producto,bandle.getInt("position"));

        productoView.cargarModelo();


        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle("Modificar");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==16908332)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
