package com.example.atividadedoisdevandoid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secondView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        if (bundle != null) {
            val drink = bundle.getParcelable<Drink>("drink")
            if (drink != null) {
                findViewById<ImageView>(R.id.imageViewDrink).setImageResource(drink.drinkImage)
                findViewById<TextView>(R.id.textViewName).text = drink.drinkName
                findViewById<TextView>(R.id.textViewVolume).text = drink.drinkVolume
                findViewById<TextView>(R.id.textViewTeor).text = drink.drinkTeor.toString()
                findViewById<TextView>(R.id.textViewPreco).text = drink.drinkPrice.toString()

            }
        }
    }

    fun back(view: View) {
        finish()
    }
}