package com.example.jetpack_ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.jetpack_ui.ui.theme.Jetpack_uiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_uiTheme {
                Main()
                RoundedButtonDemo()
            }
        }
    }
}

@Preview
@Composable
fun Poss(){
    Main()
    RoundedButtonDemo()
}

@Composable
fun RoundedButtonDemo() {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = {
              context.startActivity(Intent(context, Home::class.java))
            },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth()
                .height(60.dp),

                colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF846046),
                contentColor = Color.White
            )
        ) {
            Text(text = "Get Started")
        }
    }
}

@Composable
fun Main() {
      val customFontFamily = FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {
        Image(
            painter = painterResource(id = R.drawable.blur),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .padding(bottom = 200.dp)
                .wrapContentSize(align = Alignment.BottomCenter)
        ) {

            Text(
                text = "Good coffee,\n" +
                        "Good friends,\n" +
                        "let it blends\n",
                color = Color.White,
                fontFamily = customFontFamily,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
            )

            Text(
                text = "The best grain, the finest roast,\n" +
                        " the most powerful flavor.",
                color = Color.White,
                fontFamily = customFontFamily,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold)
            )

        }
    }
}


