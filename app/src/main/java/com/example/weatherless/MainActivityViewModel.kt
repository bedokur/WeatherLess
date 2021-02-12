package com.example.weatherless

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val _temperature = MutableLiveData<Int>()
    val temperature: LiveData<Int> = _temperature

    private val _humidity = MutableLiveData<String>()
    val humidity: LiveData<String> = _humidity

    private val _wind = MutableLiveData<String>()
    val wind: LiveData<String> = _wind

    
}