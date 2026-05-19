package com.roma.kai.ui.kai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.roma.kai.databinding.FragmentTuKaiBinding;

public class TuKaiFragment extends Fragment {

    private FragmentTuKaiBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTuKaiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBackKai.setOnClickListener(v -> 
            Navigation.findNavController(v).navigateUp()
        );

        // Aquí se cargaría el estado actual de Kai (etapa, vigor, personalidad, etc.)
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
