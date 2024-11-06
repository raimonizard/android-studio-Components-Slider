package com.example.componentslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentslider.ui.theme.ComponentSliderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentSliderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding))
                    {
                        MyProSlider(modifier = Modifier.padding(innerPadding))
                        MyRangeSlider(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

/**
 * Composició de Slider
 * @author Raimon Izard
 * @since 06-11-2024
 */
@Composable
fun MyProSlider(modifier: Modifier) {
    var sliderValue: Float by remember { mutableStateOf(0f) }
    var finishValue: String by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(20.dp, 40.dp)
    ) {

        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            onValueChangeFinished = { finishValue = sliderValue.toString() },
            valueRange = 0f..10f,
            steps = 9,
            enabled = true
        )

        Text(text = finishValue)
    }
}

/**
 * Composició de RangeSlider
 * @author Raimon Izard
 * @since 06-11-2024
 */
@Composable
fun MyRangeSlider(modifier: Modifier) {
    var currentRange by remember { mutableStateOf(2f..5f) }

    Box(
        modifier = Modifier
            .padding(20.dp, 40.dp)
    ) {

        RangeSlider(
            value = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..10f,
            enabled = true
        )

        Text(
            text = "From ${String.format("%.2f", currentRange.start)} to ${
                String.format(
                    "%.2f",
                    currentRange.endInclusive
                )
            }"
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComponentSliderTheme {}
}