package com.seleneab.clase4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {
    private List<Persona> personas;
    private MainActivity mainActivity;

    public PersonaAdapter(List<Persona> personas, MainActivity mainActivity) {
        this.personas = personas;
        this.mainActivity = mainActivity;
    }

    //representacion de un item pero para un viewholder
    //crear uno por cada item sin la informacion
    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //por cada tag de apertura genera una linea de apertura con el id para recuperar con el findxid
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(v);
        return personaViewHolder;
    }

    //bindiarle los datos, llenado la informacion
    //llenandolos en ell holder reciclando la view
    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvApellido.setText(personas.get(position).getApellido());
    }

    //cuantos tengo que dibujar
    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
