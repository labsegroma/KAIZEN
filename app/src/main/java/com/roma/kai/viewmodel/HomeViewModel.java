package com.roma.kai.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.roma.kai.model.Habito;
import com.roma.kai.model.Usuario;
import com.roma.kai.utils.EstadoUI;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<EstadoUI> _estadoUsuario = new MutableLiveData<>();
    public LiveData<EstadoUI> getEstadoUsuario() { return _estadoUsuario; }

    private final MutableLiveData<List<Habito>> _habitosHoy = new MutableLiveData<>();
    public LiveData<List<Habito>> getHabitosHoy() { return _habitosHoy; }

    public void cargarDatosInicio() {
        _estadoUsuario.setValue(new EstadoUI.EstadoCargando());
        
        // Simular carga de usuario
        Usuario usuario = new Usuario("Estudiante", "estudiante@ejemplo.com", 1, 100, 3);
        _estadoUsuario.setValue(new EstadoUI.EstadoExito<>(usuario));

        // Simular carga de habitos
        List<Habito> habitos = new ArrayList<>();
        habitos.add(new Habito("Beber 2L de agua", "Salud", false));
        habitos.add(new Habito("Meditar 5 min", "Mental", false));
        _habitosHoy.setValue(habitos);
    }
}
