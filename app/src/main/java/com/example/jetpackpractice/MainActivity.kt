package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           myApp()
        }
    }
}

data class Message(val author: String, val message: String)

@Composable
fun myApp(names: List<String> = listOf("world", "compose")){
 Surface( modifier = Modifier.padding(vertical = 4.dp)){
     Column {
         for (name in names) {
             Message(name)
         }
     }
     }
 }


@Composable
fun Message(name: String) {
    val extended = remember{ mutableStateOf(false) }
    val extraPadding = if (extended.value) 48.dp else 0.dp
    Surface( color = Color.Magenta,
        modifier = Modifier.padding( horizontal = 8.dp, vertical = 4.dp )) {
        Row(modifier = Modifier.padding(24.dp)){
            Column(
                modifier = Modifier.weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = name)}
            OutlinedButton(onClick = {
                extended.value = !extended.value
            }) {
                Text(if (extended.value) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MessagePreview(){
    myApp()
}
