package com.example.atividadedoisdevandoid

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {

    private lateinit var recyclerViewDrink: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerViewDrink = findViewById(R.id.list)
        recyclerViewDrink.adapter = DrinkAdapter(this.createDrinks(), this) { drink ->
            val intent = Intent(this, secondView::class.java)
            intent.putExtra("drink", drink)
            startActivity(intent)
        }
        recyclerViewDrink.layoutManager = LinearLayoutManager(this)
        recyclerViewDrink.setHasFixedSize(true)
        recyclerViewDrink.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }
    private fun createDrinks() : List<Drink>{
        return listOf(
            Drink(R.drawable.chopp, "Chopp", "5%", "500ml", "12 reais"),
            Drink(R.drawable.gin, "Gin", "40%", "750ml", "75 reais"),
            Drink(R.drawable.whisky, "Whisky", "40%", "1L", "120 reais"),
            Drink(R.drawable.vinho, "Vinho", "12%", "750ml", "50 reais"),
            Drink(R.drawable.tequila, "Tequila", "38%", "750ml", "95 reais"),
            Drink(R.drawable.corote, "Corote", "20%", "500ml", "5 reais")
        )
    }
}