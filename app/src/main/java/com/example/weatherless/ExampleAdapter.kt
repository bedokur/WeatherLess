package com.example.weatherless

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherless.data.WeatherItem
import com.example.weatherless.databinding.ListItemWeatherDaysBinding

class ExampleAdapter(private val exampleList: List<WeatherItem>) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    private lateinit var binding: ListItemWeatherDaysBinding

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

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

    }

    override fun getItemCount() = exampleList.size

}