package com.roma.kai.network;

import com.roma.kai.model.AuthData;
import com.roma.kai.model.LoginRequest;
import com.roma.kai.model.RegisterRequest;
import com.roma.kai.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // --- Autenticación ---
    @POST("api/v1/auth/login")
    Call<ResponseData<AuthData>> login(@Body LoginRequest loginRequest);

    @POST("api/v1/auth/register")
    Call<ResponseData<AuthData>> register(@Body RegisterRequest registerRequest);

    // PETICION RAPIDA PARA VERIFICAR EL TOKEN VIVO
    @GET("api/urlcualquiera")
    Call<Void> verificarSession();
}
