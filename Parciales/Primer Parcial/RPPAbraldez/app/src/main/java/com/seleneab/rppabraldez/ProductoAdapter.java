package com.seleneab.rppabraldez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    private List<ProductoModel> productos;
    private MainActivity mainActivity;

    public ProductoAdapter(List<ProductoModel> productos, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.productos = productos;
    }

    public void setProductos(List<ProductoModel> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_producto, parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(v, mainActivity);
        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.tvNombre.setText(productos.get(position).getNombre());
        holder.tvCantidad.setText(productos.get(position).getCantidad().toString());
        holder.tvPrecio.setText(productos.get(position).getPrecio().toString());
        holder.index = position;
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }


}
