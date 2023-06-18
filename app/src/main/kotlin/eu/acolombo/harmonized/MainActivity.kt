package eu.acolombo.harmonized

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.acolombo.harmonized.ui.theme.CustomColor
import eu.acolombo.harmonized.ui.theme.HarmonizedColorsTheme
import eu.acolombo.harmonized.ui.theme.LocalHarmonizedColor
import eu.acolombo.harmonized.ui.theme.LocalHarmonizedColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarmonizedColorsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Greeting(
                            name = "Custom color",
                            backgroundColor = CustomColor,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting(
                            name = "Harmonized custom color",
                            backgroundColor = LocalHarmonizedColor.current.harmonizedCustomColor,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting(
                            name = "Harmonized custom color accent",
                            backgroundColor = LocalHarmonizedColors.current.accent,
                            textColor = LocalHarmonizedColors.current.onAccent,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting(
                            name = "Harmonized custom color accent container",
                            backgroundColor = LocalHarmonizedColors.current.accentContainer,
                            textColor = LocalHarmonizedColors.current.onAccentContainer,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    textColor: Color = LocalHarmonizedColors.current.onAccent,
) {
    Text(
        text = name,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.extraLarge,
            )
            .padding(16.dp),
        color = textColor,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HarmonizedColorsTheme {
        Greeting("Android", CustomColor)
    }
}