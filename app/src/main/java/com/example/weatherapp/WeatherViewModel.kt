package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    val  weatherData : StateFlow<WeatherResponse?> = _weatherData
    private val weatherApi =  WeatherApiInterface.create()

    fun fetchWeather(city : String,apikey : String){
        viewModelScope.launch {
            try {
                val response  = weatherApi.getWeather(city, apikey)
                _weatherData.value =  response
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
}