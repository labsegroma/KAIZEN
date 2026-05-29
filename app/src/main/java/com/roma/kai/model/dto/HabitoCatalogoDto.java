package com.roma.kai.model.dto;

import com.google.gson.annotations.SerializedName;

public class HabitoCatalogoDto {
    private String id;
    private String nombre;
    private String descripcion;
    private String categoria;
    @SerializedName("tipo_cuidado")
    private String tipoCuidado;
    private String dificultad;
    @SerializedName("xp_base")
    private int xpBase;
    @SerializedName("es_premium")
    private boolean esPremium;
    @SerializedName("imagen_habito")
    private String imagenHabito;
    @SerializedName("categoria_xp_id")
    private String categoriaXpId;

    public HabitoCatalogoDto() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoCuidado() {
        return tipoCuidado;
    }

    public void setTipoCuidado(String tipoCuidado) {
        this.tipoCuidado = tipoCuidado;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getXpBase() {
        return xpBase;
    }

    public void setXpBase(int xpBase) {
        this.xpBase = xpBase;
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public String getImagenHabito() {
        return imagenHabito;
    }

    public void setImagenHabito(String imagenHabito) {
        this.imagenHabito = imagenHabito;
    }

    public String getCategoriaXpId() {
        return categoriaXpId;
    }

    public void setCategoriaXpId(String categoriaXpId) {
        this.categoriaXpId = categoriaXpId;
    }
}
