package com.example.repasorecycleview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {
    // se lo pasamos en un seter!

    public List<Persona> getPersonas() {
        return personas;
    }

    private List<Persona> personas;

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    private MainActivity mainActivity;
    public PersonaAdapter(MainActivity mainActivity,List<Persona> personas){
        this.mainActivity=mainActivity;
        this.personas=personas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,
                false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(mainActivity,view);
        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvApellido.setText(personas.get(position).getApellido());
        holder.indice=position;

    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
