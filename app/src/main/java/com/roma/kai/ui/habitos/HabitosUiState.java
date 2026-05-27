package com.roma.kai.ui.habitos;

import com.roma.kai.model.dto.DailyProgress;
import com.roma.kai.model.dto.UserHabitResponse;

import java.util.List;

public class HabitosUiState {
    private boolean loading;
    private boolean success;
    private DailyProgress progresoDiario;
    private List<UserHabitResponse> habitosUsuario;

    public HabitosUiState(boolean loading, boolean success, DailyProgress progresoDiario, List<UserHabitResponse> habitosUsuario) {
        this.loading = loading;
        this.success = success;
        this.progresoDiario = progresoDiario;
        this.habitosUsuario = habitosUsuario;
    }

    public boolean isLoading() {
        return loading;
    }

    public boolean isSuccess() {
        return success;
    }

    public DailyProgress getProgresoDiario() {
        return progresoDiario;
    }

    public List<UserHabitResponse> getHabitosUsuario() {
        return habitosUsuario;
    }
}
