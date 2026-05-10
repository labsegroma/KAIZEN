package com.roma.kai.model;

public class Habito {
    private String nombre;
    private String categoria;
    private boolean completado;

    public Habito(String nombre, String categoria, boolean completado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.completado = completado;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}
