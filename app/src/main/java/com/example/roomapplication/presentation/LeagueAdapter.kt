package com.example.roomapplication.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.data.League
import com.example.roomapplication.databinding.ItemLeagueBinding

class LeagueAdapter(
    private var dataset: List<League>
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
        dataset[position].let {
            holder.bind(it.name, it.id.toString())
        }
    }

    fun updateDataset(dataset: List<League>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }
}