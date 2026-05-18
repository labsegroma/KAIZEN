package com.roma.kai.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.roma.kai.network.ApiService;
import com.roma.kai.network.RetrofitClient;
import com.roma.kai.session.SessionManager;
import com.roma.kai.utils.SPManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseViewModel extends AndroidViewModel {
    private SessionManager sessionManager;
    private ApiService apiService;
    public BaseViewModel(@NonNull Application application) {
        super(application);
        apiService = RetrofitClient.getService(application);
        sessionManager = SessionManager.getInstance(application);
    }

    public void verificarSession() {
        String token = sessionManager.getToken();
        if(token == null || token.isEmpty()) {
            // crear un intent y enviar al LOGIN
            return;
        }

        Call<Void> call = apiService.verificarSession();
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    //crear un intent y enviar al HOME
                } else {
                    sessionManager.clearSession();
                    //crear un intent y enviar al LOGIN
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                sessionManager.clearSession();
                //crear un intent y enviar al LOGIN
            }
        });
    }
}
