package com.example.esqueletoprimerparcial.clases;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.esqueletoprimerparcial.DetalleDeProductoActivity;
import com.example.esqueletoprimerparcial.MainActivity;
import com.example.esqueletoprimerparcial.R;
import com.example.esqueletoprimerparcial.servicios.Servicio;

public class ProductoView {
    private DetalleDeProductoActivity activity;
    Servicio servicio=Servicio.getInstancia();
    private ProductoModel modelo;
    EditText editTextNombre;
    EditText editTextCantidad;
    EditText editTextPrecio;
    int position;

    public ProductoView(DetalleDeProductoActivity activity, ProductoModel modelo,int position) {
        this.activity=activity;
        this.modelo=modelo;
        Button btnGuardar= activity.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new ProductoController(activity,modelo,position,this));
       // btnGuardar.setOnClickListener(this);

        this.position=position;
    }

    public void cargarModelo(){
         editTextNombre=activity.findViewById(R.id.inputNombreProducto);
         editTextCantidad=activity.findViewById(R.id.inputCantidad);
         editTextPrecio=activity.findViewById(R.id.inputPrecio);


        editTextNombre.setText(modelo.getNombre());
        editTextCantidad.setText(modelo.getCantidad().toString());
        editTextPrecio.setText(modelo.getPrecio().toString());
    }
    public void leerModelo(){
        editTextNombre=activity.findViewById(R.id.inputNombreProducto);
        editTextCantidad=activity.findViewById(R.id.inputCantidad);
        editTextPrecio=activity.findViewById(R.id.inputPrecio);


        this.modelo.setNombre(editTextNombre.getText().toString());
        this.modelo.setCantidad(Integer.valueOf(editTextCantidad.getText().toString()));
        this.modelo.setPrecio(Float.valueOf(editTextPrecio.getText().toString()));


    }

}
