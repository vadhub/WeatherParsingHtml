package com.vad.weatherparsinghtml.screens.addcity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.vad.weatherparsinghtml.R
import com.vad.weatherparsinghtml.databinding.DialogFragmentAddCityBinding
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.screens.cities.CitiesFragment
import com.vad.weatherparsinghtml.viewmodel.ViewModelApp

class AddCityDialogFragment : DialogFragment() {

    private lateinit var datable: Datable
    private var viewModel: ViewModelApp? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        datable = CitiesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: DialogFragmentAddCityBinding = DialogFragmentAddCityBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(requireActivity()).get(ViewModelApp::class.java)

        rootView.addBtn.setOnClickListener {
            //datable.setNameCity(rootView.cityName.text.toString())
            viewModel!!.addCity(City(0, rootView.cityName.text.toString()))
            dialog?.dismiss()
        }
        return rootView.root
    }
}