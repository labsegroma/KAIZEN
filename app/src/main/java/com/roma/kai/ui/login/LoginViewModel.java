package com.roma.kai.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.roma.kai.network.ApiService;
import com.roma.kai.network.RetrofitClient;
import com.roma.kai.session.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    private ApiService apiService;
    private SessionManager sessionManager;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        apiService = RetrofitClient.getService(application);
        sessionManager = SessionManager.getInstance(application);
    }

    public void login(String email, String password) {
        //validar

        Call<String> call = apiService.login(email, password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful() && response.body() != null) {
                    sessionManager.saveToken(response.body());
                    //crear intent y enviar a HOME
                } else {
                    //mostrar msg de error
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                //mostrar msg de error
            }
        });
    }
}
