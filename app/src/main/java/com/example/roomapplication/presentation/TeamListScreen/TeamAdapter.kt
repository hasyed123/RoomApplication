package com.example.roomapplication.presentation.TeamListScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.R
import com.example.roomapplication.data.team.TeamEntity
import com.example.roomapplication.databinding.ItemTeamBinding
import com.example.roomapplication.domain.model.Team

class TeamAdapter(private var dataset: List<Team>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TeamViewHolder(private val binding: ItemTeamBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team, oddeven: Int) {
            binding.apply {
                root.apply {
                    setBackgroundColor(
                        if (oddeven==0) resources.getColor(R.color.white)
                        else resources.getColor(R.color.grey)
                    )
                }
                tvName.text = team.name
                tvWin.text = team.wins.toString()
                tvLoss.text = team.losses.toString()
                tvTie.text = team.ties.toString()
            }
        }
    }

    class HeaderViewHolder(private val binding: ItemTeamBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                listOf(tvName,tvWin,tvLoss,tvTie).forEach {
                    it.apply {
                        setTextColor(resources.getColor(R.color.white))
                    }
                }
                tvName.text = "Team Name"
                tvWin.text = "W"
                tvLoss.text = "L"
                tvTie.text = "T"
                root.setBackgroundColor(binding.root.resources.getColor(R.color.black))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return if(viewType==0) HeaderViewHolder(binding)
        else TeamViewHolder(binding)
    }

    override fun getItemCount() = dataset.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> holder.bind()
            is TeamViewHolder -> holder.bind(dataset[position-1], position%2)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0) 0
        else 1
    }

    fun updateDataset(dataset: List<Team>) {
        this.dataset = dataset
        notifyDataSetChanged()
    }
}