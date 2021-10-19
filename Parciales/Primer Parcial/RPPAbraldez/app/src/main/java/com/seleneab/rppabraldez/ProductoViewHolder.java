package com.seleneab.rppabraldez;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tvNombre;
    public TextView tvPrecio;
    public TextView tvCantidad;

    public MainActivity mainActivity;
    public int index = 0;

    public ProductoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvNombreProd);
        tvPrecio = itemView.findViewById(R.id.tvPrecio);
        tvCantidad = itemView.findViewById(R.id.tvCantidad);

        //listener en toda view para cuando haga click para editar datos
        itemView.setOnClickListener(this);

        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        this.mainActivity.seleccionarProducto(this.index);
    }
}

