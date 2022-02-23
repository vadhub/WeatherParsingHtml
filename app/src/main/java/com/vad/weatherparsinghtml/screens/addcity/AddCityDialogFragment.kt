package com.vad.weatherparsinghtml.screens.addcity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.vad.weatherparsinghtml.databinding.DialogFragmentAddCityBinding
import com.vad.weatherparsinghtml.model.room.city.entities.City
import com.vad.weatherparsinghtml.screens.cities.CitiesFragment
import com.vad.weatherparsinghtml.viewmodel.ViewModelCity

class AddCityDialogFragment : DialogFragment() {

    private var viewModel: ViewModelCity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: DialogFragmentAddCityBinding = DialogFragmentAddCityBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(requireActivity()).get(ViewModelCity::class.java)

        rootView.addBtn.setOnClickListener {
            //datable.setNameCity(rootView.cityName.text.toString())
            viewModel!!.addCity(City(0, rootView.cityName.text.toString()))
            dialog?.dismiss()
        }
        return rootView.root
    }
}