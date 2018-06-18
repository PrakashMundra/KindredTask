package com.kindredtask.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kindredtask.R
import com.kindredtask.data.model.Game
import com.kindredtask.databinding.ListItemBinding

class ListAdapterKt(private val games: List<Game>) : RecyclerView.Adapter<ListAdapterKt.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.game = games[position]
    }

    inner class ViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}