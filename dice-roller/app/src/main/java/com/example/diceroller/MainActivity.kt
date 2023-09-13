package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
                DiceWithButtonAndImage(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center))
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {

}
private fun getRandomDiceImage(result: Int): Int{
    return when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var primerDado by remember { mutableStateOf(1)}
    var segundoDado by remember { mutableStateOf(1)}
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(getRandomDiceImage(primerDado)), contentDescription = primerDado.toString())
        Image(painter = painterResource(getRandomDiceImage(segundoDado)), contentDescription = segundoDado.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            primerDado = (1..6).random()
            segundoDado = (1..6).random()
        }) {
            Text(stringResource(R.string.roll))
        }
    }
}