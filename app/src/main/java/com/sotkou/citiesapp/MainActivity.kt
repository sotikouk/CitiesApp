package com.sotkou.citiesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. RecyclerView. Αρχικοποίηση
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        // Το LinearLayoutManager χειρίζεται την προβολή των
        // items στο RecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(this, // Context
                LinearLayoutManager.VERTICAL, // Οριζόντια κατεύθυνση
                false) // Αντιστροφή των στοιχείων

        // 2. Data Source
        var citiesList: ArrayList<City> = ArrayList()

        val city1 = City("New York", R.drawable.nyc)
        val city2 = City("London", R.drawable.london)
        val city3 = City("Paris", R.drawable.paris)
        val city4 = City("Amsterdam", R.drawable.amsterdam)
        val city5 = City("San Francisco", R.drawable.sanfrancisco)
        val city6 = City("Hong Kong", R.drawable.hongkong)

        citiesList.add(city1)
        citiesList.add(city2)
        citiesList.add(city3)
        citiesList.add(city4)
        citiesList.add(city5)
        citiesList.add(city6)

        // 3. Adapter
        val adapter = CitiesAdapter(citiesList)
        // Σύνδεση με recyclerView
        recyclerView.adapter = adapter
    }
}