package com.roma.kai.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.roma.kai.R;
import com.roma.kai.databinding.FragmentLoginBinding;
import com.roma.kai.utils.EstadoUI;
import com.roma.kai.viewmodel.LoginViewModel;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString();
            String pass = binding.etPassword.getText().toString();
            viewModel.iniciarSesion(email, pass);
        });

        observarEstado();
    }

    private void observarEstado() {
        viewModel.getEstado().observe(getViewLifecycleOwner(), estado -> {
            if (estado instanceof EstadoUI.EstadoError) {
                Toast.makeText(getContext(), ((EstadoUI.EstadoError) estado).getMensaje(), Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getEventoNavegarHome().observe(getViewLifecycleOwner(), evento -> {
            if (evento.obtenerContenidoSiNoManejado() != null) {
                Navigation.findNavController(requireView()).navigate(R.id.action_login_to_home);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
