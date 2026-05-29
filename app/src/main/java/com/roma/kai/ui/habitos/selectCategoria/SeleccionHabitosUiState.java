package com.roma.kai.ui.habitos.selectCategoria;

import com.roma.kai.model.dto.CategoriaDto;
import java.util.List;

public class SeleccionHabitosUiState {
    private final boolean isLoading;
    private final boolean isSuccess;
    private final List<CategoriaDto> categorias;

    public SeleccionHabitosUiState(boolean isLoading, boolean isSuccess, List<CategoriaDto> categorias) {
        this.isLoading = isLoading;
        this.isSuccess = isSuccess;
        this.categorias = categorias;
    }

    public boolean isLoading() { return isLoading; }
    public boolean isSuccess() { return isSuccess; }
    public List<CategoriaDto> getCategorias() { return categorias; }
}
