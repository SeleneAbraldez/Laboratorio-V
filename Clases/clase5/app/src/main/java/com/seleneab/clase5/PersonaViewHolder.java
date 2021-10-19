package com.seleneab.clase5;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder {
    public TextView tvApellido;
    public TextView tvNombre;

    public PersonaViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvNombre);
        tvApellido = itemView.findViewById(R.id.tvApellido);
    }
}
