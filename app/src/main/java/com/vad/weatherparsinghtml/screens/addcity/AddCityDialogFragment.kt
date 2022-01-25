package com.vad.weatherparsinghtml.screens.addcity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.vad.weatherparsinghtml.R
import com.vad.weatherparsinghtml.databinding.DialogFragmentAddCityBinding

class AddCityDialogFragment : DialogFragment() {

    private lateinit var datable: Datable

    override fun onAttach(context: Context) {
        super.onAttach(context)
        datable = activity as Datable
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: DialogFragmentAddCityBinding = DialogFragmentAddCityBinding.inflate(layoutInflater)

        rootView.addBtn.setOnClickListener {
            datable.setNameCity(rootView.cityName.text.toString())
            dialog?.dismiss()
        }
        return rootView.root
    }
}