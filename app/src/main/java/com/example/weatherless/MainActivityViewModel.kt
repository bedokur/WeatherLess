package com.example.weatherless

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

    private var wRepo = WeatherRepository()

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _temperature = MutableLiveData<Int>()
    val temperature: LiveData<Int> = _temperature

    private val _humidity = MutableLiveData<String>()
    val humidity: LiveData<String> = _humidity

    private val _wind = MutableLiveData<String>()
    val wind: LiveData<String> = _wind

    @Bindable
    val vMCity = MutableLiveData<String>()


    fun getWeather(city: String) {
        coroutineScope.launch {
            val wG = wRepo.getWeather(vMCity.toString())
        }
    }
}