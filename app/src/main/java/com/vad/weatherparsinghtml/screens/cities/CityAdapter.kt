package com.vad.weatherparsinghtml.screens.cities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vad.weatherparsinghtml.R

class CityAdapter(cities: List<String>): RecyclerView.Adapter<CityAdapter.MyViewHolder>() {

    private var cities: List<String> = cities
    @SuppressLint("NotifyDataSetChanged")
    set(cities) {
        field = cities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameCity.text = cities[position]
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameCity = itemView.findViewById<TextView>(R.id.textViewNameCity)
    }

}