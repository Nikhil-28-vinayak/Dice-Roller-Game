package com.example.dicerollergame.screens.dicegamescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceGameScreen(){
    Scaffold(
        topBar = {DiceGameTopBar()}
    ) {innerPadding->
        Column(modifier = Modifier.padding(innerPadding)) {  }
    }
}