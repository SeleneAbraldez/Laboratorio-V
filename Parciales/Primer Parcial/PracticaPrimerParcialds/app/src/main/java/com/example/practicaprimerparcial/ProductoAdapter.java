package com.example.practicaprimerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter<PersonaViewHolder> extends RecyclerView.Adapter<ProductoViewHolder>  {

    private List<Producto> productos;
    private MainActivity mainActivity;

    public void setPersonas(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getPersonas() {
        return productos;
    }
    public ProductoAdapter(MainActivity mainActivity,List<Producto> productos){
        this.mainActivity=mainActivity;
        this.productos=productos;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,
                false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(mainActivity,view);
        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.tvNombre.setText(productos.get(position).getNombre());
        holder.tvCantidad.setText("Cantidad: "+productos.get(position).getCantidad().toString());
        holder.tvPrecio.setText("Precio por unidad: $"+productos.get(position).getPrecio().toString());
        holder.indice=position;
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
