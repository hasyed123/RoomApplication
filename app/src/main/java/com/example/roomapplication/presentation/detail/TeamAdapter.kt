package com.example.roomapplication.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.data.League
import com.example.roomapplication.data.Team
import com.example.roomapplication.databinding.ItemTeamBinding

class TeamAdapter(private var dataset: List<Team>): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    class TeamViewHolder(private val binding: ItemTeamBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.tvName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(dataset[position].name)
    }

    fun updateDataset(dataset: List<Team>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }
}