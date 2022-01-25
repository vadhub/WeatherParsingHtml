package com.vad.weatherparsinghtml.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.vad.weatherparsinghtml.databinding.ActivityMainBinding
import com.vad.weatherparsinghtml.screens.addcity.AddCityDialogFragment
import com.vad.weatherparsinghtml.screens.addcity.Datable
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class MainActivity : AppCompatActivity(), Datable {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val places = mutableListOf("волгоград", "москва", "камчатка")
//
//        Thread{
//            println(gettingResult(places))
//        }.start()


    }

    fun onAddCity(view: View) {
        showDialog()
    }

    override fun setNameCity(name: String) {
        Log.i("MYDIALOG", "setNameCity: $name")
    }

    fun showDialog() {
        val dialog = AddCityDialogFragment()
        dialog.show(supportFragmentManager, "Add city")
    }


//    private fun gettingResult(places: List<String>):List<String> {
//        val degrees = mutableListOf<String>()
//
//        for (p in places) {
//            val elements = connection(p)?.getElementsByClass("wob_t q8U8x")
//            elements?.let { degrees.add(it.text()) }
//        }
//
//        return degrees
//    }
//
//    private fun connection(place: String): Document? {
//        var document: Document? = null
//
//            document = Jsoup
//                .connect("https://www.google.com/search?channel=fs&client=ubuntu&q=погода+$place")
//                .get()
//        return document
//    }

//    private class GetResultTask(context: MainActivity): AsyncTask<Void, Void, String>() {
//
//        private val activityReference: WeakReference<MainActivity> = WeakReference(context)
//
//        override fun doInBackground(vararg p0: Void?): String? {
//            val document: Document = Jsoup
//                .connect("https://www.google.com/search?channel=fs&client=ubuntu&q=%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0+%D0%B2%D0%BE%D0%BB%D0%B3%D0%BE%D0%B3%D1%80%D0%B0%D0%B4")
//                .get()
//
//            val elements: Elements = document.getElementsByClass("wob_t q8U8x")
//            return elements.text()
//        }
//
//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            val activity = activityReference.get()
//
//            if (activity == null || activity.isFinishing) return
//
//            activity.binding.textViewWeather.text = result
//        }
//    }


}