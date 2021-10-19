package com.example.repasorecycleview;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView tvNombre;
    public TextView tvApellido;
    public MainActivity mainActivity;
    public int indice=0;


    public PersonaViewHolder(MainActivity mainActivity,@NonNull View itemView) {
        super(itemView);
        tvNombre=itemView.findViewById(R.id.tvNombre);
        tvApellido=itemView.findViewById(R.id.tvApellido);
        this.mainActivity=mainActivity;
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        this.mainActivity.llamarPorTelefono(this.indice);
    }

}
