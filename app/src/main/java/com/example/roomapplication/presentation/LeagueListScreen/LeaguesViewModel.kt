package com.example.roomapplication.presentation.LeagueListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.league.League
import com.example.roomapplication.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _leagues = MutableLiveData<List<League>>()
    val leagues: LiveData<List<League>> = _leagues

    fun addLeague(name: String) {
        viewModelScope.launch() {
            repository.addLeague(League(0, name))
            getLeagues()
        }
    }

    fun getLeagues() {
        viewModelScope.launch {
            _leagues.value = repository.getLeagues()
        }
    }

}