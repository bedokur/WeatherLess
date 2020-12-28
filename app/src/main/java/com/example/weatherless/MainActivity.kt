package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.util.Log
import android.widget.Toast
import com.example.weatherless.Interface.RetrofitServices
import com.example.weatherless.common.Common
import com.example.weatherless.databinding.ActivityMainBinding
import com.example.weatherless.model.Weather
import dmax.dialog.SpotsDialog
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var dialog: AlertDialog
    lateinit var mService: RetrofitServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mService = Common.retrofitService
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        binding.updateButton.setOnClickListener { getWeather() }
    }

    private fun getWeather() {
        dialog.show()
        val city = binding.cityInput.text.toString().toLowerCase(Locale.ROOT)

        mService.getWeatherUpdate(
            city = city,
            appId = "802f2694ef69158bfa043bbb8096fbaa",
            units = "metric"
        ).enqueue(object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                println(t)
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.code() == 200) {
                    val weather: Weather? = response.body()
                    binding.cityName.text = city
                    binding.temperature.text = weather?.main?.temp.toString()
                } else if (response.code() == 404) {
                    Toast.makeText(
                        this@MainActivity,
                        "Введите город правильно",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dialog.dismiss()
            }
        })
    }
}
