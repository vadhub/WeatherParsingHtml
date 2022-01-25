package com.vad.weatherparsinghtml.screens.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.vad.weatherparsinghtml.R
import com.vad.weatherparsinghtml.databinding.FragmentCitiesBinding

class CitiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCitiesBinding.inflate(inflater, container, false)

        return binding.root
    }
}