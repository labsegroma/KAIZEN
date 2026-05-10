package com.roma.kai.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.roma.kai.model.Kai;
import com.roma.kai.utils.EstadoUI;

public class KaiViewModel extends ViewModel {

    private final MutableLiveData<EstadoUI> _estadoKai = new MutableLiveData<>();
    public LiveData<EstadoUI> getEstadoKai() { return _estadoKai; }

    public void cargarKai() {
        _estadoKai.setValue(new EstadoUI.EstadoCargando());
        
        // Simular datos de Kai
        Kai kai = new Kai(5, "Feliz", "¡Me alegra verte de nuevo!");
        _estadoKai.setValue(new EstadoUI.EstadoExito<>(kai));
    }
}
