package com.seleneab.ppabraldezpractica;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView tvNombre;
    public TextView tvPrecio;
    public TextView tvCantidad;

    public Button btEditar;
    public Button btRestar;
    public Button btSumar;

    public MainActivity mainActivity;
    public int index = 0;


    public ProductoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvNombreProd);
        tvPrecio = itemView.findViewById(R.id.tvPrecio);
        tvCantidad = itemView.findViewById(R.id.tvCantidad);

        btEditar = itemView.findViewById(R.id.btEditar);
        btSumar = itemView.findViewById(R.id.btmas);
        btRestar = itemView.findViewById(R.id.btmenos);

        btEditar.setOnClickListener(this);
        btSumar.setOnClickListener(this);
        btRestar.setOnClickListener(this);

        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        this.mainActivity.controlStock(v.getId(), this.index);
    }
}
