package com.vad.weatherparsinghtml.screens.viewweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vad.weatherparsinghtml.R
import com.vad.weatherparsinghtml.databinding.FragmentWeatherBinding
import com.vad.weatherparsinghtml.model.room.weather.repository.RoomWeatherRepository
import com.vad.weatherparsinghtml.viewmodel.ViewModelWeatherFactory
import com.vad.weatherparsinghtml.viewmodel.ViewModelWeathers

class WeatherFragment : Fragment() {

    private var viewModelWeather: ViewModelWeathers? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: FragmentWeatherBinding = FragmentWeatherBinding.inflate(layoutInflater)

        val recyclerView: RecyclerView = rootView.WeathersRecycler
        val adapterWeather = AdapterWeather()

        val viewModelWeatherFactory = ViewModelWeatherFactory(requireActivity().application)
        viewModelWeather = ViewModelProvider(requireActivity(), viewModelWeatherFactory).get(ViewModelWeathers::class.java)

        return rootView.root
    }
}