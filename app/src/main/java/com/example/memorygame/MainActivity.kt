package com.example.memorygame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Train
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memorygame.ui.theme.MemoryGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoryGameTheme {

            }
        }
    }
}

@Composable
fun Game (modifier: Modifier = Modifier) {
    var image_list = listOf<Int>(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5
    )
    var score by remember { mutableIntStateOf(0) }
    var imageVector by remember { mutableIntStateOf(R.drawable.image_1) }
    Scaffold(
        topBar = {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Score: $score",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        containerColor = Color(195,177,222),
        bottomBar = {
            Row (
                modifier = modifier
                    .fillMaxWidth()
                    .height(70.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Red)
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "No")
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Green)
                ) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "Yes")
                }
            }
        }
    ) {paddingValues ->
        Column (modifier = modifier.padding(top = paddingValues.calculateTopPadding())) {
            Image(painter = painterResource(id = imageVector), contentDescription = "image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MemoryGameTheme {
        Game()
    }
}