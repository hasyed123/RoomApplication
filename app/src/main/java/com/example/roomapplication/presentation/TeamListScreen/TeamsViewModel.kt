package com.example.roomapplication.presentation.TeamListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.RepositoryImpl
import com.example.roomapplication.data.team.TeamEntity
import com.example.roomapplication.domain.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val repository: RepositoryImpl
): ViewModel() {

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    private var leagueId: Int = 0

    fun setup(leagueId: Int) {
        this.leagueId = leagueId
        getTeams()
    }

    fun getTeams() {
        viewModelScope.launch {
            _teams.value = repository.getTeamsInLeague(leagueId)
        }
    }

    fun addTeam(name: String) {
        viewModelScope.launch {
            repository.addTeam(Team(
                name = name,
                leagueId = leagueId,
                wins = 0,
                losses = 0,
                ties = 0
            ))
            getTeams()
        }
    }

}