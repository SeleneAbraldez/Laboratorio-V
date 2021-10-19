package com.example.esqueletoprimerparcial.servicios;

import com.example.esqueletoprimerparcial.clases.ProductoModel;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private static Servicio servicio;
    private List<ProductoModel> lista;

    private Servicio() {
        this.lista = new ArrayList<ProductoModel>();
    }

    public static Servicio getInstancia() {
        if (servicio == null) {
            return servicio = new Servicio();
        }
        return servicio;
    }

    public void agregarElemento(ProductoModel producto) {
        lista.add(producto);
    }

    public void cargarLista(List<ProductoModel> auxLista) {
        lista = auxLista;
    }

    public List<ProductoModel> getLista() {
        return lista;
    }

    public void editarElemento(int indice, ProductoModel producto) {
        lista.set(indice, producto);
    }

}