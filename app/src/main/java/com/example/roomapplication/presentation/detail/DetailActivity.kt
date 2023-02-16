package com.example.roomapplication.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapplication.R
import com.example.roomapplication.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUI()
    }

    private fun initializeUI() {
        viewModel.setLeague(intent.getIntExtra("LEAGUE",0))

        val teamAdapter = TeamAdapter(listOf())
        binding.rvTeams.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = teamAdapter
        }

        viewModel.teams.observe(this) {dataset ->
            teamAdapter.updateDataset(dataset)
        }

        binding.btAddTeam.setOnClickListener {
            binding.etTeam.text.let {
                if(!it.isNullOrEmpty()) viewModel.addTeam(it.toString())
            }
        }

        viewModel.getTeams()
    }
}