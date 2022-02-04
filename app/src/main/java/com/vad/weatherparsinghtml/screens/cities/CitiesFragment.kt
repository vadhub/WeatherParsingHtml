package com.vad.weatherparsinghtml.screens.cities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vad.weatherparsinghtml.databinding.FragmentCitiesBinding
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.screens.addcity.AddCityDialogFragment
import com.vad.weatherparsinghtml.screens.addcity.Datable
import com.vad.weatherparsinghtml.viewmodel.ViewModelApp

class CitiesFragment : Fragment(), Datable {

    private var viewModel: ViewModelApp? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCitiesBinding.inflate(inflater, container, false)

        val myRecyclerView = binding.citiesListRecycler
        val adapter = CityAdapter()

        myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        myRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(requireActivity()).get(ViewModelApp::class.java)

        Log.i("fdff", "${viewModel.toString()} dfg")

        viewModel?.readAllData?.observe(viewLifecycleOwner, { cities ->
            adapter.setCities(cities)
        })

        binding.floatingActionButton.setOnClickListener{
            showDialog()
        }

        return binding.root
    }

    override fun setNameCity(name: String) {
//        println(name)
//        println(viewModel.toString())
//        val city = City(0, name)
//        viewModel?.addCity(city)
    }

    fun showDialog() {
        val dialog = AddCityDialogFragment()
        activity?.supportFragmentManager?.let { dialog.show(it, "Add city") }
    }
}