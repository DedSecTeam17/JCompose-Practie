package com.example.composepractice.screens.fragments

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composepractice.Component.SpacerH
import com.example.composepractice.R
import com.example.composepractice.utils.AppColors
import com.example.composepractice.utils.HexToJetpackColor



@Composable
fun HomeFragment() {
    Scaffold(
        backgroundColor = AppColors.BACKGROUND_COLOR


    ) {
        LazyColumn {
            item {

                TopNews()
            }
            item {
                BreakingNews()
            }

        }
    }
}

@Composable
fun BreakingNews() {
    val items = (1..10).map { "Item $it" }

    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Breaking News",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Text(text = "More", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp))

        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState()

        ) {
            itemsIndexed(items = items) { index, item ->
                HorizntalNewsItem()
            }

        }


    }
}

@Composable
fun HorizntalNewsItem(imageUrl : String  = "https://static.seekingalpha.com/cdn/s3/uploads/getty_images/1204283040/image_1204283040.jpg?io=getty-c-w750") {
    Column(modifier = Modifier
        .padding(all = 10.dp)
        .width(220.dp)
        .clickable { }
        .padding(10.dp)) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .width(200.dp)
                .height(120.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        )
         SpacerH(sizeInDp = 10f)
        Text(
            text = "Displaying a notification with playback controls...",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = "2 min ago",
            style = TextStyle(fontSize = 14.sp, color = Color.Gray)
        )
        Text(
            text = "By Mohammed Elamin",
            style = TextStyle(fontSize = 14.sp, color = Color.Gray)

        )

    }
}

@Preview
@Composable
fun TopNews() {
    val topNewsHeight: Int = 350;

    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f)),
        startY = topNewsHeight.toFloat() / 3,  // 1/3
        endY = topNewsHeight.toFloat()
    )
    return Box(modifier = Modifier
        .fillMaxWidth(1f)
        .height(topNewsHeight.dp), content = {

        AsyncImage(
            model = "https://static.seekingalpha.com/cdn/s3/uploads/getty_images/1352477873/image_1352477873.jpg?io=getty-c-w750",
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(topNewsHeight.dp)
                .clip(shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp))
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp))
                .background(gradient)
        )

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
            .clickable {

            }
            .padding(all = 10.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.White.copy(alpha = 0.6f))
            .padding(all = 10.dp)


    ) {

        Text(
            text = "News of the day",
            modifier = Modifier.padding(horizontal = 12.dp),

            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
        )

    }
}





