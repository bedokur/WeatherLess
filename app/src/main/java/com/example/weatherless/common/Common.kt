package com.example.weatherless.common

import com.example.weatherless.Interface.RetrofitServices
import com.example.weatherless.Retrofit.RetrofitClient
import com.google.gson.annotations.SerializedName

//?q=kazan&appid=802f2694ef69158bfa043bbb8096fbaa&units=metric/
object Common {
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val retrofitService: RetrofitServices =
        RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)

}