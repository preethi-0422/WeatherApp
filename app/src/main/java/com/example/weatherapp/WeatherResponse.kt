package com.example.weatherapp

data class WeatherResponse(
    val  name : String,
    val main :  Main,
    val weather : List<Weather>

)
data class Main(
    val temp :  Float,
    val Humidity : Int
)
data class Weather(
    val  description : String
)
