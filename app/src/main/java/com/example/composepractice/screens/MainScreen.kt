package com.example.composepractice.screens

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.composepractice.screens.fragments.HomeFragment
import com.example.composepractice.screens.fragments.ProfileFragment
import com.example.composepractice.screens.fragments.SearchFragment
import com.example.composepractice.ui.widgets.BottomNavBar


@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }

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

@ExperimentalMaterialApi
@Composable
fun ShowFragmentBasedOnIndex(selectedIndex: Int = 0) {
    when (selectedIndex) {
        0 -> HomeFragment()
        1 -> SearchFragment()
        2 -> ProfileFragment()

    }
}




