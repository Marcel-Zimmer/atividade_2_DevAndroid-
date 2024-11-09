package com.example.atividadedoisdevandoid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView


class DrinkAdapter(
    private val drinks : List<Drink>,
    private val context : Context,
    private val click : (drink : Drink) -> Unit
) : RecyclerView.Adapter<DrinkAdapter.DrinksViewHolder>() {

    inner class DrinksViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        val drinkName = itemView.findViewById<TextView>(R.id.textView)
        val drinkImage = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(drink:Drink){
            drinkName.text = drink.drinkName
            drinkImage.setImageResource(drink.drinkImage)
            itemView.setOnClickListener{
                click(drink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return DrinksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size

    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        val drink = drinks[position]
        holder.bind(drink)
    }

}