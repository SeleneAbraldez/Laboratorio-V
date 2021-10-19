package com.seleneab.rppabraldez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoViewHolder> {
    private List<AutoModel> autos;
    private MainActivity mainActivity;

    public AutoAdapter(List<AutoModel> autos, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.autos = autos;
    }

    public void setProductos(List<AutoModel> productos) {
        this.autos = productos;
    }

    @NonNull
    @Override
    public AutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_autos, parent, false);
        AutoViewHolder autoViewHolder = new AutoViewHolder(v, mainActivity);
        return autoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AutoViewHolder holder, int position) {
        holder.tvModelo.setText(autos.get(position).getNModelo());
        holder.tvMarca.setText(autos.get(position).getMarca());
        holder.index = position;
    }

    @Override
    public int getItemCount() {
        return this.autos.size();
    }


}
