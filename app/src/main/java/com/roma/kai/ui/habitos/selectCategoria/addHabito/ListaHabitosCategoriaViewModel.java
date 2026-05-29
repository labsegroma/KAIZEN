package com.roma.kai.ui.habitos.selectCategoria.addHabito;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.roma.kai.data.callback.RepositoryCallback;
import com.roma.kai.data.remote.RetrofitClient;
import com.roma.kai.data.repository.HabitosRepository;
import com.roma.kai.model.dto.HabitoCatalogoDto;
import com.roma.kai.utils.Event;
import com.roma.kai.utils.UiMessage;

import java.util.Collections;
import java.util.List;

public class ListaHabitosCategoriaViewModel extends AndroidViewModel {
    private final HabitosRepository habitosRepository;
    private final MutableLiveData<ListaHabitosCategoriaUiState> uiState = new MutableLiveData<>();
    private final MutableLiveData<Event<UiMessage>> eventUiMessage = new MutableLiveData<>();

    public ListaHabitosCategoriaViewModel(@NonNull Application application) {
        super(application);
        habitosRepository = new HabitosRepository(RetrofitClient.getService(application));
    }

    public LiveData<ListaHabitosCategoriaUiState> getUiState() { return uiState; }

    public LiveData<Event<UiMessage>> getEventUiMessage() { return eventUiMessage; }

    public void loadHabitos(String categoryId) {
        uiState.setValue(new ListaHabitosCategoriaUiState(true, false, false, Collections.emptyList()));

        habitosRepository.getCatalogByCategory(categoryId, new RepositoryCallback<List<HabitoCatalogoDto>>() {
            @Override
            public void onSuccess(List<HabitoCatalogoDto> data) {
                uiState.setValue(new ListaHabitosCategoriaUiState(false, true, false, data));
            }

            @Override
            public void onError(String error) {
                uiState.setValue(new ListaHabitosCategoriaUiState(false, false, false, Collections.emptyList()));
                eventUiMessage.setValue(new Event<>(new UiMessage(error, UiMessage.Type.ERROR)));
            }
        });
    }

    public void seleccionarHabito(String habitId) {
        uiState.setValue(new ListaHabitosCategoriaUiState(true, true, false, uiState.getValue() != null ? uiState.getValue().getHabitos() : Collections.emptyList()));

        habitosRepository.selectHabit(habitId, new RepositoryCallback<Void>() {
            @Override
            public void onSuccess(Void data) {
                uiState.setValue(new ListaHabitosCategoriaUiState(false, true, true, uiState.getValue().getHabitos()));
            }

            @Override
            public void onError(String error) {
                uiState.setValue(new ListaHabitosCategoriaUiState(false, true, false, uiState.getValue().getHabitos()));
                eventUiMessage.setValue(new Event<>(new UiMessage(error, UiMessage.Type.ERROR)));
            }
        });
    }
}
