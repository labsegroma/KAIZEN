package com.roma.kai.ui.habitos.selectCategoria;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.roma.kai.data.callback.RepositoryCallback;
import com.roma.kai.data.remote.RetrofitClient;
import com.roma.kai.data.repository.HabitosRepository;
import com.roma.kai.model.dto.CategoriaDto;
import com.roma.kai.utils.Event;
import com.roma.kai.utils.UiMessage;

import java.util.Collections;
import java.util.List;

public class SeleccionHabitosViewModel extends AndroidViewModel {
    private final HabitosRepository habitosRepository;
    private final MutableLiveData<SeleccionHabitosUiState> uiState = new MutableLiveData<>();
    private final MutableLiveData<Event<UiMessage>> eventUiMessage = new MutableLiveData<>();

    public SeleccionHabitosViewModel(@NonNull Application application) {
        super(application);
        habitosRepository = new HabitosRepository(RetrofitClient.getService(application));
    }

    public LiveData<SeleccionHabitosUiState> getUiState() { return uiState; }

    public LiveData<Event<UiMessage>> getEventUiMessage() { return eventUiMessage; }

    public void loadCategorias() {
        uiState.setValue(new SeleccionHabitosUiState(true, false, Collections.emptyList()));

        habitosRepository.getCategories(new RepositoryCallback<List<CategoriaDto>>() {
            @Override
            public void onSuccess(List<CategoriaDto> data) {
                uiState.setValue(new SeleccionHabitosUiState(false, true, data));
            }

            @Override
            public void onError(String error) {
                uiState.setValue(new SeleccionHabitosUiState(false, false, Collections.emptyList()));
                eventUiMessage.setValue(new Event<>(new UiMessage(error, UiMessage.Type.ERROR)));
            }
        });
    }
}
