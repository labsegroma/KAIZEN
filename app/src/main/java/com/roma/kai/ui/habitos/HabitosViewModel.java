package com.roma.kai.ui.habitos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.roma.kai.data.callback.RepositoryCallback;
import com.roma.kai.data.remote.RetrofitClient;
import com.roma.kai.data.repository.HabitosRepository;
import com.roma.kai.model.dto.HabitsViewResponse;
import com.roma.kai.utils.Event;
import com.roma.kai.utils.UiMessage;

import java.util.Collections;

public class HabitosViewModel extends AndroidViewModel {
    private final HabitosRepository habitosRepository;
    private final MutableLiveData<HabitosUiState> habitosUiState = new MutableLiveData<>();
    private final MutableLiveData<Event<UiMessage>> eventUiMessage = new MutableLiveData<>();
    public HabitosViewModel(@NonNull Application application) {
        super(application);
        habitosRepository = new HabitosRepository(RetrofitClient.getService(application));
    }

    public LiveData<HabitosUiState> getHabitosUiState() { return habitosUiState; }

    public LiveData<Event<UiMessage>> getEventUiMessage() { return eventUiMessage; }

    public void loadHabitosView() {
        habitosUiState.setValue(new HabitosUiState(
                true,
                false,
                null,
                Collections.emptyList()
        ));

        habitosRepository.loadHabitsView(new RepositoryCallback<HabitsViewResponse>() {
            @Override
            public void onSuccess(HabitsViewResponse data) {
                habitosUiState.setValue(new HabitosUiState(
                        false,
                        true,
                        data.getProgresoDiario(),
                        data.getHabitosUsuario()
                ));
            }

            @Override
            public void onError(String error) {
                habitosUiState.setValue(new HabitosUiState(
                        false,
                        false,
                        null,
                        Collections.emptyList()
                ));
                eventUiMessage.setValue(new Event<>(new UiMessage(error, UiMessage.Type.ERROR)));
            }
        });
    }
}
