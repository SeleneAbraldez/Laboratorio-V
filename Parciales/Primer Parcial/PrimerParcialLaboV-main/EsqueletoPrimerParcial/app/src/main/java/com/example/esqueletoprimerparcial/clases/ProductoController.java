package com.example.esqueletoprimerparcial.clases;

import android.util.Log;
import android.view.View;

import com.example.esqueletoprimerparcial.DetalleDeProductoActivity;
import com.example.esqueletoprimerparcial.servicios.Servicio;

public class ProductoController implements  View.OnClickListener{
    private DetalleDeProductoActivity activity;
    private ProductoModel modelo;
    private Servicio servicio=Servicio.getInstancia();
    private int indice;
    private  ProductoView view;

    public ProductoController(DetalleDeProductoActivity activity,ProductoModel modelo,int indice,ProductoView view){
        this.activity=activity;
        this.modelo=modelo;
        this.indice=indice;
        this.view=view;
    }

    @Override
    public void onClick(View v) {
        view.leerModelo();
        Log.d("Hasta aca estamos ", "onClick: "+modelo.getNombre());
        servicio.editarElemento(indice,modelo);

        activity.finish();
    }


    //validaciones//logica//manejadores
}
