package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layout2 = findViewById<ConstraintLayout>(R.id.layout2)

        val name = intent.getStringExtra("NAME")
        var age = intent.getStringExtra("AGE")
        val ageCalcul = 2024 - (age?.toInt() ?: 2024)

        var welcomeLabel = "Hello "
        welcomeLabel += name ?: "Aucun nom reçu"
        welcomeLabel += " vous avez "
        welcomeLabel += ageCalcul
        welcomeLabel += " ans !"

        val homeWelcomeLabel = TextView(this).apply {
            text = welcomeLabel
            textSize = 24f
        }

        layout2.addView(homeWelcomeLabel)

    }
}