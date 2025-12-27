package com.example.dicerollergame.screens.dicegamescreen

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.dicerollergame.R

@Composable
fun ScoreImage1(){
    Image(painter = painterResource(R.drawable.dice_01),contentDescription = null)
}
@Composable
fun ScoreImage2(){
    Image(painter = painterResource(R.drawable.dice_02),contentDescription = null)
}
@Composable
fun ScoreImage3(){
    Image(painter = painterResource(R.drawable.dice_03),contentDescription = null)
}
@Composable
fun ScoreImage4(){
    Image(painter = painterResource(R.drawable.dice_04),contentDescription = null)
}
@Composable
fun ScoreImage5(){
    Image(painter = painterResource(R.drawable.dice_05),contentDescription = null)
}
@Composable
fun ScoreImage6(){
    Image(painter = painterResource(R.drawable.dice_06),contentDescription = null)
}