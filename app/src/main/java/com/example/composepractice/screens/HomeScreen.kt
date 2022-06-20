package com.example.composepractice.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.Component.SpacerH
import com.example.composepractice.R

//H&$8Er1isrd

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

@Composable
fun HomeScreen() {
    Scaffold(
        backgroundColor = HexToJetpackColor.getColor("f2f2f2")


    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            TopNews()
        }
    }
}

@Preview
@Composable
fun TopNews() {
    val topNewsHeight: Int = 400;
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }

    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f)),
        startY = topNewsHeight.toFloat()/3,  // 1/3
        endY = topNewsHeight.toFloat()
    )
    return Box(modifier = Modifier
        .fillMaxWidth(1f)
        .height(topNewsHeight.dp), content = {

        Image(
            painter = painterResource(id = R.drawable.news_img),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(topNewsHeight.dp)
                .clip(shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
        )
        Box(modifier = Modifier.matchParentSize().clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)).background(gradient))

        Column(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(top = (topNewsHeight / 3).dp, end = 16.dp, start = 16.dp)
        ) {
            OpacityButton()
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "How to make a surface background half transparent in jetpack compose, but not the content?",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            )
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 32.dp)
                .align(alignment = Alignment.BottomStart)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Learn More",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            )
            Icon(Icons.Default.ArrowForward, contentDescription = "", tint = Color.White)
        }



    })
}

@Composable
fun OpacityButton() {
    return Box(
        Modifier
            .padding(all = 10.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.White.copy(alpha = 0.6f))
            .padding(all = 10.dp)
            .clickable {

            }

    ) {

        Text(
            text = "News of the day",
            modifier = Modifier.padding(horizontal = 12.dp),

            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
        )

    }
}

@Composable
fun HomeTaps() {
    val list = listOf(
        "All", "Sport", "Games", "Political",
        "All", "Sport", "Games", "Political"

    )

    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    LazyRow() {
        items(count = list.size, itemContent = { index: Int ->
            Tap(isSelected = index == selectedIndex, title = list[index], onClick = {
                selectedIndex = index
            })
        })
    }
}


@Composable
fun Tap(isSelected: Boolean, title: String, onClick: () -> Unit) {
    val modifierForContainer: Modifier = if (isSelected)
        Modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(MaterialTheme.colors.primary)
            .border(0.4.dp, MaterialTheme.colors.primary, shape = RoundedCornerShape(15.dp))
            .padding(horizontal = 16.dp, vertical = 1.dp)
    else
        Modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color.White)
            .clip(shape = RoundedCornerShape(15.dp))
            .border(0.4.dp, MaterialTheme.colors.primary, shape = RoundedCornerShape(15.dp))
            .padding(horizontal = 16.dp, vertical = 1.dp)


    val modifierForTextStyle: TextStyle = if (isSelected)
        TextStyle(color = Color.White)
    else
        TextStyle(color = MaterialTheme.colors.primary)


    Box(modifier = modifierForContainer.padding(5.dp)) {
        Text(text = title, style = modifierForTextStyle)
    }
}





