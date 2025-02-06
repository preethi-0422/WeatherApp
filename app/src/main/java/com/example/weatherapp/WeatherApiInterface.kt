package com.example.weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterface {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city : String,
        @Query("appid") apikey : String,
        @Query("units") units : String = "metric"
    ): WeatherResponse
    companion object{
        private const val BASE_URL =  "https://api.openweathermap.org/data/2.5/"
        fun create() : WeatherApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(WeatherApiInterface::class.java)
        }
    }
}