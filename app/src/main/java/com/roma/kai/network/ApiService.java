package com.roma.kai.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // --- Autenticación ---
    @FormUrlEncoded
    @POST("api/v1/auth/login")
    Call<String> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/v1/auth/register")
    Call<Void> register(@Field("nombre") String nombre, @Field("email") String email, @Field("password") String password);

    // PETICION RAPIDA PARA VERIFICAR EL TOKEN VIVO
    @GET("api/urlcualquiera")
    Call<Void> verificarSession();
}
