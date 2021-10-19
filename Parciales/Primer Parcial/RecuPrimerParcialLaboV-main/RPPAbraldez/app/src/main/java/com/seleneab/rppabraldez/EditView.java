package com.seleneab.rppabraldez;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditView {
    private EditActivity activity;
    private AutoModel autoModeloMVC;    //antes se llamaba solo modelo solo pero termino con este nomrbe para no confurdirme que es el model del patron y no el modelo del auto lol
    private EditText etModelo;
    private EditText etMarca;
    private Spinner spAnio;
    private int index;

    public EditView(EditActivity activity, AutoModel modelo, int index) {
        this.activity = activity;
        this.autoModeloMVC = modelo;
        Button btnGuardar = activity.findViewById(R.id.btnEditar);
        btnGuardar.setOnClickListener(new EditController(activity, modelo, index, this));
        this.index = index;
    }

    public void cargarModelo() {
        int i;
        etModelo = activity.findViewById(R.id.inputModelo);
        etMarca = activity.findViewById(R.id.inputMarca);
        spAnio = activity.findViewById(R.id.inputAnio);

        etModelo.setText(autoModeloMVC.getNModelo());
        etMarca.setText(autoModeloMVC.getMarca());
        for (i = 0; i < spAnio.getCount(); i++) {
            if (spAnio.getItemAtPosition(i).toString().equalsIgnoreCase(autoModeloMVC.getAnio().toString())) {
                spAnio.setSelection(i);
            }
        }

    }

    public void refrescarModelo() {
        autoModeloMVC.setModelo(etModelo.getText().toString());
        autoModeloMVC.setMarca(etMarca.getText().toString());
        autoModeloMVC.setAnio(Integer.valueOf(spAnio.getSelectedItem().toString()));
    }

}
