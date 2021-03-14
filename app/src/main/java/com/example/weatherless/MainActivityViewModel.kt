package com.example.weatherless

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherless.model.CurrentWeather
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

    private var wRepo = WeatherRepository()

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _temperature = MutableLiveData<String>()
    val temperature: LiveData<String> = _temperature

    private val _humidity = MutableLiveData<String>()
    val humidity: LiveData<String> = _humidity

    private val _wind = MutableLiveData<String>()
    val wind: LiveData<String> = _wind

    var city = MutableLiveData<String>()



    fun getWeather() {
        CoroutineScope(Dispatchers.IO).launch {
            val wG = city.value?.let {
                wRepo.getWeather(it) {
                    CoroutineScope(Dispatchers.Main).launch {
                        setView(it)
                    }
                }
            }
        }
    }
    suspend fun setView(it: CurrentWeather){
        _temperature.value = it.main.temp.toString()
    }
}