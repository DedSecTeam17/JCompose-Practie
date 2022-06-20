package com.example.composepractice.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext


@Composable
fun MainScreen() {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }

    val fragments = arrayListOf<Unit>()
    fragments.add(HomeScreen())
    fragments.add(HomeScreen())
    fragments.add(HomeScreen())
    fragments.add(HomeScreen())


    val context = LocalContext.current
    Scaffold(



        bottomBar = {
            BottomNavBar(
                selectedIndex = selectedIndex,
                onTapChanged = { index: Int ->
                    selectedIndex = index
                }
            )
        },
        backgroundColor = Color.Gray.copy(alpha = 1f),
    ) {
        ShowFragmentBasedOnIndex(selectedIndex = selectedIndex)
    }
}
@Composable
fun ShowFragmentBasedOnIndex(selectedIndex : Int = 0 ) {
    when(selectedIndex){
        0 -> HomeScreen()
        1 -> HomeScreen()
        2 -> HomeScreen()
        3 -> HomeScreen()


    }
}



@Preview
@Composable
fun BottomNavBar(selectedIndex: Int = 0, onTapChanged: (index: Int) -> Unit) {

//    var selectedIndex by rememberSaveable {
//       mutableStateOf(1)
//    }


    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
            .background(color = Color.White).padding(all  = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment  = Alignment.CenterVertically,


            modifier = Modifier
                .fillMaxWidth()

                .height(60.dp)
        ) {

            BottomNavItem(
                title = "Home",
                icon = Icons.Filled.Home,
                isSelected = selectedIndex == 0,
                onClick = {

                    onTapChanged(0)
                })
            BottomNavItem(
                title = "Calls",
                icon = Icons.Filled.Search,
                isSelected = selectedIndex == 1,
                onClick = {
                    onTapChanged(1)

                })
            BottomNavItem(
                title = "Date",
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
    title: String, icon: ImageVector, isSelected: Boolean, onClick: () -> Unit
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
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.Black)
                .padding(horizontal = 8.dp, vertical = 5.dp)

        ) {
            Box(modifier = Modifier.clickable {
                onClick()
            }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        icon,
                        contentDescription = "",
                        tint = Color.White,

                        modifier = Modifier

                            .padding(1.dp)
                            .size(size = 25.dp)
                    )

                }
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
                    contentDescription = "",
                    modifier = Modifier
                        .padding(1.dp)
                        .size(size = 25.dp)
                )
            }
        }
    }


}


@Composable
fun HomeAppBar() {
    TopAppBar(


        title = {

            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "NEWS APP",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }, elevation = 0.dp, backgroundColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Menu, null)
            }
        }, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Search, null)
            }
        }
    )
}
