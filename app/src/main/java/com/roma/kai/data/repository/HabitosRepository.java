package com.roma.kai.data.repository;

import com.roma.kai.data.callback.RepositoryCallback;
import com.roma.kai.data.remote.ApiService;
import com.roma.kai.data.remote.error.ApiErrorParser;
import com.roma.kai.model.dto.HabitsViewResponse;
import com.roma.kai.model.response.ResponseData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HabitosRepository {
    private final ApiService apiService;

    public HabitosRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loadHabitsView(RepositoryCallback<HabitsViewResponse> callback) {
        Call<ResponseData<HabitsViewResponse>> call = apiService.getHabitsView();
        call.enqueue(new Callback<ResponseData<HabitsViewResponse>>() {
            @Override
            public void onResponse(Call<ResponseData<HabitsViewResponse>> call, Response<ResponseData<HabitsViewResponse>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getData());
                } else {
                    callback.onError(ApiErrorParser.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<ResponseData<HabitsViewResponse>> call, Throwable throwable) {
                callback.onError("MSG DE ERROR GENERICO PARA EL SISTEMA");
            }
        });
    }
}
