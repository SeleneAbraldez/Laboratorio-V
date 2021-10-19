package com.seleneab.ppabraldezpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AgregarProductoActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Producto> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        lista = MainActivity.getLista();

        Button btnGuardar = this.findViewById(R.id.btnGuardar);
        Button btnCancelar = this.findViewById(R.id.btnCancelar);
        btnGuardar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnGuardar){
            EditText nombre = this.findViewById(R.id.inputNombre);
            EditText cantidad = this.findViewById(R.id.inputCantidad);
            EditText precio = this.findViewById(R.id.inputPrecio);
            Producto producto = new Producto(nombre.getText().toString(), Integer.valueOf(cantidad.getText().toString()), Float.valueOf(precio.getText().toString()));

            lista.add(producto);
        }

        this.finish();
    }

}
