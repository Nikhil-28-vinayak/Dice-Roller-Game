package com.example.dicerollergame.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    object PlayerName : Routes()

    @Serializable
    data class DiceGame(
        val player01: String,
        val player02: String,
         val totalScore:Int
    ) : Routes()

    @Serializable
    data class Winner(val winnerName: String, val looserName: String,val totalScore: Int) : Routes()
}