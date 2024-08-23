package com.example.islamiproject.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.islamiproject.doman.entity.RadioResponse
import com.example.islamiproject.doman.repo.RadioRepo
import com.example.islamiproject.doman.usecase.GetRadio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val radioRepo: RadioRepo
) : ViewModel() {

    private val _radio: MutableStateFlow<RadioResponse?> = MutableStateFlow(null)
    val radio: StateFlow<RadioResponse?> get() = _radio

    fun getRadio() {
        viewModelScope.launch {
            try {
                val response = radioRepo.getRadio()
                if (response.isSuccessful) {
                    _radio.value = response.body()
                    Log.e("success", _radio.value.toString())
                } else {
                    Log.e("ViewModel", "Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("ViewModel", "Error fetching radio data", e)
            }
        }
    }
}

