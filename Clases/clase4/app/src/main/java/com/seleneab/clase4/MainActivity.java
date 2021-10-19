package com.seleneab.clase4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<Persona> personas = new ArrayList<>();
    private PersonaAdapter personaAdapter;

    public static List<Persona> getListaPersonas() {
        return personas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 10; i < 40; i++) {
            personas.add(new Persona("Nombre" + i, "Apellido" + i));
        }

        PersonaAdapter personaAdapter = new PersonaAdapter(personas, this);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(personaAdapter);

        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
    }

    public void llamarPorTelefono(int posPersona) {
        Persona p = this.personas.get(posPersona);
        Log.d("Llamando a ", p.getApellido());
    }

}