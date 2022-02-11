package com.vad.weatherparsinghtml.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vad.weatherparsinghtml.model.api.repository.RepositoryApi

class ViewModelAppFactory(private val application: Application,private val repositoryApi: RepositoryApi): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelApp(application, repositoryApi) as T
    }
}