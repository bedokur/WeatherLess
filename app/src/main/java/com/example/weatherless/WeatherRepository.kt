package com.example.weatherless

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherless.Interface.RetrofitServices
import com.example.weatherless.model.CurrentWeather
import com.example.weatherless.model.OneCall
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherRepository {
    lateinit var mService: RetrofitServices

    //    mService = Common.retrofitService
    private val compositeDisposable = CompositeDisposable()


    suspend fun getWeather(city: String) {
        compositeDisposable.add(
            mService.getWeatherUpdate(
                appId = "802f2694ef69158bfa043bbb8096fbaa",
                city = city,
                units = "metric",
                lang = "ru"
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { respond -> suspend { getListCall(respond) }; return@subscribe },
                    { t -> onFailure(t) })
        )
    }

    suspend fun getListCall(response: CurrentWeather) {
        compositeDisposable.add(
            mService.getOneCall(
                lat = response.coord.lat.toString(),
                long = response.coord.lon.toString(),
                appID = "802f2694ef69158bfa043bbb8096fbaa",
                exclude = "current,minutely,hourly,alerts",
                units = "metric",
                lang = "ru"
            ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response -> onOneCallResponce(response) }, { t -> onFailure(t) })
        )
    }

    private fun onMainResponce(response: CurrentWeather) {
//        binding.temperature.text = response.main.temp.toString()
//        binding.cityName.text = response.name
    }


    private fun onOneCallResponce(response: OneCall) {
//        val recyclerView = binding.bottomSheet.recyclerViewWeather
//        recyclerView.adapter = ExampleAdapter(response.daily)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
    }

    private fun onFailure(t: Throwable) {
//        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

}