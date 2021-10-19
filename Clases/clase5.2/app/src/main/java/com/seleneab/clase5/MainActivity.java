package com.seleneab.clase5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Persona> personas = new ArrayList<>();
    private PersonaAdapter personaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle("Clase 5");
        actionBar.setDisplayHomeAsUpEnabled(true);

        personas.add(new Persona("Carlos", "Adolfo"));
        personas.add(new Persona("Juana", "Perez"));
        personas.add(new Persona("Martin", "Perez"));
        personas.add(new Persona("Isak", "De Leo"));

        personaAdapter = new PersonaAdapter(personas);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(personaAdapter);

        Context context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
//        a medida que voy escribiendo se va pasando, y al apretar la lupa se ejecuta el onquery text
        MenuItem menuItem = menu.findItem(R.id.opSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.op1) {
            Log.d("Click", "Se hizo click en la op1!");
        } else if (item.getItemId() == R.id.op2) {
            Log.d("Click", "Se hizo click en la op2!");
//      porque es un id creado por android, no por nosotros
        } else if ((item.getItemId() == android.R.id.home)) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
//        cuando se hace enter
        Log.d("onQueryTextSubmit", query);
        List<Persona> auxList = new ArrayList<Persona>();
//      se fija el nombre y el apellido
        for (Persona auxPersona : this.personas) {
            if (auxPersona.getNombre().contains(query) || auxPersona.getApellido().contains(query)) {
                auxList.add(auxPersona);
            }
        }
//      y le notifica del cambio
        personaAdapter.setPersonas(auxList);
        personaAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
//    cuando hay modificaciones
    public boolean onQueryTextChange(String newText) {
        Log.d("OnQueryTextChange", newText);
        return false;
    }
}