package com.example.repasorecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class agregarContactoActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Persona> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

         lista= MainActivity.obtenerLista();

        Button btnGuardar= this.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        EditText nameInput = this.findViewById(R.id.inputName);
        EditText lastName = this.findViewById(R.id.inputLastName);
        Persona  persona=new Persona(nameInput.getText().toString(),lastName.getText().toString());

        lista.add(persona);
        Log.d("Hasta aca estamos ", "onClick: "+persona.getNombre());
        this.finish();
    }
}
