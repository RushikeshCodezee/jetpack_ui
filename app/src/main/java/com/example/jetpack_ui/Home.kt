package com.example.jetpack_ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpack_ui.ui.theme.Jetpack_uiTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_uiTheme {
                Main2()
                BarkHomeContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_uiTheme {
        Main2()
        BarkHomeContent()
    }
}

@Composable
fun Main2() {
    val context = LocalContext.current
    val customFontFamily = FontFamily(
        Font(R.font.lato, FontWeight.Normal)
    )
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

        ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
                    .padding(top = 25.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.notificatio),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
                    .padding(top = 25.dp)
            )
        }
    }

    Text(
        text = "Good morning, Rushi",
        color = Color.Black,
        fontFamily = customFontFamily,
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(top = 80.dp, start = 20.dp)
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .width(350.dp)
                .padding(top = 100.dp)
                .padding(16.dp),
            backgroundColor = Color(0xFFF8F7FA),
            shape = RoundedCornerShape(corner = CornerSize(30.dp))
        ) {
            var text by remember { mutableStateOf("Search") }

            BasicTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle = typography.body1
            )
        }
    }

    Clickable(
        onClick = {
            val intent = Intent(context, Product::class.java)
            context.startActivity(intent)
        }
    ) {
        Text(
            text = "Categories",
            color = Color.Black,
            fontFamily = customFontFamily,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 190.dp, start = 20.dp)
                .clickable {
                    val intent = Intent(context, Product::class.java)
                    context.startActivity(intent)
                }
        )
    }

    Row(
        modifier = Modifier
            .padding(top = 485.dp)
            .fillMaxWidth()
    ) {

        Text(
            text = "Special Offer",
            color = Color.Black,
            fontFamily = customFontFamily,
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 5.dp, start = 20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_fire),
            contentDescription = null,
            modifier = Modifier
                .height(30.dp)
                .width(50.dp)
                .padding(start = 10.dp)
        )
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .padding(top = 520.dp)
            .height(175.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.pic_three),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .width(150.dp)
                    .padding(start = 10.dp)
            )

            Text(
                text = "Buy 1 get 1 free if you buy with Rushikesh",
                color = Color.Black,
                fontFamily = customFontFamily,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 60.dp, start = 15.dp)
            )
        }
    }

    Row(
        modifier = Modifier.padding(12.dp).padding(top = 200.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RoundedCornerButton2(text = "Cappuccino")
        RoundedCornerButton2(text = "ColdBrew")
        RoundedCornerButton2(text = "Expresso")
    }

}


@Composable
fun Clickable(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    content.invoke()
}

@Composable
fun BarkHomeContent() {
    val puppies = remember { DataProvider.puppyList }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 270.dp)
    ) {

        items(
            items = puppies,
            itemContent = {
                PuppyListItem(puppy = it)
            })
    }
}

@Composable
fun PuppyListItem(puppy: Item) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .width(150.dp),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Column {
            PuppyImage(puppy)
            Column (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)) {
                puppy.title?.let { Text(text = it, style = typography.h6) }
                puppy.subTitle?.let { Text(text = it, fontSize = 12.sp) }
                puppy.prize?.let { Text(text = it, fontSize = 8.sp) }
            }
        }
    }
}

@Composable
private fun PuppyImage(puppy: Item) {
    puppy.img?.let { painterResource(id = it) }?.let {
        Image(
        painter = it,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    }
}

@Composable
fun RoundedCornerButton2(text: String) {
    Button(
        onClick = {  },
        modifier = Modifier
            .padding(2.dp)
            .graphicsLayer(clip = true)
            .width(110.dp),
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF846046),
            contentColor = Color.White
        )
    ) {
        Text(text = text, fontSize = 11.sp)

    }

}