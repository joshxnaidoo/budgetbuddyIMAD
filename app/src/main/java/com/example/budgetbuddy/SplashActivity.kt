package com.example.budgetbuddy  // Replace with your actual package name

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val splashDuration: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash) // Ensure this layout file exists

        // Use a Handler to delay the transition to the MainActivity
        Handler().postDelayed({
            // Start the MainActivity
            val intent = Intent(this, MainActivity::class.java) // Create Intent for MainActivity
            startActivity(intent)
            finish() // Close the SplashActivity
        }, splashDuration)
    }
}