package com.example.weatherless.Interface

import com.example.weatherless.model.CurrentWeather
import com.example.weatherless.model.OneCall
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
    suspend fun getWeatherUpdate(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String,
        @Query("lang") lang: String
    ) : Observable<CurrentWeather>

    @GET("onecall?")
    suspend fun getOneCall(
        @Query("lat") lat:String,
        @Query("lon") long:String,
        @Query("appid") appID:String,
        @Query("exclude") exclude:String,
        @Query("units") units:String,
        @Query("lang") lang:String
    ): Observable<OneCall>
}
//https://api.openweathermap.org/data/2.5/onecall?lat=55.796391&lon=49.108891&exclude=current,minutely,hourly,alerts&appid=802f2694ef69158bfa043bbb8096fbaa
//interface MyService {
//    @GET("user/me")
//    Observable<User> getUser()
//}