package com.example.roomapplication.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.Repository
import com.example.roomapplication.data.team.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    private var leagueId: Int = 0

    fun getTeams() {
        viewModelScope.launch {
            _teams.value = repository.getTeams(leagueId)?.teams
        }
    }

    fun addTeam(name: String) {
        viewModelScope.launch {
            repository.addTeam(Team(name, leagueId))
            getTeams()
        }
    }

    fun setLeague(leagueId: Int) {
        this.leagueId = leagueId
    }

}