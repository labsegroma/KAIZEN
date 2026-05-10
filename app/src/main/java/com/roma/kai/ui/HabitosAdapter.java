package com.roma.kai.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.roma.kai.databinding.ItemHabitoBinding;
import com.roma.kai.model.Habito;
import java.util.ArrayList;
import java.util.List;

public class HabitosAdapter extends RecyclerView.Adapter<HabitosAdapter.HabitoViewHolder> {

    private List<Habito> habitos = new ArrayList<>();
    private final OnHabitoClickListener listener;

    public interface OnHabitoClickListener {
        void onCompletarClick(Habito habito);
    }

    public HabitosAdapter(OnHabitoClickListener listener) {
        this.listener = listener;
    }

    public void setHabitos(List<Habito> nuevosHabitos) {
        this.habitos = nuevosHabitos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HabitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHabitoBinding binding = ItemHabitoBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new HabitoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitoViewHolder holder, int position) {
        holder.bind(habitos.get(position));
    }

    @Override
    public int getItemCount() {
        return habitos.size();
    }

    class HabitoViewHolder extends RecyclerView.ViewHolder {
        private final ItemHabitoBinding binding;

        public HabitoViewHolder(ItemHabitoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Habito habito) {
            binding.tvNombreHabito.setText(habito.getNombre());
            binding.tvCategoriaHabito.setText(habito.getCategoria());
            binding.btnCompletarHabito.setOnClickListener(v -> listener.onCompletarClick(habito));
        }
    }
}
