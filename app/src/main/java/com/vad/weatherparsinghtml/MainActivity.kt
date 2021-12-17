package com.vad.weatherparsinghtml

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.vad.weatherparsinghtml.databinding.ActivityMainBinding
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val task = GetResultTask(this)
        Thread{
            val document = Jsoup
                .connect("https://www.google.com/search?channel=fs&client=ubuntu&q=%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0+%D0%B2%D0%BE%D0%BB%D0%B3%D0%BE%D0%B3%D1%80%D0%B0%D0%B4")
                .get()
            val elements: Elements = document.getElementsByClass("wob_t q8U8x")
            handler.post{
                binding.textViewWeather.text = elements.text()
            }
        }.start()
        //task.execute()

    }

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