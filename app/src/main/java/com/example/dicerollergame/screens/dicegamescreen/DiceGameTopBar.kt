package com.example.dicerollergame.screens.dicegamescreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.dicerollergame.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceGameTopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text("Dice Rolling Game",
            fontWeight = FontWeight.SemiBold) },
        actions = {
            Button(
                onClick = {navController.navigate(Routes.PlayerName)},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ), modifier = Modifier.padding(end = 16.dp),
                elevation = ButtonDefaults.buttonElevation(10.dp)
            ) {
                Text("New Game")
            }
        })
}