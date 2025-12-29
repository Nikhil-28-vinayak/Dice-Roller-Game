package com.example.dicerollergame.screens.playernamescreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dicerollergame.R
import com.example.dicerollergame.navigation.Routes
import kotlin.math.sin


@Composable
fun PlayerNameScreen(navController: NavHostController) {
    var player01 by remember { mutableStateOf("") }
    var player02 by remember { mutableStateOf("") }
    var selectScore by remember { mutableStateOf(50) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(painter = painterResource(id = R.drawable.dice_logo), contentDescription = null)
        Spacer(modifier = Modifier.height(70.dp))
        OutlinedTextField(
            value = player01,
            onValueChange = { if (it.length <= 8) player01 = it },
            label = { Text("Player 01 Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = player02,
            onValueChange = { if (it.length <= 8) player02 = it },
            label = { Text("Player 02 Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(30.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Select Score", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(
                        modifier = Modifier
                            .clickable(onClick = {})
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = if (selectScore == 50) {
                                    Color.Black
                                } else {
                                    Color.LightGray
                                }, shape = RoundedCornerShape(30.dp)
                            )
                            .clickable(onClick = { selectScore = 50 }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "50",
                            fontWeight = FontWeight.Bold,
                            color = if (selectScore.equals(50)) Color.White else Color.Gray,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
                            .background(
                                color = if (selectScore == 100)
                                    Color.Black
                                else Color.LightGray,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clickable(onClick = { selectScore = 100 }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "100",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectScore == 100) Color.White else Color.Gray
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                navController.navigate(
                    Routes.DiceGame(
                        player01 = player01,
                        player02 = player02,
                        totalScore = selectScore
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Gray
            ), shape = RoundedCornerShape(8.dp),
            enabled = player01.isNotEmpty() && player02.isNotEmpty() && player02 != player01
        ) {
            Text("START GAME", fontSize = 16.sp)
        }
    }
}