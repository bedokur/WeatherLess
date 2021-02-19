package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherless.Interface.RetrofitServices
import com.example.weatherless.common.Common
import com.example.weatherless.data.WeatherItem
import com.example.weatherless.databinding.ActivityMainBinding
import com.example.weatherless.model.CurrentWeather
import com.example.weatherless.model.OneCall
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dmax.dialog.SpotsDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var dialog: AlertDialog
    lateinit var mService: RetrofitServices
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mService = Common.retrofitService
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        binding.updateButton.setOnClickListener { getWeather() }


//        val exampleWeatherList = generateSomeList(10)
//        val recyclerView = binding.bottomSheet.recyclerViewWeather
//        recyclerView.adapter = ExampleAdapter(exampleWeatherList)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)


        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet.bottomSheet)
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide
            }
        })

//        binding.bottomSheet.firstButton.setOnClickListener{Toast.makeText(this@MainActivity, "Hi", Toast.LENGTH_SHORT).show()}
//сделать самособираемые запросы

    }


    private fun getWeather() {
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            mService.getWeatherUpdate(
                appId = "802f2694ef69158bfa043bbb8096fbaa",
                city = binding.cityInput.text.toString(),
                units = "metric",
                lang = "ru"
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { responce -> onMainResponce(responce); getListCall(responce) },
                    { t -> onFailure(t) })
        )
    }

    private fun getListCall(response: CurrentWeather) {
        val compositeDisposable = CompositeDisposable()
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
        binding.temperature.text = response.main.temp.toString()
        binding.cityName.text = response.name
    }


    private fun onOneCallResponce(response: OneCall) {
        val recyclerView = binding.bottomSheet.recyclerViewWeather
        recyclerView.adapter = ExampleAdapter(response.daily)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    private fun generateSomeList(size: Int): List<WeatherItem> {
        val list = ArrayList<WeatherItem>()

        for (i in 0 until size) {
            val drawable = R.drawable.ic_baseline_wb_sunny_24

            val item = WeatherItem(drawable, "Item $i", "Humidity $i")
            list += item
        }
        return list
    }

}


//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                when (newState) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(
//                        this@MainActivity,
//                        "STATE_COLLAPSED",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(
//                        this@MainActivity,
//                        "STATE_EXPANDED",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(
//                        this@MainActivity,
//                        "STATE_DRAGGING",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(
//                        this@MainActivity,
//                        "STATE_SETTLING",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(
//                        this@MainActivity,
//                        "STATE_HIDDEN",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    else -> Toast.makeText(this@MainActivity, "OTHER_STATE", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }