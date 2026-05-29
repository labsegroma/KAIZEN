package com.roma.kai.ui.habitos.selectCategoria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.roma.kai.R;
import com.roma.kai.databinding.FragmentSeleccionHabitosBinding;
import com.roma.kai.utils.UiMessage;
import com.roma.kai.utils.UiMessageHelper;

public class SeleccionHabitosFragment extends Fragment {

    private FragmentSeleccionHabitosBinding binding;
    private SeleccionHabitosViewModel seleccionHabitosVM;
    private CategoriaAdapter adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSeleccionHabitosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);

        seleccionHabitosVM =
                new ViewModelProvider(this)
                        .get(SeleccionHabitosViewModel.class);

        setupRecyclerView();
        setupObservers();

        seleccionHabitosVM.loadCategorias();
    }

    private void setupRecyclerView() {

        adapter = new CategoriaAdapter(categoria -> {

            Bundle bundle = new Bundle();

            bundle.putString(
                    "categoryId",
                    categoria.getId()
            );

            bundle.putString(
                    "categoriaNombre",
                    categoria.getNombre()
            );

            Navigation.findNavController(requireView())
                    .navigate(
                            R.id.action_nav_seleccion_habitos_to_nav_lista_habitos_categoria,
                            bundle
                    );
        });

        binding.rvCategorias.setLayoutManager(
                new GridLayoutManager(getContext(), 2)
        );

        binding.rvCategorias.setAdapter(adapter);
    }

    private void setupObservers() {

        seleccionHabitosVM.getUiState().observe(
                getViewLifecycleOwner(),
                uiState -> {

                    binding.progressBarCategorias.setVisibility(
                            uiState.isLoading()
                                    ? View.VISIBLE
                                    : View.GONE
                    );

                    if (uiState.isSuccess()) {
                        adapter.submitList(uiState.getCategorias());
                    }
                }
        );

        seleccionHabitosVM.getEventUiMessage().observe(
                getViewLifecycleOwner(),
                event -> {

                    UiMessage message =
                            event.obtenerContenidoSiNoManejado();

                    if (message != null) {
                        UiMessageHelper.showMessage(
                                binding.getRoot(),
                                requireContext(),
                                message
                        );
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}