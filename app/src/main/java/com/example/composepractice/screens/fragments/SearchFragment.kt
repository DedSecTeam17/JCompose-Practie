package com.example.composepractice.screens.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composepractice.Component.SpacerH
import com.example.composepractice.utils.AppColors
import com.example.composepractice.utils.HexToJetpackColor
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun SearchFragment() {
    val items = (1..10).map { "Item $it" }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        backgroundColor = AppColors.BACKGROUND_COLOR,
        scaffoldState = bottomSheetScaffoldState,

        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.White)
            ) {
                Text(text = "Hello from sheet")
            }
        }, sheetPeekHeight = 0.dp
    ) {
        it

        LazyColumn {
//           header
            item {
                Header()
            }
//           search bar
            item {
                Search()
            }

//           tabs
            item {
                SearchTaps()
            }

            itemsIndexed(items) { index, item ->
                NewsVerticalItem{
                    coroutineScope.launch {

                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
            }
            item {
                SpacerH(sizeInDp = 90f)
            }
        }
    }
}


@Composable
fun Header() {
    Column(modifier = Modifier.padding(all = 16.dp)) {
        SpacerH(sizeInDp = 100f)
        Text(text = "Discover", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 34.sp))
        SpacerH(sizeInDp = 8f)
        Text(
            text = "News from all over the world",
            style = TextStyle(color = Color.Gray, fontSize = 15.sp)
        )

    }
}

@Composable
fun Search() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .padding(all = 15.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = HexToJetpackColor.getColor("D9D9D9"))

            .padding(all = 0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text, onValueChange = { newText ->
                text = newText
            },
            label = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search, contentDescription = "", modifier = Modifier.clickable { }
                )

            },
            trailingIcon = {
                Icon(
                    Icons.Outlined.List, contentDescription = "", modifier = Modifier.clickable { }
                )
            },
            singleLine = true,

            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )


    }

}


@Composable
fun SearchTaps() {
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
    var size by remember { mutableStateOf(IntSize.Zero) }

    val modifierForContainer: Modifier = if (isSelected)
        Modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
            .padding(horizontal = 16.dp, vertical = 1.dp)
    else
        Modifier
            .clickable {
                onClick()
            }
            .padding(5.dp)
            .padding(horizontal = 16.dp, vertical = 1.dp)


    val modifierForTextStyle: TextStyle = if (!isSelected)
        TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold)
    else
        TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)





    Column(modifier = modifierForContainer.padding(5.dp)) {
        Text(text = title, style = modifierForTextStyle.copy(fontSize = 17.sp))
        if (isSelected)
            Box(
                modifier = Modifier
                    .width(15.dp)
                    .height(2.dp)
                    .background(Color.Black)
            )
        else
            Box(
                modifier = Modifier
                    .width(15.dp)
                    .height(2.dp)
                    .background(Color.Gray)
            )

    }
}

//CategoriyList
@Composable
fun CategoriyList() {
    val items = (1..10).map { "Item $it" }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState()
    ) {

        items(items = items, itemContent = { item ->
            NewsVerticalItem{

            }
        })

    }
}

@Composable
fun NewsVerticalItem(onClick: () -> Unit) {
    Row(
        modifier = Modifier.clickable { onClick() }
            .padding(all = 24.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = "https://regmedia.co.uk/2022/06/27/toyota-bz4x-ev.jpg",
            contentDescription = "",
            modifier = Modifier
                .width(65.dp)
                .height(65.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = "Sony’s next big thing in tech is helping Honda take on Tesla",
                style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Bold)
            )
            SpacerH(sizeInDp = 5f)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color.Gray
                    )
                    Text(
                        text = "6 hours ago",
                        style = TextStyle(fontSize = 12.sp, color = Color.Gray)
                    )
                }

                Row {
                    Icon(
                        Icons.Outlined.Lock,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color.Gray

                    )
                    Text(
                        text = "100k views",
                        style = TextStyle(fontSize = 12.sp, color = Color.Gray)
                    )
                }
            }
        }
    }
}
