package com.example.roomapplication.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapplication.data.League
import com.example.roomapplication.databinding.ActivityMainBinding
import com.example.roomapplication.presentation.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUi()
    }

    private fun initializeUi() {

        val leagueAdapter = LeagueAdapter(listOf<League>()) {
            Intent(this, DetailActivity::class.java).apply {
                putExtra("LEAGUE", it)
                startActivity(this)
            }
        }
        binding.rvLeagues.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = leagueAdapter
        }

        viewModel.leagues.observe(this) { dataset ->
            leagueAdapter.updateDataset(dataset)
        }
        binding.btAddLeague.setOnClickListener {
            binding.etLeague.text.let {
                if(!it.isNullOrEmpty()) viewModel.addLeague(it.toString())
            }
        }
        viewModel.getLeagues()
    }

}