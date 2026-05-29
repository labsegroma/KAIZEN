package com.roma.kai.model.dto;

import com.google.gson.annotations.SerializedName;

public class CategoriaDto {
    private String id;
    private String nombre;
    private String descripcion;
    @SerializedName("imagen_categoria")
    private String imagenCategoria;

    public CategoriaDto() {}

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

    public String getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(String imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }
}
