package com.example.repasorecycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final List<Persona> personas=new ArrayList<Persona>();

    public static  List<Persona> obtenerLista(){
        return  personas;
    }
private PersonaAdapter personaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas.add(new Persona("aJonathan1","Haedo"));
        personas.add(new Persona("bJonathan2","Haedo"));
        personas.add(new Persona("cJonathan3","Haedo"));
        personas.add(new Persona("dJonathan4","Haedo"));
        personas.add(new Persona("aJonathan1","Haedo"));

        personaAdapter = new PersonaAdapter(this,personas);
        RecyclerView recyclerView= super.findViewById(R.id.myRecyclerView);
        recyclerView.setAdapter(personaAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ActionBar actionBar=super.getSupportActionBar();//
        actionBar.setTitle("Contactos");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        personaAdapter.setPersonas(personas);
        this.personaAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);//llamo al inflate que recupera el menu.

        MenuItem menuItem = menu.findItem(R.id.opSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opSearch:
                break;
            case R.id.btnAddNewContact:
                Intent intent = new Intent(this,agregarContactoActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home:
                super.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void llamarPorTelefono(int posPersona) {
        Persona p = this.personas.get(posPersona);
        Log.d("PERSONA!", "Llamando a  " + p.getNombre());


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("onQueryTextSubmit", query);

        List<Persona> auxList=new ArrayList<Persona>();
        for(Persona auxPersona:this.personas){
            if(auxPersona.getNombre().contains(query)){
                auxList.add(auxPersona);
            }
        }
         personaAdapter.setPersonas(auxList);
         personaAdapter.notifyDataSetChanged();
        return false;

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("onQueryTextChange", newText);
        return false;
    }
}
