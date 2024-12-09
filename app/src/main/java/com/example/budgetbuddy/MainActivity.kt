// Author: Josh Jonathan Naidoo ST10454615
package com.example.budgetbuddy

import DetailsActivity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Parallel arrays to store daily spending
    private val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val dailySpending = DoubleArray(7) // Array to store spending for each day

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize daily spending data (example values)
        initializeData()

        // Set up ListView to display daily spending
        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getDailySpendingList())
        listView.adapter = adapter

        // Set up button click listener
        val buttonDetails: Button = findViewById(R.id.button_details)
        buttonDetails.setOnClickListener {
            navigateToDetailsScreen()
        }
    }

    // Method to initialize daily spending data
    private fun initializeData() {
        dailySpending[0] = 20.0 // Monday
        dailySpending[1] = 15.5 // Tuesday
        dailySpending[2] = 30.0 // Wednesday
        dailySpending[3] = 25.0 // Thursday
        dailySpending[4] = 10.0 // Friday
        dailySpending[5] = 50.0 // Saturday
        dailySpending[6] = 40.0 // Sunday
    }

    // Method to get a list of daily spending as strings
    private fun getDailySpendingList(): Array<String> {
        return Array(daysOfWeek.size) { index ->
            "${daysOfWeek[index]}: $${dailySpending[index]}"
        }
    }

    // Method to navigate to the details screen
    private fun navigateToDetailsScreen() {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("dailySpending", dailySpending) // Pass daily spending data to the next activity
        startActivity(intent)
    }
}