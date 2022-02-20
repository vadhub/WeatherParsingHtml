package com.vad.weatherparsinghtml.screens.viewweather

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vad.weatherparsinghtml.R
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather

class AdapterWeather() : RecyclerView.Adapter<AdapterWeather.MyViewHolder>() {

    private var weathers: List<Weather> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setWeathers(weathers: List<Weather>) {
        this.weathers = weathers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_city_weather, parent, false)
        return MyViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cityName.text = weathers[position].cityId.toString()
        holder.degree.text = weathers[position].weather.toString()
        holder.date.text = weathers[position].date.toString()
    }

    override fun getItemCount(): Int {
        return weathers.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityName = itemView.findViewById<TextView>(R.id.textViewCity)
        val degree = itemView.findViewById<TextView>(R.id.textViewDegree)
        val date = itemView.findViewById<TextView>(R.id.textViewDate)
    }
}