package com.roma.kai.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.roma.kai.model.Usuario;
import com.roma.kai.utils.EstadoUI;

public class PerfilViewModel extends ViewModel {

    private final MutableLiveData<EstadoUI> _estadoPerfil = new MutableLiveData<>();
    public LiveData<EstadoUI> getEstadoPerfil() { return _estadoPerfil; }

    public void cargarPerfil() {
        _estadoPerfil.setValue(new EstadoUI.EstadoCargando());
        
        // Simular datos de perfil
        Usuario usuario = new Usuario("Estudiante KAI", "estudiante@kai.com", 10, 5000, 15);
        _estadoPerfil.setValue(new EstadoUI.EstadoExito<>(usuario));
    }
}
