package com.roma.kai.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.roma.kai.databinding.FragmentHabitosBinding;
import com.roma.kai.viewmodel.HabitosViewModel;

public class HabitosFragment extends Fragment {

    private FragmentHabitosBinding binding;
    private HabitosViewModel viewModel;
    private HabitosAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHabitosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HabitosViewModel.class);

        setupRecyclerView();
        viewModel.getHabitos().observe(getViewLifecycleOwner(), adapter::setHabitos);
        
        viewModel.cargarHabitos();
    }

    private void setupRecyclerView() {
        adapter = new HabitosAdapter(habito -> viewModel.completarHabito(habito));
        binding.rvTodosHabitos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvTodosHabitos.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
