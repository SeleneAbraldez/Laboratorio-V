package com.seleneab.ppabraldezpractica;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class ClickDialogEditarNombreListener implements DialogInterface.OnClickListener {
    private int index;
    private View view;
    private ProductoAdapter adapter;

    public ClickDialogEditarNombreListener(int indexPasado, View view, ProductoAdapter adapter) {
        this.index = indexPasado;
        this.view = view;
        this.adapter = adapter;
    }

    @Override
    public void onClick(DialogInterface dialog, int boton) {
        List<Producto> productos = MainActivity.getLista();
        Producto productoSelec = productos.get(this.index);
        EditText editTitulo = this.view.findViewById(R.id.inputNombre);
        String nuevoNombre = editTitulo.getText().toString();

        if (boton == -1) { //si es la interaccion positiva
            productoSelec.setNombre(nuevoNombre);
            this.adapter.setProductos(productos);
            this.adapter.notifyDataSetChanged();
        }


    }
}
