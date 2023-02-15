package com.example.roomapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.League
import com.example.roomapplication.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun addLeague(name: String) {
        viewModelScope.launch() {
            repository.addLeague(League(0, name))
        }
    }

}