package com.example.weatherless.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeStampToDate {

    fun convertLongToTime(time: Long): String {
        val date = Date(time * 1000)
        val format = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        return format.format(date)
    }
}













//mActivityComments
//    private fun generateSomeList(size: Int): List<WeatherItem> {
//        val list = ArrayList<WeatherItem>()
//
//        for (i in 0 until size) {
//            val drawable = R.drawable.ic_baseline_wb_sunny_24
//
//            val item = WeatherItem(drawable, "Item $i", "Humidity $i")
//            list += item
//        }
//        return list
//    }
//
//}


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