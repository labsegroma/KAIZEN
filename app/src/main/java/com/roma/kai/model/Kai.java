package com.roma.kai.model;

public class Kai {
    private int nivel;
    private String estadoEmocional;
    private String mensajeActual;

    public Kai(int nivel, String estadoEmocional, String mensajeActual) {
        this.nivel = nivel;
        this.estadoEmocional = estadoEmocional;
        this.mensajeActual = mensajeActual;
    }

    public int getNivel() { return nivel; }
    public String getEstadoEmocional() { return estadoEmocional; }
    public String getMensajeActual() { return mensajeActual; }
}
