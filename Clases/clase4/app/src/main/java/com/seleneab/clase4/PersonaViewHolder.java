package com.seleneab.clase4;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvApellido;
    public TextView tvNombre;
    private MainActivity mainActivity;
    private int indice;

    public PersonaViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvNombre);
        tvApellido = itemView.findViewById(R.id.tvApellido);
    }

    @Override
    public void onClick(View v) {
        Log.d("APrentando", "Hola");
        this.mainActivity.llamarPorTelefono(this.indice);
    }
}
