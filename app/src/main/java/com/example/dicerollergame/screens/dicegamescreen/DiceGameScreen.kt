package com.example.dicerollergame.screens.dicegamescreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dicerollergame.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun DiceGameScreen(
    navController: NavHostController,
    player01: String,
    player02: String,
    totalScore1: Int
) {
    Row {
        Scaffold(
            topBar = { DiceGameTopBar(navController) }
        ) { innerPadding ->
            //for players score
            var player1Score by remember { mutableStateOf(0) }
            var player2Score by remember { mutableStateOf(0) }
            //for dice rolling
            var diceValue by remember { mutableStateOf(0) }
            var isPlayer1Turn by remember { mutableStateOf(true) }
            var isRolling by remember { mutableStateOf(false) }

            //for Coroutine
            val scope = rememberCoroutineScope()

            // Animation
            val rotation = remember { Animatable(0f) }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Let's Play",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("Score Limit: $totalScore1", fontSize =16.sp, fontWeight = FontWeight.SemiBold )
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black, RoundedCornerShape(8.dp))
                        .height(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row() {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Text(
                                "$player01 's Score: $player1Score",
                                color = Color.White,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(start = 10.dp),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Row {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Text(
                                "$player02 's Score: $player2Score",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                            .rotate(rotation.value),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        when (diceValue) {
                            1 -> ScoreImage1()
                            2 -> ScoreImage2()
                            3 -> ScoreImage3()
                            4 -> ScoreImage4()
                            5 -> ScoreImage5()
                            else -> ScoreImage6()
                        }
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            scope.launch {
                                if (!isRolling) {
                                    isRolling = true
                                    repeat(5) {
                                        diceValue =(1..6).random()
                                        rotation.snapTo(0f)
                                        rotation.animateTo(
                                            targetValue = 180f,
                                            animationSpec = tween(50)
                                        )
                                        delay(50)
                                    }
                                }
                                player1Score += diceValue
                                if (diceValue == 6) isPlayer1Turn = true
                                else isPlayer1Turn = false
                                isRolling = false
                                if (player1Score>=totalScore1){
                                    navController.navigate(Routes.Winner(winnerName = player01, looserName = player02,totalScore=totalScore1))
                                    return@launch
                                }
                            }

                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            disabledContainerColor = Color.LightGray,
                            disabledContentColor = Color.Black
                        ), modifier = Modifier.weight(1f),
                        enabled = isPlayer1Turn,
                        elevation = ButtonDefaults.buttonElevation(10.dp)
                    ) {
                        Text("$player01: Roll Dice")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                if (!isRolling) {
                                    isRolling = true
                                    repeat(5) {
                                        diceValue = (1..6).random()
                                        rotation.snapTo(0f)
                                        rotation.animateTo(
                                            targetValue = 180f,
                                            animationSpec = tween(50)
                                        )
                                        delay(50)
                                    }
                                }
                                player2Score += diceValue
                                if (diceValue == 6) isPlayer1Turn = false
                                else isPlayer1Turn = true
                                isRolling = false
                                if(player2Score>=totalScore1){
                                    navController.navigate(Routes.Winner(winnerName = player02, looserName = player01, totalScore = totalScore1))
                                    return@launch
                                }
                            }
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            disabledContainerColor = Color.LightGray,
                            disabledContentColor = Color.Black
                        ), modifier = Modifier.weight(1f),
                        enabled = !isPlayer1Turn,
                        elevation = ButtonDefaults.buttonElevation(10.dp)
                    ) {
                        Text("$player02: Roll Dice")
                    }
                }
            }
        }
    }
}