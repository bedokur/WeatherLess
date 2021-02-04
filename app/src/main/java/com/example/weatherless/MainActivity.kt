package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weatherless.Interface.RetrofitServices
import com.example.weatherless.common.Common
import com.example.weatherless.databinding.ActivityMainBinding
import com.example.weatherless.model.Weather
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dmax.dialog.SpotsDialog
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call
import java.util.*
import kotlinx.android.synthetic.main.layout_modal_bottom_sheet.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var dialog: AlertDialog
    lateinit var mService: RetrofitServices
//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mService = Common.retrofitService
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()
        binding.updateButton.setOnClickListener { getWeather() }
//        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
//
//        bottomSheetBehavior.addBottomSheetCallback(object :
//            BottomSheetBehavior.BottomSheetCallback() {
//
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                // handle onSlide
//            }
//
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                when (newState) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@MainActivity, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(this@MainActivity, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@MainActivity, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(this@MainActivity, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@MainActivity, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
//                    else -> Toast.makeText(this@MainActivity, "OTHER_STATE", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })

        binding.btnBottomSheetModal.setOnClickListener {
            CustomBottomSheetDialogFragment().apply {
                show(supportFragmentManager, CustomBottomSheetDialogFragment.TAG)
            }
        }
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
