package com.example.weatherless.Interface

import com.example.weatherless.model.Weather
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

//q=kazan&appid=802f2694ef69158bfa043bbb8096fbaa&units=metric
//interface RetrofitServices {
//    @GET("weather?")
//    fun getWeatherUpdate(
//        @Query("q") city: String,
//        @Query("appid") appId: String,
//        @Query("units") units: String
//    ): Call<Weather>
//}

interface RetrofitServices {
    @GET("weather?")
    fun getWeatherUpdate(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ) : Observable<Weather>
}


//interface MyService {
//    @GET("user/me")
//    Observable<User> getUser()
//}