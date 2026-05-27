package com.roma.kai.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class UserHabitResponse {
    @SerializedName("habito_usuario_id")
    private String habitoUsuarioId;
    @SerializedName("habito_catalogo_id")
    private String habitoCatalogoId;
    private String nombre;
    private String descripcion;
    private String categoria;
    @SerializedName("tipo_cuidado")
    private String tipoCuidado;
    private String dificultad;
    @SerializedName("xp_base")
    private int xpBase;
    private boolean personalizado;
    private boolean activo;
    @SerializedName("fecha_inicio")
    private String fechaInicio;
    @SerializedName("imagen_habito")
    private String imagenHabito;
    @SerializedName("completado_hoy")
    private boolean completadoHoy;
    @SerializedName("xp_total")
    private int xpTotal;
    @SerializedName("racha_actual")
    private int rachaActual;

    public UserHabitResponse(String habitoUsuarioId, String habitoCatalogoId, String nombre, String descripcion, String categoria, String tipoCuidado, String dificultad, int xpBase, boolean personalizado, boolean activo, String fechaInicio, String imagenHabito, boolean completadoHoy, int xpTotal, int rachaActual) {
        this.habitoUsuarioId = habitoUsuarioId;
        this.habitoCatalogoId = habitoCatalogoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipoCuidado = tipoCuidado;
        this.dificultad = dificultad;
        this.xpBase = xpBase;
        this.personalizado = personalizado;
        this.activo = activo;
        this.fechaInicio = fechaInicio;
        this.imagenHabito = imagenHabito;
        this.completadoHoy = completadoHoy;
        this.xpTotal = xpTotal;
        this.rachaActual = rachaActual;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserHabitResponse that = (UserHabitResponse) o;
        return xpBase == that.xpBase && personalizado == that.personalizado && activo == that.activo && completadoHoy == that.completadoHoy && xpTotal == that.xpTotal && rachaActual == that.rachaActual && Objects.equals(habitoUsuarioId, that.habitoUsuarioId) && Objects.equals(habitoCatalogoId, that.habitoCatalogoId) && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(categoria, that.categoria) && Objects.equals(tipoCuidado, that.tipoCuidado) && Objects.equals(dificultad, that.dificultad) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(imagenHabito, that.imagenHabito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitoUsuarioId, habitoCatalogoId, nombre, descripcion, categoria, tipoCuidado, dificultad, xpBase, personalizado, activo, fechaInicio, imagenHabito, completadoHoy, xpTotal, rachaActual);
    }

    public String getHabitoUsuarioId() {
        return habitoUsuarioId;
    }

    public String getHabitoCatalogoId() {
        return habitoCatalogoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipoCuidado() {
        return tipoCuidado;
    }

    public String getDificultad() {
        return dificultad;
    }

    public int getXpBase() {
        return xpBase;
    }

    public boolean isPersonalizado() {
        return personalizado;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getImagenHabito() {
        return imagenHabito;
    }

    public boolean isCompletadoHoy() {
        return completadoHoy;
    }

    public int getXpTotal() {
        return xpTotal;
    }

    public int getRachaActual() {
        return rachaActual;
    }
}
