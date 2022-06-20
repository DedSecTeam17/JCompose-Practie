package com.example.composepractice.screens

import android.content.Context
import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composepractice.Component.SpacerH
import com.example.composepractice.R

@Composable
fun SplashScreen(navController: NavController) {

    val timer = object : CountDownTimer(2000, ( 1000).toLong()) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
//            timerAction.onFinish()

            navController.navigate("MainScreen")
        }
    }
    timer.start()

    val splashScreenImg: Painter = painterResource(id = R.drawable.news_splash_screen)
    Scaffold(

        modifier = Modifier.background(color = Color.White),

        content = {
//            list view with the content---->


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                SpacerH(sizeInDp = (LocalConfiguration.current.densityDpi / 2).toFloat())
                Image(
                    splashScreenImg,
                    contentDescription = "",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
                Text(text = "We Are Fetching Your news....")
                SpacerH(sizeInDp = 20.0f)
            }
        }
    )
}