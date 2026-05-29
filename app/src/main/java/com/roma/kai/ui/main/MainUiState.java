package com.roma.kai.ui.main;

import com.roma.kai.model.entity.UsuarioEntity;
import com.roma.kai.utils.Event;

public class MainUiState {
    private final boolean loading;
    private final boolean success;
    private final UsuarioEntity usuario;

    public MainUiState(boolean loading, boolean success, UsuarioEntity usuario) {
        this.loading = loading;
        this.success = success;
        this.usuario = usuario;
    }

    public boolean isLoading() {
        return loading;
    }

    public boolean isSuccess() {
        return success;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }
}
