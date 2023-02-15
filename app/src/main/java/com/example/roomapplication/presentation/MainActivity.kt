package com.example.roomapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapplication.data.League
import com.example.roomapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val leagueAdapter = LeagueAdapter(listOf<League>())
        binding.rvLeagues.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = leagueAdapter
        }

        viewModel.leagues.observe(this) { dataset ->
            leagueAdapter.updateDataset(dataset)
        }
        viewModel.getLeagues()
        binding.btSubmit.setOnClickListener {
            if(!binding.etLeague.text.isNullOrEmpty()) {
                viewModel.addLeague(binding.etLeague.text.toString())
            }
        }
    }

}