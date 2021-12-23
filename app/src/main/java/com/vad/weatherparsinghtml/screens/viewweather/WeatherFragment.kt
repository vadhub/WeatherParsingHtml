package com.vad.weatherparsinghtml.screens.viewweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vad.weatherparsinghtml.R
import com.vad.weatherparsinghtml.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: FragmentWeatherBinding = FragmentWeatherBinding.inflate(layoutInflater)
        return rootView.root
    }
}