package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme
import java.io.RandomAccessFile
import kotlin.random.Random

class PracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            val color = remember{
                mutableStateOf(Color.Yellow)
            }

            Column (Modifier.fillMaxSize()){
                colorBox(Modifier.fillMaxSize().weight(1f)){
                    color.value = it
                }


                Box(modifier = Modifier.fillMaxSize()
                    .weight(1f)
                    .background(color.value))
            }

        }
    }
}

@Composable
fun colorBox(modifier: Modifier = Modifier,
             updateColor: (Color) -> Unit){

    Box(modifier = modifier
        .background(Color.Blue)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )
}

@Composable
@Preview
fun box(){
colorBox(Modifier.fillMaxSize()){
    it
}
}
