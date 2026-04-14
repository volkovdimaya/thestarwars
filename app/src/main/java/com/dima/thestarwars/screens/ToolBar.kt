package com.dima.thestarwars.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable

fun ToolBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    when {
        currentRoute == NavScreen.Home.route -> {
            MainTopbar(NavScreen.Home.title)
        }

        currentRoute?.startsWith(prefix = NavScreen.Details.route)== true -> {
            DetailsTopbar(NavScreen.Details.title, navController)
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopbar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .clickable(onClick = {
                        navController.popBackStack()
                    })
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp
                    )
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopbar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        },
    )
}