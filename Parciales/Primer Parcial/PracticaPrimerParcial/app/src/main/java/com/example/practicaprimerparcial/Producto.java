package com.example.practicaprimerparcial;

import java.util.Objects;

public class Producto {
    private String nombre;
    private Integer cantidad;
    private Float precio;

    public Producto(String nombre, Integer cantidad, Float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(getNombre(), producto.getNombre()) &&
                Objects.equals(getCantidad(), producto.getCantidad()) &&
                Objects.equals(getPrecio(), producto.getPrecio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getCantidad(), getPrecio());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
