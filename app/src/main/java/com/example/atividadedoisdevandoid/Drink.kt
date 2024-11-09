package com.example.atividadedoisdevandoid
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
class Drink (
    val drinkImage : Int,
    val drinkName : String,
    val drinkTeor : String,
    val drinkVolume : String,
    val drinkPrice : String
) : Parcelable {
}
