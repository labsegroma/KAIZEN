package com.roma.kai.ui.login;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.roma.kai.model.AuthData;
import com.roma.kai.model.LoginRequest;
import com.roma.kai.model.RegisterRequest;
import com.roma.kai.model.ResponseData;
import com.roma.kai.network.ApiService;
import com.roma.kai.network.RetrofitClient;
import com.roma.kai.session.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    private final ApiService apiService;
    private final SessionManager sessionManager;
    private final MutableLiveData<Boolean> navigateToHome = new MutableLiveData<>();
    public LoginViewModel(@NonNull Application application) {
        super(application);
        apiService = RetrofitClient.getService(application);
        sessionManager = SessionManager.getInstance(application);
    }

    public LiveData<Boolean> getNavigateToHome() {
        return navigateToHome;
    }

    public void login(String email, String password) {
        //validar

        LoginRequest loginRequest = new LoginRequest(email, password);
        Call<ResponseData<AuthData>> call = apiService.login(loginRequest);
        call.enqueue(new Callback<ResponseData<AuthData>>() {
            @Override
            public void onResponse(Call<ResponseData<AuthData>> call, Response<ResponseData<AuthData>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    sessionManager.saveToken(response.body().getData().getToken());
                    navigateToHome.postValue(true);
                    // que hacemos con el usuario???
                }
            }

            @Override
            public void onFailure(Call<ResponseData<AuthData>> call, Throwable throwable) {
                Log.d("ERRORR", throwable.getMessage());
            }
        });
    }
}
