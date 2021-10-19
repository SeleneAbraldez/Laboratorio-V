package com.seleneab.clase3;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ClickButton implements View.OnClickListener {
    private PersonaView view;
    private PersonaModel modelo;

    //recibe un objeto de la vista y la carga al modelo para
    public ClickButton(PersonaView view, PersonaModel modelo) {
        this.view = view;
        this.modelo = modelo;
    }

    //con cargar al modelo ya esta
    @Override
    public void onClick(View v) {
        this.view.cargarModelo();
        Log.d("Persona Ingresada", modelo.toString());
    }
}
