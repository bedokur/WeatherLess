package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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


//        binding.updateButton.setOnClickListener { WeatherRepository().getWeather() }
        sharedViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
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

//        val cityname = sharedViewModel.city.value.toString()
//        if (cityname.isEmpty()) {
//            Toast.makeText(this@MainActivity, cityname, Toast.LENGTH_SHORT).show()
        }

    }

