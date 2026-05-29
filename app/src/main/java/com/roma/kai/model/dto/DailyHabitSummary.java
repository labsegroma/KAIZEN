package com.roma.kai.model.dto;

import com.google.gson.annotations.SerializedName;

public class DailyHabitSummary {
    @SerializedName("habito_usuario_id")
    private String id;
    private String nombre;
    private String categoria;
    private boolean completado;
    @SerializedName("imagen_habito")
    private String imagenHabito;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isCompletado() {
        return completado;
    }

    public String getImagenHabito() {
        return imagenHabito;
    }
}
