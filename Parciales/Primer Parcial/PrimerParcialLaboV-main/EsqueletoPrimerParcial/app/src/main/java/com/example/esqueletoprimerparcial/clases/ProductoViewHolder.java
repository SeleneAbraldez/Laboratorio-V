package com.example.esqueletoprimerparcial.clases;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esqueletoprimerparcial.MainActivity;
import com.example.esqueletoprimerparcial.R;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvNombre;
    public TextView tvCantidad;
    public TextView tvPrecio;
    public MainActivity mainActivity;
    public int indice = 0;


    public ProductoViewHolder(MainActivity mainActivity, @NonNull View itemView) {
        super(itemView);
        tvNombre = itemView.findViewById(R.id.tvTitle);
        tvCantidad = itemView.findViewById(R.id.tvCantidad);
        tvPrecio = itemView.findViewById(R.id.tvPrecio);


        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        this.mainActivity.funcionRara(this.indice);
    }
}
