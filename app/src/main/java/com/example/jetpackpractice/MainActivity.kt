package com.example.jetpackpractice

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp()
        }
    }
}

data class Message(val author: String, val message: String)


@Composable
fun MyApp(){

    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if (shouldShowOnboarding){
        OnboardingScreen(onContinueClicked = {shouldShowOnboarding = false})
    }
    else{ Greeting()
    }
}

@Composable
fun Greeting(    modifier: Modifier = Modifier,
                 names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
             Message(name = name)
        }
    }
}

@Composable
fun Message(name: String) {
    var extended  by remember{ mutableStateOf(false) }
    val extraPadding = if (extended) 48.dp else 0.dp
    Surface( color = Color.Magenta,
        modifier = Modifier.padding( horizontal = 8.dp, vertical = 4.dp )) {
        Row(modifier = Modifier.padding(24.dp)){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = name)}
            ElevatedButton(onClick = {
                extended = !extended
            }) {
                Text(if (extended) "Show Less" else "Show More")
            }
        }
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: ()-> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { onContinueClicked }
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
        OnboardingScreen(onContinueClicked = {})
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MessagePreview(){
    Greeting()
}
