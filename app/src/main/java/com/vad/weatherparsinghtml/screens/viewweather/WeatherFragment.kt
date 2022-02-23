package com.vad.weatherparsinghtml.screens.viewweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.vad.weatherparsinghtml.databinding.FragmentWeatherBinding
import com.vad.weatherparsinghtml.model.api.repository.RepositoryApi
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.model.room.weather.entities.Weather
import com.vad.weatherparsinghtml.viewmodel.ViewModelAppFactory
import com.vad.weatherparsinghtml.viewmodel.ViewModelCity
import com.vad.weatherparsinghtml.viewmodel.ViewModelWeatherFactory
import com.vad.weatherparsinghtml.viewmodel.ViewModelWeathers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class WeatherFragment : Fragment() {

    private var viewModelWeather: ViewModelWeathers? = null
    private var viewModelCity: ViewModelCity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: FragmentWeatherBinding = FragmentWeatherBinding.inflate(layoutInflater)

        val recyclerView: RecyclerView = rootView.WeathersRecycler
        val adapterWeather = AdapterWeather()

        val repositoryApi = RepositoryApi()

        val viewModelWeatherFactory =
            ViewModelWeatherFactory(requireActivity().application, repositoryApi)
        viewModelWeather = ViewModelProvider(
            requireActivity(),
            viewModelWeatherFactory
        ).get(ViewModelWeathers::class.java)

        val viewModelAppFactory = ViewModelAppFactory(requireActivity().application)
        viewModelCity =
            ViewModelProvider(requireActivity(), viewModelAppFactory).get(ViewModelCity::class.java)

        viewModelCity?.readAllData?.observe(viewLifecycleOwner) { cities ->
            cities.forEach { city ->
                viewModelCity?.viewModelScope?.launch {
                    viewModelWeather?.getWeather(
                        city.nameCity
                    )
                }
            }
        }


        viewModelWeather?.myResponse?.observe(viewLifecycleOwner) { response ->

            if (response.isSuccessful) {

                viewModelWeather!!.addWeather(
                    Weather(
                        0,
                        0,
                        response.body()?.current?.tempC as Float,
                        System.currentTimeMillis()
                    )
                )
            } else {
                response.errorBody()
            }
        }

        return rootView.root
    }

}