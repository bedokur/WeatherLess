package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weatherless.data.WeatherItem
import com.example.weatherless.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private val sharedViewModel: MainActivityViewModel by viewModels()
    private var repo  = WeatherRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.updateButton.setOnClickListener { WeatherRepository().getWeather() }

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