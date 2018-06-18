package com.kindredtask.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kindredtask.R
import com.kindredtask.data.model.GameKt
import com.kindredtask.databinding.ListItemKtBinding

class ListAdapterKt(private val games: List<GameKt>) : RecyclerView.Adapter<ListAdapterKt.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemKtBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.list_item_kt, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.game = games[position]
    }

    inner class ViewHolder(var binding: ListItemKtBinding) : RecyclerView.ViewHolder(binding.root)
}