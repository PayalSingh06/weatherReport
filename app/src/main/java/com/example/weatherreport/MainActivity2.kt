package com.example.weatherreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val i = intent.extras
        val city = i?.getString("city")


        if (city != null){
            val url = "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=d0ea2ea24ddf8ada009af1f4f7d7dca2"
            getReport(url)
        }else{

//            val url = "https://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$long&appid=d0ea2ea24ddf8ada009af1f4f7d7dca2"
//            getReport(url)
        }

    }

    private fun getReport(url :String){
        val queue = Volley.newRequestQueue(this)
        val jsonObj = JsonObjectRequest(Request.Method.GET, url, null,
        Response.Listener { response ->
            Log.i("Response", response.toString())

            val main = response.getJSONObject("main")
            textViewTemp.text = main.get("temp").toString()
            textViewHum.text = main.get("humidity").toString()

            val wind = response.getJSONObject("wind")
            textViewWind.text = wind.get("speed").toString()

            val coord = response.getJSONObject("coord")
            textViewLong.text = coord.get("lon").toString()
            textViewLat.text = coord.get("lat").toString()

            textViewCity2.text = response.getString("name")

        },
        Response.ErrorListener {
            Log.i("errorResponse", "error")
        })
        queue.add(jsonObj)
    }
}