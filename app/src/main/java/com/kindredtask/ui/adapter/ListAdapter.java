package com.kindredtask.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kindredtask.R;
import com.kindredtask.data.model.Game;
import com.kindredtask.databinding.ListItemBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Game> mGames;

    public ListAdapter(List<Game> games) {
        this.mGames = games;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item,
                        parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mBinding.setGame(mGames.get(position));
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding mBinding;

        ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
