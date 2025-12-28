package com.example.dicerollergame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.dicerollergame.navigation.Routes
import com.example.dicerollergame.screens.dicegamescreen.DiceGameScreen
import com.example.dicerollergame.screens.playernamescreen.PlayerNameScreen
import com.example.dicerollergame.screens.winnerscreen.WinnerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.PlayerName) {
                    composable<Routes.PlayerName> {
                        PlayerNameScreen(navController)
                    }
                    composable<Routes.DiceGame> {backStackEntry->
                        val args = backStackEntry.toRoute<Routes.DiceGame>()
                        DiceGameScreen(navController,args.player01,args.player02)
                    }
                    composable<Routes.Winner> {backStackEntry->
                        val args = backStackEntry.toRoute<Routes.Winner>()
                        WinnerScreen(navController,args.winnerName,args.looserName)
                    }
                }
        }
    }
}
