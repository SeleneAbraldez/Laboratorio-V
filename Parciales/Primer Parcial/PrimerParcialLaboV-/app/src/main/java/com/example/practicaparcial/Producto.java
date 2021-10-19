package com.example.practicaparcial;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Producto {

    private String nombre;
    private int cantidad;
    private int precioUnitario;

    public Producto(String nombre, int cantidad, int precioUnitario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(getNombre(), producto.getNombre()) &&
                Objects.equals(getCantidad(), producto.getCantidad()) &&
                Objects.equals(getPrecioUnitario(), producto.getPrecioUnitario());
    }


}
