package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.weatherless.data.WeatherItem
import com.example.weatherless.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private lateinit var sharedViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.updateButton.setOnClickListener { WeatherRepository().getWeather() }
        sharedViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        sharedViewModel.vMCity.observe(this, androidx.lifecycle.Observer {

        })
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
    }

    fun getWeatherUpd(city: String){
        sharedViewModel.getWeather(city)
    }
}
