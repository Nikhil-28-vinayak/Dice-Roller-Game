package com.example.dicerollergame.screens.winnerscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dicerollergame.R
import com.example.dicerollergame.navigation.Routes


@Composable
fun WinnerScreen(
    navController: NavHostController,
    winnerName: String,
    looserName: String,
    totalScore: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.winner_trophy),
            contentDescription = null,
            modifier = Modifier.size(400.dp)
        )
        Text(
            "Congratulations",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "$winnerName Won the Game!",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {navController.navigate(Routes.DiceGame(player01 = winnerName, player02 = looserName, totalScore = totalScore))},
            modifier = Modifier.padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            ), shape = RoundedCornerShape(8.dp),
        ) {
            Text("PLAY AGAIN", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {navController.navigate(Routes.PlayerName)},
            modifier = Modifier.padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            ), shape = RoundedCornerShape(8.dp),
        ) {
            Text("START NEW GAME", fontSize = 16.sp)
        }
    }

}