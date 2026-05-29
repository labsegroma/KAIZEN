package com.roma.kai.data.repository;

import android.util.Log;

import com.roma.kai.data.callback.RepositoryCallback;
import com.roma.kai.data.remote.ApiService;
import com.roma.kai.data.remote.error.ApiErrorParser;
import com.roma.kai.model.dto.CategoriaDto;
import com.roma.kai.model.dto.HabitoCatalogoDto;
import com.roma.kai.model.dto.HabitsViewResponse;
import com.roma.kai.model.request.SelectHabitRequest;
import com.roma.kai.model.response.ResponseData;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HabitosRepository {
    private final ApiService apiService;
    private final Gson gson = new Gson();

    public HabitosRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loadHabitsView(RepositoryCallback<HabitsViewResponse> callback) {
        Call<ResponseData<HabitsViewResponse>> call = apiService.getHabitsView();
        call.enqueue(new Callback<ResponseData<HabitsViewResponse>>() {
            @Override
            public void onResponse(Call<ResponseData<HabitsViewResponse>> call, Response<ResponseData<HabitsViewResponse>> response) {
                Log.d("API_RESPONSE", "HabitsView: " + gson.toJson(response.body()));
                if(response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onError(ApiErrorParser.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<ResponseData<HabitsViewResponse>> call, Throwable throwable) {
                callback.onError("Error de conexión: " + throwable.getMessage());
            }
        });
    }

    public void getCategories(RepositoryCallback<List<CategoriaDto>> callback) {
        Call<ResponseData<List<CategoriaDto>>> call = apiService.getCategories();
        call.enqueue(new Callback<ResponseData<List<CategoriaDto>>>() {
            @Override
            public void onResponse(Call<ResponseData<List<CategoriaDto>>> call, Response<ResponseData<List<CategoriaDto>>> response) {
                Log.d("API_RESPONSE", "Categories: " + gson.toJson(response.body()));
                if(response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onError(ApiErrorParser.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<ResponseData<List<CategoriaDto>>> call, Throwable throwable) {
                callback.onError("Error de conexión: " + throwable.getMessage());
            }
        });
    }

    public void getCatalogByCategory(String categoryId, RepositoryCallback<List<HabitoCatalogoDto>> callback) {
        Call<ResponseData<List<HabitoCatalogoDto>>> call = apiService.getCatalog(categoryId);
        call.enqueue(new Callback<ResponseData<List<HabitoCatalogoDto>>>() {
            @Override
            public void onResponse(Call<ResponseData<List<HabitoCatalogoDto>>> call, Response<ResponseData<List<HabitoCatalogoDto>>> response) {
                Log.d("API_RESPONSE", "Catalog: " + gson.toJson(response.body()));
                if(response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onError(ApiErrorParser.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<ResponseData<List<HabitoCatalogoDto>>> call, Throwable throwable) {
                callback.onError("Error de conexión: " + throwable.getMessage());
            }
        });
    }

    public void selectHabit(String habitId, RepositoryCallback<Void> callback) {
        Call<ResponseData<Void>> call = apiService.selectHabit(new SelectHabitRequest(habitId));
        call.enqueue(new Callback<ResponseData<Void>>() {
            @Override
            public void onResponse(Call<ResponseData<Void>> call, Response<ResponseData<Void>> response) {
                Log.d("API_RESPONSE", "SelectHabit: " + gson.toJson(response.body()));
                if(response.isSuccessful()) {
                    callback.onSuccess(null);
                } else {
                    callback.onError(ApiErrorParser.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<ResponseData<Void>> call, Throwable throwable) {
                callback.onError("Error de conexión: " + throwable.getMessage());
            }
        });
    }
}
