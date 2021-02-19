package com.example.weatherless

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherless.data.WeatherItem
import com.example.weatherless.databinding.ListItemWeatherDaysBinding
import com.example.weatherless.model.Daily
import com.example.weatherless.utils.TimeStampToDate

class ExampleAdapter(private val exampleList: List<Daily>) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    private lateinit var binding: ListItemWeatherDaysBinding
    val date = TimeStampToDate()
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.quality_image)
        val textView1: TextView = itemView.findViewById(R.id.sleep_length)
        val textView2: TextView = itemView.findViewById(R.id.quality_string)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_weather_days,
            parent, false
        )
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]


        holder.imageView.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
//        holder.textView1.text = currentItem.dt.toString()
        holder.textView1.text = date.convertLongToTime(currentItem.dt.toLong())
        holder.textView2.text = currentItem.temp.day.toString()

    }

    override fun getItemCount() = exampleList.size

}