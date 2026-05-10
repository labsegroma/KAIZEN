package com.roma.kai.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.roma.kai.model.Habito;
import java.util.ArrayList;
import java.util.List;

public class HabitosViewModel extends ViewModel {

    private final MutableLiveData<List<Habito>> _habitos = new MutableLiveData<>();
    public LiveData<List<Habito>> getHabitos() { return _habitos; }

    public void cargarHabitos() {
        List<Habito> lista = new ArrayList<>();
        lista.add(new Habito("Beber 2L de agua", "Salud", false));
        lista.add(new Habito("Meditar 5 min", "Mental", false));
        lista.add(new Habito("Leer 10 paginas", "Crecimiento", false));
        lista.add(new Habito("Hacer ejercicio", "Salud", false));
        _habitos.setValue(lista);
    }

    public void completarHabito(Habito habito) {
        // Logica para completar habito
    }
}
