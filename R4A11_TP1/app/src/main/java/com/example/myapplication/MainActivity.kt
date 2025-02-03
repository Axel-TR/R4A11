package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutPrincipal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layoutPrincipal : ConstraintLayout = findViewById(R.id.layoutPrincipal)
        val premierBouton : Button =findViewById(R.id.premierButton)
        val text : TextView = findViewById(R.id.textView)
        val saisie :EditText = findViewById(R.id.editTextText)
        val nextButton = Button(this)
        layoutPrincipal.addView(nextButton)
        nextButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        premierBouton.setOnClickListener {
            val texteSaisie = saisie.text.toString()
            if (texteSaisie== "afficher nouveau textView"){
                val deuxiemeTextView = TextView(this)
                deuxiemeTextView.text= "text"
                layoutPrincipal.addView(deuxiemeTextView)


                text.text = texteSaisie
            }
        }
    }
}