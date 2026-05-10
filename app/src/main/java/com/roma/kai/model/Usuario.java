package com.roma.kai.model;

public class Usuario {
    private String nombre;
    private String email;
    private int nivel;
    private int xpTotal;
    private int rachaActual;

    public Usuario(String nombre, String email, int nivel, int xpTotal, int rachaActual) {
        this.nombre = nombre;
        this.email = email;
        this.nivel = nivel;
        this.xpTotal = xpTotal;
        this.rachaActual = rachaActual;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getNivel() { return nivel; }
    public int getXpTotal() { return xpTotal; }
    public int getRachaActual() { return rachaActual; }
}
