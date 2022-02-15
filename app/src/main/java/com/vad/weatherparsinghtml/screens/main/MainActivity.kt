package com.vad.weatherparsinghtml.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vad.weatherparsinghtml.databinding.ActivityMainBinding
import com.vad.weatherparsinghtml.screens.cities.CitiesFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, CitiesFragment()).commit()

    }

}