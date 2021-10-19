package com.seleneab.rppabraldez;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvModelo;
    public TextView tvMarca;

    public MainActivity mainActivity;
    public int index = 0;

    public AutoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);

        tvModelo = itemView.findViewById(R.id.tvModelo);
        tvMarca = itemView.findViewById(R.id.tvMarca);

        //listener en toda view para cuando haga click para editar datos
        itemView.setOnClickListener(this);

        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        this.mainActivity.seleccionarAuto(this.index);
    }
}

