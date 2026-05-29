package com.roma.kai.ui.habitos.selectCategoria.addHabito;

import com.roma.kai.model.dto.HabitoCatalogoDto;
import java.util.List;

public class ListaHabitosCategoriaUiState {
    private final boolean isLoading;
    private final boolean isSuccess;
    private final boolean isSelectSuccess;
    private final List<HabitoCatalogoDto> habitos;

    public ListaHabitosCategoriaUiState(boolean isLoading, boolean isSuccess, boolean isSelectSuccess, List<HabitoCatalogoDto> habitos) {
        this.isLoading = isLoading;
        this.isSuccess = isSuccess;
        this.isSelectSuccess = isSelectSuccess;
        this.habitos = habitos;
    }

    public boolean isLoading() { return isLoading; }
    public boolean isSuccess() { return isSuccess; }
    public boolean isSelectSuccess() { return isSelectSuccess; }
    public List<HabitoCatalogoDto> getHabitos() { return habitos; }
}
