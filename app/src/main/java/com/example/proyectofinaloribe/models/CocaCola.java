package com.example.proyectofinaloribe.models;

public class CocaCola {

    private int imagen;
    private String marca;
    private String nombre;
    private float precio;

    public CocaCola(int imagen, String marca, String nombre, float precio) {
        this.imagen = imagen;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
