package com.seleneab.rppabraldez;

import android.widget.Button;
import android.widget.EditText;

public class EditView {
    private EditActivity activity;
    private ProductoModel modelo;
    private EditText etNombre;
    private EditText etCantidad;
    private EditText etPrecio;
    private int index;

    public EditView(EditActivity activity, ProductoModel modelo, int index) {
        this.activity = activity;
        this.modelo = modelo;
        Button btnGuardar = activity.findViewById(R.id.btnEditar);
        btnGuardar.setOnClickListener(new EditController(activity, modelo, index, this));
        this.index = index;
    }

    public void cargarModelo() {
        etNombre = activity.findViewById(R.id.inputNombreProducto);
        etCantidad = activity.findViewById(R.id.inputCantidad);
        etPrecio = activity.findViewById(R.id.inputPrecio);

        etNombre.setText(modelo.getNombre());
        etCantidad.setText(modelo.getCantidad().toString());
        etPrecio.setText(modelo.getPrecio().toString());
    }

    public void refrescarModelo() {
        modelo.setNombre(etNombre.getText().toString());
        modelo.setCantidad(Integer.valueOf(etCantidad.getText().toString()));
        modelo.setPrecio(Float.valueOf(etPrecio.getText().toString()));
    }

}
