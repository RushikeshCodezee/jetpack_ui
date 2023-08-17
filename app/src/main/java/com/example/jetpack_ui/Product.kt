package com.example.jetpack_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_ui.ui.theme.Jetpack_uiTheme

class Product : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_uiTheme {
                Ui()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Jetpack_uiTheme {
        Ui()
    }
}

@Composable
fun Ui() {
    val customFontFamily = FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )

    Image(
        painter = painterResource(id = R.drawable.pic_one),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    )

    Image(
        painter = painterResource(id = R.drawable.ic_back_btn),
        contentDescription = null,
        modifier = Modifier
            .height(40.dp)
            .width(50.dp)
            .padding(top = 10.dp, start = 10.dp)
    )

    Text(
        text = "Cappuccino",
        color = Color.White,
        fontFamily = customFontFamily,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(top = 145.dp, start = 20.dp)
    )

    Text(
        text = "With Chocolate",
        color = Color.White,
        fontFamily = customFontFamily,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 12.sp),
        modifier = Modifier.padding(top = 175.dp, start = 20.dp)
    )

    Image(
        painter = painterResource(id = R.drawable.ic_back_btn),
        contentDescription = null,
        modifier = Modifier
            .height(40.dp)
            .width(50.dp)
            .padding(top = 10.dp, start = 10.dp)

    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.fram),
            contentDescription = null,
            modifier = Modifier
                .height(500.dp)
                .width(330.dp)
        )
    }

    Image(
        painter = painterResource(id = R.drawable.cofffe),
        contentDescription = null,
        modifier = Modifier
            .padding(start =30.dp, top = 210.dp)
            .size(80.dp)
    )

    Text(
        text = "Coffee Size",
        color = Color.Black,
        fontFamily = customFontFamily,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(top = 300.dp, start = 20.dp)
    )

    Row(
        modifier = Modifier.padding(16.dp).padding(top = 320.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundedCornerButton(text = "Small")
        RoundedCornerButton(text = "Medium")
        RoundedCornerButton(text = "Large")
    }

    Text(
        text = "About",
        color = Color.Black,
        fontFamily = customFontFamily,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(top = 410.dp, start = 20.dp)
    )

    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Id ipsum vivamus velit lorem amet. Tincidunt cras volutpat aliquam porttitor molestie. Netus neque, habitasse id vulputate proin cras. Neque, vel duis sit vel pellentesque tempor. A commodo arcu tortor arcu, elit. ",
        color = Color.Black,
        fontFamily = customFontFamily,
        textAlign = TextAlign.Left,
        style = TextStyle(fontSize = 14.sp),
        modifier = Modifier.padding(top = 450.dp, start = 20.dp, end = 20.dp)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = {  },
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
            Text(text = "Add to Cart       |    50 K")
        }
    }
}

@Composable
fun RoundedCornerButton(text: String) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .padding(4.dp)
            .graphicsLayer(clip = true)
            .width(100.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF846046),
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }

}
