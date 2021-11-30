package com.example.proyectofinaloribe;

public class Gaseosa {

    private int imagen;
    private String nombre;
    private String descripcion;
    private float precio;

    public Gaseosa(int imagen, String nombre, String descripcion, float precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
