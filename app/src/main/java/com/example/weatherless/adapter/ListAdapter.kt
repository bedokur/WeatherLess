package com.example.weatherless.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherless.R
import com.example.weatherless.databinding.ActivityMainBinding
import com.example.weatherless.model.TypedText

private lateinit var binding: ActivityMainBinding

class ListAdapter(private val context: Context, private val textes: MutableList<String>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(private val view: View?):RecyclerView.ViewHolder(view!!){
        var textView: TextView? = null
        init {
            val textView: TextView? = view?.findViewById(R.id.item_text_place)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textView?.text = textes[position]

    }

    override fun getItemCount() = textes.size
}