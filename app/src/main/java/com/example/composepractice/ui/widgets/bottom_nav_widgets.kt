package com.example.composepractice.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@Composable
fun BottomNavBar(selectedIndex: Int = 0, onTapChanged: (index: Int) -> Unit) {

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
            .background(color = Color.White.copy(alpha = 0.9f))
            .padding(all = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment  = Alignment.CenterVertically,


            modifier = Modifier
                .fillMaxWidth()

                .height(60.dp)
        ) {

            BottomNavItem(
                icon = Icons.Filled.Home,
                isSelected = selectedIndex == 0,
                onClick = {

                    onTapChanged(0)
                })
            BottomNavItem(
                icon = Icons.Filled.Search,
                isSelected = selectedIndex == 1,
                onClick = {
                    onTapChanged(1)

                })
            BottomNavItem(
                icon = Icons.Filled.AccountCircle,
                isSelected = selectedIndex == 2,
                onClick = {
                    onTapChanged(2)


                })


        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector, isSelected: Boolean, onClick: () -> Unit
) {
    val textStyle: TextStyle =
        if (isSelected) TextStyle(color = Color.White) else TextStyle(color = Color.White)


    if (isSelected) {
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clickable {
                    print("clicked")
                    onClick()
                }
                .padding(horizontal = 8.dp, vertical = 5.dp)

        ) {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        icon,
                        tint = Color.Black,

                        contentDescription = "",

                        modifier = Modifier

                            .padding(1.dp)
                            .size(size = 25.dp)
                    )

                }
                Box(modifier = Modifier.width(30.dp).height(3.dp).clip(shape = RoundedCornerShape(topEnd = 2.dp, topStart = 2.dp)).background(Color.Black))
            }
        }
    } else {
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clickable {
                    onClick()
                }
                .padding(horizontal = 8.dp, vertical = 5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    icon,
                    tint = Color.DarkGray,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(1.dp)
                        .size(size = 25.dp)
                )
            }
        }
    }


}

