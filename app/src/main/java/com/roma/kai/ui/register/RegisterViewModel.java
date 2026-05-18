package com.roma.kai.ui.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.roma.kai.network.ApiService;
import com.roma.kai.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends AndroidViewModel {
    private ApiService apiService;
    public RegisterViewModel(@NonNull Application application) {
        super(application);
        apiService = RetrofitClient.getService(application);
    }

    public void registrar(String nombre, String email, String password) {
        //validar

        Call<Void> call = apiService.register(nombre, email, password);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    //crear intent y enviar a LOGIN
                } else {
                    //mostrar msg de error
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                //mostrar msg de error
            }
        });
    }
}
