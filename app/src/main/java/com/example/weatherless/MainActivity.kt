package com.example.weatherless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherless.databinding.ActivityMainBinding
import com.example.weatherless.data.DataSource
import com.example.weatherless.adapter.ListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myDataset = DataSource().loadTextToList()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(this, myDataset)
        binding.addButton.setOnClickListener { addToList() }
    }
    private fun addToList(): MutableList<String>{

        val textes = mutableListOf<String>()
        for (i in 0..10){
            textes.add("$i")
        }
        return textes
    }
}
