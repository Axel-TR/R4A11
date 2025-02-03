package com.example.myapplication

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val layoutPrincipal = ConstraintLayout(this)
        layoutPrincipal.id = View.generateViewId()

        setContentView(layoutPrincipal)

        ViewCompat.setOnApplyWindowInsetsListener(layoutPrincipal) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Welcome Label
        val welcomeLabel = TextView(this).apply {
            id = View.generateViewId()
            text = getString(R.string.welcome)
            setTypeface(null, Typeface.BOLD)
            textSize = 24f
        }
        layoutPrincipal.addView(welcomeLabel)

        // Display Name Label
        val displayNameLabel = TextView(this).apply {
            id = View.generateViewId()
            textSize = 18f
        }
        layoutPrincipal.addView(displayNameLabel)

        // Name Input
        val nameInput = EditText(this).apply {
            id = View.generateViewId()
            hint = getString(R.string.nameInput)
            setPadding(20, 20, 20, 20)

        }
        layoutPrincipal.addView(nameInput)

        //ageInput
        val ageInput = EditText(this).apply {
            id = View.generateViewId()
            hint = getString(R.string.ageInput)
            setPadding(20, 20, 20, 20)
        }
        layoutPrincipal.addView(ageInput)

        // Confirm Button
        val confirmButton = Button(this).apply {
            id = View.generateViewId()
            text = getString(R.string.confirm)
        }
        layoutPrincipal.addView(confirmButton)


        val constraintSet = ConstraintSet()
        constraintSet.clone(layoutPrincipal)

        // Positionnement de welcomeLabel
        constraintSet.connect(welcomeLabel.id, ConstraintSet.TOP, layoutPrincipal.id, ConstraintSet.TOP, 550)
        constraintSet.connect(welcomeLabel.id, ConstraintSet.START, layoutPrincipal.id, ConstraintSet.START, 0)
        constraintSet.connect(welcomeLabel.id, ConstraintSet.END, layoutPrincipal.id, ConstraintSet.END, 0)

        // Positionnement de displayNameLabel
        constraintSet.connect(displayNameLabel.id, ConstraintSet.TOP, welcomeLabel.id, ConstraintSet.BOTTOM, 400)
        constraintSet.connect(displayNameLabel.id, ConstraintSet.START, layoutPrincipal.id, ConstraintSet.START, 0)
        constraintSet.connect(displayNameLabel.id, ConstraintSet.END, layoutPrincipal.id, ConstraintSet.END, 0)

        // Positionnement de nameInput
        constraintSet.connect(nameInput.id, ConstraintSet.TOP, displayNameLabel.id, ConstraintSet.BOTTOM, 50)
        constraintSet.connect(nameInput.id, ConstraintSet.START, layoutPrincipal.id, ConstraintSet.START, 50)
        constraintSet.connect(nameInput.id, ConstraintSet.END, layoutPrincipal.id, ConstraintSet.END, 50)
        // Positionnement de nameInput
        constraintSet.connect(ageInput.id, ConstraintSet.TOP, nameInput.id, ConstraintSet.BOTTOM, 50)
        constraintSet.connect(ageInput.id, ConstraintSet.START, layoutPrincipal.id, ConstraintSet.START, 50)
        constraintSet.connect(ageInput.id, ConstraintSet.END, layoutPrincipal.id, ConstraintSet.END, 50)

        // Positionnement de confirmButton
        constraintSet.connect(confirmButton.id, ConstraintSet.TOP, ageInput.id, ConstraintSet.BOTTOM, 50)
        constraintSet.connect(confirmButton.id, ConstraintSet.START, layoutPrincipal.id, ConstraintSet.START, 50)
        constraintSet.connect(confirmButton.id, ConstraintSet.END, layoutPrincipal.id, ConstraintSet.END, 50)

        // Appliquer les contraintes
        constraintSet.applyTo(layoutPrincipal)

        // Update on nameInput
        nameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                displayNameLabel.text = s.toString()
            }
        })

        confirmButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("NAME", nameInput.text.toString())
            intent.putExtra("AGE",ageInput.text.toString())
            startActivity(intent)
        }
    }
}
