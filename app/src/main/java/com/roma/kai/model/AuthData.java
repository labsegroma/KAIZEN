package com.roma.kai.model;

public class AuthData {
    private String token;
    private Usuario usuario;

    public AuthData(Usuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public AuthData() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
