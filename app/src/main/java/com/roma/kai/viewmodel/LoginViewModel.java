package com.roma.kai.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.roma.kai.utils.EstadoUI;
import com.roma.kai.utils.Event;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<EstadoUI> _estado = new MutableLiveData<>();
    public LiveData<EstadoUI> getEstado() { return _estado; }

    private final MutableLiveData<Event<Boolean>> _eventoNavegarHome = new MutableLiveData<>();
    public LiveData<Event<Boolean>> getEventoNavegarHome() { return _eventoNavegarHome; }

    public void iniciarSesion(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            _estado.setValue(new EstadoUI.EstadoError("Por favor completa todos los campos"));
            return;
        }

        _estado.setValue(new EstadoUI.EstadoCargando());
        
        // Simulacion de login exitoso
        _estado.setValue(new EstadoUI.EstadoExito<>(null));
        _eventoNavegarHome.setValue(new Event<>(true));
    }
}
