package com.seleneab.rppabraldez;

import java.util.Objects;

public class AutoModel {
    private String modelo;
    private String marca;
    private Integer anio;

    public AutoModel(String modelo, String marca, Integer anio) {
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
    }

    public AutoModel(){
    }

    public String getNModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoModel producto = (AutoModel) o;
        return Objects.equals(modelo, producto.modelo) &&
                Objects.equals(marca, producto.marca) &&
                Objects.equals(anio, producto.anio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, anio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "modelo='" + modelo + '\'' +
                ", marca=" + marca +
                ", anio=" + anio +
                '}';
    }
}
