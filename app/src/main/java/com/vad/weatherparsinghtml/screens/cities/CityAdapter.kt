package com.vad.weatherparsinghtml.screens.cities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vad.weatherparsinghtml.R

class CityAdapter: RecyclerView.Adapter<CityAdapter.MyViewHolder>() {

    val cities = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityAdapter.MyViewHolder, position: Int) {
        holder.nameCity.text = cities[position]
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameCity = itemView.findViewById<TextView>(R.id.textViewNameCity)
    }

}