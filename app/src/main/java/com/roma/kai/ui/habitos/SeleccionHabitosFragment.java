package com.roma.kai.ui.habitos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.roma.kai.databinding.FragmentSeleccionHabitosBinding;

public class SeleccionHabitosFragment extends Fragment {

    private FragmentSeleccionHabitosBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSeleccionHabitosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Lógica para mostrar categorías de hábitos
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
