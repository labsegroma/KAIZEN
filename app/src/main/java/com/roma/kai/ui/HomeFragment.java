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
import com.roma.kai.R;
import com.roma.kai.databinding.FragmentHomeBinding;
import com.roma.kai.model.Usuario;
import com.roma.kai.utils.EstadoUI;
import com.roma.kai.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private HabitosAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        setupRecyclerView();
        observarDatos();

        viewModel.cargarDatosInicio();
    }

    private void setupRecyclerView() {
        adapter = new HabitosAdapter(habito -> {
            // Logica simple
        });
        binding.rvHabitosHoy.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvHabitosHoy.setAdapter(adapter);
    }

    private void observarDatos() {
        viewModel.getEstadoUsuario().observe(getViewLifecycleOwner(), estado -> {
            if (estado instanceof EstadoUI.EstadoExito) {
                Usuario user = (Usuario) ((EstadoUI.EstadoExito<?>) estado).getDatos();
                binding.tvSaludo.setText(getString(R.string.saludo_usuario, user.getNombre()));
                binding.tvXp.setText(getString(R.string.xp_total, user.getXpTotal()));
                binding.tvRacha.setText(getString(R.string.racha_actual, user.getRachaActual()));
            }
        });

        viewModel.getHabitosHoy().observe(getViewLifecycleOwner(), adapter::setHabitos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
