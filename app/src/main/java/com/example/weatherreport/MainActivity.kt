package com.example.weatherreport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtCity = findViewById<EditText>(R.id.editTextCity1)
        val btnCity = findViewById<Button>(R.id.buttonCity1)
        val btnCurrent = findViewById<Button>(R.id.buttonCurrent)


        btnCity.setOnClickListener {
            val city = edtCity.text.toString()
            val intentCity = Intent(this,MainActivity2::class.java)
            intentCity.putExtra("city",city)
            startActivity(intentCity)
        }

        btnCurrent.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}