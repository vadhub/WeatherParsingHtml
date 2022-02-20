package com.vad.weatherparsinghtml.screens.cities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vad.weatherparsinghtml.databinding.FragmentCitiesBinding
import com.vad.weatherparsinghtml.model.api.repository.RepositoryApi
import com.vad.weatherparsinghtml.screens.addcity.AddCityDialogFragment
import com.vad.weatherparsinghtml.screens.addcity.Datable
import com.vad.weatherparsinghtml.viewmodel.ViewModelApp
import com.vad.weatherparsinghtml.viewmodel.ViewModelAppFactory

class CitiesFragment : Fragment(){

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

        val viewModelAppFactory = ViewModelAppFactory(requireActivity().application)
        viewModel =
            ViewModelProvider(requireActivity(), viewModelAppFactory).get(ViewModelApp::class.java)

        Log.i("fdff", "${viewModel.toString()} dfg")

        viewModel?.readAllData?.observe(viewLifecycleOwner) { cities ->
            adapter.setCities(cities)
        }

        //viewModel?.getWeather("Volgograd")

        binding.floatingActionButton.setOnClickListener {
            showDialog()
        }

        return binding.root
    }

    fun showDialog() {
        val dialog = AddCityDialogFragment()
        activity?.supportFragmentManager?.let { dialog.show(it, "Add city") }
    }
}