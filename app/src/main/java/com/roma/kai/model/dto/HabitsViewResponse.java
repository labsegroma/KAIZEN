package com.roma.kai.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HabitsViewResponse {
    @SerializedName("progreso_diario")
    private DailyProgress progresoDiario;
    @SerializedName("habitos_usuario")
    private List<UserHabitResponse> habitosUsuario;

    public HabitsViewResponse(DailyProgress progresoDiario, List<UserHabitResponse> habitosUsuario) {
        this.progresoDiario = progresoDiario;
        this.habitosUsuario = habitosUsuario;
    }

    public DailyProgress getProgresoDiario() {
        return progresoDiario;
    }

    public List<UserHabitResponse> getHabitosUsuario() {
        return habitosUsuario;
    }
}
