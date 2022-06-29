package com.example.composepractice.screens.fragments

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composepractice.Component.SpacerH
import com.example.composepractice.Component.SpacerW
import com.example.composepractice.R
import com.example.composepractice.utils.AppColors
import com.example.composepractice.utils.HexToJetpackColor

enum class ActionType {
    ACTION, CLICKABLE
}

data class Option(
    var icon: ImageVector,
    var iconColor: String,
    var title: String,
    var description: String,
    var actionType: ActionType
)


@Composable
fun ProfileFragment() {
    val options = mutableListOf<Option>()
    options.add(
        Option(
            icon = Icons.Filled.Notifications,
            title = "Notification",
            description = "controal notifications visiblity",
            iconColor = "2fb47b",
            actionType = ActionType.ACTION
        )
    )
    options.add(
        Option(
            icon = Icons.Default.WbSunny,
            title = "Night Mode",
            description = "controal how look like",
            iconColor = "ECB27B",
            actionType = ActionType.ACTION

        )
    )
    options.add(
        Option(
            icon = Icons.Filled.Logout,
            title = "Sign Out",
            description = "You will miss a joy :D",
            iconColor = "FB6E65",
            actionType = ActionType.CLICKABLE

        )
    )
    val items = (1..10).map { "Item $it" }

    Scaffold(
        backgroundColor = AppColors.BACKGROUND_COLOR
    ) { _ ->


        LazyColumn(modifier = Modifier.padding(all = 16.dp)) {
//          header
            item {
                ProfileHeader()

            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Favoutes News",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    )
                    Text(
                        text = "View All",
                        style = TextStyle(
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    )

                }
            }
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    state = rememberLazyListState()

                ) {
                    itemsIndexed(items = items) { index, item ->
                        HorizntalNewsItem(imageUrl = "https://netstorage-briefly.akamaized.net/images/866be64dca8b88ee.jpg")
                    }

                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Settings",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    )


                }
            }
            itemsIndexed(options) { index: Int, item: Option ->

                OptionItem(option = item, onSwitchChange = {})
            }
            item {
                SpacerH(sizeInDp = 90f)
            }
//          list of options

        }
    }
}


@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_image),
                contentDescription = "",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .width(120.dp)
                    .height(120.dp)
            ) {
                AsyncImage(
                    model = "https://randomuser.me/api/portraits/thumb/men/44.jpg",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(110.dp)
                        .height(110.dp)
                        .border(
                            border = BorderStroke(width = 2.dp, color = Color.White),
                            shape = RoundedCornerShape(110.dp)
                        )
                        .clip(shape = RoundedCornerShape(110.dp))
                )
                Row(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .padding(top = 50.dp)
                        .width(25.dp)
                        .height(25.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .background(color = HexToJetpackColor.getColor("2FB47B"))
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            shape = RoundedCornerShape(25.dp)
                        )
                        .padding(0.dp),

                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp),
                        tint = Color.White
                    )
                }
            }

        }
        Text(
            text = "Mohammed Elamin",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = "@BedBug17",
            style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold)
        )
    }

}


@Composable
fun OptionItem(
    option: Option,
    onSwitchChange: () -> Unit,

    ) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Row {
            Row(
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
                    .clip(shape = RoundedCornerShape(45.dp))
                    .background(
                        color = HexToJetpackColor
                            .getColor(option.iconColor)
                            .copy(alpha = 0.7f)
                    )
                    .padding(0.dp),

                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    option.icon,
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            }
            SpacerW(sizeInDp = 10f)

            Column (verticalArrangement = Arrangement.Center){
                Text(
                    text = option.title,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                SpacerH(sizeInDp = 5f)
               if (option.description.isNotEmpty()) Text(text = option.description, style = TextStyle(fontSize = 14.sp))

            }
        }
        if (option.actionType == ActionType.ACTION)
            Switch(checked = true, onCheckedChange = {
                onSwitchChange()
            }) else
            Icon(Icons.Filled.ArrowForwardIos, contentDescription = "", tint = Color.Black)
    }

}


