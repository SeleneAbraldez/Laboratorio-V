package com.seleneab.clase5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {
    private List<Persona> personas;

    public PersonaAdapter(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(v);
        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvApellido.setText(personas.get(position).getApellido());
    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
