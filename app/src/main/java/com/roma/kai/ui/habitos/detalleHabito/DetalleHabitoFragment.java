package com.roma.kai.ui.habitos.detalleHabito;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.roma.kai.databinding.FragmentDetalleHabitoBinding;

public class DetalleHabitoFragment extends Fragment {

    private FragmentDetalleHabitoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDetalleHabitoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBackDetalle.setOnClickListener(v -> 
            Navigation.findNavController(v).navigateUp()
        );
        
        // Aquí se recibirían los argumentos del hábito seleccionado para mostrar su info
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
