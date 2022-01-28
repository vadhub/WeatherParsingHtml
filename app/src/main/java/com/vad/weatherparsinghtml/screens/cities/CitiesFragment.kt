package com.vad.weatherparsinghtml.screens.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vad.weatherparsinghtml.databinding.FragmentCitiesBinding
import com.vad.weatherparsinghtml.model.city.entities.City
import com.vad.weatherparsinghtml.screens.addcity.AddCityDialogFragment
import com.vad.weatherparsinghtml.screens.addcity.Datable
import com.vad.weatherparsinghtml.viewmodel.ViewModelApp

class CitiesFragment : Fragment(), Datable {

    private lateinit var viewModel: ViewModelApp

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCitiesBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ViewModelApp::class.java)

        val myRecyclerView = binding.citiesListRecycler
        val adapter = CityAdapter()
        myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        myRecyclerView.adapter = adapter

        viewModel.readAllData.observe(viewLifecycleOwner, Observer { cities ->
            adapter.setCities(cities)
        })

        binding.floatingActionButton.setOnClickListener{
            showDialog()
        }

        return binding.root
    }

    override fun setNameCity(name: String) {
       viewModel.addCity(City(0, name))
    }

    fun showDialog() {
        val dialog = AddCityDialogFragment()
        activity?.supportFragmentManager?.let { dialog.show(it, "Add city") }
    }
}