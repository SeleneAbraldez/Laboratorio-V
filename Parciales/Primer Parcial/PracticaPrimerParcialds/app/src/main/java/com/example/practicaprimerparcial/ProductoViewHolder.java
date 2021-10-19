package com.example.practicaprimerparcial;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvNombre;
    public TextView tvCantidad;
    public TextView tvPrecio;
    public Button btnRestar;
    public Button btnSumar;
    public Button btnEditar;
    public MainActivity mainActivity;
    public int indice = 0;


    public ProductoViewHolder(MainActivity mainActivity, @NonNull View itemView) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvTitle);
        tvCantidad = itemView.findViewById(R.id.tvCantidad);
        tvPrecio = itemView.findViewById(R.id.tvPrecio);

          btnRestar=itemView.findViewById(R.id.btnRestar);
          btnSumar=itemView.findViewById(R.id.btnSumar);
          btnEditar=itemView.findViewById(R.id.btnEditar);

        this.mainActivity = mainActivity;

        btnRestar.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
       this.mainActivity.controlDeStock(this.indice,v.getId());
    }
}