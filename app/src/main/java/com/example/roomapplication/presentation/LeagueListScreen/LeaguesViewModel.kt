package com.example.roomapplication.presentation.LeagueListScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.league.LeagueEntity
import com.example.roomapplication.data.RepositoryImpl
import com.example.roomapplication.domain.model.League
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val repository: RepositoryImpl
): ViewModel() {

    private val _leagues = MutableLiveData<List<League>>()
    val leagues: LiveData<List<League>> = _leagues

    fun setup() {
        getLeagues()
    }

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