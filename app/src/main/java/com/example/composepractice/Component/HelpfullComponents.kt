package com.example.composepractice.Component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp



@Composable
fun SpacerH(sizeInDp : Float){
    Spacer(modifier = Modifier
        .height(sizeInDp.dp))

}


@Composable
fun SpacerW(sizeInDp : Float){
    Spacer(modifier = Modifier
        .width(sizeInDp.dp))

}
