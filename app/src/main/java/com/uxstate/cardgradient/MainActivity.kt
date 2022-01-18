package com.uxstate.cardgradient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.uxstate.cardgradient.ui.theme.CardGradientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardGradientTheme {

            }
        }
    }
}


@Composable
fun ImageCardComposable(painter: Painter, description: String, title: String) {


    Box(modifier = Modifier.width(250.dp)) {

        //Layer 1 - Image
        Image(painter = painter, contentDescription = description)

        //Layer 2 - Gradient - wrap in a box to apply modifier

        Box(
            modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                          colors=  listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
        )
    }

}