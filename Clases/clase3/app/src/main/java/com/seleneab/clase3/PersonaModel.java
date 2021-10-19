package com.seleneab.clase3;

//data de la aplicacion y reglas para usarla
public class PersonaModel {
    private String nombre;
    private String apellido;
    private String DNI;
    private String genero;

    public PersonaModel() {

    }

    public PersonaModel(String nombre, String apellido, String DNI, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "PersonaModel{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
