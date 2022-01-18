package com.uxstate.cardgradient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uxstate.cardgradient.ui.theme.CardGradientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            //vals

            val painter = painterResource(id = R.drawable.kermit_snow)
            val title = "Kermit Playing in the Snow"
            val description = "Kermit Playing in the Snow"




            Box(modifier = Modifier.fillMaxWidth(.5f)){

                //call ImageCardComposable
                ImageCardComposable(painter = painter, description = description, title = title)
            }

        }
    }
}


@Composable
fun ImageCardComposable(painter: Painter, description: String, title: String) {


    Card(modifier = Modifier.fillMaxWidth(),
        elevation = 5.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(Modifier.height(200.dp)) {

            //Layer 1 - Image
            Image(painter = painter, contentDescription = description, contentScale = ContentScale.Crop)

            //Layer 2 - Gradient - wrap in a box to apply modifier

            Box(
                modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
            )


            //Layer 3 - Text - align to bottom left corner
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomStart){

                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }


        }
    }



}