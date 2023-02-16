package com.example.roomapplication.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.data.League
import com.example.roomapplication.databinding.ItemLeagueBinding

class LeagueAdapter(
    private var dataset: List<League>,
    val onItemClickListener: (Int) -> Unit
): RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    class LeagueViewHolder(private val binding: ItemLeagueBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, number: String) {
            binding.tvName.text = name
            binding.tvId.text = number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val binding = ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeagueViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        dataset[position].apply {
            holder.bind(name, id.toString())
            holder.itemView.setOnClickListener { onItemClickListener(id) }
        }
    }

    fun updateDataset(dataset: List<League>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }
}