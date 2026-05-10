package com.roma.kai.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.roma.kai.R;
import com.roma.kai.databinding.FragmentKaiBinding;
import com.roma.kai.model.Kai;
import com.roma.kai.utils.EstadoUI;
import com.roma.kai.viewmodel.KaiViewModel;

public class KaiFragment extends Fragment {

    private FragmentKaiBinding binding;
    private KaiViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentKaiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KaiViewModel.class);

        observarKai();
        viewModel.cargarKai();
    }

    private void observarKai() {
        viewModel.getEstadoKai().observe(getViewLifecycleOwner(), estado -> {
            if (estado instanceof EstadoUI.EstadoExito) {
                Kai kai = (Kai) ((EstadoUI.EstadoExito<?>) estado).getDatos();
                binding.tvKaiNivel.setText(getString(R.string.nivel_kai, kai.getNivel()));
                binding.tvKaiEmocion.setText(getString(R.string.emocion_kai, kai.getEstadoEmocional()));
                binding.tvKaiMensaje.setText(getString(R.string.mensaje_kai, kai.getMensajeActual()));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
