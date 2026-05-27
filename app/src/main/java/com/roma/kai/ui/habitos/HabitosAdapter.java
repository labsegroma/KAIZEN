package com.roma.kai.ui.habitos;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.roma.kai.databinding.ItemHabitoBinding;
import com.roma.kai.model.dto.UserHabitResponse;
import com.roma.kai.model.entity.Habito;
import java.util.List;
import java.util.Objects;

public class HabitosAdapter extends ListAdapter<UserHabitResponse, HabitosAdapter.HabitoViewHolder> {

    private final OnHabitoClickListener listener;

    public interface OnHabitoClickListener {
        void onHabitoClick(UserHabitResponse habito);
    }

    public HabitosAdapter(OnHabitoClickListener listener) {

        super(DIFF_CALLBACK);

        this.listener = listener;
    }

    // DIFFUTIL
    private static final DiffUtil.ItemCallback<UserHabitResponse> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserHabitResponse>() {

                @Override
                public boolean areItemsTheSame(@NonNull UserHabitResponse oldItem, @NonNull UserHabitResponse newItem) {
                    // Comparás IDs únicos
                    return Objects.equals(oldItem.getHabitoUsuarioId(), newItem.getHabitoUsuarioId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull UserHabitResponse oldItem, @NonNull UserHabitResponse newItem) {
                    // Comparás contenido
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public HabitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHabitoBinding binding = ItemHabitoBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new HabitoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitoViewHolder holder, int position) {
        UserHabitResponse habito = getItem(position);
        holder.bind(habito, listener);
    }

    // VIEW HOLDER
    static class HabitoViewHolder extends RecyclerView.ViewHolder {
        private final ItemHabitoBinding binding;

        public HabitoViewHolder(ItemHabitoBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(UserHabitResponse habito, OnHabitoClickListener listener) {

            binding.txtHabitoNombre.setText(habito.getNombre());

            binding.txtHabitoCategoria.setText(habito.getCategoria());

            binding.txtHabitoRacha.setText("Racha: " + habito.getRachaActual() + " días");

            // Icono
//            if (habito.getIconResId() != 0) {
//                binding.imgHabitoIcon.setImageResource(
//                        habito.getIconResId()
//                );
//            }

            itemView.setOnClickListener(v ->
                    listener.onHabitoClick(habito)
            );
        }
    }
}
